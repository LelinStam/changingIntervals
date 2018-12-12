package matc.controller;

import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_street.Client;
import com.smartystreets.api.us_street.Lookup;
import matc.entity.Location;
import matc.entity.User;
import matc.persistence.Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet to add new user to the database.
 * @author lclemens
 */
@WebServlet(
        urlPatterns = {"/addAddress"}
)

public class AddAddress extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());

        // Get Form Parameters
        String streetAddress = request.getParameter("streetAddress");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip = request.getParameter("zip");
        String username = request.getUserPrincipal().getName();

        String authId = "f39d9e4e-ce1b-48eb-5a02-89391dba1a91";
        String authToken = "53dTZDZ6bZJ21KwmmTxc";
        String message = "";

        StaticCredentials credentials = new StaticCredentials(authId, authToken);
        Client client = new ClientBuilder(credentials)
                .buildUsStreetApiClient();

        Lookup lookup = new Lookup();
        lookup.setStreet(streetAddress);
        lookup.setCity(city);
        lookup.setState(state);
        lookup.setZipCode(zip);

        try {
            client.send(lookup);
        } catch (SmartyException ex) {
            //Logger.debug(ex);
        } catch (IOException ex) {
            //log.debug(ex);
        }

        ArrayList<Candidate> results = lookup.getResult();

        if (results.isEmpty()) {
            message = "No results- the address is not valid.";
            HttpSession newSession = request.getSession();
            newSession.setAttribute("message", message);

        } else {

            // Create Daos
            Dao userDao = new Dao(User.class);
            Dao locationDao = new Dao(Location.class);

            // find user by session
            List<User> users = userDao.getByPropertyEqual("userName", username);
            User user = users.get(0);

            // Create objects and add to the database
            Location location = new Location();
            location.setStreetAddress(streetAddress);
            location.setCity(city);
            location.setState(state);
            location.setZip(zip);

            locationDao.insert(location);

            user.setLocation(location);

            message = "*You have successfully entered a new address. Click <a href=results.jsp>here</a> to go home";
            HttpSession newSession = request.getSession();
            newSession.setAttribute("message", message);

            Candidate singleResult = results.get(0);
            request.setAttribute("address", singleResult);
        }

        // Redirect
        response.sendRedirect("address.jsp");

    }

}

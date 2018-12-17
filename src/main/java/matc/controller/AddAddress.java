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
        HttpSession newSession = request.getSession();

        StaticCredentials credentials = new StaticCredentials(authId, authToken);
        Client client = new ClientBuilder(credentials)
                .buildUsStreetApiClient();

        if (state.equals("none")) {
            message = "Please pick a state.";
            newSession.setAttribute("message", message);
            response.sendRedirect("address.jsp");

        } else {
            Lookup lookup = new Lookup();
            lookup.setStreet(streetAddress);
            lookup.setCity(city);
            lookup.setState(state);
            lookup.setZipCode(zip);


            try {
                client.send(lookup);

            } catch (SmartyException ex) {
                logger.debug("There was an error verifying the Address.");
                message = "There was an error verifying the Address.";
                response.sendRedirect("address.jsp");

            } catch (IOException ex) {
                logger.debug("there was an error verifying the address");
                message = "There was an error verifying the Address.";
                response.sendRedirect("address.jsp");

            }

            ArrayList<Candidate> results = lookup.getResult();

            if (results.isEmpty()) {
                logger.debug("No results-- invalid address");
                message = "No results- the address is not valid.";
                newSession.setAttribute("message", message);

                // Redirect
                response.sendRedirect("address.jsp");

            } else {

                // Create Daos */
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

                Candidate singleResult = results.get(0);


                message = "You have successfully added the addres: ";
                newSession.setAttribute("message", message);

                String address = singleResult.getComponents().getPrimaryNumber() + ' ' + singleResult.getComponents().getStreetName()
                        + ' ' + singleResult.getComponents().getStreetSuffix() + ' ' + singleResult.getComponents().getCityName()
                        + ' ' + singleResult.getComponents().getState() + ' ' + singleResult.getComponents().getZipCode();
                newSession.setAttribute("address", address);

                // Redirect
                response.sendRedirect("address.jsp");
            }
        }
    }
}

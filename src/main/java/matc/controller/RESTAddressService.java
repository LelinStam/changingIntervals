package matc.controller;

import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.exceptions.SmartyException;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_street.Client;
import com.smartystreets.api.us_street.Lookup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A servlet to use a rest service- Smarty Streets- and verify address.
 * @author lclemens
 */

@WebServlet(
        urlPatterns = {"/verifyAddress"}
)
public class RESTAddressService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());

        // Get Form Parameters
        String streetAddress = req.getParameter("streetAddress");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zip = req.getParameter("zip");

        String authId = "f39d9e4e-ce1b-48eb-5a02-89391dba1a91";
        String authToken = "53dTZDZ6bZJ21KwmmTxc";
        String message = "";

        // We recommend storing your secret keys in environment variables instead---it's safer!
        // String authId = System.getenv("SMARTY_AUTH_ID");
        // String authToken = System.getenv("SMARTY_AUTH_TOKEN");

        StaticCredentials credentials = new StaticCredentials(authId, authToken);
        Client client = new ClientBuilder(credentials)
                // Uncomment the line below to try it with a proxy
                // .withProxy(Proxy.Type.HTTP, "localhost", 8080)
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
            HttpSession newSession = req.getSession();
            newSession.setAttribute("message", message);

            resp.sendRedirect("address.jsp");
        } else {
            message = "Please confirm the address below.";
            HttpSession newSession = req.getSession();
            newSession.setAttribute("message", message);

            Candidate singleResult = results.get(0);
            req.setAttribute("address", singleResult);
            RequestDispatcher dispatcher = req.getRequestDispatcher("verify-address.jsp");
            dispatcher.forward(req, resp);
        }
    }

}

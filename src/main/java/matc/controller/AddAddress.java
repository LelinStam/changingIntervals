package matc.controller;

import matc.entity.Location;
import matc.entity.User;
import matc.entity.Workout;
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
import java.time.LocalDate;
import java.util.Date;
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
        location.setUser(user);

        locationDao.insert(location);

        user.setLocation(location);

        String message = "*You have successfully entered a new address. Click <a href=my-workouts.jsp>here</a> to go home";
        HttpSession newSession = request.getSession();
        newSession.setAttribute("message", message);

        // Redirect
        response.sendRedirect("address.jsp");

    }

}

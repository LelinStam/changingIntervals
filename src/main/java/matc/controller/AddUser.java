package matc.controller;

import matc.entity.*;
import matc.persistence.Dao;
import org.apache.logging.log4j.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Servlet to add new user to the database.
 * @author lclemens
 */
@WebServlet(
        urlPatterns = {"/addUser"}
)

public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());
        // Get Form Parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");

        // Create Daos
        Dao userDao = new Dao(User.class);
        Dao roleDao = new Dao(Role.class);

        // Validate form
        String message;
        List<User> usernameCheck = userDao.getByPropertyLike("userName", username);

        if (usernameCheck.size() != 0) {
            // Check that username is unique
            message = "*The username you have selected is already in use";
            HttpSession session = request.getSession();
            session.setAttribute("message", message);
            response.sendRedirect("signup.jsp");

        } else if (!password.equals(confirmPassword)) {
            // Check that password fields match
            message = "*The passwords you have entered do not match";
            HttpSession session = request.getSession();
            session.setAttribute("message", message);
            response.sendRedirect("signup.jsp");

        } else if (password.length() < 6 || confirmPassword.length() < 6) {
            // Check that password is at least 6 characters
            message = "*Your password must contain at least 6 characters";
            HttpSession session = request.getSession();
            session.setAttribute("message", message);
            response.sendRedirect("signup.jsp");

        } else {
            // Create objects and add to the database
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setUserName(username);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date parsed = format.parse(dateOfBirth);
                user.setDateOfBirth(parsed);
            } catch(Exception parseException) {
                logger.debug("unable to parse date");
            }


            Role role = new Role();
            role.setRole("user");
            role.setUser(user);
            role.setUsername(username);
            user.addRole(role);
            userDao.insert(user);

            message = "*You have successfully signed up. Please log in to access your account.";
            HttpSession session = request.getSession();
            session.setAttribute("message", message);

            // Redirect
            response.sendRedirect("my-workouts.jsp");
        }
    }
}

package matc.controller;

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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet to edit user and add to the database.
 *
 * @author lclemens
 */
@WebServlet(
        urlPatterns = {"/editUser"}
)

public class EditUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());            
        
        HttpSession session = request.getSession();
            
        // Get Form Parameters
        String id = request.getParameter("id");
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String dateOfBirth = request.getParameter("dateOfBirth");

        // Create Daos
        Dao userDao = new Dao(User.class);

        // Validate form
        String message;
        User user = (User)userDao.getById(id);

        if(user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setUserName(username);
            user.setEmail(email);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date parsed = format.parse(dateOfBirth);
                user.setDateOfBirth(parsed);
                    
            } catch (Exception parseException) {
                logger.debug("unable to parse date");
                message= "Unable to read birthdate";
                session.setAttribute("message", message);
                    
            }

            userDao.saveOrUpdate(user);

            message = "You have successfully updated " + username;
            session.setAttribute("message", message);

        } else {
            message = "User not found";
            logger.debug("User not found");
            session.setAttribute("message", message);
        }

        // Redirect
        response.sendRedirect("user.jsp");

    }
}

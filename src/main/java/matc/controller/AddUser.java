package matc.controller;

import matc.entity.*;
import matc.persistence.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet to add new user to the database.
 * @author kheise
 */
@WebServlet(
        urlPatterns = {"/addUser"}
)

public class AddUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get Form Parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        // Create Daos
        Dao userDao = new Dao(User.class);
        Dao roleDao = new Dao(Role.class);
        // Validate form
        String errorMessage;
        List<User> usernameCheck = userDao.getByPropertyLike("username", username);

        if (usernameCheck.size() != 0) {
            // Check that username is unique
            errorMessage = "*The username you have selected is already in use";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("signUp.jsp");
        } else if (!password.equals(confirmPassword)) {
            // Check that password fields match
            errorMessage = "*The passwords you have entered do not match";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("signUp.jsp");
        } else if (password.length() < 6 || confirmPassword.length() < 6) {
            // Check that password is at least 6 characters
            errorMessage = "*Your password must contain at least 6 characters";
            HttpSession session = request.getSession();
            session.setAttribute("errorMessage", errorMessage);
            response.sendRedirect("signUp.jsp");
        } else {
            // Create objects and add to the database
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setUserName(username);

            Role role = new Role();
            role.setRole("user");
            role.setUser(user);
            user.addRole(role);
            userDao.insert(user);

            // Redirect
            response.sendRedirect("signUpConfirmation.jsp");
        }
    }
}

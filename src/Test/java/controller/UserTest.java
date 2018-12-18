package controller;

import matc.entity.Role;
import matc.entity.User;
import matc.persistence.Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserTest extends Mockito {

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("username")).thenReturn("la");
        when(request.getParameter("password")).thenReturn("password");
        when(request.getParameter("confirmPassword")).thenReturn("password");
        when(request.getParameter("firstName")).thenReturn("La");
        when(request.getParameter("lastName")).thenReturn("La");
        when(request.getParameter("email")).thenReturn("me@me.com");
        when(request.getParameter("dateOfBirth")).thenReturn("2018-09-09");
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        doPost(request, response);

        Dao dao = new Dao(User.class);
        List<User> users = dao.getByPropertyLike("userName", "la");
        Assertions.assertEquals(1, users.size());

    }

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

        HttpSession session = request.getSession();

        // Create Daos
        Dao userDao = new Dao(User.class);
        Dao roleDao = new Dao(Role.class);

        // Validate form
        String message;
        List<User> usernameCheck = userDao.getByPropertyLike("userName", username);

        if (usernameCheck.size() != 0) {
            // Check that username is unique
            message = "The username you have selected is already in use";

        } else if (!password.equals(confirmPassword)) {
            // Check that password fields match
            message = "The passwords you have entered do not match";
        } else if (password.length() < 6 || confirmPassword.length() < 6) {
            // Check that password is at least 6 characters
            message = "Your password must contain at least 6 characters";

        } else {
            // Create objects and add to the database
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(password);
            user.setUserName(username);
            user.setEmail(email);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date parsed = format.parse(dateOfBirth);
                user.setDateOfBirth(parsed);
            } catch(Exception parseException) {
                logger.debug("unable to parse date");
                message = "Unable to read date of birth";
            }

            Role role = new Role();
            role.setRole("user");
            role.setUser(user);
            role.setUsername(username);
            user.addRole(role);
            userDao.insert(user);

            message = "You have successfully signed up. Please log in to access your account.";
        }
    }
}
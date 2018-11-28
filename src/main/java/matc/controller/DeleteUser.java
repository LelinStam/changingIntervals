package matc.controller;

import matc.entity.User;
import matc.persistence.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet to add new user to the database.
 *
 * @author lclemens
 */
@WebServlet(
        urlPatterns = {"/deleteUser"}
)

public class DeleteUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get Form Parameters
        String id = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        // Create Dao
        Dao userDao = new Dao(User.class);

        // Validate form
        String message;
        User userToDelete = (User)userDao.getById(id);

        if (userToDelete == null) {
            // Check that id exists
            message = "*That is not a valid id";
            HttpSession session = request.getSession();
            session.setAttribute("message", message);
            response.sendRedirect("delete.jsp");
        } else {
            message = "*User " + firstName + " successfully deleted";
            HttpSession session = request.getSession();
            session.setAttribute("message", message);
            userDao.delete(userToDelete);
        }

            // Redirect
            response.sendRedirect("delete.jsp");
        }
    }


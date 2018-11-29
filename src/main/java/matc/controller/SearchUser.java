package matc.controller;

import matc.entity.User;
import matc.persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author lclemens
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Dao dao = new Dao(User.class);
        boolean isValid = true;

        if (req.getParameter("submit").equals("search")) {
            try {
                int id = Integer.parseInt(req.getParameter("searchTerm").trim());
            } catch (NumberFormatException nfe) {
                isValid = false;
                RequestDispatcher dispatcher = req.getRequestDispatcher("/search-error.jsp");
                dispatcher.forward(req, resp);
            }
            if(isValid) {
                    req.setAttribute("user", dao.getById(req.getParameter("searchTerm")));
            }
        } else {
            req.setAttribute("users", dao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
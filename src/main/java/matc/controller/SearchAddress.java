package matc.controller;

import matc.entity.Location;
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
        urlPatterns = {"/searchAddress"}
)

public class SearchAddress extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Dao dao = new Dao(User.class);
        Dao locationDao = new Dao(Location.class);

        String searchTerm = req.getParameter("searchTerm");

        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("addresses", dao.getByPropertyLike("city", searchTerm));
        } else {
            req.setAttribute("addresses", locationDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("results.jsp");
        dispatcher.forward(req, resp);
    }
}
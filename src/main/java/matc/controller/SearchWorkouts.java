package matc.controller;

import matc.entity.User;
import matc.entity.Workout;
import matc.persistence.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author lclemens
 */

@WebServlet(
        urlPatterns = {"/searchWorkouts"}
)

public class SearchWorkouts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Dao dao = new Dao(Workout.class);
        boolean isValid = true;
        String search = req.getParameter("submit");
        String searchTerm = req.getParameter("searchTerm");

        if(search.equals("search")) {
            if (!searchTerm.isEmpty() && searchTerm instanceof String) {
            req.setAttribute("workouts", dao.getByPropertyLike("workout", searchTerm));

            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/search-error.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            HttpSession session = req.getSession(false);
            String username = req.getRemoteUser();
            Dao userDao = new Dao(User.class);
            List<User> user = userDao.getByPropertyEqual("username", username);
            User currentUser = user.get(0);
            req.setAttribute("workouts", currentUser.getWorkouts());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/workout-results.jsp");
        dispatcher.forward(req, resp);
    }
}
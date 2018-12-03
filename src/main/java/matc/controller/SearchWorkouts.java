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
import java.util.Set;

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

        Dao workoutDao = new Dao(Workout.class);
        Dao userDao = new Dao(User.class);

        boolean isValid = true;
        String search = req.getParameter("submit");
        String searchTerm = req.getParameter("searchTerm");
        String userId = req.getParameter("userId");

        User user = (User)userDao.getById(userId);

        if(search.equals("search")) {
            if (!searchTerm.isEmpty() && searchTerm instanceof String) {

                req.setAttribute("workouts", workoutDao.getByPropertyLike("workout", searchTerm));

            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/search-error.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            //HttpSession session = req.getSession(false);
            //String username = req.getRemoteUser();
            req.setAttribute("workouts", user.getWorkouts());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/workout-results.jsp");
        dispatcher.forward(req, resp);
    }
}
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

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

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

        String search = req.getParameter("submit");
        String searchTerm = req.getParameter("searchTerm");
        String searchType = req.getParameter("searchType");
        String username = req.getUserPrincipal().getName();

        Dao workoutDao = new Dao(Workout.class);
        Dao userDao = new Dao(User.class);
        String message = "";
        boolean isValid = true;

        if (search.equals("search")) {
            if (!searchTerm.isEmpty() && searchTerm instanceof String){

                List<User> users = userDao.getByPropertyEqual("userName", username);
                User user = users.get(0);
                List<Workout> workouts = workoutDao.getByPropertyLike(searchType, searchTerm);

                List<Workout> searchedWorkouts = findUsersWorkouts(user, workouts);
                req.setAttribute("workouts", searchedWorkouts);

            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/search-error.jsp");
                dispatcher.forward(req, resp);
            }
        } else {
            List<User> users = userDao.getByPropertyEqual("userName", username);
            User user = users.get(0);
            req.setAttribute("workouts", user.getWorkouts());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/workout-results.jsp");
        dispatcher.forward(req, resp);
    }

    public List<Workout> findUsersWorkouts(User user, List<Workout> workouts) {
       List<Workout> searchedWorkouts = null;
       for(Workout workout : workouts) {
           if(user == workout.getUser()) {
               searchedWorkouts.add(workout);
           }
       }
        return searchedWorkouts;
    }

}
package matc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import matc.entity.User;
import matc.entity.Workout;
import matc.persistence.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Servlet to add new user to the database.
 * @author lclemens
 */
@WebServlet(
        urlPatterns = {"/addWorkout"}
)

public class AddWorkout extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());

        // Get Form Parameters
        String enteredWorkout = request.getParameter("workout");
        String mileage = request.getParameter("mileage");
        String username = request.getUserPrincipal().getName();
        int mileageNumber = 0;
            
        String message = "";
        HttpSession newSession = request.getSession();

        // Create Daos
        Dao userDao = new Dao(User.class);
        Dao workoutDao = new Dao(Workout.class);

        // find user by session
        List<User> users = userDao.getByPropertyEqual("userName", username);
        User user = users.get(0);
        request.setAttribute("workouts", user.getWorkouts());
            
         try {
            mileageNumber = Integer.parseInt(mileage);
          } catch (NumberFormatException e) {
            //log.debug(e);
            message = "Please enter a number for mileage";
            newSession.setAttribute("message", message);
                    
            // Redirect
            response.sendRedirect("new-workout.jsp");
          }     

        // Create objects and add to the database
        Workout workout = new Workout();
        workout.setWorkout(enteredWorkout);
        workout.setMileage(mileageNumber);
        workout.setDateCreated(convertToDateViaSqlDate(LocalDate.now()));
        workout.setDateModified(convertToDateViaSqlDate(LocalDate.now()));
        workout.setUser(user);
        workoutDao.insert(workout);

        message = "*You have successfully entered a new workout. Click <a href=my-workouts.jsp>here</a> to view all workouts";        
        newSession.setAttribute("message", message);
            
        // Redirect
        response.sendRedirect("new-workout.jsp");

    }

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
}

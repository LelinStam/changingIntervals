package matc.controller;

import matc.entity.Workout;
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
 * Servlet to add new user to the database.
 * @author lclemens
 */
@WebServlet(
        urlPatterns = {"/editWorkout"}
)

public class EditWorkout extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());
        // Get Form Parameters
        String id = request.getParameter("id");
        String dateCreated = request.getParameter("dateCreated");
        String dateModified = request.getParameter("dateModified");
        String workoutDetails = request.getParameter("workout");
        String mileage = request.getParameter("mileage");

        // Create Daos
        Dao workoutDao = new Dao(Workout.class);

        // Validate form
        String message;
        Workout workout = (Workout)workoutDao.getById(id);

        if(workout != null) {
            workout.setMileage(Integer.parseInt(mileage));
            workout.setWorkout(workoutDetails);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date parsedDateCreated = format.parse(dateCreated);
                Date parsedDateModified = format.parse(dateModified);
                workout.setDateCreated(parsedDateCreated);
                workout.setDateModified(parsedDateModified);

            } catch (Exception parseException) {
                logger.debug("unable to parse date");
            }

            workoutDao.saveOrUpdate(workout);

            message = "You have successfully updated your workout";
            HttpSession session = request.getSession();
            session.setAttribute("message", message);

        } else {
            message = "Workout not found";
            HttpSession session = request.getSession();
            session.setAttribute("message", message);
        }

        // Redirect
        response.sendRedirect("my-workouts.jsp");

    }
}

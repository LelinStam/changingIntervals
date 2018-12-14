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
        int mileageNumber = 0;

        // Create Daos
        Dao workoutDao = new Dao(Workout.class);

        // Validate form
        String message = "";            
        HttpSession session = request.getSession();
        Workout workout = (Workout)workoutDao.getById(id);
        
        try {
            mileageNumber = Integer.parseInt(mileage);
                
          } catch (NumberFormatException e) {
            logger.debug("Unable to parse mileage");
            message = "Please enter a number for mileage";
            newSession.setAttribute("message", message);
                    
            // Redirect
            response.sendRedirect("my-workouts.jsp");
          }     
            
        if(workout != null) {
            workout.setMileage(mileageNumber);
            workout.setWorkout(workoutDetails);

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date parsedDateCreated = format.parse(dateCreated);
                Date parsedDateModified = format.parse(dateModified);
                workout.setDateCreated(parsedDateCreated);
                workout.setDateModified(parsedDateModified);

            } catch (Exception parseException) {
                logger.debug("unable to parse date");
                message = "Cannot read today's date";                     
                newSession.setAttribute("message", message);

                // Redirect
                response.sendRedirect("my-workouts.jsp");
            }

            workoutDao.saveOrUpdate(workout);

            message = "You have successfully updated your workout";
            session.setAttribute("message", message);

        } else {
            message = "Workout not found";
            session.setAttribute("message", message);
        }

        // Redirect
        response.sendRedirect("my-workouts.jsp");

    }
}

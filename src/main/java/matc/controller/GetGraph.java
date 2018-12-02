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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple servlet to get a graph of mileage over time.
 * @author lclemens
 */

@WebServlet(
        urlPatterns = {"/getGraph"}
)

public class GetGraph extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dao workoutDao = new Dao(Workout.class);
        String mileages= "";
        int mileage= 0;

        List<Workout> workouts = workoutDao.getAll();
        for (int counter = 0; counter < workouts.size(); counter++) {
            if (counter == (workouts.size()-1)) {
                mileages += Integer.toString(workouts.get(counter).getMileage());
            } else {
                mileages += Integer.toString(workouts.get(counter).getMileage()) + ",";
            }

        }
        req.setAttribute("image", "<img src='http://services.sapo.pt/Chart/Get?cht=lc&chs=400x200&chd=t:" + mileages
                + "&chds=1,10&chxt=x,y&chxl=0:|Apr|May|June|1:|1|2|3|4|5|6|7|8|9|10+miles' title='graph' alt='Error generating chart...' />" );

        RequestDispatcher dispatcher = req.getRequestDispatcher("/my-workouts.jsp");
        dispatcher.forward(req, resp);
    }
}
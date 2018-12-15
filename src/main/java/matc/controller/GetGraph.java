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
import java.util.*;

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
        Dao userDao = new Dao(User.class);

        String username = req.getUserPrincipal().getName();
        String mileages = "";
        String message = "";
        int mileage= 0;

        String months = req.getParameter("months");
        Calendar date = Calendar.getInstance();
        if(months=="3") {
            date.set(Calendar.MONTH, Calendar.OCTOBER);
        } else if(months=="6") {
            date.set(Calendar.MONTH, Calendar.JULY);
        }

        List<User> users = userDao.getByPropertyEqual("userName", username);
        User user = users.get(0);
        Set<Workout> workouts = user.getWorkouts();
        List<Workout> workoutsList= convertToList(workouts);

        for (int counter = 0; counter < workoutsList.size(); counter++) {
            Date dateOfCurrentWorkout = workoutsList.get(counter).getDateCreated();                
             
            if(dateOfCurrentWorkout.after(date.getTime())) {
                if(!mileages.isEmpty()) {
                    mileages += ",";
                }
                mileages += Integer.toString(workoutsList.get(counter).getMileage());
            }
        }
        
            
        if (mileages.isEmpty()) { 
            message = "No results for this time frame: " + months + "months from today.";
            req.setAttribute("message", message);
        } else {
            req.setAttribute("image", "<img src='http://services.sapo.pt/Chart/Get?cht=lc&chs=400x200&chd=t:" + mileages
                + "&chds=0,10&chxt=x,y&chxl=0:" + getDate(months) + "|1:|1|2|3|4|5|6|7|8|9|10+miles' title='graph' alt='Error generating chart...' />" );
        }
            
        //req.setAttribute("mileages",mileages);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/progress.jsp");
        dispatcher.forward(req, resp);
    }

    public List<Workout> convertToList(Set<Workout> workouts) {
        List<Workout> mainList = new ArrayList<Workout>();
        mainList.addAll(workouts);

        return mainList;
    }

    public String getDate(String months){

        String monthNames = "";
        int numberMonths = Integer.parseInt(months);

        if(numberMonths==3) {
             monthNames = "|Oct|Nov|Dec";
        } else if(numberMonths ==6){
            monthNames = "|July|Aug|Sept|Oct|Nov|Dec";
        }

        return monthNames;
    }
}

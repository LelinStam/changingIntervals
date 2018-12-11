package matc.controller;

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
        urlPatterns = {"/sendToPage"}
)

public class SendToPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchType =  req.getParameter("searchType");
        String page = "";

        if (searchType.equals("address")) {
            page = "results.jsp";
        } else if( searchType.equals("workout")){
            page = "all-workouts.jsp";
        } else {
            page = "blog-posts.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }
}

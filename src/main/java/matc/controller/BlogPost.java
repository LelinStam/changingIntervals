package matc.controller;

import matc.entity.Blog;
import matc.entity.User;
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
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Servlet to add new user to the database.
 * @author lclemens
 */
@WebServlet(
        urlPatterns = {"/postBlog"}
)

public class BlogPost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final Logger logger = LogManager.getLogger(this.getClass());

        // Get Form Parameters
        String title = request.getParameter("title");
        String blog = request.getParameter("blog");
        String username = request.getUserPrincipal().getName();

        // Create Daos
        Dao userDao = new Dao(User.class);
        Dao blogDao = new Dao(Blog.class);

        // find user by session
        List<User> users = userDao.getByPropertyEqual("userName", username);
        User user = users.get(0);
        request.setAttribute("workouts", user.getWorkouts());

        // Create objects and add to the database
        Blog blogToAdd = new Blog();
        blogToAdd.setTitle(title);
        blogToAdd.setBlog(blog);
        blogToAdd.setDateCreated(convertToDateViaSqlDate(LocalDate.now()));
        blogToAdd.setUser(user);
        blogDao.insert(blogToAdd);

        String message = "Thanks for submitting your blog post!";
        HttpSession newSession = request.getSession();
        newSession.setAttribute("message", message);

        // Redirect
        response.sendRedirect("blog-posts.jsp");

    }

    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
}

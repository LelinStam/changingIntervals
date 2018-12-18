package matc.persistence;

import matc.entity.Blog;
import matc.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlogDaoTest {

    Dao dao;
    Dao userDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        matc.test.util.Database database = matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        userDao = new Dao(User.class);
        dao = new Dao(Blog.class);
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        Blog retrievedBlog = (Blog)dao.getById("1");
        assertEquals("title", retrievedBlog.getTitle());
        assertEquals("Swim fast", retrievedBlog.getBlog());
        assertEquals(1, retrievedBlog.getId());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {
        User user = (User)userDao.getById("1");
        Blog newBlog = new Blog("Why I swim", "Swimming is important for a healthy life", new Date(1988, 12, 13), user);
        int id = dao.insert(newBlog);
        assertNotEquals(0,id);
        Blog insertedBlog = (Blog)dao.getById(Integer.toString(id));
        assertTrue(newBlog.equals(insertedBlog));
    }


    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        String newTitle = "Swim";
        Blog blogToUpdate = (Blog)dao.getById("2");
        blogToUpdate.setTitle(newTitle);
        dao.saveOrUpdate(blogToUpdate);
        Blog retrievedBlog = (Blog)dao.getById("2");
        assertTrue(blogToUpdate.equals(retrievedBlog));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<Blog> blogs = dao.getAll();
        assertEquals(2, blogs.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Blog> blogs = dao.getByPropertyLike("title", "title");
        assertEquals(1, blogs.size());
        assertEquals(1, blogs.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Blog> blogs = dao.getByPropertyLike("blog", "s");
        assertEquals(2, blogs.size());
    }

    @Test
    void getByPropertyEqual() {
        List<Blog> blogs = dao.getByPropertyEqual("title", "title");
        assertEquals(1, blogs.size());
    }

    /**
     * Verify successful delete of user

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById("2"));
        assertNull(dao.getById("2"));
    }*/

}
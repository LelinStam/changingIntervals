package matc.persistence;

import matc.entity.Blog;
import matc.entity.Location;
import matc.entity.User;
import matc.entity.Workout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    Dao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        matc.test.util.Database database = matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");
        dao = new Dao(User.class);
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)dao.getById("3");
        assertEquals("Barney", retrievedUser.getFirstName());
        assertEquals("Curry", retrievedUser.getLastName());
        assertEquals("bcurry", retrievedUser.getUserName());
        assertEquals(3, retrievedUser.getId());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("Mercury", "Mack", "mmack", new Date(1988, 12, 13), "password");
        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)dao.getById(Integer.toString(id));
        assertTrue(newUser.equals(insertedUser));
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWithWorkoutSuccess() {
        User newUser = new User("Maple", "Marple", "mmarple", new Date(1968, 01, 01), "password");

        String workout = "2x500 warmup, 2x400 free on 2:20, 300 cooldown";
        Date dateCreated = new Date(2016, 11, 06);
        Date dateModified = new Date(2018, 12, 01);
        int mileage = 3;
        Workout newWorkout = new Workout(workout, dateCreated, dateModified, mileage, newUser);

        newUser.addWorkout(newWorkout);

        int id = dao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)dao.getById(Integer.toString(id));
        assertTrue(newUser.equals(insertedUser));
    }

    @Test
    void insertBlogSuccess() {
        User newUser = new User("Dorothy", "Doll", "ddoll", new Date(1968, 01, 01), "password");

        String title = "My Swim Post";
        String blogPost = "I swim daily since I was 9. For me, it is the only exercise that works full body.";
        Date dateCreated = new Date(2018, 9, 13);
        Blog blog = new Blog(title, blogPost, dateCreated, newUser);
        newUser.addBlog(blog);

        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        assertEquals(1, newUser.getBlogs().size());
    }

    @Test
    void insertLocationSuccess() {
        User newUser = new User("Timmy", "Wallis", "twallis", new Date(1968, 01, 01), "password");

        String streetAddress = "123 Corey Ln";
        String city = "Kensington";
        String state = "MA";
        String zip = "34778";
        Location location = new Location(streetAddress, city, state, zip);
        newUser.setLocation(location);

        int id = dao.insert(newUser);
        assertNotEquals(0, id);
        assertNotNull(newUser.getLocation());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById("5"));
        assertNull(dao.getById("5"));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        String newLastName = "Davis";
        User userToUpdate = (User)dao.getById("3");
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)dao.getById("3");
        assertTrue(userToUpdate.equals(retrievedUser));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(5, users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "Coyne");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "c");
        assertEquals(3, users.size());
    }

    @Test
    void getByPropertyEqual() {
        List<User> users = dao.getByPropertyEqual("firstName", "Dawn");
        assertEquals(1, users.size());
    }

}
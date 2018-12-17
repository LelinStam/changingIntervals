package matc.persistence;

import matc.entity.User;
import matc.entity.Workout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 * The type Workout dao test.
 */
class WorkoutDaoTest {

    /**
     * The Dao.
     */
    Dao dao;
    /**
     * The User dao.
     */
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
        dao = new Dao(Workout.class);
        userDao = new Dao(User.class);
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        Workout retrievedWorkout = (Workout)dao.getById("2");
        assertEquals("400SKIMPS, 3x100 free on 1:30, cooldown choice", retrievedWorkout.getWorkout());
        assertEquals(2, retrievedWorkout.getMileage());
        assertEquals(2, retrievedWorkout.getId());
    }

    /**
     * Verify successful insert of a user

    @Test
    void insertSuccess() {

        User user = (User)userDao.getById("1");

        Workout newWorkout = new Workout("Swam across Lake Michigan", new Date(2018,8,15), new Date(2018,8,15), 20, user);
        int id = dao.insert(newWorkout);
        assertNotEquals(0,id);
        Workout insertedWorkout = (Workout)dao.getById(Integer.toString(id));
        assertTrue(insertedWorkout.equals(newWorkout));
    }


    /**
     * Update success.

    @Test
    void updateSuccess() {
        int newMileage = 3;
        Workout workoutToUpdate = (Workout)dao.getById("2");
        workoutToUpdate.setMileage(newMileage);
        dao.saveOrUpdate(workoutToUpdate);
        Workout retrievedWorkout = (Workout)dao.getById("2");
        assertTrue(workoutToUpdate.equals(retrievedWorkout));
    }
     */

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<Workout> workouts = dao.getAll();
        assertEquals(2, workouts.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Workout> workouts = dao.getByPropertyLike("workout", "skimps");
        assertEquals(2, workouts.size());
        assertEquals(1, workouts.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Workout> workouts = dao.getByPropertyLike("workout", "30");
        assertEquals(1, workouts.size());
    }

    /**
     * Gets by property equal.
     */
    @Test
    void getByPropertyEqual() {
        List<Workout> workouts = dao.getByPropertyEqual("workout", "400SKIMPS, 3x100 free on 1:30, cooldown choice");
        assertEquals(1, workouts.size());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById("3"));
        assertNull(dao.getById("3"));
    }

}
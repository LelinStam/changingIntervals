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
public class WorkoutDaoTest {
    /**
     * The Workout dao.
     */
    WorkoutDao workoutDao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {

        matc.test.util.Database database = matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        workoutDao = new WorkoutDao();
    }

    /**
     * Gets workout by date created success.
     */
    @Test
    void getWorkoutByDateCreatedSuccess() {
        List<Workout> workouts = workoutDao.getWorkoutsByDateCreated(11022018);
        assertEquals(0, workouts.size());
    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        Workout retrievedWorkout = workoutDao.getById(3);
        assertEquals("30 mins swim", retrievedWorkout.getWorkout());
        //TODO compare remaining values
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertWorkoutSuccess() {
        Dao userDao = new Dao();
        User user = userDao.getById(1);

        Workout workout = new Workout("200SKIMPS, 400IM, 6x100 free on 1:25, 200 cooldown", 03122012, 04052015, null);
        user.addWorkout(workout);

        int id = workoutDao.insert(workout);
        assertNotEquals(0,id);
        Workout insertedWorkout = workoutDao.getById(id);
        assertNotNull(insertedWorkout.getUser());
        assertEquals(03122012, insertedWorkout.getDateCreated());
        // TODO review .equals recommendations http://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode
    }


    /**
     * Verify successful delete of user
     */
    @Test
    void deleteWorkoutSuccess() {
        workoutDao.delete(workoutDao.getById(3));
        assertNull(workoutDao.getById(3));
    }

    /**
     * Update success.
     */
    @Test
    void updateWorkoutSuccess() {
        String newWorkout = "Float on your back for 5 hours";
        Workout workoutToUpdate = workoutDao.getById(3);
        workoutToUpdate.setWorkout(newWorkout);
        workoutDao.saveOrUpdate(workoutToUpdate);
        Workout retrievedWorkout = workoutDao.getById(3);
        assertEquals(newWorkout, retrievedWorkout.getWorkout());
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllWorkoutsSuccess() {
        List<Workout> workouts = workoutDao.getAllWorkouts();
        assertEquals(3, workouts.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getWorkoutsByPropertyEqualSuccess() {
        List<Workout> workouts = workoutDao.getByPropertyEqual("id", "2");
        assertEquals(1, workouts.size());
        assertEquals(2, workouts.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getWorkoutByPropertyLikeSuccess() {
        List<Workout> workouts = workoutDao.getByPropertyLike("workout", "SKIMPS");
        assertEquals(2, workouts.size());
    }

    /**
     * Gets workout by property equal.
     */
    @Test
    void getWorkoutByPropertyEqual() {
        List<Workout> workouts = workoutDao.getByPropertyEqual("dateCreated", "07152018");
        assertEquals(1, workouts.size());
    }
}

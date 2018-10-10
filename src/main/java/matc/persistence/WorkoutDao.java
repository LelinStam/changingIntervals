package matc.persistence;

import matc.entity.Workout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class WorkoutDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all workouts.
     *
     * @return the all workouts
     */
    public List<Workout> getAllWorkouts() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Workout> query = builder.createQuery(Workout.class);
        Root<Workout> root = query.from(Workout.class);
        List<Workout> workouts = session.createQuery(query).getResultList();
        session.close();
        return workouts;
    }

    /**
     * Gets workouts by .
     *
     * @param dateCreated the date created
     * @return the workouts by date created
     */
    public List<Workout> getWorkoutsByDateCreated(int dateCreated) {
        logger.debug("searching for: {}" + dateCreated);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Workout> query = builder.createQuery(Workout.class);
        Root<Workout> root = query.from( Workout.class );
        query.select(root).where(builder.equal(root.get("dateCreated"), dateCreated));
        List<Workout> workouts = session.createQuery( query ).getResultList();
        session.close();
        return workouts;
    }

    /**
     * Get workout by id
     */
    public Workout getById(int id) {
        Session session = sessionFactory.openSession();
        Workout workout = session.get( Workout.class, id );
        session.close();
        return workout;
    }

    /**
     * update workout
     * @param workout  User to be inserted or updated
     */
    public void saveOrUpdate(Workout workout) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(workout);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * update workout
     * @param workout  User to be inserted or updated
     */
    public int insert(Workout workout) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(workout);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a workout
     * @param workout Workout to be deleted
     */
    public void delete(Workout workout) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(workout);
        transaction.commit();
        session.close();
    }

    /**
     * Get workout by property (exact match)
     * sample usage: getByPropertyEqual("dateCreated", 01/01/2011)
     */
    public List<Workout> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Workout> query = builder.createQuery( Workout.class );
        Root<Workout> root = query.from( Workout.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Workout> workouts = session.createQuery( query ).getResultList();
        session.close();
        return workouts;
    }

    /**
     * Get workout by property (like)
     * sample usage: getByPropertyLike("dateModified", 02/12/2015)
     */
    public List<Workout> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Workout> query = builder.createQuery( Workout.class );
        Root<Workout> root = query.from( Workout.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Workout> workouts = session.createQuery( query ).getResultList();
        session.close();
        return workouts;
    }
}

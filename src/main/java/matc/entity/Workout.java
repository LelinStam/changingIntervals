package matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * The type workout.
 */
@Entity(name = "Workout")
@Table(name = "personal_workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String workout;

    @Column(name = "date_created")
    private int dateCreated;

    @Column(name = "date_modified")
    private int dateModified;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "personal_workouts_user_id_fk")
    )
    private User user;

    /**
     * Instantiates a new Workout.
     */
    public Workout() {
    }

    /**
     * Instantiates a new Workout.
     *
     * @param workout      the workout
     * @param dateCreated  the date
     * @param dateModified the date
     * @param user         the user
     */
    public Workout(String workout, int dateCreated, int dateModified, User user ) {
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.user = user;
        this.workout = workout;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets workout.
     *
     * @return the workout
     */
    public String getWorkout() {
        return workout;
    }

    /**
     * Sets workout.
     *
     * @param workout the workout
     */
    public void setWorkout(String workout) {
        this.workout = workout;
    }


    /**
     * Gets date created.
     *
     * @return the date created
     */
    public int getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets date created.
     *
     * @param dateCreated the date created
     */
    public void setDateCreated(int dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Gets date modified.
     *
     * @return the date modified
     */
    public int getDateModified() {
        return dateModified;
    }

    /**
     * Sets date modified.
     *
     * @param dateModified the date modified
     */
    public void setDateModified(int dateModified) {
        this.dateModified = dateModified;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", workout='" + workout + '\'' +
                ", date created='" + dateCreated + '\'' +
                ", date modified='" + dateModified + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout1 = (Workout) o;
        return id == workout1.id &&
                dateCreated == workout1.dateCreated &&
                dateModified == workout1.dateModified &&
                Objects.equals(workout, workout1.workout) &&
                Objects.equals(user, workout1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workout, dateCreated, dateModified, user);
    }
}
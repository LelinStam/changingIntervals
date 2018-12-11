package matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * The type role.
 */
@Entity(name = "Blog")
@Table(name = "blog")
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String title;

    private String blog;

    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "blog_user_id_fk")
    )
    private User user;

    /**
     * Instantiates a new Role.
     */
    public Blog() {
    }


    /**
     * Instantiates a new Blog.
     *
     * @param title       the title
     * @param blog        the blog
     * @param dateCreated the date created
     * @param user        the user
     */
    public Blog(String title, String blog, Date dateCreated, User user) {
        this.user = user;
        this.title = title;
        this.blog = blog;
        this.dateCreated = dateCreated;
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


    /**
     * Gets blog.
     *
     * @return Value of blog.
     */
    public String getBlog() {
        return blog;
    }

    /**
     * Gets dateCreated.
     *
     * @return Value of dateCreated.
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets new dateCreated.
     *
     * @param dateCreated New value of dateCreated.
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Sets new blog.
     *
     * @param blog New value of blog.
     */
    public void setBlog(String blog) {
        this.blog = blog;
    }

    /**
     * Gets title.
     *
     * @return Value of title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets new title.
     *
     * @param title New value of title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog1 = (Blog) o;
        return id == blog1.id &&
                Objects.equals(title, blog1.title) &&
                Objects.equals(blog, blog1.blog) &&
                Objects.equals(dateCreated, blog1.dateCreated) &&
                Objects.equals(user, blog1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, blog, dateCreated, user);
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", blog='" + blog + '\'' +
                ", dateCreated=" + dateCreated +
                ", user=" + user +
                '}';
    }
}
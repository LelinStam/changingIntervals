package matc.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * Represents a Location entry
 */
@Entity(name = "Location")
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "street")
    private String streetAddress;

    private String city;

    private String state;

    private String zip;

    /**
     * Instantiates a new Location.
    */
    public Location() {
    }


    /**
     * Instantiates a new Location.
     *
     * @param streetAddress the street address
     * @param city          the city
     * @param state         the state
     * @param zip   the state postal
     *
     */
    public Location( String streetAddress, String city, String state, String zip) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
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
     * Gets street address.
     *
     * @return the street address
    */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets street address.
     *
     * @param streetAddress the street address
    */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets city.
     *
     * @return the city
    */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
    */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets new state.
     *
     * @param state New value of state.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets state.
     *
     * @return Value of state.
     */
    public String getState() {
        return state;
    }

    /**
     * Gets state postal.
     *
     * @return the state postal
    */
    public String getZip() {
        return zip;
    }

    /**
     * Sets state postal.
     *
     * @param zip the state postal
    */
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id &&
                Objects.equals(streetAddress, location.streetAddress) &&
                Objects.equals(city, location.city) &&
                Objects.equals(state, location.state) &&
                Objects.equals(zip, location.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, streetAddress, city, state, zip);
    }

    @Override
    public String toString() {
        return "Location{" +
                ", id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", state=" + state + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }



}
package matc.persistence;

import matc.entity.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationsDaoTest {

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
        dao = new Dao(Location.class);
    }

    /**
     * Verify successful retrieval of a Location
     */
    @Test
    void getByIdSuccess() {
        Location retrievedLocation = (Location)dao.getById("1");
        assertEquals("345 Market St", retrievedLocation.getStreetAddress());
        assertEquals("Milwaukee", retrievedLocation.getCity());
        assertEquals("WI", retrievedLocation.getState());
        assertEquals("45660", retrievedLocation.getZip());
    }

    /**
     * Verify successful insert of a Location
     */
    @Test
    void insertSuccess() {

        Location newLocation = new Location("1901 Walker St", "Madison", "WI", "54776");
        int id = dao.insert(newLocation);
        assertNotEquals(0,id);
        Location insertedLocation = (Location)dao.getById(Integer.toString(id));
        assertTrue(insertedLocation.equals(newLocation));
    }


    /**
     * Verify successful delete of Location
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById("2"));
        assertNull(dao.getById("2"));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess() {
        String newCity = "LaCrosse";
        Location LocationToUpdate = (Location)dao.getById("1");
        LocationToUpdate.setCity(newCity);
        dao.saveOrUpdate(LocationToUpdate);
        Location retrievedLocation = (Location)dao.getById("1");
        assertTrue(LocationToUpdate.equals(retrievedLocation));
    }

    /**
     * Verify successful retrieval of all Locations
     */
    @Test
    void getAllSuccess() {
        List<Location> Locations = dao.getAll();
        assertEquals(3, Locations.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Location> Locations = dao.getByPropertyLike("state", "WI");
        assertEquals(2, Locations.size());
        assertEquals(1, Locations.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Location> Locations = dao.getByPropertyLike("city", "M");
        assertEquals(2, Locations.size());
    }

}
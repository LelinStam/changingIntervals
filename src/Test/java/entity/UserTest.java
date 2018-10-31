package entity;


import matc.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class UserTest {

   @Test
    void getAge() {
        User user = new User();

        LocalDate birthDate = LocalDate.parse("1968-01-01");
        user.setDateOfBirth(birthDate);
        int expectedAge = 50;
        int actualAge = user.getAge();

        assertEquals(expectedAge, actualAge);
    }

}
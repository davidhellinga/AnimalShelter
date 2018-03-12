package Animals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    private Animal animal;

    @Before
    public void DucklingGenerator() {
        animal = new Animal("Ugly Duckling", Gender.Male);
    }

    @Test
    public void TestConstructor() {
        assertEquals("Ugly Duckling", animal.getName());
        assertEquals(Gender.Male, animal.getGender());
        assertNull(this.animal.getReserver());
    }


    @Test
    public void TestReservation() {
        assertNull(animal.getReserver());
        assertTrue(animal.Reserve("John Doe"));
        assertNotNull(animal.getReserver());
        assertEquals("John Doe", animal.getReserver().getName());
        assertFalse(animal.Reserve("Jane Doe"));
    }

    @Test
    public void TestReservationTime() {
        // TODO: Implement this when interfaces have been explained.
        // We don't yet test the reserved time because it used the current
        // system clock to determine the result. Therefore we cannot check
        // if the values are the same, since two consecutive calls to
        // DateTime.Now are very likely to give different results. There is
        // a way to account for this, but the solution will use interfaces:
        // a concept that is not yet discussed in class. To be implemented.

    }
}
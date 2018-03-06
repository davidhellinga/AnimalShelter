package Animals;

import org.junit.Test;

import static org.junit.Assert.*;

public class CatTest {
    private Cat cat;

    @Test
    public void TestConstructor() {
        cat=new Cat("Ms. Meow", Gender.Female, "Scratches couch");
        assertEquals("Ms. Meow", cat.getName());
        assertEquals(Gender.Female, cat.getGender());
        assertNull(cat.getReserver());
        assertEquals("Scratches couch", cat.getBadHabits());
    }

    @Test
    public void TestReservation(){
        cat=new Cat("Ms. Meow", Gender.Female, "Scratches couch");
        assertNull(cat.getReserver());
        assertTrue(cat.Reserve("John Doe"));
        assertNotNull(cat.getReserver());
        assertEquals("John Doe", cat.getReserver().getName());
        assertFalse(cat.Reserve("Jane Doe"));
    }

    @Test
    public void TestReservationTime(){
        // TODO: Implement this when interfaces have been explained.
        // We don't yet test the reserved time because it used the current
        // system clock to determine the result. Therefore we cannot check
        // if the values are the same, since two consecutive calls to
        // DateTime.Now are very likely to give different results. There is
        // a way to account for this, but the solution will use interfaces:
        // a concept that is not yet discussed in class. To be implemented.

    }
}
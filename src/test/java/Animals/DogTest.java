package Animals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DogTest {

    private Dog dog;

    @Before
    public void DogGenerator(){
        dog=new Dog("Sgt. Woof", Gender.Male);
    }

    @Test
    public void TestConstructor() {
        assertEquals("Sgt. Woof", dog.getName());
        assertEquals(Gender.Male, dog.getGender());
        assertNull(dog.getReserver());
        assertFalse(dog.NeedsWalk());
    }

    @Test
    public void TestReservation(){
        assertNull(dog.getReserver());
        assertTrue(dog.Reserve("John Doe"));
        assertNotNull(dog.getReserver());
        assertEquals("John Doe", this.dog.getReserver().getName());
        assertFalse(dog.Reserve("Jane Doe"));
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
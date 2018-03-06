import Animals.Gender;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservationTest {

    private Reservation reservation;

    @Test
    public void TestNewCat(){
        this.reservation=new Reservation();
        assertEquals(0,reservation.getAnimals().size());
        this.reservation.NewCat("Ms. Meow", Gender.Female,"Scratches couch");
        assertEquals(1,reservation.getAnimals().size());
    }

    @Test
    public void TestNewDog(){
        this.reservation=new Reservation();
        assertEquals(0,reservation.getAnimals().size());
        this.reservation.NewDog("Sgt. Woof", Gender.Male);
        assertEquals(1,reservation.getAnimals().size());
    }


}

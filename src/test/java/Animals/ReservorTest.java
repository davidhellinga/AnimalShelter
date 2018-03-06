package Animals;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ReservorTest {

    @Test
    public void TestConstructor(){
        LocalDate reservedAt=LocalDate.now();
        Reservor reservor=new Reservor("John Doe", reservedAt);
        assertEquals("John Doe", reservor.getName());
        assertEquals(reservedAt, reservor.getReservedAt());
    }

}
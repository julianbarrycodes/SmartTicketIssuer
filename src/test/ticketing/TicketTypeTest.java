package test.ticketing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.ticketing.TicketType;

public class TicketTypeTest {
    @Test
    public void testSingleReducedPrice() {
        Assertions.assertEquals(2.20, TicketType.SINGLE_REDUCED.getPrice());
    }

    @Test
    public void testSingleFullPrice() {
        Assertions.assertEquals(3.20, TicketType.SINGLE_FULL.getPrice());
    }

    @Test
    public void testDayReducedPrice() {
        Assertions.assertEquals(5.50, TicketType.DAY_REDUCED.getPrice());
    }

    @Test
    public void testDayFullPrice() {
        Assertions.assertEquals(7.90, TicketType.DAY_FULL.getPrice());
    }
}

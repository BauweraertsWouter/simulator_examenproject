package be.kdg.se3.wbw.examenproject.simulator.domain.models;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

public class RushHourTest {
    RushHour rushHour;

    @Before
    public void setUp() throws Exception {
        rushHour = new RushHour(LocalTime.of(8,0), LocalTime.of(9,0));
    }

    @Test
    public void isRushHour_givenTimeBeforeBegin_returnsFalse() throws Exception {
        LocalTime time = LocalTime.of(7,59);
    }

    @Test
    public void isRushHour_givenTimeAfterEnd_returnsFalse() throws Exception {
        LocalTime time = LocalTime.of(9,59);
    }

    @Test
    public void isRushHour_givenTimeBetweenBeginAndEnd_returnsTrue() throws Exception {
        LocalTime time = LocalTime.of(8,15);
    }

    @Test
    public void isRushHour_givenTimeEqualToBegin_returnsTrue() throws Exception {
        LocalTime time = LocalTime.of(8,0);
    }

    @Test
    public void isRushHour_givenTimeEqualToEnd_returnsTrue() throws Exception {
        LocalTime time = LocalTime.of(9,0);
    }
}
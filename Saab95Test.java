import static org.junit.Assert.*;
import org.junit.Test;

public class Saab95Test {

    @Test
    public void testSpeedFactorTurboOff() {
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        double expected = 1.25;
        assertEquals(expected, saab.speedFactor(), 0.0001);
    }

    @Test
    public void testSpeedFactorTurboOn() {
        Saab95 saab = new Saab95();
        saab.setTurboOn();
        double expected = 1.625;
        assertEquals(expected, saab.speedFactor(), 0.0001);
    }

    @Test
    public void testIncrementSpeed() {
        Saab95 saab = new Saab95();
        saab.setTurboOff();
        saab.incrementSpeed(1);
        assertEquals(1.25, saab.getCurrentSpeed(), 0.0001);

        saab.incrementSpeed(0.5);
        assertEquals(1.875, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void testDecrementSpeed() {
        Saab95 saab = new Saab95();
        saab.startEngine(); 
        saab.setTurboOff();

        saab.incrementSpeed(1);
        assertEquals(1.35, saab.getCurrentSpeed(), 0.0001);

        saab.decrementSpeed(0.5);
        assertEquals(0.725, saab.getCurrentSpeed(), 0.0001);
    }
}

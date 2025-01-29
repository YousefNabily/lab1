import org.junit.Test;
import static org.junit.Assert.*;

public class Volvo240Test {

    @Test
    public void testSpeedFactor() {
        Volvo240 volvo = new Volvo240();
        assertEquals(1.25, volvo.speedFactor(), 0.0001);
    }

    @Test
    public void testIncrementSpeed_exactValue() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
             
        double incrementAmount = 0.5;
        double expectedSpeed = volvo.getCurrentSpeed() + volvo.speedFactor() * incrementAmount; 

        volvo.incrementSpeed(incrementAmount);
        double actualSpeed = volvo.getCurrentSpeed();

        assertEquals(expectedSpeed, actualSpeed, 0.0001);
    }

    @Test
    public void testIncrementSpeed_doesNotExceedEnginePower() {
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();

        volvo.incrementSpeed(100); 
        assertEquals(volvo.getEnginePower(), volvo.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void testDecrementSpeed_doesNotGoBelowZero() {
        Volvo240 volvo = new Volvo240();
        volvo.decrementSpeed(1.0); 
        assertEquals(0,volvo.getCurrentSpeed(),0.0001);
    }
}

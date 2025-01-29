import java.awt.*;

public class Volvo240 extends Vehicle{

    private static final double trimFactor = 1.25;
    
    public Volvo240(){
        super(4, 100, 0, Color.black, "Volvo240");
        stopEngine();
    }
    
   @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    @Override
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

}
import java.awt.*;

public abstract class Vehicle implements Movable {

    public int nrDoors;
    public double enginePower;
    public double currentSpeed;
    public Color color;
    public String modelName;
    private double x;             
    private double y;            
    private double heading;    


    public Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.x = 0.0;
        this.y = 0.0;
        this.heading = 0.0;
    }
    
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }
    
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    public abstract void  incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);

    public abstract double speedFactor();


    public void move() {
        // Konvertera heading från grader till radianer
        double rad = Math.toRadians(heading);
        x += getCurrentSpeed() * Math.cos(rad);
        y += getCurrentSpeed() * Math.sin(rad);
    }

    public void turnLeft() {
        // Öka heading med 90 grader
        heading = (heading + 90) % 360;
    }


    public void turnRight() {
        // Minska heading med 90 grader (lägg till 360 för att hantera negativa tal)
        heading = (heading - 90 + 360) % 360;

    }
}
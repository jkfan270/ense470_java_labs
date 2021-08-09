/**
 * Decorator file
 * @author Jinkai Fan
 */
public abstract class Decorator extends Car 
{
    public static final int NUM_DECORATORS = 6;
    
    protected Car car;
    
    public Decorator(Car car)
    {
        this.car = car;
    }

    public double getPrice()
    {
        return car.getPrice();
    }
    
}

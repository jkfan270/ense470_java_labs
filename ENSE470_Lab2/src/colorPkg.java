/**
 * Color package
 * @author Jinkai Fan
 */
public class colorPkg extends Decorator
{
    private double price = 1400.00;
    
    public colorPkg(Car car)
    {
        super(car);
    }

    public double getPrice()
    {
        return car.getPrice()+price;
    }
}

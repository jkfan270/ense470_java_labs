/**
 * Block heater option
 * @author Jinkai Fan
 */
public class blockHeater extends Decorator
{
    private double price = 700.00;
    
    public blockHeater(Car car) {
    super(car);
    }

    public double getPrice() {
        return car.getPrice() + price;
    }
}

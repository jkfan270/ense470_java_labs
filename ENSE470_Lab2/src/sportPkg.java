/**
 * Sport Package
 * @author Jinkai Fan
 */
public class sportPkg extends Decorator
{
    private double price = 3200.00;
    
    public sportPkg(Car car) {
    super(car);
    }

    public double getPrice() {
        return car.getPrice() + price;
    }
}

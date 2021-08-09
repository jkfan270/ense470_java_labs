/**
 * Interior sport package
 * @author Jinkai Fan
 */
public class inSportPkg extends Decorator
{
    private double price = 4900.00;
    
    public inSportPkg(Car car) {
    super(car);
    }

    public double getPrice() {
        return car.getPrice() + price;
    }
}
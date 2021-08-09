/**
 * Night Pacakge
 * @author Jinkai Fan
 */
public class nightPkg extends Decorator
{
    private double price = 3700.00;
    
    public nightPkg(Car car) {
    super(car);
    }

    public double getPrice() {
        return car.getPrice() + price;
    }
}

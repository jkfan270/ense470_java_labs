/**
 * Milk Ingredients 
 * 
 */
public class Milk extends Ingredients {

    public Milk() 
    {
       super("Milk", CoffeeMaker.MAX_INVENTORY);
    }
    
    public Milk(int value) 
    {
	super("Milk", value);
    }
    
}

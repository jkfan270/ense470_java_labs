/**
 * Coffee Ingredients
 * 
 */
public class Coffee extends Ingredients 
{

	public Coffee(){
		super("Coffee", CoffeeMaker.MAX_INVENTORY);
	}

	public Coffee(int value) 
        {
		super("Coffee", value);
	}

}
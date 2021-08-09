/**
 * Sugar Ingredients 
 * 
 */
public class Sugar extends Ingredients 
{

	public Sugar(){
		super("Sugar", CoffeeMaker.MAX_INVENTORY);
	}

	public Sugar(int value) {
		super("Sugar", value);
	}

}

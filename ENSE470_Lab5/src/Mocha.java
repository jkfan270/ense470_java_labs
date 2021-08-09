/**
 * Mocha receipt
 * 
 */
public class Mocha extends Recipe
{
    public Mocha() 
    {
	super("Mocha");
	this.setIngredient(new Milk(2));
	this.setIngredient(new Sugar(2));
	this.setIngredient(new Coffee(2));
    }
}

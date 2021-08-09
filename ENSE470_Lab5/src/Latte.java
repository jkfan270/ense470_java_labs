/**
 * Latte receipt
 * 
 */
public class Latte extends Recipe
{
    public Latte()
    {  
	super("Latte");
	this.setIngredient(new Milk(3));
	this.setIngredient(new Coffee(2));
    }
}

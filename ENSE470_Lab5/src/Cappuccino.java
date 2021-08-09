/**
 * Cappuccino receipt
 * 
 */
public class Cappuccino extends Recipe
{
    public Cappuccino() 
    {
	super("Cappuccino");
	this.setIngredient(new Milk(2));
        this.setIngredient(new Coffee(2));
    }
   
}
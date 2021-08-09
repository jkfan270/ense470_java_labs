
import java.util.ArrayList;


/**
 * Amount of milk coffee sugar 
 * @author Jinkai Fan
 */

public class Inventory 
{
    public int amountOfMilk;
    public int amountOfCoffee;
    public int amountOfSugar;
    
    public ArrayList<Ingredients> ingredients = new ArrayList<Ingredients>();
    
    public ArrayList<Ingredients> getIngredientList()
    {
        return this.ingredients;
    }
    
    //CoffeeMaker c = new CoffeeMaker();
    
    /**
     * Inventory Constructor
     */
    public Inventory()
    {
        this.ingredients.add(new Milk());
        this.ingredients.add(new Coffee());
	this.ingredients.add(new Sugar());
    }

 
/**
 * Add inventory method
* @param inventory
* @return true if added.
*/
    public boolean addInventory(Inventory inventory)
    {
        for(Ingredients i : inventory.getIngredientList())
        {
            if(this.getIngredient(i.getName()) != null)
            {
                this.getIngredient(i.getName()).addIngredient(i);
            }
            else
            {
                this.addIngredient(i);
            }
        }
        return true;
    }
    
/**
 * addIngredient method
 * @param i
 * @return true if added and if it is already there.
 */
    public boolean addIngredient(Ingredients i)
    {
        if(this.getIngredient(i.getName()) == null)
        {
            this.ingredients.add(i);
            return true;
        }
        else
        {
            this.getIngredient(i.getName()).addIngredient(i);
            return true;
        }
    }

/**
 * getIngredient method
 * @param className
 * @return i if ingredient got and null if empty.
 */    
    public Ingredients getIngredient(String className)
    {
        for(Ingredients i : this.ingredients)
        {
            if(i.getName() == className)
                return i;
        }
        return null;
    }
 
/**
 * getIngredientLevel method
 * @param className
 * @return 0 if null and getIngredient(className).getLevel() if got.
 */    
    public int getIngredientLevel(String className)
    {
        if(this.getIngredient(className) == null)
        {
            return 0;
        }
        else 
            return this.getIngredient(className).getLevel();
    }

/**
 * setIngredient method
 * @param name
 * @param value
 * @return true if not empty and false if it is.
 */   
    public boolean setIngredient(String name, int value)
    {
        if(getIngredient(name) != null)
        {
            getIngredient(name).setLevel(value);
            return true;
        }
        else
            return false;
    }
}

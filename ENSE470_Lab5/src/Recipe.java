
import java.util.ArrayList;


/**
 * A recipe is made up of coffee, milk, and sugar in units of parts. 
 * @author Jinkai Fan
 */

public class Recipe 
{
    String name;
    //public int milkLevel;
    //public int sugarLevel;
   //public int coffeeLevel;
    
    public ArrayList<Ingredients> recipe = new ArrayList<Ingredients>();
    
    public ArrayList<Ingredients> getIngredients()
    {
        return this.recipe;
    }

    /**
     * Recipe constructor representing a Recipe for our CoffeeMaker.
     * @param recipeName recipeName
     * @param milkLevel milkLevel
     * @param sugarLevel sugarLevel
     * @param coffeeLevel coffeeLevel
     */
    public Recipe(String recipeName)
    {

        CoffeeMaker c = new CoffeeMaker();
        
        this.name = recipeName;
	//this.milkLevel = milkLevel;
	//this.sugarLevel = sugarLevel;
	//this.coffeeLevel = coffeeLevel;
        
    }
    
    /**
     * Getter of the property Name
     * @return Returns the Name.
     */
    public String getRecipeName()
    {
        return this.name;
    }
    

    /**
     * Getter of the property milkLevel
     * @return Returns the milkLevel.
     */
    /*
    public int getMilkLevel()
    {
        return this.milkLevel;
    }
    */
    /**
     * Getter of the property sugarLevel
     * @return Returns the sugarLevel.
     */
    /*
    public int getSugarLevel()
    {
        return this.sugarLevel;
    }
    */
    /**
     * Getter of the property coffeeLevel
     * @return Returns the coffeeLevel.
     */
    /*
    public int getCoffeeLevel()
    {
        return this.coffeeLevel;
    }
    */
    
    /**
     * getIngredient method
     * @param name
     * @return i if there is one.
     */
    public Ingredients getIngredient(String name)
    {
        for(Ingredients i: recipe)
        {
            if(i.getName().equals(name))
            {
                return i;
            }
        }
        return null;
    }
    
    /**
     * getIngredientLevel method
     * @param name
     * @return name if not null and 0 if null.
     */
    	public int getIngredientLevel(String name) 
        {
		if(getIngredient(name) != null) {
			return getIngredient(name).getLevel();
		} else {
			return 0;
		}
	}

    /**
     * setIngredient method
     * @param in
     * @return true if setted.
     */    
    public boolean setIngredient(Ingredients in) {
	if(this.getIngredient(in.getName()) != null) 
        {
		if(in.getLevel() >= CoffeeMaker.MAX_INVENTORY) {
				getIngredient(in.getName()).setLevel(CoffeeMaker.MAX_INVENTORY);
			} else {
				getIngredient(in.getName()).setLevel(in.getLevel());
			}
		} else {
			if(in.getLevel() >= CoffeeMaker.MAX_INVENTORY) {
				in.setLevel(CoffeeMaker.MAX_INVENTORY);
			}
			if(in.getLevel() <= 0) {
				in.setLevel(0);
			}
			this.recipe.add(in);
		}
		return true;
	}
    
}

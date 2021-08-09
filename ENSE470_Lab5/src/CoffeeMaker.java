
import java.util.ArrayList;



/**
 * This coffee maker can store up to 4 recipes in its memory. 
 * A recipe is made up of coffee, milk, and sugar in units of parts. 
 * 
 * @author Jinkai Fan
 */

public class CoffeeMaker {
    static int MAX_INVENTORY = 20;
    static int MAX_NUM_RECIPES = 4;
    
    //CoffeeMaker c = new CoffeeMaker();
    public ArrayList<Recipe> list = new ArrayList(MAX_NUM_RECIPES);
    
   private Inventory in;
    final Inventory Inventory;
    
    /**
     * Constructor for the coffee maker The inventory should be created and filled.
     */   
    public CoffeeMaker()
    {
        this.Inventory= new Inventory();
        
    }
    

    /**
     * addRecipe Method
     * @param rAdd Will add a recipe if possible
     * @return true if added and false if not
     */
    public boolean addRecipe(Recipe rAdd) 
    {
	if(list.size() >4 ) 
        {
            list.add(rAdd);
            System.out.println("Recipe added successfully.");
            return true;
	} 
        else 
        {
            System.out.println("Only max 4 recipes can be added!");
            return false;
	}
	}
    
    /**
     * editRecipe method
     * @param recipe will edit a recipe if exits
     * @return ture if edited and false if not
     */
    public boolean editRecipe(Recipe recipe)
    {
        if(getRecipe(recipe.getRecipeName())!=null)
        {
            Recipe rec = this.getRecipe(recipe.getRecipeName());
            this.list.remove(rec);
            this.list.add(recipe);
            System.out.println("Recipe edited successfuuly.");
            return true;
        }
        else
        {
            System.out.println("No matches.");
            return false;
        }
    }
    
    /**
     * deleteRecipe Method
     * @param recipeName Will delete a recipe if possible
     * @return true if deleted and false if not
     */
    public boolean deleteRecipe(String recipeName)
    {
        if(this.getRecipe(recipeName)!= null)
        {
            this.list.remove(this.getRecipe(recipeName));
            System.out.println("Recipe deleted.");
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Getter of the property inventory
     * @return Returns the inventory
     */
    public Inventory getInventory()
    {
        return this.getInventory();
    }
    
    /**
     * getRecipe Method
     * @param recipeName name String
     * @return Recipe or NULL
     */
    public Recipe getRecipe(String recipeName)
    {
        for(Recipe recipe: list)
        {
            if(recipe.getRecipeName().equals(recipeName))
                {
                    return recipe;
                }
        }
        System.out.println("Nothing to show.");
        return null;
        
    }
    
    /**
     * makeCoffee Method
     * @param recipeName Will make the coffee if the recipe is there
     * @return true if made or false if not
     */
    public boolean makeCoffee(String recipeName)
    {
        Recipe rec = getRecipe(recipeName);
        if(rec == null)
        {
            return false;
        }
        
        for(Ingredients i : rec.getIngredients()) 
        {
            if(this.getInventory().getIngredientLevel(i.getName()) < i.getLevel()) 
            {
		return false;
            }
        }
        for(Ingredients i : rec.getIngredients()) 
        {
            this.Inventory.setIngredient(i.getName(),this.Inventory.getIngredientLevel(i.getName()) - i.getLevel());
	}
		return true;
    }
    
    /**
     * addInventory method 
     * @param inventory Will add stuff to inventory
     * @return added inventory
     */
    public boolean addInventory(Inventory inventory) 
    {
	return (this.Inventory.addInventory(inventory));
	}

}

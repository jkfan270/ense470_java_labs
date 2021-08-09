

/**
 * Recipe.java version 1.0 Jan 20, 2011
 * @author Trevor Douglas
 *
 * @version
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @author tdouglas
 *
 */
public class Recipe {
    private String recipeName;
    private List<Ingredient> ingredients = new ArrayList<>();


    /**
     * Getter of the property <tt>Name</tt>
     *
     * @return Returns the Name.
     *
     */
    public String getRecipeName() {
    	return recipeName;
    }

    public void setRecipeName(String name)
    {
        this.recipeName = name;
    }
    
    public List<Ingredient> getIngredients()
    {
        return ingredients;
    }
    
    public boolean addIngredient(String name, int quantity)
    {
        return ingredients.add(new Ingredient(name, quantity));
    }
    
    public boolean deleteIngredient(String ingredient)
    {
        return ingredients.remove(ingredient);
    }
    
    public void removeAllIngredients()
    {
        ingredients.clear();
    }
}


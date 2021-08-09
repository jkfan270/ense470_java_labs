/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jkfan
 */
public class RecipeMenu {
    private List<Recipe> recipes = new ArrayList<>();
    
    
    public boolean addRecipe(String name, List<Ingredient> ingredients)
    {
        if(name.isEmpty()||ingredients.isEmpty())
        {
            return false;
        }
        
        Recipe recipe = new Recipe();
        recipe.setRecipeName(name);
        
        for(Ingredient ingredient: ingredients)
        {
            recipe.addIngredient(ingredient.getName(), ingredient.getQuantity());
            
        }
        return recipes.add(recipe);
    }
    
    public boolean editRecipe(String name, List<Ingredient> ingredients) 
    {
        if(name.isEmpty()|| ingredients.isEmpty())
        {
            return false;
        }
        
        Recipe recipeToEdit = null;
        
        for(Recipe r: recipes)
        {
            if(r.getRecipeName().equals(name))
                recipeToEdit = r;
        }
        
        if(recipeToEdit == null)
            return false;
        
        recipeToEdit.removeAllIngredients();
        
        for(Ingredient ingredient:ingredients)
        {
            recipeToEdit.addIngredient(ingredient.getName(), ingredient.getQuantity());
        }
        return true;
    }
    
    public boolean removeRecipe(String name)
    {
        if(name.isEmpty()|| recipes.isEmpty())
        {
            return false;        
        }
        
        for(Recipe r:recipes)
        {
            if(r.getRecipeName().equals(name))
            {
                return recipes.remove(r);
            }
        }
        
        return false;
    }
    
    public List<Recipe> getRecipes()
    {
        return recipes;
    }
}

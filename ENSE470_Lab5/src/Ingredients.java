/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jkfan
 */
public class Ingredients 
{
    public String ingredientName;
    public int ingredientLevel;
    
/**
* Ingredients constructor
* @param name
* @param level
* 
*/
    public Ingredients(String name, int level)
    {
        this.ingredientName = name;
        this.ingredientLevel = level;
    }
        
/**
 * getLevel constructor
 * @return ingredientLevel
 */    
    public int getLevel()
    {
        return this.ingredientLevel;
    }
 
/**
 * setLevel constructor
 * @param level 
 */
    public void setLevel(int level)
    {
        this.ingredientLevel = level;
    }

/**
 * Determine if the ingredients were used or not
 * @param level
 * @return false if not and true if it is.
 */    
    public boolean IngredientsUsed(int level) 
    {
        if(this.ingredientLevel - level < 0) 
        {
            return false;
        }
        else
        {
            this.ingredientLevel = this.ingredientLevel - level;
            return true;
        }
    }
    
/**
 * Determine if the ingredients can be added or not
 * @param i
 * @return true if could and false not.
 */    
    public boolean addIngredient(Ingredients i)
    {
        if(i.getName() == this.getName())
        {
            this.ingredientLevel = this.ingredientLevel + i.getLevel() >= CoffeeMaker.MAX_INVENTORY ? CoffeeMaker.MAX_INVENTORY : this.ingredientLevel + i.getLevel();
            return true;
        }
        else
            return false;
    }
    
 /**
  * setName constructor
  * @return ingredientName
  */   
    public String getName()
    {
        return this.ingredientName;
    }
}

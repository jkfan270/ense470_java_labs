/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jkfan
 */
public class CoffeeMakerTest 
{
 
    @Test
    public void testCoffeeMaker() 
    {
        CoffeeMaker c = new CoffeeMaker();
        assertEquals(CoffeeMaker.MAX_INVENTORY, c.Inventory.getIngredientLevel("Coffee"));
	assertEquals(CoffeeMaker.MAX_INVENTORY, c.Inventory.getIngredientLevel("Milk"));
	assertEquals(CoffeeMaker.MAX_INVENTORY, c.Inventory.getIngredientLevel("Sugar"));
        assertEquals(0, c.list.size());
    }
    
    @Test
    public void testAddRecipe() 
    {
        CoffeeMaker c = new CoffeeMaker();
        while(c.list.size() < CoffeeMaker.MAX_NUM_RECIPES) 
        {
            assertEquals(true, c.addRecipe(new Recipe("Loop")));
            assertEquals(false, c.addRecipe(new Recipe("ExceedRecipe")));
            assertEquals(true, c.deleteRecipe("Loop"));
            assertEquals(true, c.addRecipe(new Recipe("Expulse")));
	}
    }
    
    @Test
    public void testEditRecipe() 
    {
        CoffeeMaker c = new CoffeeMaker();
	assertEquals(false, c.editRecipe(new Recipe("notExist")));
	Recipe r = new Recipe("DoubleDouble");
	r.setIngredient(new Coffee(1));
	r.setIngredient(new Sugar(2));
	r.setIngredient(new Milk(1));
	assertEquals(false, c.editRecipe(r));
	assertEquals(1, c.getRecipe("DoubleDouble").getIngredientLevel("Milk"));
	assertEquals(2, c.getRecipe("DoubleDouble").getIngredientLevel("Sugar"));
	assertEquals(1, c.getRecipe("DoubleDouble").getIngredientLevel("Coffee"));
	assertEquals(false, c.editRecipe(new Recipe("notExist")));	
    }
    
    @Test
    public void testDeleteRecipe() 
    {
        CoffeeMaker c = new CoffeeMaker();
	assertEquals(false, c.deleteRecipe("test1"));
	assertEquals(true, c.addRecipe(new Recipe("test1")));
	assertEquals(true, c.deleteRecipe("test1"));
	assertEquals(0, c.list.size());
	assertEquals(false, c.deleteRecipe("nonExistantRecipe"));
    }

    @Test
    public void testAddInventory() 
    {
        CoffeeMaker c = new CoffeeMaker();	
        c.makeCoffee("DoubleDouble");
        Inventory addMe = new Inventory();
        addMe.setIngredient("Coffee", 1);
        addMe.setIngredient("Milk", 1);
        addMe.setIngredient("Sugar", 0);
        c.addInventory(addMe);
        assertEquals(CoffeeMaker.MAX_INVENTORY - 1, c.getInventory().getIngredientLevel("Coffee"));
        c.addInventory(addMe);
        c.addInventory(addMe);
        assertEquals(CoffeeMaker.MAX_INVENTORY, c.getInventory().getIngredientLevel("Coffee"));
    }


}

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
public class RecipeTest 
{
@Test
	public void testRecipe() 
        {
		Recipe r = new Recipe("test1");
		r.setIngredient(new Coffee(1));
		assertEquals("test1", r.getRecipeName());
		assertEquals(1, r.getIngredientLevel("Coffee"));
		
		r = new Recipe("Exceed");
		r.setIngredient(new Coffee(21));
		r.setIngredient(new Milk(-1));
		assertEquals("Exceed", r.getRecipeName());
		assertEquals(CoffeeMaker.MAX_INVENTORY, r.getIngredientLevel("Coffee"));
		assertEquals(0, r.getIngredientLevel("Milk"));
	}
}

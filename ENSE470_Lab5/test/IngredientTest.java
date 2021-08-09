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
public class IngredientTest 
{
    
@Test
	public void testUseIngredient() {
		
		Ingredients milk = new Milk();
		assertEquals(CoffeeMaker.MAX_INVENTORY, milk.getLevel());
		
		assertEquals(true, milk.IngredientsUsed(CoffeeMaker.MAX_INVENTORY - 1));
		assertEquals(1, milk.getLevel());
		
		assertEquals(false, milk.IngredientsUsed(10));
		assertEquals(1, milk.getLevel());
	}

	@Test
	public void testAddIngredient() {
		
		Ingredients milk = new Milk();
		milk.setLevel(1);
		
		Ingredients milk2 = new Milk();
		milk2.setLevel(1);
		
		milk.addIngredient(milk2);
		assertEquals(2, milk.getLevel());
	}
}

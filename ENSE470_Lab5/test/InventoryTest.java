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
public class InventoryTest 
{
 
        @Test
	public void testInventory() 
        {
		Inventory i = new Inventory();
		assertEquals(CoffeeMaker.MAX_INVENTORY, i.getIngredientLevel("Coffee"));
		assertEquals(CoffeeMaker.MAX_INVENTORY, i.getIngredientLevel("Milk"));
		assertEquals(CoffeeMaker.MAX_INVENTORY, i.getIngredientLevel("Sugar"));
	}

	
	@Test
	public void testAdd() 
        {
		Inventory in = new Inventory();
		in.setIngredient("Coffee", 1);
		in.setIngredient("Milk", 1);
		in.setIngredient("Sugar", 1);
		
		Inventory in2 = new Inventory();
		in2.setIngredient("Coffee", 2);
		in2.setIngredient("Milk", 2);
		in2.setIngredient("Sugar", 2);
		
		assertEquals(true, in.addInventory(in2));
		assertEquals(3, in.getIngredientLevel("Coffee"));
		assertEquals(3, in.getIngredientLevel("Milk"));
		assertEquals(3, in.getIngredientLevel("Sugar"));

		Inventory in3 = new Inventory();
		in3.setIngredient("Coffee", 2);
		in3.setIngredient("Milk", 2);
		in3.setIngredient("Sugar", 2);

		assertEquals(5, in.getIngredientLevel("Coffee"));
		assertEquals(5, in.getIngredientLevel("Milk"));
		assertEquals(5, in.getIngredientLevel("Sugar"));
	}
	
	@Test
	public void testAddIngredient() 
        {
		Inventory in = new Inventory();
		in.setIngredient("Milk", 1);;
		in.addIngredient(new Milk(2));
		assertEquals(3, in.getIngredientLevel("Milk"));		
		in.addIngredient(new Milk(CoffeeMaker.MAX_INVENTORY));
		assertEquals(CoffeeMaker.MAX_INVENTORY, in.getIngredientLevel("Milk"));
		
	}

}

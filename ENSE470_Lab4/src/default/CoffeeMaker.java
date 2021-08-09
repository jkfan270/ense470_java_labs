
import java.util.Iterator;

/**
 * CoffeeMaker constructor 
 * 
 * The inventory should be created and filled up.
 */

public class CoffeeMaker {
	
	
	//public static final int MAX_NUM_RECIPES = 4; // Maximum number of recipes
	//public static final int MAX_INVENTORY = 20;
	//private Recipe[] recipeArray; // This is the array of recipes
	//private int numRecipes = 0;
	private Inventory inventory; // This is our inventory in the coffee maker
        private RecipeMenu recipeMenu ; //This is our menu that hold all receipts
	
        private static final CoffeeMaker INSTANCE = new CoffeeMaker();
        
	/**
	 * Constructor for the coffee maker
	 * The inventory should be created and filled.
	 */
	public CoffeeMaker() {
		//Setup inventory
		//recipeArray = new Recipe[MAX_NUM_RECIPES];
                recipeMenu = new RecipeMenu();

		// Fill up the inventory in the coffee maker.
		inventory = new Inventory();
		//inventory.setMilk(20);
		//inventory.setSugar(20);
		//inventory.setCoffee(20);


	}
        
        public static CoffeeMaker getInstance()
        {
            return INSTANCE;
        }

        public RecipeMenu getRecipeMenu()
        {
            return recipeMenu;
        }
        
	
	/**
	 * Getter of the property <tt>inventory</tt>
	 *
	 * @return Returns the inventory.
	 */
	public Inventory getInventory() {
		return inventory;
	}

        
        public void printCurrentInventory()
        {
            System.out.println("Current Inventory is: ");
            if(inventory.getReservoirs().isEmpty())
            {
                System.out.println("Nothing to show.");
                return;
            }
           
            // Reservoir res = new Reservoir();
            for(Reservoir res : inventory.getReservoirs()) 
            {
                System.out.println("Ingredient Name: " + res.getName() + "Price: $" + res.getPrice() + " Quantity: "
                + res.getQuantity()+ " " + res.getCapacity());
            }
        }

        public void printCurrentRecipes()
        {
            System.out.println("Current Recipe: ");
            if(recipeMenu.getRecipes().isEmpty())
            {
                System.out.println("Nothing to show");
                return;
            }
            
            for(Recipe rec : recipeMenu.getRecipes())
            {
                System.out.println("Recipe Name: " + rec.getRecipeName());
                for(Ingredient in : rec.getIngredients())
                {
                    System.out.println("Recipe Name: " + in.getName() + " Quantity: " + in.getQuantity());
                }
            }
        }


}

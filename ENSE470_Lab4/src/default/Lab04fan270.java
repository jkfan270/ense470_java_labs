/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

/**
 *
 * @author jkfan
 */
public class Lab04fan270 {
            Scanner sc = new Scanner(System.in);
           private CoffeeMaker coffeeMaker = CoffeeMaker.getInstance();
    public void loadIngredient()
    {
        coffeeMaker.getInventory().addReservoir("Dark roast coffee ", 10, 30);
        
        //Espresson recipe
        List<Ingredient> recipe1Ingredients = new ArrayList<>();
        recipe1Ingredients.add(new Ingredient("Dark roast coffee", 2));
        recipe1Ingredients.add(new Ingredient("Milk", 2));
        coffeeMaker.getRecipeMenu().addRecipe("Espresso", recipe1Ingredients);
        //Capp recipe
        List<Ingredient> recipe2Ingredients = new ArrayList<>();
        recipe2Ingredients.add(new Ingredient("Dark roast coffee", 30));
        recipe2Ingredients.add(new Ingredient("Milk", 30));
         coffeeMaker.getRecipeMenu().addRecipe("Cappuccino", recipe2Ingredients);
         //Latte recipe
        List<Ingredient> recipe3Ingredients = new ArrayList<>();
        recipe3Ingredients.add(new Ingredient("Dark roast coffee", 5));
        recipe3Ingredients.add(new Ingredient("Milk", 5));
        recipe3Ingredients.add(new Ingredient("Chocolate", 2));
         coffeeMaker.getRecipeMenu().addRecipe("Latte", recipe3Ingredients);    
    }
    
    public void user()
    {
        System.out.println();
        coffeeMaker.printCurrentInventory();
        coffeeMaker.printCurrentRecipes();

         System.out.println("Option:" +
                    "\n 0 - Add a Recipe" +
                    "\n 1 - Edit a Recipe" +
                    "\n 2 - Delete a Recipe" +
                    "\n 3 - Add Inventory" +
                    "\n 4 - Edit Inventory" +
                    "\n 5 - Delete Inventory" +
                    "\n 6 - Make Coffee" +
                    "\n 7 - Cancel");
         
         System.out.println("Please enter a number of your choice: ");
         int input = sc.nextInt();
         
         switch(input)
         {
               case 0: addRecipe();
                    break;
                case 1: editRecipe();
                    break;        
                case 2: deleteRecipe();
                    break;
                case 3: addInventory();
                    break;
                case 4: editInventory();
                    break;
                case 5: deleteInventory();
                    break;
                case 6: makeCoffee();
                    break;
                case 7: 
                        System.exit(0);
                    return;
                default:
                    break;
         }
         
    }
    
    public void addRecipe()
    {
        System.out.println("Enter a name for your new recipe:");
        String name = sc.next();
        
        List<Ingredient> ingredients = new ArrayList<>();
            System.out.println("Enter an ingredient for this recipe: ");
            String ingredientName = sc.next();

            boolean skipIteration = false;
            
            for(Ingredient i : ingredients) {
                if(i.getName().equals(ingredientName))
                    skipIteration = true;
            }

            System.out.println("Enter the quantity for this ingredient:");
            int ingredientQuantity = sc.nextInt();

            ingredients.add(new Ingredient(ingredientName, ingredientQuantity));

        boolean result = coffeeMaker.getRecipeMenu().addRecipe(name, ingredients);

        if(result)
            System.out.println("Recipe " + name + " has been added successfully");
        else
            System.out.println("Cannot add recipe ");
    }
    
    
    public void editRecipe()
    {
        System.out.println("Enter name of existing recipe:");
        String name = sc.next();
        List<Ingredient> ingredients = new ArrayList<>();
            System.out.println("Enter an ingredient for this recipe: ");
            String ingredientName = sc.next();

            boolean skipIteration = false;
            for(Ingredient i : ingredients) {
                if(i.getName().equals(ingredientName))
                    skipIteration = true;
            }
            System.out.println("Enter the quantity for this ingredient:");
            int ingredientQuantity = sc.nextInt();
            ingredients.add(new Ingredient(ingredientName, ingredientQuantity));

        boolean result = coffeeMaker.getRecipeMenu().editRecipe(name, ingredients);

        if(result)
            System.out.println("Recipe " + name + " has been edited successfully");
        else
            System.out.println("Cannot edit recipe ");
    }
    
    
    public void deleteRecipe()
    {
        System.out.println("Enter name of existing recipe:");
        String name = sc.next();
        boolean result = coffeeMaker.getRecipeMenu().removeRecipe(name);
        if(result)
            System.out.println("Recipe " + name + " has been deleted successfully");
        else
            System.out.println("Cannot delete recipe ");
    }
    
    
    public void addInventory()
    {
        System.out.println("Enter name of new Reservoir: ");
        String name = sc.next();
        System.out.println("Enter price per unit: ");
        double price = sc.nextDouble();
        System.out.println("Enter capacity of Reservoir: ");
        int capacity = sc.nextInt();

        coffeeMaker.getInventory().addReservoir(name, price, capacity);
    }
    
    public void editInventory()
    {
        System.out.println("Enter name of existing Reservoir: ");
        String name = sc.next();
        System.out.println("Enter new name for this Reservoir: ");
        String newName = sc.next();
        System.out.println("Enter new price per unit: (price > 0)");
        double newPrice = sc.nextDouble();
        System.out.println("Enter new capacity of Reservoir: (capacity > 0)");
        int newCapacity = sc.nextInt();

        coffeeMaker.getInventory().editReservoir(name, newName, newPrice, newCapacity);
    }
    
    public void deleteInventory()
    {
        System.out.println("Enter name of existing Reservoir: ");
        String name = sc.next();

        coffeeMaker.getInventory().deleteReservoir(name);
    }
    
    public void makeCoffee()
    {
        System.out.println("Enter name of recipe to make coffee from:");
        String name = sc.next();

        Recipe recipe = null;
        for(Recipe r : coffeeMaker.getRecipeMenu().getRecipes())
            if(r.getRecipeName().equals(name))
                recipe = r;

        if(recipe == null) {
            System.out.println("Recipe " + name + " does not exist");
            return;
        }

        List<Reservoir> ingredientReservoirs = new ArrayList<>();

        for(Reservoir r : coffeeMaker.getInventory().getReservoirs()) {

            for(Ingredient i : recipe.getIngredients()) {

                if(i.getName().equals(r.getName())) {

                    if(r.getQuantity() < i.getQuantity()) {
                        System.out.println("No enough quantity of " + r.getName() + " for this recipe");
                        return;
                    }

                    ingredientReservoirs.add(r);
                }
            }
        }

        if(ingredientReservoirs.size() != recipe.getIngredients().size()) {
            System.out.println("Invalid, no required ingredients.");
            return;
        }

        double price = 0;

        for(Reservoir r : ingredientReservoirs)
            for(Ingredient i: recipe.getIngredients())
                if(r.getName().equals(i.getName())) {
                    r.setQuantity(r.getQuantity() - i.getQuantity());
                    price += r.getPrice() * i.getQuantity();
                }
        System.out.println("Coffee has been successfully made!");
        System.out.println("The total cost: " + price);
    }
    
    public static void main(String[] args)
    {
        Lab04fan270 m = new Lab04fan270 ();
        m.loadIngredient();
        m.user();
    }
    
    
    
    
}

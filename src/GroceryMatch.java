import java.util.*;
import java.io.*;

/**
 * This is the main class of p1.  It provides the user interface and 
 * matching algorithm to see if there are sufficient ingredients for each recipe.
 *
 * YOU WILL NEED TO COMPLETE METHODS IN THIS CLASS
 */
public class GroceryMatch {
    
    // DO NOT EDIT DATA MEMBERS (use where needed in GroceryMatch program)
    private static final String RECIPE_NAME_INPUT_PROMPT = "Please input recipe name";
    private static final String SERVING_NUMBER_INPUT_PROMPT = "Please input number of servings";
    private static final String RECIPE_READY = "Dish is ready";
    
    private static final String RECIPE_NAME_NOT_FOUND_ERROR_MSG = "Recipe not found";
    private static final String SERVING_NUMBER_INVALID_ERROR_MSG = "Please enter positive integer for number of servings";
    private static final String UNRECOGNIZED_COMMAND_ERROR_MSG = "Unrecognized command";
    
    private GroceryList groceries;
    private RecipeList recipes;
    
    
    /** 
     * Calculate what is the maximum number of servings of this recipe using current GroceryList.
     * All ingredients must have enough for the maximum number of servings.
     * The maximum number of servings is 0 if any ingredient is not available in 
     * sufficient quantity for one serving.
     *
     * For example: if an omelet requires 4 eggs and 1 milk
     *              and there are 10 milk and 12 eggs in groceries,
     *              then the max servings of omelet recipes is 3 
     * 
     * @param recipe The recipe that you want to serve.
     * @return The maximum number of servings, return 0 if unable to serve a single serving.
     */
    public Integer calcMaxNumServing( Recipe recipe ) {

         // TODO COMPLETE THIS METHOD
    	

    }

    /** 
     * This method is called when the desired number of servings is greater than
     * maximum possible number of servings.  
     * 
     * This method will print how many more ingredients need to be bought for 
     * the insufficient ingredients. For sufficient ingredients, do not print.
     * One ingredient per line, format is "name: quantity", no leading or trailing spaces.
     * 
     * @param recipe The recipe that you can not serve.
     * @param numOfServing The number of servings of the recipe.
     */    
    public void reportShortage ( Recipe recipe, Integer numOfServing ) {

        // TODO complete this method

        // PROPOSED ALGORITHM FOR THIS METHOD
        // for each ingredient in the recipe
        //     for each ingredient in the GroceryList
        //         if the ingredient in the recipe is same as ingredient from list
        //             if the ingredient amount in groceries is insufficient, 
        //                 print how many more needs to be bought.
        //
        //         if the ingredient is not found in the GroceryList
        //            print how many more needs to be bought

    }

    /**
     * Reduce the quantities in GroceryList since you have used them for serving.
     * 
     * @param recipe The recipe you are serving.
     * @param numOfServing The number of servings of the recipe.
     */
    public void updateGroceries( Recipe recipe, Integer numOfServing ) {

        // TODO COMPLETE THIS METHOD

        // PROPOSED ALGORITHM
        // for each ingredient in the recipe
        //     for each ingredient in the grocery list
        //         if the ingredient in the recipe is same as ingredient from list
        //             deduct the recipe quantity times num servings from the grocery list ingredient quantity
        //             break out of inner loop to get to next recipe ingredient        

    }
    
    /**
     * Handle the command when you try to (U)se a recipe.
     * Input the recipe name and the number of servings, see if it is able to serve using the current GroceryList.
     *     (1) If able to serve, update the quantities in GroceryList, and print a serving success message.
     *     (2) If unable to serve, do not update the quantities in GroceryList, and do print the ingredients need to be bought.
     *  
     * @param stdin The scanner for input.
     */
    public void handleUse(Scanner stdin){

        //TODO Complete this method (for full credit be sure to make use of the other methods in this class)

        // Get recipe to make from user input
        System.out.println(RECIPE_NAME_INPUT_PROMPT);

        // If recipe name is not in the recipe list, display RECIPE NAME NOT FOUND MESSAGE and return         
        // Find recipe from the recipe list
        
        // Get number of servings from user input (positive integer only)
        System.out.println(SERVING_NUMBER_INPUT_PROMPT);

        // If invalid integer string or integer is not positive, display SERVING NUMBER INVALID MESSAGE AND return;
        
        
        // Calculate the maximum number of serving using current groceries.
        
        // If the max number of servings is less than number of servings asked for, report shortage, do not update grocery
        // Otherwise, display RECIPE READY MESSAGE and update GroceryList

    }
    
    /**
     * Print all the ingredient names and quantities in a GroceryList. One ingredient each line.
     * Do not sort the ingredients.  Display in the order added in the list.
     *
     *  name1: quantity1
     *  name2: quantity2
     *  name3: quantity3
     *  name4: quantity4
     * 
     * @param groceries The GroceryList you want to print.
     */
    public static void print( GroceryList groceries ) {

        // TODO complete this method using the iterator from the GroceryList

    }
    
    /**
     * Print all the recipes in a RecipeList. One recipe each line.
     * Do not sort the recipes.  Display recipes in the order they were added to the list.
     * Display ingredients in the order they were added to the recipe's ingredients.
     * 
     *  Output Format Example:
     *  omelet -> milk: 1, eggs: 4
     *  recipeName1 -> ingredient1: quantity1, ingredient2: quantity2, ...
     *  recipeName2 -> ingredient1: quantity1, ingredient2: quantity2, ...
     * 
     * @param recipes The RecipeList that contains the recipes that you want to print.
     */
    public static void print(RecipeList recipes) {

        // TODO complete this method using the iterator from the RecipeList

    }
    
    /** DO NOT EDIT THIS METHOD
     * Handle the command when you try to show how many servings are possible.
     * For each recipe in RecipeList, print the maximum number of servings using the current GroceryList.
     * One recipe per line, format is "recipe-name: max-num-of-serving", no leading or trailing spaces.
     * DO NOT EDIT THIS METHOD
     */
    public void handleShow() {
        Iterator<Recipe> itr = recipes.iterator();
        while ( itr.hasNext() ) {
            Recipe recipe = itr.next();
            Integer maxNumServing = calcMaxNumServing(recipe);
            System.out.println( String.format("%s: %d", recipe.getRecipeName(), maxNumServing) );
        }
    }

    /** DO NOT EDIT THIS METHOD
     * Main loop of GroceryMatch.
     * The main loop accept input commands, execute them, and print results.
     * The main loop accepts three types of commands:
     * 
     *   (1) q : Save current groceries to file and quit the program.
     *   
     *   (2) s : For all recipes, show how many servings are possible using the current GroceryList.
     *   
     *   (3) u : Use a recipe.
     *   
     * For other commands, print UNRECOGNIZED_COMMAND_ERROR and ignore.
     * DO NOT EDIT THIS METHOD
     * 
     * @param stdin The Scanner for input.
     */
    public void mainLoop(Scanner stdin) {
    String command = "";
        while( ! command.equalsIgnoreCase("q") ) {
            System.out.println("(s)ervings, (u)se, (q)uit? ");
            command = stdin.nextLine().trim();
            switch ( command ) {
            case "s": handleShow(); break;
            case "u": handleUse(stdin); break;
            case "q": Loaders.write(groceries,Loaders.OUTPUT_FILENAME); break;
            default: 
                System.out.println(UNRECOGNIZED_COMMAND_ERROR_MSG);
            }
        }
    }
    
    /** DO NOT EDIT THIS METHOD
     * This method will initialize groceries and recipes.
     * Return false when there is IOException.
     * 
     * @param groceryFile filename of groceries
     * @param recipeFile filename of recipes
     * @return Return true if GroceryList and RecipeList are successfully loaded. Return false if there are Exceptions.
     */
    public Boolean initialize( String groceryFile, String recipeFile ) {
        try {
            groceries = Loaders.loadGroceriesFromFile(groceryFile);
            print(groceries);
            recipes = Loaders.loadRecipesFromFile(recipeFile);
            print(recipes);
            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    /** DO NOT EDIT CONSTRUCTOR */
    public GroceryMatch(){
        groceries = new GroceryList();
        recipes = new RecipeList();
    }
    
    /** DO NOT EDIT THIS METHOD
     * The main method initializes the GroceryMatch object
     * and call the initialize method before starting the main menu loop.
     */
    public static void main(String[] args) throws IOException{
        Scanner stdin = new Scanner(System.in);
        GroceryMatch gm = new GroceryMatch();
        try {
            if ( ! gm.initialize(args[0],args[1]) ) {
                return;
            }
            gm.mainLoop(stdin);
        } catch (Exception e) {
            System.out.println("Usage: java GroceryMatch ingredientFileName recipeFileName");
        }
    }
}

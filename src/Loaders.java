///////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Fall 2017 
// PROJECT:          program1
// FILE:             Loaders.java
//
// TEAM:   Individual
// Author: Yu Song
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class provides the file reader methods for reading ingredient data files and recipe data files 
 * for the GroceryMatch program.  Do not change method signatures.  Do implement the missing method bodies.
 */
public class Loaders {
    
    // DO NOT CHANGE THESE CLASS CONSTANTS
    public static final String GROCERY_FILE_IO_ERROR_MSG = "IOError when loading grocery lists";
    public static final String RECIPE_FILE_IO_ERROR_MSG = "IOError when loading recipes";
    public static final String OUTPUT_FILENAME = "remaining.txt" ;
    
    /**
     * 1. Load groceries from file, each line of the file indicates an ingredient and its quantity.
     * 2. Each ingredient is in the format of "name : quantity", the number of spaces between name, colon and quantity can be any.
     *    And there may be leading and trailing spaces in a line.
     * 3. Name of ingredient may have duplicate, this means there may be multiple lines with the same ingredient name.
     *    If names are duplicated, their quantities should be summed up.
     * 4. If a line does not match the above mentioned format, ignore the line and continue reading the next line of ingredients.
     * 5. If an IOException happens, print GROCERY_FILE_IO_ERROR_MSG, and throw the exception.
     * 
     * @param filename The name of the file that contains the list of ingredients for the grocery.
     * @return A grocery list that includes all of the ingredients that were were properly read from the file.
     * @throws IOException if the filename does not exist, the error msg is displayed and the exception is thrown to calling method
     */
    public static GroceryList loadGroceriesFromFile(String filename) throws IOException {

        // TODO COMPLETE THIS METHOD
    	
    		File groceryFile = new File(filename);
    		String line;
    		ArrayList<String> entries;
    		GroceryList readGroceryList = new GroceryList();
    		
    		// check if file exists
    		if (!groceryFile.exists()) {
    			throw new IOException(GROCERY_FILE_IO_ERROR_MSG);
    		} else {
    			Scanner fileScan = new Scanner(groceryFile);
    			
    			// check if file is empty
    			if (!fileScan.hasNext()){
    				fileScan.close();
    				throw new IOException(GROCERY_FILE_IO_ERROR_MSG);
    			} else {
    				while (fileScan.hasNextLine()) {
    					line = fileScan.nextLine();
    					Scanner lineScan = new Scanner(line);
    					
    					// get all entries that follow the required format, trim spaces
    					lineScan.useDelimiter(":");
    					entries = new ArrayList<String>();
    					String name;
    					Double quantity;
    					while (lineScan.hasNext()) {
    						entries.add(lineScan.next().trim());
    					}
    					
    					// extract name & quantity from entries
    					if (entries.size() == 2) {
    						name = entries.get(0);
    						quantity = Double.parseDouble(entries.get(1));
    						Ingredient ingredientToAdd = new Ingredient(name, quantity);
    						
    						Ingredient currIng;
    						Iterator<Ingredient> itr = readGroceryList.iterator();
    	                    
    						// if ingredient already exits in the grocery list, add quantity; if not, add ingredient
    						if(readGroceryList.contains(ingredientToAdd)){
    							while (itr.hasNext()){
    								currIng = itr.next();
    								if(currIng.getName().equals(ingredientToAdd.getName())){
    									currIng.setQuantity(currIng.getQuantity()+ingredientToAdd.getQuantity());
    								}
    							}
    						} else {
    							readGroceryList.add(ingredientToAdd);
    						}    						
    					}
    					lineScan.close();
    				}
    				fileScan.close();
    				return readGroceryList;
    			}
    		}
    }
    
    /**
     * 1. Load recipes from file, each line of the file indicates a recipe.
     * 2. Each recipe is in the format "name -> ingredient1-name: ingredient1-quantity, ingredient2-name: ingredient2-quantity"
     * 3. The number of ingredients in a recipe can be any.
     * 4. The number of spaces between name and quantity can be any, and there may be leading and trailing spaces.
     * 5. For simplicity, names of recipes will not have duplication, names of ingredients in a recipe will not have duplication, the format of the recipe is guaranteed to be correct.
     * 6. Names of ingredients might not be in GroceryList, this means you need to buy this ingredient if you want to use this recipe.
     * 7. If an IOException happens, print RECIPE_FILE_IO_ERROR_MSG, and throw the exception.
     * 
     * @param filename The name of a file containing recipe information.
     * @return A recipe list containing the recipes read from the named file.
     * @throws IOException if the filename does not exist, the error msg is displayed and the exception is thrown to calling method
     */
    public static RecipeList loadRecipesFromFile( String filename ) throws IOException {

        // TODO COMPLETE THIS METHOD
    	
    	File recipeFile = new File(filename);
		String line;
		ArrayList<String> entries;
		RecipeList readRecipeList = new RecipeList();
		
		// check if file exists
		if (!recipeFile.exists()) {
			throw new IOException(RECIPE_FILE_IO_ERROR_MSG);
		} else {
			Scanner fileScan = new Scanner(recipeFile);

			// check if file is empty
			if (!fileScan.hasNext()){
				fileScan.close();
				throw new IOException(RECIPE_FILE_IO_ERROR_MSG);
			} else {
				while (fileScan.hasNextLine()) {
					line = fileScan.nextLine();
					Scanner lineScan = new Scanner(line);
					
					// get all entries that follow the required format, trim spaces
					lineScan.useDelimiter("->|\\,|\\:");
					entries = new ArrayList<String>();
					String recipeName;
					ArrayList<Ingredient> readIngredients = new ArrayList<Ingredient>();
					while (lineScan.hasNext()) {
						entries.add(lineScan.next().trim());
					}
					
					// extract recipe name & ingredients from entries
					recipeName = entries.get(0);
					for (int i = 0; i < entries.size()-2; i++){
						readIngredients.add(new Ingredient(entries.get(i+1), Double.parseDouble(entries.get(i+2))));
						i++;
					}
					
					// complete recipe list
					Recipe readRecipe = new Recipe(recipeName, readIngredients);
					readRecipeList.add(readRecipe);

					lineScan.close();	
				}
				fileScan.close();
				return readRecipeList;
			}
		}
    }

    /** 
     * Write the GroceryList items to the specified file.
     *
     * Each ingredient is written to the file in the order that the ingredient is found in the GroceryList
     * the format for each line is:
     *
     * ingredient_name: amount
     *
     * @param groceries grocery list of ingredients
     * @param filename name of the file to write them to.
     */
    public static void write(GroceryList groceries, String filename) {

        // TODO COMPLETE THIS METHOD
    	Iterator<Ingredient> itr = groceries.iterator();
		Ingredient currIng;
    	
		try{
    		PrintWriter writer = new PrintWriter(filename);
    		
    		while(itr.hasNext()){
				currIng = itr.next();
				writer.println(currIng.getName() + ": " + currIng.getQuantity());
			}
    		
    		writer.close();
    	} catch (IOException e) {
    		System.out.println("Unable to write ingredients to " + filename);
    	}
    }

}

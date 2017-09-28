import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class TestBench {
	
	public static final String GROCERY_FILE_IO_ERROR_MSG = "IOError when loading grocery lists";
    public static final String RECIPE_FILE_IO_ERROR_MSG = "IOError when loading recipes";
    public static final String OUTPUT_FILENAME = "remaining.txt" ;

	public static void main(String args[]) throws IOException {
// GroceryListLoader
		File groceryFile = new File("ingredients_errs.txt");
		String line;
		ArrayList<String> entries;
		GroceryList readGroceryList = new GroceryList();
		if (!groceryFile.exists()) {
			throw new IOException(GROCERY_FILE_IO_ERROR_MSG);
		} else {
			Scanner fileScan = new Scanner(groceryFile);
			if (!fileScan.hasNext()){
				fileScan.close();
				throw new IOException(GROCERY_FILE_IO_ERROR_MSG);
			} else {
				while (fileScan.hasNextLine()) {
					line = fileScan.nextLine();
					Scanner lineScan = new Scanner(line);
					lineScan.useDelimiter(":");
					entries = new ArrayList<String>();
					String name;
					Double quantity;
					while (lineScan.hasNext()) {
						entries.add(lineScan.next().replaceAll("\\s",""));
					}					
					if (entries.size() == 2) {
						name = entries.get(0);
						quantity = Double.parseDouble(entries.get(1));
						
						//test
						System.out.println(name+": "+quantity);
						System.out.println("------------------------");
						
						//test
						Ingredient curr;
						Iterator<Ingredient> itr = readGroceryList.iterator();
						
						Ingredient ingredientToAdd = new Ingredient(name, quantity);
						if(readGroceryList.contains(ingredientToAdd)){
							//test
							while (itr.hasNext()){
								curr = itr.next();
								if(curr.getName().equals(ingredientToAdd.getName())){
									System.out.println("the quantity used to be: "+curr.getQuantity());
									curr.setQuantity(curr.getQuantity()+ingredientToAdd.getQuantity());
									System.out.println("this is the new quantity: "+curr.getQuantity());
								}
								
							}
							
							
							
//							for (int i = 0; i < readGroceryList.size(); i++){
//								if (readGroceryList.get(i).getName().equals(ingredientToAdd.getName())){
//									readGroceryList.get(i).setQuantity(readGroceryList.get(i).getQuantity() + ingredientToAdd.getQuantity());
//								}
//							}
							
						} else {
							readGroceryList.add(ingredientToAdd);
						}    						
					}					
					lineScan.close();
				}
				
				//test
				for(int i=0;i<readGroceryList.size();i++){
					System.out.println(readGroceryList.get(i).getName()+": "+readGroceryList.get(i).getQuantity());
				}

			}
			fileScan.close();
			
			
// RecipeListLoader			
//		File recipeFile = new File("recipes3.txt");
//		String line;
//		ArrayList<String> entries;
//		RecipeList readRecipeList = new RecipeList();
//
//		// check if file exists
//		if (!recipeFile.exists()) {
//			throw new IOException(RECIPE_FILE_IO_ERROR_MSG);
//		} else {
//			Scanner fileScan = new Scanner(recipeFile);
//
//			// check if file is empty
//			if (!fileScan.hasNext()){
//				fileScan.close();
//				throw new IOException(RECIPE_FILE_IO_ERROR_MSG);
//			} else {
//				while (fileScan.hasNextLine()) {
//					line = fileScan.nextLine();
//					Scanner lineScan = new Scanner(line);
//
//					//FIXME need to follow the recipe format!!!
//					// get all entries that follow the required format
//					lineScan.useDelimiter("->|\\,|\\:");
//					entries = new ArrayList<String>();
//					String recipeName;
//					ArrayList<Ingredient> readIngredients = new ArrayList<Ingredient>();
//					while (lineScan.hasNext()) {
//						entries.add(lineScan.next().trim());
//					}
//
//					// extract recipe name & ingredient list from entries
//					recipeName = entries.get(0);
//					//test
//					System.out.println(recipeName);
//
//					for (int i = 0; i < entries.size()-2; i++){
//						readIngredients.add(new Ingredient(entries.get(i+1), Double.parseDouble(entries.get(i+2))));
//						//test
//						System.out.println(entries.get(i+1)+": "+entries.get(i+2));
//						i++;
//					}
//
//					Recipe readRecipe = new Recipe(recipeName, readIngredients);
//					readRecipeList.add(readRecipe);					
//
//					lineScan.close();	
//				}
//				fileScan.close();
//				// return readRecipeList;
//				System.out.println();
//
//				for(int i=0; i<readRecipeList.size(); i++){
//					System.out.print(readRecipeList.get(i).getRecipeName()+" -> ");
//					for (int j=0; j<readRecipeList.get(i).getIngredients().size(); j++){
//						System.out.print(readRecipeList.get(i).getIngredients().get(j).getName()+": "+readRecipeList.get(i).getIngredients().get(j).getQuantity()+", ");
//					}
//					System.out.println();
//				}
//			}
//
//
//		}

			
//FileWriter
			String filename = "myGList.txt";
			Iterator<Ingredient> itr = readGroceryList.iterator();
			Ingredient currIng;
			try {
				PrintWriter writer = new PrintWriter(filename);
				while(itr.hasNext()){
					currIng = itr.next();
					writer.println(currIng.getName() + ": " + currIng.getQuantity());
				}
				
//				for(int i = 0; i < readGroceryList.size(); i++){
//					writer.println(readGroceryList.get(i).getName() + ": " + readGroceryList.get(i).getQuantity());
//				}
				
				writer.close();
			} catch (IOException e){
				System.out.println("Unable to write ingredients to " + filename);
			}

		}
	}
}

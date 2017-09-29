import java.util.*;
import java.io.*;

public class MatchTest {
	
	public static void main(String args[]) throws IOException {
		GroceryMatch myMatch = new GroceryMatch();
		System.out.println(myMatch.initialize("groceries_match_test.txt", "recipe_match_test.txt"));
		
		Recipe myRecipe = myMatch.recipes.get(0); // omelet -> eggs: 4, milk: 1
		GroceryList myGro = myMatch.groceries;
		
		for(int i=0; i<myRecipe.getIngredients().size(); i++){
			System.out.println("Recipe needs: "+myRecipe.getIngredients().get(i).getName()+": "+myRecipe.getIngredients().get(i).getQuantity());
		}
		
		for(int i=0; i<myGro.size(); i++){
			System.out.println("I have: "+myGro.get(i).getName()+": "+myGro.get(i).getQuantity());
		}
		
		System.out.println("Max servings is: "+myMatch.calcMaxNumServing(myRecipe));
    	
    	
		
	}

}

// 1. dont need to handle empty file
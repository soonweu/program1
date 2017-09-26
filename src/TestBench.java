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
		File groceryFile = new File("ingredients_errs.txt");
		String line;
		ArrayList<String> entries;
		GroceryList readGroceryList = new GroceryList();
		if (!groceryFile.exists()) {
			throw new IOException(GROCERY_FILE_IO_ERROR_MSG);
		} else {
			Scanner fileScan = new Scanner(groceryFile);
			if (!fileScan.hasNext()){
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
						
						Ingredient ingredientToAdd = new Ingredient(name, quantity);
						if(readGroceryList.contains(ingredientToAdd)){
							for (int i = 0; i < readGroceryList.size(); i++){
								if (readGroceryList.get(i).getName().equals(ingredientToAdd.getName())){
									readGroceryList.get(i).setQuantity(readGroceryList.get(i).getQuantity() + ingredientToAdd.getQuantity());
								}
							}
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
		}
	}
	
}

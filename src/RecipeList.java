import java.util.ArrayList;
import java.util.Iterator;

/**
 * TODO COMPLETE THIS CLASS
 *
 */
public class RecipeList implements ListADT<Recipe> {
    
    // You may use an ArrayList<Recipe> as your internal data structure
	// you may use an ArrayList<Ingredient> as your internal data structure
    private ArrayList<Recipe> items;
    
    /**
     * The constructor
     */
    public RecipeList(){
    	items = new ArrayList<Recipe>();
    }
    
    /**
     * Iterator using an ArrayList<Ingredient> iterator
     */
    public Iterator<Recipe> iterator(){
    	return new ArrayList<Recipe>().iterator();
    }
    
    /**
     * Add method
     */
    public void add(Recipe item){
    	items.add(item);
    }
    
    // add item at position pos in the List, moving the items originally in positions 
    // pos through size()-1 one place to the right to make room 
    // (error if pos is less than 0 or greater than size())
    // throw IndexOutOfBoundsException if pos is less than zero or greater than size
    public void add(int pos, Recipe item){
    	if(pos < 0 || pos > items.size()){
    		throw new IndexOutOfBoundsException();
    	} else {
    		items.add(pos,item);
    	}
    }
    
    // return true iff item is in the List (i.e., there is an item x in the List such that x.equals(item))
    public boolean contains(Recipe item){
    	for (int i = 0; i < items.size(); i++){
    		if (items.get(i).getRecipeName().equals(item.getRecipeName())){
    			return true;
    		}
    	}
    	return false;
    }

    // return the number of items in the List.
    public int size(){
    	return items.size();
    }

    // return if the List is empty.
    public boolean isEmpty(){
    	if (items.isEmpty()){
    		return true;
    	} else {
    		return false;
    	}
    }

    //  return the item at position pos in the List 
    // throw IndexOutOfBoundsException if pos is less than zero or greater than or equal to size
    public Recipe get(int pos){
    	if (pos < 0 || pos >= items.size()){
    		throw new IndexOutOfBoundsException();
    	} else {
    		return items.get(pos);
    	}
    }

    // remove and return the item at position pos in the List, 
    // shifting the items originally in positions pos+1 through size()-1 
    // one place to the left to fill in the gap
    // throw IndexOutOfBoundsException if pos is less than zero or greater than or equal to size
    public Recipe remove(int pos){
    	if (pos < 0 || pos >= items.size()){
    		throw new IndexOutOfBoundsException();
    	} else {
    		Recipe removed = items.get(pos);
    		items.remove(pos);
    		return removed;
    	}
    }
}

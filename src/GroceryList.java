import java.util.ArrayList;
import java.util.Iterator;

/**
 * TODO COMPLETE THIS CLASS
 *
 */
public class GroceryList implements ListADT<Ingredient>  {

    // you may use an ArrayList<Ingredient> as your internal data structure
    private ArrayList<Ingredient> items;
    
    /**
     * The constructor
     */
    public GroceryList(){
    	items = new ArrayList<Ingredient>();
    }
    
    /**
     * Iterator using an ArrayList<Ingredient> iterator
     */
    public Iterator<Ingredient> iterator(){
    	return new ArrayList<Ingredient>().iterator();
    }
    
    /**
     * Add method
     */
    public void add(Ingredient item){
    	items.add(item);
    }
    
    // add item at position pos in the List, moving the items originally in positions 
    // pos through size()-1 one place to the right to make room 
    // (error if pos is less than 0 or greater than size())
    // throw IndexOutOfBoundsException if pos is less than zero or greater than size
    public void add(int pos, Ingredient item){
    	if(pos < 0 || pos > items.size()){
    		throw new IndexOutOfBoundsException();
    	} else {
    		items.add(pos,item);
    	}
    }
    
    // return true iff item is in the List (i.e., there is an item x in the List such that x.equals(item))
    public boolean contains(Ingredient item){
    	for (int i = 0; i < items.size(); i++){
    		if (items.get(i).getName().equals(item.getName())){
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
    public Ingredient get(int pos){
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
    public Ingredient remove(int pos){
    	if (pos < 0 || pos >= items.size()){
    		throw new IndexOutOfBoundsException();
    	} else {
    		Ingredient removed = items.get(pos);
    		items.remove(pos);
    		return removed;
    	}
    }
    
    
}

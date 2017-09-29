///////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Fall 2017 
// PROJECT:          program1
// FILE:             GroceryList.java
//
// TEAM:   Individual
// Author: Yu Song
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.ArrayList;
import java.util.Iterator;

/**
 * TODO COMPLETE THIS CLASS
 *
 * This class is a list of ingredients, implementing ListADT, 
 * and using ArrayList as internal data structure.
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
     * 
     * @return an Ingredient Iterator object
     */
    public Iterator<Ingredient> iterator(){
    	return items.iterator();
    }
    
    /**
     *  Add method, adds an Ingredient object to the end of the grocery list, 
     *  and increases the size of the grocery list (default for ArrayList data structure).
     * 
     *  @param item Ingredient object to be added to grocery list
     */
    public void add(Ingredient item){
    	items.add(item);
    }
    
    // add item at position pos in the List, moving the items originally in positions 
    // pos through size()-1 one place to the right to make room 
    // (error if pos is less than 0 or greater than size())
    // throw IndexOutOfBoundsException if pos is less than zero or greater than size
    /**
     * Overloading of add method, adds an Ingredient object to a specified index position of
     * the grocery list, and increases the size of the grocery list.
     * 
     * @param pos Index of grocery list to add Ingredient object, 
     *        cannot be smaller than 0 or exceeds grocery list size.
     * @param item Ingredient object to be added.
     */
    public void add(int pos, Ingredient item){
    	if(pos < 0 || pos > items.size()){
    		throw new IndexOutOfBoundsException();
    	} else {
    		items.add(pos,item);
    	}
    }
    
    // return true iff item is in the List (i.e., there is an item x in the List such that x.equals(item))
    /**
     * Contains method, checks if an Ingredient object (name) is in the grocery list.
     * 
     * @param item Ingredient object to be checked through grocery list.
     * @return true if Ingredient name found in the grocery list.
     * @return false if Ingredient name not found in the grocery list.
     */
    public boolean contains(Ingredient item){
    	for (int i = 0; i < items.size(); i++){
    		if (items.get(i).getName().equals(item.getName())){
    			return true;
    		}
    	}
    	return false;
    }

    // return the number of items in the List.
    /**
     * Size of grocery list.
     * 
     * @return the size (# of Ingredient objects) of the grocery list.
     */
    public int size(){
    	return items.size();
    }

    // return if the List is empty.
    /**
     * Checks if the grocery list is empty.
     * 
     * @return true if the grocery list is empty.
     * @return false if the grocery list is not empty.
     */
    public boolean isEmpty(){
    	if (items.isEmpty()){
    		return true;
    	} else {
    		return false;
    	}
    }

    //  return the item at position pos in the List 
    // throw IndexOutOfBoundsException if pos is less than zero or greater than or equal to size
    /**
     * Gives the Ingredient object at the specified position in grocery list.
     * throw IndexOutOfBoundsException if position is less than zero or greater than or equal to size.
     * 
     * @param pos the index.
     * @return the Ingredient object at index pos in the grocery list.
     */
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
    /**
     * Removes the Ingredient object at a specified position in grocery list.
     * throw IndexOutOfBoundsException if position is less than zero or greater than or equal to size.
     * 
     * @param pos the specified index which has the Ingredient object to be removed.
     * @return the removed Ingredient object.
     */
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

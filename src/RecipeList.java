///////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Fall 2017 
// PROJECT:          program1
// FILE:             RecipeList.java
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
 * This class is a list of recipes, implementing ListADT, 
 * and using ArrayList as internal data structure.
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
     * 
     * @return a Recipe Iterator object
     */
    public Iterator<Recipe> iterator(){
    	return items.iterator();
    }
    
    /**
     *  Add method, adds an Recipe object to the end of the grocery list, 
     *  and increases the size of the recipe list (default for ArrayList data structure).
     * 
     *  @param item Recipe object to be added to recipe list
     */
    public void add(Recipe item){
    	items.add(item);
    }
    
    // add item at position pos in the List, moving the items originally in positions 
    // pos through size()-1 one place to the right to make room 
    // (error if pos is less than 0 or greater than size())
    // throw IndexOutOfBoundsException if pos is less than zero or greater than size
    /**
     * Overloading of add method, adds an Recipe object to a specified index position of
     * the recipe list, and increases the size of the recipe list.
     * 
     * @param pos Index of recipe list to add Ingredient object, 
     *        cannot be smaller than 0 or exceeds recipe list size.
     * @param item Ingredient object to be added.
     */
    public void add(int pos, Recipe item){
    	if(pos < 0 || pos > items.size()){
    		throw new IndexOutOfBoundsException();
    	} else {
    		items.add(pos,item);
    	}
    }
    
    // return true iff item is in the List (i.e., there is an item x in the List such that x.equals(item))
    /**
     * Contains method, checks if an Recipe object (recipe name) is in the recipe list.
     * 
     * @param item Recipe object to be checked through recipe list.
     * @return true if Recipe name found in the recipe list.
     * @return false if Recipe name not found in the recipe list.
     */
    public boolean contains(Recipe item){
    	for (int i = 0; i < items.size(); i++){
    		if (items.get(i).getRecipeName().equals(item.getRecipeName())){
    			return true;
    		}
    	}
    	return false;
    }

    // return the number of items in the List.
    /**
     * Size of recipe list.
     * 
     * @return the size (# of Recipe objects) of the recipe list.
     */
    public int size(){
    	return items.size();
    }

    // return if the List is empty.
    /**
     * Checks if the recipe list is empty.
     * 
     * @return true if the recipe list is empty.
     * @return false if the recipe list is not empty.
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
     * Gives the Recipe object at the specified position in recipe list.
     * throw IndexOutOfBoundsException if position is less than zero or greater than or equal to size.
     * 
     * @param pos the index.
     * @return the Recipe object at index pos in the recipe list.
     */
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
    /**
     * Removes the Recipe object at a specified position in recipe list.
     * throw IndexOutOfBoundsException if position is less than zero or greater than or equal to size.
     * 
     * @param pos the specified index which has the Recipe object to be removed.
     * @return the removed Recipe object.
     */
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

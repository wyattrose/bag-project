package edu.wit.scds.ds.bag.app ;
import edu.wit.scds.ds.bag.BagInterface ;
import edu.wit.scds.ds.bag.adt.ResizableArrayBag ;

/**
 * A grocery bag that stores items
 * (this class is dependent on GroceryItem v1.0)
 * @author Wyatt Rose
 * @version 1.2.0
 */
public class GroceryBag implements BagInterface<GroceryItem>
	{
	
    /** Underlying data structure used for storing GroceryItems */
	private ResizableArrayBag<GroceryItem> b = new ResizableArrayBag<GroceryItem>() ;

    /** Maximum volume of the bag (unit is abstract) */
	private final int maxVolume = 10 ;

    /** Maximum weight of the bag (unit is abstract) */
	private final int maxWeight = 10 ;

    /** The current volume of the bag */
	private int currentVolume ;

    /** The current weight of the bag */
	private int currentWeight ;
	
	/**
	 * Default constructor, initializes current volume and current weight to zero
	 */
	public GroceryBag()
		{
		super() ; // explicit > implicit
		this.currentVolume = 0 ;
		this.currentWeight = 0 ;
		
		} // end of default constructor
	
	/**
	 * Adds an item into the bag
	 * @param newEntry - the item to be added to the bag
	 * @return if the item was successfully added or not
	 */
	@Override
	public boolean add(GroceryItem newEntry)
		{
		
        // if bag is full, you can't add another item
		if(isFull())
			{
			return false ;
			}
		
		this.currentVolume += newEntry.getSize() ;
		this.currentWeight += newEntry.getWeight() ;
		
		return b.add(newEntry) ;
		
		} // end of add( GroceryItem )
	
	/**
	 * Clears all entries from the bag, setting currentWeight and currentSize to zero
	 */
	@Override
	public void clear()
		{
		b.clear() ;
		this.currentVolume = 0 ;
		this.currentWeight = 0 ;
		
		} // end of clear()

	/**
	 * Checks if an item is contained in the bag
	 * @param anEntry - the item to find in the bag
	 * @return true if the bag contains the entry, false if it doesn't
	 */
	@Override
	public boolean contains(GroceryItem anEntry)
		{
		return b.contains(anEntry) ;
		
		} // end of contains( GroceryItem )

	/**
	 * Gets the total number of items in the bag
	 * @return the total number of items in the bag
	 */
	@Override
	public int getCurrentSize()
		{
		return b.getCurrentSize() ;
		
		} // end of getCurrentSize()

	/**
	 * Gets the total number of the item specified in the bag
	 * @param newEntry - the item to be found in the bag
	 * @return the total number of the item specified in the bag
	 */
	@Override
	public int getFrequencyOf(GroceryItem anEntry)
		{
		return b.getFrequencyOf(anEntry) ;
		
		} // end of getFrequencyOf( GroceryItem )
	
	/**
	 * Checks to see if the bag is empty or not
	 * @return true if the bag contains no items, false otherwise
	 */
	@Override
	public boolean isEmpty()
		{
		return b.isEmpty() ;
		
		} // end of isEmpty() 
	
	/**
	 * Removes an unspecified item from the bag
	 * @return the item that was removed, null if there aren't any items left in the bag
	 */
	@Override
	public GroceryItem remove()
		{
		
		GroceryItem item = b.remove() ;
		
		if(item != null)
			{
		
			this.currentVolume -= item.getSize() ;
			this.currentWeight -= item.getWeight() ;
			}
		
		return item ;
		
		} // end of remove()
	
	/**
	 * Removes a specified item from the bag
	 * @param newEntry - the item to be removed from the bag
	 * @return true if the item was removed, false otherwise
	 */
	@Override
	public boolean remove(GroceryItem anEntry)
		{
		if(b.remove(anEntry)) 
			{
			this.currentVolume -= anEntry.getSize() ;
			this.currentWeight -= anEntry.getWeight() ;
			
			return true ;
			
			}
		return false ;
		
		} // end of remove( GroceryItem )

	/**
	 * Returns an array containing all items in the bag
	 * @return an array containing all items in the bag
	 */
	@Override
	public GroceryItem[] toArray()
		{
			Object[] objects = b.toArray() ; // we know that this is full of items, so we're all good
			GroceryItem[] items = new GroceryItem[objects.length] ;
			for(int i = 0; i < objects.length; i++)
				{
				items[i] = (GroceryItem) objects[i] ;
				}
			return items ;
			
		} // end of toArray()
	
	/**
	 * Checks to see if the bag's volume limit is exceeded
	 * @return true if the bag's weight or volume limit is met or exceeded, false otherwise
	 */
	public boolean isFull()
		{
		return this.currentVolume >= this.maxVolume || this.currentWeight >= this.maxWeight ;
		
		} // end of isFull()
	
	/**
	 * Accessor for volume attribute
	 * @return current volume in the bag
	 */
	public int getCurrentVolume()
		{
		return currentVolume ;
		
		} // end of getCurrentVolume()
	
	/**
	 * Accessor for weight attribute
	 * @return current weight in the bag
	 */
	public int getCurrentWeight()
		{
		return currentWeight ;
		
		} // end of getCurrentWeight()
	
	/**
	 * Accesor for maximum volume attribute
	 * @return the maximum volume for this bag
	 */
	public int getMaxVolume()
		{
		return maxVolume ;
		
		} // end of getMaxVolume()
	
	/**
	 * Accessor for the maximum weight of this bag
	 * @return the maximum weight of this bag
	 */
	public int getMaxWeight()
		{
		return maxWeight ;
		
		} // end of getMaxWeight()
	
	} // end of GroceryBag class
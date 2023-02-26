package edu.wit.scds.ds.bag.app;

/**
 * An item to be stored within a grocery bag
 * 
 * @author Wyatt R. Rose
 * @version 1.1
 */
public class GroceryItem
    {

    /** The name of the item*/
    private final String name ;

    /** How big the item is */
    private final int size ;

    /** How heavy the item is */
    private final int weight ;

    /** How firm the item is */
    private final int firmness ;

    /** How rigid the item is */
    private final boolean rigidity ;

    /** How fragile the item is */
    private final boolean breakable ;


    /**
     * Primary single parameter constructor for initializing items from an item definition string
     * 
     * @param rawInput the string with values for creating the item
     */
    public GroceryItem(String rawInput) {

        final String[] itemFields = rawInput.split("\t"); // help with regex: https://regexone.com/

        // this porition uses GroceryItemFieldIds, the string input must correspond to the ordinality of GroceryItemFieldIds
        this.name = itemFields[GroceryItemFieldIds.NAME.ordinal()];
        this.size = GroceryItemSize.interpretDescription(itemFields[GroceryItemFieldIds.SIZE.ordinal()]).sizeValue;
        this.weight = GroceryItemWeight.interpretDescription(itemFields[GroceryItemFieldIds.WEIGHT.ordinal()]).weightValue;
        this.firmness = GroceryItemFirmness.interpretDescription(itemFields[GroceryItemFieldIds.FIRMNESS.ordinal()]).firmnessValue;
        this.rigidity = Boolean.parseBoolean(itemFields[GroceryItemFieldIds.RIGIDITY.ordinal()]);
        this.breakable = Boolean.parseBoolean(itemFields[GroceryItemFieldIds.BREAKABLE.ordinal()]);

    }

    /**
     * Accessor for name attribute
     * @return the name of the item
     */
    public String getName()
        {
        return name ;

        } // end of getName()

    /**
     * Attribute for firmness attribute
     * @return the firmness attribute
     */
    public int getFirmness() 
        {
        return firmness ;

        } // end of getFirmness

    /**
     * Accessor for size attribute
     * @return the size of the item
     */
    public int getSize()
        {
        return size ;

        } // end of getSize()

    /**
     * Accessor for weight attribute
     * @return the weight of the item
     */
    public int getWeight() 
        {
        return weight ;

        } // end of getWeight

    /**
     * Accessor for breakable attribute
     * @return the breakable attribute
     */
    public boolean isBreakable()
        {
        return breakable ;

        } // end of isBreakable()

    /**
     * Accessor for rigidity attribute
     * @return the rigidity of the item
     */
    public boolean isRigid()
        {
        return rigidity ;

        } // end of isRigid()

    } // end of GroceryItem class

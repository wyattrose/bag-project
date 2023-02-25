package edu.wit.scds.ds.bag.app;

/**
 * An item to be stored within a grocery bag
 * 
 * @author Wyatt R. Rose
 * @version 1.0
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
     * Primary six parameter constructor to create new items.
     * 
     * @param name the name of the item
     * @param size the size of the item (1 is small, 3 is medium, 5 is large, extra large is 7)
     * @param weight the weight of the item (1 is light, 3 is medium, 5 is heavy, 7 is very heavy)
     * @param firmness the firmness of the item
     * @param rigidity the rigidity of the item
     * @param breakable the breakability of the item
     */
    public GroceryItem(String name, int size, int weight, int firmness, boolean rigidity, boolean breakable)
        {
        this.name = name ;
        this.size = size ;
        this.weight = weight ;
        this.firmness = firmness ;
        this.rigidity = rigidity ;
        this.breakable = breakable ;

        } // end of GroceryItem( String, int, int, int, boolean, boolean )

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

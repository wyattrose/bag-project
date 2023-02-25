package edu.wit.scds.ds.bag.app;

/**
 * Enumeration of grocery item firmness for the GroceryBagger application.
 * 
 * @author Wyatt R. Rose
 * 
 * @version 1.0.0 version for the GroceryBagger application
 */
public enum GroceryItemFirmness
    {


    // Firmness - Name - Value
    /** Soft item */
    SOFT ( "Soft", 1),

    /** Hard item */
    HARD ( "Hard", 2),

    /** Firm item */
    FIRM ( "Firm", 3);

    /** DATA FIELDS */

    /** formatted name */
    public final String name;

    /** integer equivalent of the firmness */
    public final int value;

    /**
     * @param name
     *  formatted name
     * @param itemSizeValue
     *  integer equivalent of the firmness
     */
    private GroceryItemFirmness(final String name, final int value)
        {
        this.name = name;
        this.value = value;
        } // end of GroceryItemFirmness( String, int )

    /**
     * Parse a text description of firmness
     * 
     * @param firmnessDescription
     *  a name to parse
     * 
     * @return the corresponding enum constant or HARD if the name is unrecognized
     * 
     */
    public static GroceryItemFirmness interpretDescription( final String firmnessDescription )
        {
        
        return switch ( firmnessDescription.toLowerCase().charAt(0))
            {
            case 's' -> SOFT;
            case 'h' -> HARD;
            case 'f' -> FIRM;
            default -> HARD;
            };
        } // end of interpretDescription( String )

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
        {
        return this.name;

        } // end of toString()

    /**
     * Test driver - displays all constants for this enumeration
     * 
     * @param args
     *  -unused-
     */
    public static void main( final String[] args)
        {
        
        // writing test cases is easy, when you don't have a social life
        System.out.printf("Members of the %s enumeration%n%n", GroceryItemFirmness.class.getSimpleName());

        // display column headers (why so many string literals 先輩)
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s%n", "#", "Item Size", "Name", "Display Name", "Firmness Value", "Interpreted Firmness");

        // display each element of the enumeration (I really don't like how that sounds out loud)
        for( final GroceryItemFirmness anItemFirmness : GroceryItemFirmness.values() )
            {
            System.out.printf("%-5d %-15s %-15s %-15s %-15s %-15s%n", anItemFirmness.ordinal(), anItemFirmness, anItemFirmness.name(), anItemFirmness, anItemFirmness.name, anItemFirmness.value, interpretDescription(anItemFirmness.toString()));
            }
        } // end of main( String[] )
    }

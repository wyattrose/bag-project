package edu.wit.scds.ds.bag.app;

/**
 * Enumeration of grocery item weight for the GroceryBagger application.
 * 
 * @author Wyatt R. Rose
 * 
 * @version 1.0.1 version for the GroceryBagger application
 */
public enum GroceryItemWeight
    {

    // Weight - Name - Value
    /**Light item */
    LIGHT ( "Light", 1 ),
    MEDIUM ( "Medium", 3),
    HEAVY ( "Heavy", 5),
    VERY_HEAVY ( "Very Heavy", 7);

    /** formatted name */
    public final String name;

    /** integer equivalent of the weight */
    public final int weightValue;

    /**
     * @param name
     *  formatted name
     * @param weightValue
     * integer equivalent of the weight
     */
    private GroceryItemWeight(final String name, final int weightValue)
        {
        this.name = name;
        this.weightValue = weightValue;
        } // end of GroceryItemWeight( String, int )

    /**
     * Parse a text description of weight
     * 
     * @param weightDescription
     *  a name to parse
     * 
     * @return the corresponding enum constant or MEDIUM if the name is unrecognized
     * 
     */
    public static GroceryItemWeight interpretDescription( final String weightDescription )
        {

        return switch ( weightDescription.toLowerCase().charAt(0))
            {
            case 'l' -> LIGHT;
            case 'm' -> MEDIUM;
            case 'h' -> HEAVY;
            case 'v' -> VERY_HEAVY;
            default -> MEDIUM;
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

        // writing test case lets go (maybe we should use JUNIT next time? I'll parse this out later lol)
        System.out.printf("Members of the %s enumeration%n%n", GroceryItemWeight.class.getSimpleName());

        // display column headers (why so many string literals 先輩)
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s%n", "#", "Item Size", "Name", "Display Name", "Weight Value", "Interpreted Weight");

        // display each element of the enumeration (I really don't like how that sounds out loud)
        for( final GroceryItemWeight anItemWeight : GroceryItemWeight.values() )
            {
            System.out.printf("%-5d %-15s %-15s %-15s %-15s %-15s%n", anItemWeight.ordinal(), anItemWeight, anItemWeight.name(), anItemWeight, anItemWeight.name, anItemWeight.weightValue, interpretDescription(anItemWeight.toString()));
            }
        } // end of test case main( String[] )
    }
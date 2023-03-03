package edu.wit.scds.ds.bag.app;
import java.util.*;

import edu.wit.scds.ds.bag.adt.ResizableArrayBag;

import java.io.*;

public class TestBagger {

    // we'll need to import everything from the other classes
    

    public static void main(String[] args) throws IOException {

        System.out.println("program starting...");
        
        GroceryBag bag = new GroceryBag();

        Scanner shoppingCart = new Scanner(new File("./data/shopping-cart.data"));
        shoppingCart.nextLine(); // skip first line

        bag.add(new GroceryItem(shoppingCart.nextLine())); // add one item


        System.out.println(Arrays.toString(bag.toArray()));

        System.out.println("program ending...");

        

        // end of the main method

        /*
        try                             
            {
            Scanner shoppingCart = new Scanner(new FileInputStream("./data/shopping-cart.data")) ;
    
            String ignoreFirstLine = shoppingCart.nextLine() ;
            
            ArrayList<GroceryBag> bags = new ArrayList<GroceryBag>();
            
            for(int i=0 ; i<20 ; i++) 
                {
                bags.add( i, new GroceryBag() ) ;
                }
            
            
            for(int i=0; i<20; i++)
                {
            
                while(shoppingCart.hasNextLine()) 
                    {
                    GroceryItem nextItem = new GroceryItem(shoppingCart.nextLine());
                    if(GroceryBagger.isCompatible( bags.get( i ), nextItem ) )  // error is occuring right here
                        {
                        bags.get(i).add( nextItem ) ;
                        continue ;
                        }
                    else 
                        {
                        bags.get( i+1 ).add( nextItem );
                        break;
                        }
                    }
                }
            
            
            
            
            
            }//end of try block
            
        
    
        catch ( final FileNotFoundException e )
            {
         // can't open the file
            System.out.printf( "Unable to open the shopping cart:%n%s%n", e ) ;

            // get out
            return ;
            }



            */
    }

}

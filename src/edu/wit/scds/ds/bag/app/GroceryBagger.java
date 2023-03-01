package edu.wit.scds.ds.bag.app;

import edu.wit.scds.ds.bag.BagInterface ;

import java.io.File ;
import java.io.FileInputStream ;
import java.io.FileNotFoundException ;
import java.util.Scanner;

/**
 * Class decides on item compatibility and puts items in bag 
 * main method does file input/output
 * 
 * @author Isabella DiTommaso
 * @version 1.0
 *
 */

public class GroceryBagger {
    
    
    //TODO: Fix indentations and semicolons, check style guide
    //TODO: Finish main method

public static void main(String[] args) {



    try                             
    {
    Scanner fin = new Scanner(new FileInputStream("./data/shopping-cart.data"));
    
    String ignoreFirstLine = fin.nextLine();
    
    String nextItem = fin.nextLine();
     
    //GroceryItem nextGrocery = new GroceryItem(String nextItem);
    
    BagInterface<GroceryItem> nextBag = new GroceryBag();
        
       
    }
    
    catch ( FileNotFoundException e )
    {
    // TODO Auto-generated catch block
    e.printStackTrace() ;

    }


}


        /**
         * Checks whether the next grocery item may be added to the bag that is 
         * currently open
         *  
         * @param b is the current bag
         * @param i is the current grocery item to decide on
         * @return compatibility (true or false)
         */
        public static boolean isCompatible(GroceryBag b, GroceryItem i) 
            {
        
        // status of bag
            if(b.isEmpty()) {
                return true;
            }
            if(b.isFull()) {
                return false;
            }
            
       // limitations
            if(itemTooHeavy(b,i)) {
                return false;
            }
            if(itemTooBig(b,i)) {
                return false;
            }
            
      // restrictions
            
            // item is soft
            if(i.getFirmness() == 1) {
                if(bagContainsHeavy(b.toArray())) {
                    return false;
                }
            
            }
            
            // item is very heavy
            if(i.getWeight() >=7 ) {
                return false;
            }
            
            
            // item is heavy
            if(i.getWeight() >= 5) {
                if(bagContainsSoft(b.toArray())) {
                    return false;
                }
                else if(bagContainsLightBag(b.toArray())) {
                    return false;
                }
                else if(bagContainsLightRigidBreakable(b.toArray())) {
                    return false;
                }
            }
           
            
            
            // item is a bagged good
            if(i.getName().contains( "bag" )) {
                    //bagged item is light
                    if(i.getWeight()==1) {
                        if(bagContainsHeavy(b.toArray())) {
                            return false;
                        }
                    }
                    else if(bagContainsRigid(b.toArray())) {
                        return false;
                    }
            }
            
            
            //item is rigid
            if(i.isRigid()) {
            
                    // item is light, rigid and breakable
                    if(i.getWeight()==1 && i.isBreakable()) {
                        if(bagContainsHeavy(b.toArray())) {
                            return false;
                        }
                    }
                    else if(bagContainsBaggedItem(b.toArray())) {
                        return false;
                    }
                    else if(bagContainsFlexibleBreakable(b.toArray())) {
                        return false;
                    }
                
            }
            
            
            //item is flexible and breakable
            if(   !(i.isRigid()) &&   i.isBreakable()   ){
                if(bagContainsRigid(b.toArray())) {
                    return false;
                }
            }
                               

            return true;
        }

        /**
         * Checks whether there are any very heavy items in the bag
         * 
         * @param b array of grocery items in the bag
         * @return whether the bag contains a very heavy item t/f
         */
        public static boolean bagContainsVeryHeavy(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].getWeight()==7) {
                return true;
                }
            }
        return false;
        }
        
        /**
         * Checks whether there are any heavy items in the bag
         * 
         * @param b array of grocery items in the bag
         * @return whether bag contains heavy item
         */
        public static boolean bagContainsHeavy(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].getWeight()>=5) {
                return true;
                }
            }
        return false;
        }
        /**
         * Checks whether there are any soft items in the bag
         * 
         * 
         * @param b array of grocery items in the bag
         * @return whether bag contains soft item
         */
        public static boolean bagContainsSoft(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].getFirmness()==1) {
                return true;
                }
            }
        return false;
        }
        
        /**
         * Checks whether there are any items 
         * that are bags (for example a bag of chips, a bag of ice)
         * 
         * @param b array of grocery items in the bag
         * @return whether bag contains a bagged item
         */
        public static boolean bagContainsBaggedItem(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].getName().contains( "bag" )){
                    return true;
                }
            }
            return false;
        }
        
        
        /**
         * Checks whether any items in the bag are light bags
         * 
         * 
         * @param b array of grocery items in the bag
         * @return whether bag contains a lightweight bagged item
         */
        public static boolean bagContainsLightBag(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].getName().contains( "bag" ) && b[i].getWeight()==1){
                return true;
                }
            }
        return false;
        }
        
        /**
         * Checks whether any rigid items in the bag
         * 
         * 
         * @param b array of grocery items in the bag
         * @return whether bag contains a rigid item
         */
        public static boolean bagContainsRigid(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].isRigid()) {
                    return true;
                }
            }
        return false;
        }
        
        /**
         * Checks whether there are any items that are both light,
         * rigid and breakable in the bag
         * 
         * 
         * @param b array of grocery items in bag
         * @return whether bag contains a light, rigid and breakable item
         */
        public static boolean bagContainsLightRigidBreakable(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].isRigid() && b[i].getWeight()==1 && b[i].isBreakable()) {
                    return true;
                }
            }
            return false;
        }
        
        /**
         * Checks whether there are any items that are both flexible and breakable
         * in the bag
         * 
         * 
         * @param b array of grocery items in bag
         * @return whether bag contains a flexible and breakable item
         */
        public static boolean bagContainsFlexibleBreakable(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(!(b[i].isRigid()) && b[i].isBreakable()) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Checks whether the current item is too heavy to fit in
         * the current bag without making its 
         * total weight exceed the maximum capacity
         * 
         * @param b current grocery bag
         * @param i current grocery item to be added to the bag
         * @return whether the item is too heavy to be compatible with current bag 
         */
        public static boolean itemTooHeavy(GroceryBag b, GroceryItem i) {
        return b.getCurrentWeight() + i.getWeight() > b.getMaxWeight();
        
        }

        /**
         * Checks whether the current item is too big to fit in
         * the current bag without making its 
         * total volume exceed the maximum capacity
         * 
         * @param b current grocery bag
         * @param i current grocery item to be added to the bag
         * @return whether the item's volume is too big to be compatible with current bag 
         */
        public static boolean itemTooBig(GroceryBag b, GroceryItem i) {
        return b.getCurrentVolume() + i.getSize() > b.getMaxVolume();
        }
        





}

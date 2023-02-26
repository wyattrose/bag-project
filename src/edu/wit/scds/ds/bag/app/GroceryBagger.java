package edu.wit.scds.ds.bag.app;

public class GroceryBagger {

        // TODO: document methods
        // TODO: change indentation, semi colon space (refer style guides)

        public static boolean isCompatible(GroceryBag b, GroceryItem i) {
        
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


        public static boolean bagContainsVeryHeavy(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].getWeight()==7) {
                return true;
                }
            }
        return false;
        }
        
        public static boolean bagContainsHeavy(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].getWeight()>=5) {
                return true;
                }
            }
        return false;
        }
        
        public static boolean bagContainsSoft(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].getFirmness()==1) {
                return true;
                }
            }
        return false;
        }
        
        public static boolean bagContainsBaggedItem(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].getName().contains( "bag" )){
                    return true;
                }
            }
            return false;
        }
        
        
        
        public static boolean bagContainsLightBag(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].getName().contains( "bag" ) && b[i].getWeight()==1){
                return true;
                }
            }
        return false;
        }
        
        public static boolean bagContainsRigid(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].isRigid()) {
                    return true;
                }
            }
        return false;
        }
        
        public static boolean bagContainsLightRigidBreakable(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(b[i].isRigid() && b[i].getWeight()==1 && b[i].isBreakable()) {
                    return true;
                }
            }
            return false;
        }
        
        public static boolean bagContainsFlexibleBreakable(GroceryItem[] b) {
            for(int i=0; i<b.length; i++) {
                if(!(b[i].isRigid()) && b[i].isBreakable()) {
                    return true;
                }
            }
            return false;
        }


        public static boolean itemTooHeavy(GroceryBag b, GroceryItem i) {
            // cleaned it up a little bit - Wyatt
            return b.getCurrentWeight() + i.getWeight() > b.getMaxWeight();
            
        }

        
        public static boolean itemTooBig(GroceryBag b, GroceryItem i) {
            // cleaned it up a little bit - Wyatt
            return b.getCurrentVolume() + i.getSize() > b.getMaxVolume();
        }














}
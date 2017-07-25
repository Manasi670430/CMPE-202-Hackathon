import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gasstation1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PickyGasStation extends Actor implements StratergyInterface
{
    boolean isRightCardInserted;
    public static World w = null;
    
    //StratergyInterface stratergy;
    /**
     * Act - do whatever the Gasstation1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PickyGasStation(){
        GreenfootImage image = getImage() ;
        image.scale( 150, 400 ) ;  
    }
   
    public static void setCurrentWorld(World currentWorld)
    {
       w = currentWorld;
    }
   
        public void act() 
    {
        DisplayScreen screen = new DisplayScreen();
        World w =getWorld();
      
        // Add your action code here.
        int mouseCordinateX, mouseCordinateY;
        //System.out.println("Inside act of card slot");
         
        if(hasCollisionOccured(FakeCard.class))
        {
         System.out.println("Fake card");
         isRightCardInserted=false;
         GasPumpStateInterface currentState = GasPumpWorld.currentState;
         System.out.println("Set state when fake card scanned: "+ currentState);
         if(currentState instanceof NoCardState)
         {
             System.out.println("Inside cardslot set current state to NoCard");
             currentState.printReceipt(w,"Fake");
     
         }
         
         if(currentState instanceof HasCardState)
         {
             System.out.println("Inside cardslot wih has card state");
             currentState.insertCard(w,"Card Already Scanned");
         }
         
         if(currentState instanceof ZipValidatedState)
         {
             System.out.println("Inside cardslot with zip validated state");
             currentState.insertCard(w,"Card Already Scanned");
         }
         
         //screen.setMessageString(w,"Fake");
         
          
        }
        
     if(hasCollisionOccured(ValidCard.class))
     {
         System.out.println("Valid card");
         isRightCardInserted=true;
         GasPumpStateInterface currentState = GasPumpWorld.currentState;
         System.out.println("Set state when valid card scanned: "+ currentState);
         if(currentState instanceof NoCardState)
         {
             System.out.println("Inside cardslot set current state to HasCard");
             //currentState.insertCard(w, "Valid");
             currentState.printReceipt(w, "Valid");
         }
         
         if(currentState instanceof HasCardState)
         {
             System.out.println("Inside cardslot wih has card state");
             currentState.insertCard(w,"Card Already Scanned");
         }
         
         if(currentState instanceof ZipValidatedState)
         {
             System.out.println("Inside cardslot with zip validated state");
             currentState.insertCard(w,"Card Already Scanned");
         }
         //screen.setMessageString(w,"Card Validated");
         //w.setCurrentWorldState("Card Scanned");
         
        
     }
     if(hasCollisionOccured(MembershipCard.class))
     {
         
         System.out.println("Valid Membership card");
         isRightCardInserted=true;
         GasPumpStateInterface currentState = GasPumpWorld.currentState;
         System.out.println("Set state when valid card scanned: "+ currentState);
         if(currentState instanceof NoCardState)
         {
             System.out.println("Inside cardslot set cuurent state to HasCard");
             currentState.printReceipt(w, "Valid");
         }
         
         if(currentState instanceof HasCardState)
         {
             System.out.println("Inside cardslot wih has card state");
             currentState.insertCard(w,"Card Already Scanned");
         }
         
         if(currentState instanceof ZipValidatedState)
         {
             System.out.println("Inside cardslot with zip validated state");
             currentState.insertCard(w,"Card Already Scanned");
         }
         
     }
       
    }    
    
    public boolean hasCollisionOccured(Class CollidingClass)
    {
        Actor actor = getOneObjectAtOffset(10, 10, CollidingClass);
        if(actor !=null )  
        {
            getWorld().removeObject(actor);  
            return true;
        }
        else
            return false;
    }
    
    public boolean hasRightCard()
    {
        return isRightCardInserted;
    }  
    
}

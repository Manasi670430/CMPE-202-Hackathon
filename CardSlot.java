import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CardSlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardSlot extends Actor
{
    /**
     * Act - do whatever the CardSlot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean isRightCardInserted;
    private static Actor gasPumpType = null;
    
    //public static GasPumpState currentState = null;
    
    public CardSlot()
    {
        GreenfootImage image = getImage() ;
        image.scale( 150, 180 ) ; 
    }
    
    public static void setGasPumpType(Actor gasPumpType)
    {
        System.out.println("Gasppump set "+ gasPumpType);
        CardSlot.gasPumpType = gasPumpType;
    }
    
    public Actor getGasPumpType()
    {
        return CardSlot.gasPumpType;
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
             System.out.println("Gas pump selecetd " +this.gasPumpType);
             if(getGasPumpType() instanceof PickyGasStation)
             {
                 System.out.println("Pcky Gas station seleted");
                 currentState.insertCard(w,"Fake");
             }
             if(getGasPumpType() instanceof NormalGasStation)
             {
                System.out.println("Normal Gas station seleted");
                currentState.insertCard(w,"Fake");
             }
             
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
             System.out.println("Gas pump selecetd " +getGasPumpType());
             System.out.println("Inside cardslot set current state to NoCard");
             if(getGasPumpType() instanceof PickyGasStation)
             {
                 System.out.println("Pcky Gas station selected");
                 currentState.printReceipt(w, "Valid:Picky");
                     
             }
             if(getGasPumpType() instanceof NormalGasStation)
             {
                System.out.println("Normal Gas station seleted");
                currentState.insertCard(w,"Valid");
             }
             
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
             System.out.println("Gas pump selecetd " +getGasPumpType());
             System.out.println("Inside cardslot set current state to NoCard");
             if(getGasPumpType() instanceof PickyGasStation)
             {
                 System.out.println("Pcky Gas station selected");
                 currentState.printReceipt(w, "Valid:Picky");
                
                 
             }
             if(getGasPumpType() instanceof NormalGasStation)
             {
                System.out.println("Normal Gas station seleted");
                currentState.insertCard(w,"Valid");
             }
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

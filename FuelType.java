import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FuelType here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FuelType extends Actor
{
    /**
     * Act - do whatever the FuelType wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public FuelType()
    {
        GreenfootImage image = getImage() ;
        image.scale( 250, 280 ) ; 
    }
    public void act() 
    {
       // Add your action code here.
           
        DisplayScreen screen = new DisplayScreen();
        World w =getWorld();
        
        GasPumpStateInterface currentState = GasPumpWorld.currentState;
        //System.out.println("Current state in Select Fuel is "+ currentState);
         
        
        if(Greenfoot.mouseClicked(this))
        {
            
            System.out.println("Inside Select Fuel Type");
            if(currentState instanceof NoCardState)
            {
                System.out.println("Cannot SelectFuel... please scan your card first");
                currentState.selectFuel(w,"CantSelectFuelWithoutCard");
               
            }
            if(currentState instanceof HasCardState)
            {
                System.out.println("Cannot Select Fuel... please authenticate zip first");
                currentState.selectFuel(w,"CantSelectFuelWithoutZip");
                
            }
            if(currentState instanceof ZipValidatedState)
            {
                System.out.println("Inside SelectFuel validated state");
                currentState.selectFuel(w,"SelectFuel");
               
            }
        
        }
    }    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nozzle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nozzle extends Actor
{
    /**
     * Act - do whatever the Nozzle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        String current_state = "not_paid";   
        DisplayScreen screen = new DisplayScreen();
        World w =getWorld();
        
        GasPumpStateInterface currentState = GasPumpWorld.currentState;
        //System.out.println("Current state in nozzle is "+ currentState);
         
        
        if(Greenfoot.mouseDragged(this))
        {
            
            System.out.println("Inside nozzle dragged if");
            if(currentState instanceof NoCardState)
            {
                System.out.println("Cannot fill gas... please scan your card first");
                currentState.fillGas(w,"CantUseNozzleWithoutCard");
               // screen.setMessageString(w,"CantUseNozzleWithoutCard");
            }
            if(currentState instanceof HasCardState)
            {
                System.out.println("Cannot fill gas... please authenticate zip first");
                currentState.fillGas(w,"CantUseNozzleWithoutZip");
                //screen.setMessageString(w,"CantUseNozzleWithoutZip");
            }
            if(currentState instanceof ZipValidatedState)
            {
                System.out.println("Cannot fill gas... please Select Fuel first");
                currentState.fillGas(w,"CantUseNozzleWithoutType");
               // screen.setMessageString(w,"UseNozzle");
            }
            if(currentState instanceof FuelSelectedState)
            {
                System.out.println("Inside nozzle zip validated state");
                currentState.fillGas(w,"UseNozzle");
               // screen.setMessageString(w,"UseNozzle");
            }
        
        }
        
    }
    
    
}

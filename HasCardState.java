import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HasCardState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HasCardState implements GasPumpStateInterface
{

    /**
     * Constructor for objects of class HasCardState.
     * 
     */
    DisplayScreen screen = new DisplayScreen();
    Keypad k= new Keypad();
        Zip zip = new Zip();
        String zipCurrentStream = "";
    public HasCardState()
    { 
        System.out.println("Inside HasCardState constructor");
        //GasPumpWorld gasPumpWorld = new GasPumpWorld();
    }
    
    
    public void insertCard(World w, String cardType){
       World currentWorld = w;
       //System.out.println("Inside has card state");
       //screen.setMessageString(currentWorld,"Card Validated");
       //this.currentState = new HasCardState();
    }
    public void enterPin(World w){
         World currentWorld = w;
         
         System.out.println("Inside enter pin of Has card state");
         screen.setMessageString(currentWorld,"Enter Pin");
         Keypad.beepCondition = false;
        
            String finalStream ="";
            String finalStream1 ="";
            while(finalStream.length()<4)
            {
                finalStream = Keypad.zipStream;
                if(finalStream.length()==4)
                {
                    finalStream1 = finalStream;
                }
            }
            
         //String finalStream = Keypad.zipStream;   
         
         System.out.println("Inside hascardstate enter pin method "+ finalStream1);
         validateZip(currentWorld, finalStream1);
         Keypad.beepCondition = true;
         
         System.out.println("Inside enter pin beep condition is : "+ Keypad.beepCondition);
       
    }
    public void validateZip(World w, String pin){
         World currentWorld = w;
         GasPumpWorld.currentState = new ZipValidatedState();
         
         System.out.println("Set current state in has card state: "+ GasPumpWorld.currentState);
         
         
         
         //zip.validateZip(pin, currentWorld);
         
       
           //System.out.println("Current State : "+ GasPumpWorld.currentState);
         //screen.setMessageString(currentWorld,"Zip Validated");
    }
    public void selectFuel(World w, String Msg){}
    public void fillGas(World w, String stateMsg){
        World currentWorld = w;
        //System.out.println("Cannot fill gas... please authenticate zip first");
        screen.setMessageString(currentWorld,stateMsg);
    
    }
    public void printReceipt(World w, String stateMsg){}
}

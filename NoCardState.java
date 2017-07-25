import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WelcomeState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NoCardState implements GasPumpStateInterface
{

    /**
     * Constructor for objects of class WelcomeState.
     * 
     */
    GasPumpWorld gasPumpWorld = null;
    DisplayScreen screen = new DisplayScreen();
    public NoCardState()
    {
         //gasPumpWorld = new GasPumpWorld();
         System.out.println("Inside NoCardState");
    }
    
    
    public void insertCard(World w, String cardType){
        
       World currentWorld = w;
       
       if(cardType.equals("Valid"))
       {
           System.out.println("Inside Insert card of nocardstate having valid card");
           GasPumpWorld.currentState = new HasCardState();
           System.out.println("Set current state in nocard state: "+ GasPumpWorld.currentState);
       
           //System.out.println("Current State : "+ GasPumpWorld.currentState);
           screen.setMessageString(currentWorld,"Card Validated");
           
           //calling hascardState enterPin
           //GasPumpWorld.currentState.enterPin(currentWorld);
       }
       
       if(cardType.equals("Fake"))
       {
           System.out.println("Inside Insert card of nocardstate having fake card");
           //GasPumpWorld.currentState = new HasCardState();
           System.out.println("Cannot set next state card is fake, current state remains: "+ GasPumpWorld.currentState);
       
           //System.out.println("Current State : "+ GasPumpWorld.currentState);
           screen.setMessageString(currentWorld,"Fake");
       }
       
       
       //setState(new HasCardState());
       
    }
    public void enterPin(World w){
        System.out.println("No card Scanned..Please scan your card first");
    }
    public void validateZip(World w, String pin){}
    public void selectFuel(World w, String Msg){
        System.out.println("No card Scanned..Please scan your card first");
    }
    public void fillGas(World w, String stateMsg){
        World currentWorld = w;
        //System.out.println("No card Scanned..Please scan your card first");
        screen.setMessageString(currentWorld,stateMsg);
    }
    public void printReceipt(World w, String cardType){
        System.out.println("Inside printReceipt of nocardstate invoked");
    World currentWorld = w;
    
       if(cardType.equals("Valid:Picky"))
       {
           System.out.println("Inside printReceipt of nocardstate picky selected");
           //GasPumpWorld.currentState = new HasCardState();
           //System.out.println("Set current state in nocard state: "+ GasPumpWorld.currentState);
       
           //System.out.println("Current State : "+ GasPumpWorld.currentState);
           screen.setMessageString(currentWorld,"Do you want to print receipt?"+cardType);
          
       }
    
    
       
      /* if(cardType.equals("Valid"))
       {
           System.out.println("Inside printReceipt of nocardstate having valid card");
           GasPumpWorld.currentState = new HasCardState();
           System.out.println("Set current state in nocard state: "+ GasPumpWorld.currentState);
       
           //System.out.println("Current State : "+ GasPumpWorld.currentState);
           screen.setMessageString(currentWorld,"Do you want to print receipt?");
           
           //calling hascardState enterPin
           //GasPumpWorld.currentState.enterPin(currentWorld);
       }
       */
       if(cardType.equals("Fake"))
       {
           System.out.println("Inside print Recipt of nocardstate having fake card");
           //GasPumpWorld.currentState = new HasCardState();
           System.out.println("Cannot set next state card is fake, current state remains: "+ GasPumpWorld.currentState);
       
           //System.out.println("Current State : "+ GasPumpWorld.currentState);
           screen.setMessageString(currentWorld,"Fake");
          
       }
       
    }
}

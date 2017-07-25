import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ActiveNozzleState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ActiveNozzleState implements GasPumpStateInterface
{
    // instance variables - replace the example below with your own
    private int x;
    DisplayScreen screen = new DisplayScreen();
    Keypad k= new Keypad();
    Zip zip = new Zip();
    String zipCurrentStream = "";

    /**
     * Constructor for objects of class ActiveNozzleState
     */
    public ActiveNozzleState()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public void insertCard(World w, String cardType){
       World currentWorld = w;
       System.out.println("Inside zip validated state --> insert card");
       screen.setMessageString(currentWorld,cardType);
       //this.currentState = new HasCardState();
    }
    public void enterPin(World w){}
    public void validateZip(World w, String pin){}
    public void selectFuel(World w, String Msg){}
    public void fillGas(World w, String stateMsg){
        World currentWorld = w;
        GasPumpWorld.currentState = new ActiveNozzleState();
        screen.setMessageString(currentWorld,stateMsg);
    
    }
    public void printReceipt(World w, String stateMsg){}
}

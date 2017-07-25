import greenfoot.*;  
/**
 * Write a description of class ZipValidatedState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ZipValidatedState implements GasPumpStateInterface
{
    // instance variables - replace the example below with your own
    private int x;
    DisplayScreen screen = new DisplayScreen();
    /**
     * Constructor for objects of class ZipValidatedState
     */
    public ZipValidatedState()
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
    public void selectFuel(World w, String Msg){
     World currentWorld = w;
        GasPumpWorld.currentState = new FuelSelectedState();
        screen.setMessageString(currentWorld,Msg);}
    public void fillGas(World w, String stateMsg){
        World currentWorld = w;
        GasPumpWorld.currentState = new ActiveNozzleState();
        screen.setMessageString(currentWorld,stateMsg);
    
    }
    public void printReceipt(World w, String stateMsg){}
}

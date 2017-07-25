import greenfoot.*;
/**
 * Write a description of class FuelSelectedState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FuelSelectedState implements GasPumpStateInterface
{
    // instance variables - replace the example below with your own
    private int x;
    DisplayScreen screen = new DisplayScreen();
    Keypad k= new Keypad();
    Zip zip = new Zip();
    String zipCurrentStream = "";
    /**
     * Constructor for objects of class FuelSelectedState
     */
    public FuelSelectedState()
    {
    }

    public void insertCard(World w, String cardType){
        World currentWorld = w;
       System.out.println("Inside zip validated state --> insert card");
       screen.setMessageString(currentWorld,cardType);
    }
    public void enterPin(World w){}
    public void validateZip(World w, String pin){}
    public void selectFuel(World w, String Msg){
        World currentWorld = w;
        GasPumpWorld.currentState = new FuelSelectedState();
        screen.setMessageString(currentWorld,Msg);
    }
    public void fillGas(World w, String stateMsg){
     World currentWorld = w;
        GasPumpWorld.currentState = new ActiveNozzleState();
        screen.setMessageString(currentWorld,stateMsg);}
    public void printReceipt(World w, String stateMsg){}
}

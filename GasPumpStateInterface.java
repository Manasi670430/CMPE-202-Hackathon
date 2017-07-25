import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GasPumpState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface GasPumpStateInterface
{
    public void insertCard(World w, String cardType);
    public void enterPin(World w);
    public void validateZip(World w, String pin);
    public void selectFuel(World w, String Msg);
    public void fillGas(World w, String stateMsg);
    public void printReceipt(World w, String Ms);
    
}

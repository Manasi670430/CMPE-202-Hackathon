import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DisplayScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayScreen extends Actor
{
    
    /**
     * Act - do whatever the DisplayScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static boolean pickyYesSelected = false;
    public void act() 
    {
        // Add your action code here.
        String state = "";
        GreenfootImage currentScreenImage= null;
        Message message = null;
        //Keypad k= null;
       
        
    } 
    
    public void setMessageString(World w,String msg)
    {
        
        World currentWorld = w;
        System.out.println("Inside displayscreen " + msg);
        String stateMessgae = msg;
        Keypad k= new Keypad();
        Zip zip = new Zip();
        String zipCurrentStream = "";
       
        //World c= getWorld();
        
        Message message = new Message();
        
        
        if(stateMessgae.equals("Card Validated"))
        {
            System.out.println("Inside setMessageString of display screen with current world "+ currentWorld);
            message.showMessage(stateMessgae, currentWorld);
            Greenfoot.delay(50);
            currentWorld.removeObject(message);
            
            message.showMessage("Please Enter Zip Code..", currentWorld);
            Greenfoot.delay(50);
            currentWorld.removeObject(message);
            
            k.setBeepCondition(false);
            k.setCurrentWorld(currentWorld);
            
            k.act();
               
        }
        if(stateMessgae.equals("Fake"))
        {
            message.showMessage(stateMessgae, currentWorld);
            Greenfoot.delay(50);
            currentWorld.removeObject(message);
            
            message.showMessage("Please Insert Valid Card", currentWorld);
            Greenfoot.delay(80);
            currentWorld.removeObject(message);
            k.setBeepCondition(true);
        }
        
        if(stateMessgae.equals("Zip Validated"))
        {
            System.out.println("inside zip validATED IF");
            //System.out.println("Object name is "+currentWorld);
            
            message.showMessage("Your Zip is validated!", currentWorld);
            Greenfoot.delay(80);
            currentWorld.removeObject(message);
            message.showMessage("Select Fuel Type!"+"\n\n\n\n\n\n\n\n\n\n Help                                                 Cancel", currentWorld);
            SidebarButtons.buttonName="HelpCancel";
            SidebarButtons.msg = message;
            
        }
        if(stateMessgae.equals("Enter Pin"))
        {
            message.showMessage("Please Enter Zip Code..", currentWorld);
            
            System.out.println("Inside enter Pin of display screen ");
            Greenfoot.delay(30);
            currentWorld.removeObject(message);
            
        }
        if(stateMessgae.equals("Zip Not Valid"))
        {
            
            message.showMessage(stateMessgae, currentWorld);
            Greenfoot.delay(80);
            message.showMessage("Please enter correct zip", currentWorld);
            Greenfoot.delay(80);
            currentWorld.removeObject(message);
        }
       if(stateMessgae.equals("CantSelectFuelWithoutCard"))
        {
            
            message.showMessage("Cannot Select Fuel... please scan your card first", currentWorld);
            Greenfoot.delay(80);
            currentWorld.removeObject(message);
            
        }
        
        if(stateMessgae.equals("CantSelectFuelWithoutZip"))
        {
            
            message.showMessage("Cannot Select Fuel... please authenticate zip first", currentWorld);
            Greenfoot.delay(80);
            currentWorld.removeObject(message);
            
        }
        if(stateMessgae.equals("SelectFuel"))
        {
            
            message.showMessage("Fuel Selected! Please Start filling"+"\n\n\n\n\n\n\n\n\n\n\n\n Help                                                 Cancel", currentWorld);
            SidebarButtons.buttonName="HelpCancel";
            SidebarButtons.msg = message;
            
        }
        if(stateMessgae.equals("CantUseNozzleWithoutCard"))
        {
            
            message.showMessage("Cannot fill gas... please scan your card first", currentWorld);
            Greenfoot.delay(80);
            currentWorld.removeObject(message);
            
        }
        
        if(stateMessgae.equals("CantUseNozzleWithoutZip"))
        {
            
            message.showMessage("Cannot fill gas... please authenticate zip first", currentWorld);
            Greenfoot.delay(80);
            currentWorld.removeObject(message);
            
        }
        if(stateMessgae.equals("CantUseNozzleWithoutType"))
        {
            
            message.showMessage("Cannot fill gas... please select fuel type first", currentWorld);
            Greenfoot.delay(80);
            currentWorld.removeObject(message);
            
        }
        if(stateMessgae.equals("UseNozzle"))
        {
            
            message.showMessage("Gas Filling in progress..please wait"+"\n\n\n\n\n\n\n\n\n\n\n\n Help                                                 Cancel", currentWorld);
            Greenfoot.delay(150);
            currentWorld.removeObject(message);
            
            System.out.println("If picky slected or not :"+DisplayScreen.pickyYesSelected);
            System.out.println("If button is picky yes or not :"+SidebarButtons.buttonName);
            
            System.out.println("If button is picky yes or not :"+new SidebarButtons().getButtonName());
            
            if(DisplayScreen.pickyYesSelected==true)
            {
                
                    message.showMessage("Your receipt is printed.!!", w);
                    Greenfoot.delay(150);
                    w.removeObject(message);
                    message.showMessage("Thank You.!!", w);
                    Greenfoot.delay(80);
                    Greenfoot.setWorld(new GasPumpWorld());
                    
            }
            else if(DisplayScreen.pickyYesSelected==false)
            {
                message.showMessage("Thank You.!!", w);
                    Greenfoot.delay(80);
                    Greenfoot.setWorld(new GasPumpWorld());
                
                    
            }
            else
            {
                message.showMessage("Thank You.!!", w);
            }
            
            
        }
        
        if(stateMessgae.equals("Card Already Scanned"))
        {
            
            message.showMessage(stateMessgae, currentWorld);
            Greenfoot.delay(80);
            currentWorld.removeObject(message);
            
        }
        if(stateMessgae.equals("Do you want to print receipt?"))
        {
            
            message.showMessage(stateMessgae+ "\n\n\n\n\n\n\n\n\n\n\n\n   Yes                                                        No  ", currentWorld);
            //Greenfoot.delay(80);
            //currentWorld.removeObject(message);
            
        }
        
        if(stateMessgae.equals("Do you want to print receipt?Valid:Picky"))
        {
            //String stateMessgae1 = stateMessgae.replaceAll("Do you want to print receipt?Valid:Picky", "Do you want to print receipt?");
            //System.out.println(stateMessgae1);
            message.showMessage("Do you want to print receipt?"+ "\n\n\n\n\n\n\n\n\n\n\n\n   Yes                                                        No  ", currentWorld);
            SidebarButtons.stateMessage = stateMessgae;
            SidebarButtons.buttonName="PrintSlipYesNoPicky";
            SidebarButtons.msg = message;
            //Greenfoot.delay(200);
            //currentWorld.removeObject(message);
            
        }
        
        
        
    }
}

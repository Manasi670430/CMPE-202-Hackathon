import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SidebarButtons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SidebarButtons extends Actor
{
    /**
     * Act - do whatever the SidebarButtons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static String buttonName = "";
    public static Message msg = null;
    public static String stateMessage = "";
    
    public String getButtonName()
    {
        return buttonName;
    }
    
    public String getStateMessage()
    {
        return stateMessage;
    }
    
    
    public Message getMSG()
    {
        return msg;
    }
    
    public void act() 
    {
        int sidebarButtonX = getX();
        int sidebarButtonY = getY();
        
        World w = getWorld();
        //DisplayScreen ds = new DisplayScreen();
        Message message = new Message();
       
        int currentMouseX = 0 ;
        int currentMouseY = 0 ;
        MouseInfo currentMouseState = Greenfoot.getMouseInfo();
        
        if(currentMouseState!=null) {
           currentMouseX = currentMouseState.getX();
           currentMouseY = currentMouseState.getY();
        }
        //System.out.println("Inside sidebar Act Current Mouse"+ currentMouseX  + "||" +  currentMouseY);
        
        //System.out.println("Inside sidebar Act"+ sidebarButtonX  + "||" +  sidebarButtonY);
       
        if((currentMouseX > 523 && currentMouseX < 594) && (currentMouseY > 226 && sidebarButtonY < 280))

        {
            //System.out.println("Inside sidebar"+ sidebarButtonX  + "||" +  sidebarButtonY);
            System.out.println("button name "+ this.getButtonName());
            System.out.println("Current Message object inside button  "+ getMSG());
            
            if(this.getButtonName().contains("Help"))
            {
                System.out.println("Inside help");
                if(Greenfoot.mousePressed(this))
                {
                    //w.removeObject(getMSG());
                   // w.addObject(new DisplayScreen(), 721, 164);
                    message.showMessage("We are happy to help you!!", w);
                }
            }
            if(this.getButtonName().equals("PrintSlipYesNo"))
            {
                System.out.println("Inside PrintSlipYes");
                

                if(Greenfoot.mousePressed(this))
                {
                   System.out.println("Inside  yes");
                    message.showMessage("Your receipt is printed.!!", w);
                    Greenfoot.delay(150);
                    w.removeObject(message);
                    message.showMessage("Thank You.!!", w);
                    Greenfoot.delay(80);
                    Greenfoot.setWorld(new GasPumpWorld());
                }
            }
             if(this.getButtonName().contains("PrintSlipYesNoPicky"))
            {
                System.out.println("Inside PrintSlipYesPicky");
                

                if(Greenfoot.mousePressed(this))
                {
                    if(getStateMessage().contains("Valid:Picky"))
                    {
                        System.out.println("Inside valid pickey yes");
                        DisplayScreen.pickyYesSelected = true;
                        message.showMessage("A receipt will be printed at the end.!!", w);
                        Greenfoot.delay(90);
                        w.removeObject(message);
                        message = getMSG();
                        System.out.println("Inside valid pickey yes messsage object "+message);
                        getWorld().removeObject(message);
                        GasPumpStateInterface currentState = GasPumpWorld.currentState;
                        if(currentState instanceof NoCardState)
                        {
                             currentState.insertCard(w, "Valid");
                        }      
                    }
                  
                    
                    
                }
            
            }
            
            
            
        }
        if((currentMouseX > 855 && currentMouseX < 920) && (currentMouseY > 226 && sidebarButtonY < 280))

        {
            System.out.println("Inside sidebar"+ sidebarButtonX  + "" +  sidebarButtonY);
           
            if(this.getButtonName().equals("HelpCancel"))
            {
                if(Greenfoot.mousePressed(this))
                {
                    message.showMessage("Your transaction is cancelled", w);
                    Greenfoot.delay(80);
                    Greenfoot.setWorld(new GasPumpWorld());
                }
            }
            
            if(this.getButtonName().equals("PrintSlipYesNo"))
            {
                System.out.println("Inside PrintSlip No");
                if(Greenfoot.mousePressed(this))
                {
                    //w.removeObject(getMSG());
                   // w.addObject(new DisplayScreen(), 721, 164);
                    message.showMessage("Thank You..!!", w);
                    Greenfoot.delay(80);
                    Greenfoot.setWorld(new GasPumpWorld());
                }
            }
            if(this.getButtonName().contains("PrintSlipYesNoPicky"))
            {
                System.out.println("Inside PrintSlipYesPicky");
                

                if(Greenfoot.mousePressed(this))
                {
                    if(getStateMessage().contains("Valid:Picky"))
                    {
                        System.out.println("Inside valid pickey no");
                        DisplayScreen.pickyYesSelected = false;
                        message.showMessage("No receipt will be printed.!!", w);
                        Greenfoot.delay(90);
                        w.removeObject(message);
                        message = getMSG();
                        System.out.println("Inside valid pickey no messsage object "+message);
                        getWorld().removeObject(message);
                        GasPumpStateInterface currentState = GasPumpWorld.currentState;
                        if(currentState instanceof NoCardState)
                        {
                             currentState.insertCard(w, "Valid");
                        } 
                    }
                  
                    
                    
                }
            
            }
        }
    }
}

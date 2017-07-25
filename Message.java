import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Message extends Actor
{
    private GreenfootImage screenimage;
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Message(String msg)
    {
       
        if(msg.contains("Welcome"))
        {
         screenimage = new GreenfootImage(250,50);
         setImage(screenimage);
         screenimage.clear();
         screenimage.setColor(Color.WHITE);
         screenimage.fill();
         screenimage.setColor(Color.BLACK);
         screenimage.drawString(msg,0,25);
        }
        else
        {
           screenimage = new GreenfootImage(msg,250, Color.WHITE, Color.BLACK); 
           setImage(screenimage);
        }
        
         
    }
    
    public Message()
    {
        
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    public void showMessage(String msg, World w)
    {
       World thisWorld = w;
        //Instruction inst = new Instruction();
       String passedMessage= msg;
       
       
       if(passedMessage.equals("Zip Not Valid"))
       {
           //screenimage.clear();
           screenimage = new GreenfootImage(passedMessage,40, Color.BLACK, Color.WHITE); 
           setImage(screenimage);
           thisWorld.addObject(this,740, 200);
           this.setLocation(722, 154);
       }
       if(passedMessage.contains("Here is your receipt"))
       {
        System.out.println("Inside message print receipt"+ passedMessage);
        screenimage = new GreenfootImage(passedMessage,15, Color.BLACK, Color.WHITE); 
        setImage(screenimage);
        thisWorld.addObject(this,724, 170);
        this.setLocation(724, 170);
       }
       else
       {
        System.out.println("Inside message "+ passedMessage);
        screenimage = new GreenfootImage(passedMessage,15, Color.BLACK, Color.WHITE); 
        setImage(screenimage);
        thisWorld.addObject(this,740, 200);
        this.setLocation(722, 154);
       }
       
       
    }
}

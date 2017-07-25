import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ValidCard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ValidCard extends Cards
{
    /**
     * Act - do whatever the ValidCard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
      public ValidCard()
    {
        GreenfootImage image = getImage() ;
        image.scale( 150, 100 ) ;           
    }
    
    
    public void act() 
    {
        // Add your action code here.
         int mouseX, mouseY ;
        
        if(Greenfoot.mouseDragged(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX=mouse.getX();  
            mouseY=mouse.getY();  
            setLocation(mouseX, mouseY);  
        } 
    }
}

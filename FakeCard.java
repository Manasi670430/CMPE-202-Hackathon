import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FakeCard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FakeCard extends Cards
{
    /**
     * Act - do whatever the FakeCard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public FakeCard()
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

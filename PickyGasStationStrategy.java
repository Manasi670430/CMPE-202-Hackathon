import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Number2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PickyGasStationStrategy extends Actor
{
    /**
     * Act - do whatever the Number2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PickyGasStationStrategy(){
        GreenfootImage image = getImage() ;
        image.scale( 60, 60 ) ;  
    }
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(this)){
            System.out.println("Picky Gas station");
             World w = getWorld();
             System.out.println("All set for strategy 1");
             //StratergyInterface s1 = new PickyGasStation();
             
             new CardSlot().setGasPumpType(new PickyGasStation());
             
             
         }
    }    
}

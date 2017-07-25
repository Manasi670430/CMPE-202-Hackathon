import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Number1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalGasStationStrategy extends Actor
{
    /**
     * Act - do whatever the Number1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public NormalGasStationStrategy(){
        GreenfootImage image = getImage() ;
        image.scale( 60, 60 ) ;  
    }
    
    public void act() 
    {
        // Add your action code here.
         if(Greenfoot.mousePressed(this)){
             System.out.println("Nomral Gas station");
             World w = getWorld();
             System.out.println("All set for strategy 2");
             //StratergyInterface s2 = new NormalGasStation();
             new CardSlot().setGasPumpType(new NormalGasStation());
             
         }
        
    }    
}

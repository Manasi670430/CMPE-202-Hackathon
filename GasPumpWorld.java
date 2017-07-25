import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GasPumpWorld extends World
{
    public static GasPumpStateInterface currentState = null;
    
    public void setState(GasPumpStateInterface state)
    {
        System.out.println("set hascard state");
        this.currentState = state;
    }
    
    public GasPumpStateInterface getState()
    {
        return this.currentState;
    }
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GasPumpWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 700, 1); 
        prepare();
        
    }
    
    public void prepare()
    {
        addObject( new Keypad(), 725, 475);
        addObject( new SidebarButtons(), 554, 164 ) ;
        addObject( new SidebarButtons(), 887, 165 ) ;
        addObject( new ValidCard(), 151, 101 ) ;
        addObject( new MembershipCard(), 159, 312 ) ;
        addObject( new FakeCard(), 153, 525 ) ;
        addObject( new Nozzle(), 1062, 254 ) ; 
        addObject( new CardSlot(), 470, 450 ) ;
        addObject( new DisplayScreen(), 721, 164 ) ;
        //addObject( new PickyGasStation(), 313, 500);
        //addObject( new NormalGasStation(), 542, 500);
        addObject( new NormalGasStationStrategy(), 325, 40);
        addObject( new PickyGasStationStrategy(), 400, 40);
        addObject( new FuelType(), 1062, 454 ) ;
        addObject( new Message("Welcome to the gas pump station"), 720, 25 ) ;
        currentState= new NoCardState();

    }
}

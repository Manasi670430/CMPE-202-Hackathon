import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zip extends Actor
{
    /**
     * Act - do whatever the Zip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String message_zip;
    
    public void act() 
    {
        // Add your action code here.
        //World w =getWorld();
    }    
    
    public boolean validateZip(String zipcode, World w)
    {
       DisplayScreen ds = new DisplayScreen();
       World currentWorld = w;
       String zip = zipcode;
       System.out.println("Current world in zip"+ " " + currentWorld + " and zip is " + zip);
        //String zipcode = "97238";
        if(zipcode.startsWith("9"))
        {
            System.out.println("inside validate ValidateZip");
            //System.out.println("value of w is "+currentWorld);
            ds.setMessageString(w,"Zip Validated");
            return true;
        }
        else{
            ds.setMessageString(currentWorld,"Zip Not Valid");
            return false;
        }
    }
    
    public void setMessage(String message){
        message_zip = message;
    }
    
    public String getMessage(){
        return message_zip;
    }
}

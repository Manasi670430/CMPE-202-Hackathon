import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Keypad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Keypad extends Actor implements KeyPressHandler
{
    /**
     * Act - do whatever the Keypad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    int numberOfButtonRow=4;
    int numberOfButtonCol=3;
    int keypadWidth=240;
    int keypadHeight=320;
    int buttonlength=80;
    int buttonWidth=80;
    int mCoordinateX;
    int mCoordinateY;
    int keypadCentreCordinateX=725;
    int keypadCentreCordinateY=475;
    int keypadStartCordinateX=keypadCentreCordinateX-(keypadWidth/2);
    int keypadStartCordinateY=keypadCentreCordinateY-(keypadHeight/2);
    int keypadEndCordinateX=keypadCentreCordinateX+(keypadWidth/2);
    int keypadEndCordinateY=keypadCentreCordinateY+(keypadHeight/2);
    String keyInput="";
    String keyValue="";
    public static Boolean beepCondition=true;
    private KeyPressHandler successor = null;
    
    public static World w = null;
    public static String zipStream = "";
    
    String zipCurrentStream = "";
    
    
    Zip zip = null;
    public Keypad()
    {
        GreenfootImage image = getImage() ;
        image.scale( 240, 320 ) ; 
        zip = new Zip();
    }
    
   public static void setBeepCondition(boolean condition)
   {
       beepCondition=condition;
   }
   
   public static void setCurrentWorld(World currentWorld)
   {
       w = currentWorld;
   }
   
   
    
    public void act() 
    {
     World w =getWorld();
     //System.out.println("Beep condition is " + beepCondition);
     GasPumpStateInterface currentState = GasPumpWorld.currentState;
     //System.out.println("Set state in Keypad when valid card scanned: "+ currentState);
       
      //if(currentState instanceof NoCardState)
     //{
        if(Greenfoot.mousePressed(this))
         {
           System.out.println("Inside Greenfoot mouse pressed beep condition is " + beepCondition + " and state is "+ currentState);  
           MouseInfo mouseInformation = Greenfoot.getMouseInfo();
           mCoordinateX= mouseInformation.getX();
           mCoordinateY= mouseInformation.getY();
           //setLocation(mouseCordinateX,mouseCordinateY);
           if(beepCondition && currentState instanceof NoCardState)
           {
            Greenfoot.playSound("beep-07.wav");
           }
           else if(beepCondition && currentState instanceof ZipValidatedState)
           {
            Greenfoot.playSound("beep-07.wav");
           }
           else if(beepCondition && currentState instanceof ActiveNozzleState)
           {
            Greenfoot.playSound("beep-07.wav");
           }
           else {
           //System.out.println(mouseCoordinateX);
           //System.out.println(mouseCoordinateY);
           if((keypadStartCordinateX <mCoordinateX || mCoordinateX<keypadEndCordinateX) && (keypadStartCordinateY< mCoordinateX || mCoordinateX < keypadEndCordinateY)){
           String Key=buttonInfo(mCoordinateX,mCoordinateY);
           System.out.println(Key);
           String zipCurrent = inputString(Key);
           System.out.println(zipCurrent);
          if(zipCurrent.length()==4)
           {
               System.out.println("Inside if zip stream is "+ zipCurrent);
               zipStream = zipCurrent;
           }
       }
       else {
        if ( successor != null )
             successor.buttonInfo(mCoordinateX,mCoordinateX);
                
            }
      
      
           
           
           
           //zipStream = inputString(Key);
           //System.out.println(zipStream);
           }
        }
        
        
        if(currentState instanceof HasCardState)
        {
            if(zipStream.length()==4)
            {
                if(zip.validateZip(zipStream, w))
                {
                   currentState.validateZip(w, zipStream);
                }
            }
            beepCondition = true;
            zipStream = "";
        }
        
        
     //}
        
     
     
    } 
    
        public void setNextKeyPressHandler(KeyPressHandler next) {
        this.successor = next ;
	}
    
    
    public String buttonInfo(int mouseCoordinateX,int mouseCoordinateY)
    {
        String KeyString=null;
        int KeyNum=0;
         Message message = new Message();
           World currentWorld = w;
        for (int i=0;i<numberOfButtonRow;i++){
            for (int j=0;j<numberOfButtonCol;j++){
                KeyNum = KeyNum+1;
                int rangeStartX=(j*buttonlength)+keypadStartCordinateX;
                int rangeEndX=((j+1)*buttonlength)+keypadStartCordinateX;
                int rangeStartY=(i*buttonWidth)+keypadStartCordinateY;
                int rangeEndY=((i+1)*buttonWidth)+keypadStartCordinateY;
                
                //System.out.println(rangeStartX+" "+rangeEndX);
                //System.out.println(rangeStartY+" "+rangeEndY);
                
                if(rangeStartX<=mouseCoordinateX && rangeEndX>mouseCoordinateX && rangeStartY<=mouseCoordinateY && rangeEndY>mouseCoordinateY)
                {  
                   
                   if(KeyNum==10)
                   { KeyString="*";
                      
                     System.out.println(KeyString);
                     message.showMessage(KeyString, currentWorld);
                     Greenfoot.delay(80);
                     currentWorld.removeObject(message);
                     return KeyString;
                     
                   }
                   if(KeyNum==11)
                   {
                   KeyString="0";
                   System.out.println(KeyString);
                   message.showMessage(KeyString, currentWorld);
                   Greenfoot.delay(80);
                    currentWorld.removeObject(message); 
                   return KeyString;
                   
                   }
                   if(KeyNum==12)
                   {
                   KeyString="#";
                   System.out.println(KeyString);
                    message.showMessage(KeyString, currentWorld);
                    Greenfoot.delay(80);
                     currentWorld.removeObject(message);
                   return KeyString;
                  
                   }
                   keyValue=keyValue+String.valueOf(KeyNum);
                   KeyString=String.valueOf(KeyNum);
                   System.out.println(KeyNum);
                   System.out.println(KeyString);
                   message.showMessage(keyValue, currentWorld);
                   Greenfoot.delay(10);
                   currentWorld.removeObject(message);
                   return KeyString;
                   
                }
                
        }
     }
     
     return KeyString;
    }
    
        public String inputString(String key){
            if(key == "*")
            { System.out.println("Do nothing");}
            if(key == "#")
            { keyInput=keyInput.substring(0,keyInput.length() - 1);}
           
            if(key != "*" && key != "#")
            {keyInput=keyInput+key;}
            System.out.println(keyInput);
            return keyInput;
        }
}

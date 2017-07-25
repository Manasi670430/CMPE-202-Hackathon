import greenfoot.*;
/**
 * Write a description of class KeyPressHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface KeyPressHandler {

	public String buttonInfo(int mouseCoordinateX,int mouseCoordinateY);
	public void setNextKeyPressHandler(KeyPressHandler NextKeyPressHandler);

}

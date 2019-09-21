import greenfoot.*;  
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class POS extends Actor
{
    String pos = "noun";
    public POS() {
        swap("noun");
    }
    /**
     * used to display current mode onto screen
     * swap is used by other actors like Alien to change mode
     */
    public void swap(String change) 
    {
       pos = change;
       
       GreenfootImage img = new GreenfootImage(100, 30);
       img.setColor(Color.YELLOW);
       img.drawString("SHOOT:" + change, 10, 25);
       setImage(img);
       
    }    
}

import greenfoot.*;

/**
 * Actor class for printing text on the screen.
 * 
 * @author Andrew Bochkarev
 */
public class Text extends Actor
{
    /**
     * Constructor for objects of class Text.
     */
    public Text(String text, int size)
    {
        if (size != 0)
        {
            GreenfootImage image = new GreenfootImage(text, size, Color.BLACK, null);
            setImage(image);
        }
        else
        {
            GreenfootImage image = new GreenfootImage(text);
            setImage(image);
        }
    }
}

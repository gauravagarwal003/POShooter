import greenfoot.*;

/**
 * Main menu of the game. Includes short tutorial and word length preferences.
 * 
 * @author Andrew Bochkarev
 */
public class Menu extends World
{
    public static boolean modeL = true, modeM = true, modeS = true;
    Text play = new Text("play.png", 0);
    Text tutorial1 = new Text("Type incoming words on your keyboard.", 35);
    Text tutorial2 = new Text("If words cross the line, you lose lives.", 35);
    Text tutorial3 = new Text("Difficulty increases over time.", 35);
    Text tutorial4 = new Text("Only type the part of speech that the mode is.", 35);
    Text tutorial5 = new Text("For example, if the mode is verb, you will lose",35);
    Text tutorial6 = new Text("points for typing words that are not verbs.", 35);
 
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        super(800, 400, 1); 
        addObject(play, 80, 80);
        addObject(tutorial1, 470, 50);
        addObject(tutorial2, 453, 110);
        addObject(tutorial3, 393, 170);
        addObject(tutorial4, 360, 230);
        addObject(tutorial5, 360, 290);
        addObject(tutorial6, 335, 350);
    }
    /**
     * Manages all the buttons.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(play))
        {
            if (modeS == true || modeM == true || modeL == true)
            {
                MyWorld myworld = new MyWorld();
                Greenfoot.playSound("play.wav");
                Greenfoot.setWorld(myworld);
            }
        }
    }
}

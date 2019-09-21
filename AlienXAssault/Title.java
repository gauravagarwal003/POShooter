import greenfoot.*;  
public class Title extends World
{
    /**
     * This method creates the dimensions for title "AlienXAssault"
     */
    public Title()
    {    
        super(900, 600, 1); 

        addObject(new Enter(), 580, 400);
    }
/**
 * Creates actual title of game to display
 */
    public void act()

    {
        Greenfoot.setWorld(new Title());//creates new title
        if (Greenfoot.isKeyDown("enter"))//if user presses enter start game
        {
            Greenfoot.setWorld(new SpaceLand());
        }
    }
}

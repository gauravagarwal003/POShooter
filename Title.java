import greenfoot.*;  
public class Title extends World
{
    public Title()
    {    
        super(900, 600, 1); 

        addObject(new Enter(), 580, 400);
    }

    public void act()

    {
        Greenfoot.setWorld(new Title());
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new SpaceLand());
        }
    }
}

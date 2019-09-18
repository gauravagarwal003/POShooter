import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldier extends Actor
{
    //public boolean - allowing for single key press
    public boolean upD = false; 
    public boolean downD = false;
    public boolean spaceD = false;

    public void act() // Move Actor Up and down by 200 cells
    {
        if (Greenfoot.isKeyDown("up") && upD ==false) {
            upD = true;
            setLocation(getX(), getY()-200);
        }
        else if (!Greenfoot.isKeyDown("up") && upD ==true)
            upD = false; 
        if (Greenfoot.isKeyDown("down") && downD ==false) {
            downD = true;
            setLocation(getX(), getY()+200); 
        }
        else if (!Greenfoot.isKeyDown("down") ==true)
            downD = false;
        // Stop Actor from leaving World
        if (getY()>500) {
            setLocation(50, 500);
        }
        else if (getY()<100) {
            setLocation(50, 100);
        }
        // Fire bullet
        if (Greenfoot.isKeyDown("space") && spaceD ==false){
            spaceD = true;

            Greenfoot.playSound("bullet.wav"); // play sound

            Bullet Bullet = new Bullet();
            getWorld().addObject(Bullet, getX(), getY());
        }
        else if (!Greenfoot.isKeyDown("space") ==true)
            spaceD = false;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien2 extends Actor
{
    int SPEED = -7; // Speed of 10 in left direction "-"
    public Alien2() {
    }

    public void act() 
    {
        move (SPEED); //calls SPEED function

        Actor Bullet = getOneIntersectingObject(Bullet.class); 

        if (Bullet !=null) {
            Greenfoot.playSound("explosion.wav");
            getWorld(). removeObject(Bullet);
            
            ((SpaceLand)(getWorld())).score.add(50);
            
            getWorld(). removeObject(this); //remove alien from screen 
        }
    }
}
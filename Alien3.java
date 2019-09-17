import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien3 extends Actor
{
    int SPEED = -7; // Speed of 10 in left direction "-"
    public Alien3() {
    }
    {
        int tempType = ((int)(Math.random() * 3));
        
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
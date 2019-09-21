import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int SPEED = 9;//speed of bullet
    /**
     * This class sets speed for other classes
     */
    public void act() 
    {
        move(SPEED);//speed
    }    
}


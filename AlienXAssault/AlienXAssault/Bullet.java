import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int SPEED = 9;
    public Bullet () {
    }

    public void act() 
    {
        move(SPEED);
    }    
}


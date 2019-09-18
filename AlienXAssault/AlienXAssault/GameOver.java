import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    public boolean isPlain = true; 
    public GameOver() {
        GreenfootImage gmeO = new GreenfootImage(335,100);
        gmeO.setColor(Color.GREEN);
        Font myFont = new Font("bauhaus 93", false, false, 60);
        gmeO.setFont(myFont);
        gmeO.drawString("Game Over", 20, 45);
        setImage(gmeO);
    }
}

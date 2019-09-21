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
    /**
     * The GameOver method that is called upon by the "alien" (meant to be words) actors when they pass a certain coordinate in the world.
     * Once called the game will end and the player will be asked to play again.
     */
    public GameOver() {
        GreenfootImage gmeO = new GreenfootImage(335,100);//creates new greenfoot image
        gmeO.setColor(Color.GREEN);//makes the color green
        Font myFont = new Font("bauhaus 93", false, false, 60);//defines characteristics of font
        gmeO.setFont(myFont);//sets font for class
        gmeO.drawString("Game Over", 20, 45);//constructs game over
        setImage(gmeO);//makes image game over
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class POS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class POS extends Actor
{
    /**
     * Act - do whatever the POS wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public POS() 
    {
        GreenfootImage gmeO = new GreenfootImage(335,100);
        gmeO.setColor(Color.GREEN);
        Font myFont = new Font("bauhaus 93", false, false, 60);
        gmeO.setFont(myFont);
        gmeO.drawString("FORTNITE FORTNIE FORTNITE", 20, 45);
        setImage(gmeO);
    }    
}

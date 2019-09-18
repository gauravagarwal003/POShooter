import greenfoot.*;  
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    int score = 0;
  
    public Score() {
        add(0);
    }    
    public void add(int amount) 
    {
       score = score + amount;
       
       GreenfootImage img = new GreenfootImage(100, 30);
       img.setColor(Color.YELLOW);
       img.drawString("Score:" + score, 10, 25);
       setImage(img);
       
    }    
}

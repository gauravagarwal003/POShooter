import greenfoot.*;

import java.util.*;
/**
 * Finish line. Counts lives and manages end of the game.
 * 
 * @author Andrew Bochkarev
 */
public class Finish extends Actor
{
    private int lives = 3, oldScore = 0;
    public static int xfinishvalue = 750;
    public static int livesx = 670, livesy = 20;
    /**
     * Counts lives and manages end of the game.
     */
    public void act() 
    {
        MyWorld myworld = (MyWorld) getWorld();
        for (Object obj : getIntersectingObjects(null))
        {
            Actor wordAtFinish = (Actor) obj;
            if (wordAtFinish instanceof Words)
            {  
                if (lives >1)
                {
                    lives--;
                    myworld.removeObject(wordAtFinish);
                    Greenfoot.playSound("downlife.wav");
                    if (myworld.matchesFound.contains(wordAtFinish)) 
                    {//cleans up after disappeared words
                        myworld.matchesFound.remove(wordAtFinish);
                        myworld.iinput = "";
                    }
                }
                else //game over
                {
                    lives--;
                    myworld.removeObject(wordAtFinish);
                    myworld.removeObjects(myworld.getObjects(Words.class)); //cleaning up
                    myworld.placeText("", myworld.inputx, myworld.inputy, 16);
                    myworld.placeText("", myworld.wrongx, myworld.wrongy, 16);
                    myworld.placeText("", myworld.scorex, myworld.scorey, 16);
                    
                    Text gameover = new Text("Game Over", 48);
                    Text accur = new Text("Accuracy "+myworld.accuracy+"% ", 32);
                    Text scor = new Text("Score "+ myworld.score, 32);
                    Text killed = new Text(myworld.killedWords + " words", 32);
                    
                    myworld.addObject(gameover, myworld.getWidth()/2, myworld.getHeight()*4/12);
                    myworld.addObject(accur, myworld.getWidth()/2, myworld.getHeight()*6/12);
                    myworld.addObject(killed, myworld.getWidth()/2, myworld.getHeight()*7/12);
                    myworld.addObject(scor, myworld.getWidth()/2, myworld.getHeight()*8/12);
                    Greenfoot.playSound("gameover.wav");
                    Greenfoot.stop();
                }
            }
        }
        
        if (myworld.difficulty > 1 && myworld.score - oldScore > 40* myworld.difficulty) //bonus lives
        {
            lives++;
            oldScore = myworld.score;
            Greenfoot.playSound("pluslife.wav");
        }
        myworld.placeText("You have " + lives + " lives",livesx,livesy,20);
    }  
}

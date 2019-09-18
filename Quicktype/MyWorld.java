import greenfoot.*;

import java.util.*;
import java.math.*;
/**
 * Contains and controls all the Words, checks for user input and for typing mistakes, manages difficulty.
 * 
 * @author Andrew Bochkarev
 * 
 */
public class MyWorld extends World
{   String input, iinput;
    boolean foundMatch = false, needsCleaning = false, justRemoved = false, checkedInput = true;
    public int time, deltaTime;
    int inputx = 450, inputy = 20, wrongx = 520, wrongy = 20, scorex = 200, scorey = 20, difx = 40, dify = 20;
    int delay = 100, keystrokes, mistakes, accuracy = 0, difficulty, score, red, killedWords;
    public ArrayList<Object> matchesFound = new ArrayList<Object>();
    private String[] allowedKeys = {"q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j",
            "k","l","z","x","c","v","b","n","m","0","1","2","3","4","5","6","7","8","9","`","'","-"};
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {   
        super(800, 400, 1); 
        addObject(new Finish(), Finish.xfinishvalue, this.getHeight()/2);
        addObject(new Words(), 100, 200);
        placeText("[You're typing ",(inputx - 70), inputy, 16);
    }

    /**
     * Gets user input and checks it for mistakes, manages creation/deletion of Words.
     */
    public void act()
    {
        time++;
        if (time%400 == 0)
        {
            changeDifficulty(1,-1);
            if (this.getObjects(Words.class).size() < 2)
                changeDifficulty(1,-1);
            if (difficulty > 20 && this.getObjects(Words.class).size()>5)
                changeDifficulty(1,-1);
            //if (this.getObjects(Words.class).size() > 4) // adaptive difficulty
            //    changeDifficulty(-1,3);
        }
        spawnNewWord(delay);
        input = Greenfoot.getKey(); //Getting input
        if (Arrays.asList(allowedKeys).contains(input) && input.length() == 1)
        {
            if (iinput == null) iinput = "";
            iinput += input;                       //accumulating user input in iinput
            placeText(iinput+"]", inputx, inputy, 16); //showing input on the screen
            checkedInput = false;
            justRemoved = false;
            keystrokes++;
        }  

        if (!this.getObjects(Words.class).isEmpty() && !checkedInput)//checking the word, symbol by symbol
        {
            for(int i = 0; i < this.getObjects(Words.class).size(); i++)
            {
                String sWord = this.getObjects(Words.class).get(i).theWord;
                Object oWord = this.getObjects(Words.class).get(i);
                if (sWord.matches(iinput + (".*")) && iinput != "") //if starts the same as iinput
                {
                    if (!matchesFound.contains(oWord)) matchesFound.add(oWord);
                    if (sWord.equals(iinput))
                    {
                        this.removeObject((Actor) oWord);
                        iinput = "";
                        justRemoved = true;
                        Greenfoot.playSound("kill.wav");
                        killedWords++;
                        cleanText(inputx, inputy);
                        matchesFound.clear();
                        if (difficulty>0) score += sWord.length()*difficulty; //assigning player score
                        else score += sWord.length();
                        placeText("[Your score is "+ score+"]", scorex, scorey, 25);
                    }
                }
                else if (!justRemoved)
                {
                    if (matchesFound.contains(oWord)) matchesFound.remove(oWord);
                    if (i == this.getObjects(Words.class).size()-1 && matchesFound.size() == 0)
                    {
                        placeText("[You're wrong]", wrongx, wrongy, 16);
                        iinput = "";
                        deltaTime = time;
                        needsCleaning = true;
                        mistakes++;
                        Greenfoot.playSound("mistake.wav");
                    }//cleaning iinput
                    if (iinput.length()>1 && matchesFound.size() == 0) iinput = ""; 
                }
            }
            checkedInput = true; //every piece of user input has to be checked only once
        }
        if (time - deltaTime >= 50 && needsCleaning) cleanText(wrongx,wrongy); //time to delete "Wrong!" message
        if (mistakes > 0)
            accuracy = Math.round(100*(1-(float)mistakes/keystrokes)); //calculating user accuracy
        else accuracy = 100;
    }

    /**
     * Spawns a new word after (int delay) time.
     * 
     * @param delay
     *      Amount of frames until the next word should be added to the world.
     */
    public void spawnNewWord(int delay)
    {
        if (time%delay == 0) addObject(new Words(), 10, Greenfoot.getRandomNumber(10)*30+50);
    }

    /**
     * Clears a textfield at (int x, int y) coordinates.
     * 
     * @param x
     *      Coordinate on x-axis.
     * @param y
     *      Coordinate on y-axis.
     */
    public void cleanText(int x, int y)
    {
        if (!getObjectsAt(x,y,Text.class).isEmpty())
        {
            getObjectsAt(x,y,Text.class).get(0).setImage(new GreenfootImage(1, 1));
            needsCleaning = false;
        }
    }

    /**
     * Prints text using Text(). Adds new Text object if the spot is empty, otherwise changes object's image.
     * 
     * @param text
     *      Text to be written.
     *      
     * @param x, y
     *      Coordinates at which to place the text.
     *      
     * @param size
     *      Size of the text.
     */
    public void placeText(String text, int x, int y, int size)
    {
        if (getObjectsAt(x,y,Text.class).isEmpty()) 
            this.addObject(new Text(text, size), x,y);
        else getObjectsAt(x,y,Text.class).get(0).setImage(new GreenfootImage(text, size, Color.BLACK, null));
    }

    /**
     * Changes difficulty.
     * 
     * @param changeDif
     *      +/-int, for decreasing or increasing difficulty, respectively.
     *      
     * @param changeDelay
     *      +/-int, for increasing or decreasing delay between spawning new words.
     */
    public void changeDifficulty(int changeDif, int changeDelay)
    {
        difficulty += changeDif;
        delay += changeDelay; 
        placeText(String.valueOf("Difficulty "+difficulty), difx, dify, 16);
    }
}

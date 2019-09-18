import greenfoot.*;

import java.io.*;
import java.util.*;
/**
 * Stores and manages all words, moves them around.
 * 
 * @author Andrew Bochkarev
 */
public class Words extends Actor
{
    public int speed = getRandomNumber(1,3);
    Menu menu = (Menu) getWorld();
    String theWord = "", binaryVariant = null;
    boolean chosen = false;
    String[] allAdjectives = {"awesome","cool","long","big","small","great","best","clear","easy","hard","high","important","late","new","old","strong","young","low","public"};
    String[] allNouns = {"pencil","chair","bird","bottle","laptop","tree","man","mountain","state","ocean","building","cat","dog","train","bed","violin","milk","rice"};
    String[] allVerbs = {"listen","protect","sell","buy","drive","speak","apply","approve","bake","boil","eat","enjoy","fry","grow","get","give","hear","improve"};

    String adjective = allAdjectives[(Greenfoot.getRandomNumber(allAdjectives.length - 1))];
    String noun = allNouns[(Greenfoot.getRandomNumber(allNouns.length - 1))];
    String verb = allVerbs[(Greenfoot.getRandomNumber(allVerbs.length - 1))];

    
    GreenfootImage adjectiveImage = new GreenfootImage(adjective,35,Color.BLACK,null);
    GreenfootImage nounImage = new GreenfootImage(noun,35,Color.BLACK,null);
    GreenfootImage verbImage = new GreenfootImage(verb,35,Color.BLACK,null);
    
    public void act() 
    {
        if (!chosen)
        {
            chooseWord(menu.modeS, menu.modeM, menu.modeL);
            binaryVariant = "";
            chosen = true; //theWord for every instance of Words.class has to be chosen only once.
        }
        MyWorld myworld = (MyWorld) getWorld();
        if (myworld.time%2 == 0)move(speed); //Controls speed. Basically moves the words every 2 frames.
    }
    
    /**
     * Gets random number between (int start) and (int end), including the borders.
     * 
     * @param start
     *      First possible value.
     * @param end
     *      Last possible value.
     * @return
     *      Returns a random number between these borders.
     */
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
    
    /**
     * Chooses a list depending on user preferences, and takes a word from it.
     * 
     * @param s
     *      Boolean showing if short list is selected
     * @param m
     *      Boolean showing if medium list is selected
     * @param l
     *      Boolean showing if long list is selected
     */
    public void chooseWord(boolean s, boolean m, boolean l)
    {
        int si = (s) ? 1 : 0;
        int mi = (m) ? 1 : 0;
        int li = (l) ? 1 : 0;
        binaryVariant = "" + si + mi + li;
        switch (binaryVariant)
        {
            case "000": break;
            case "001": setImage(verbImage); theWord = verb; break;
            case "010": setImage(nounImage); theWord = noun; break;
            case "011": 
                switch (getRandomNumber(0,1))
                {
                    case 0: setImage(nounImage); theWord = noun; break;
                    case 1: setImage(verbImage); theWord = verb; break;
                }
                break;
            case "100": setImage(adjectiveImage); theWord = adjective; break;
            case "101":  
                switch (getRandomNumber(0,1))
                {
                    case 0: setImage(adjectiveImage); theWord = adjective; break;
                    case 1: setImage(verbImage); theWord = verb; break;
                }
                break;
            case "110":  
                switch (getRandomNumber(0,1))
                {
                    case 0: setImage(adjectiveImage); theWord = adjective; break;
                    case 1: setImage(nounImage); theWord = noun; break;
                }
                break;
            case "111":  
                switch (getRandomNumber(0,2))
                {
                    case 0: setImage(adjectiveImage); theWord = adjective; break;
                    case 1: setImage(nounImage); theWord = noun; break;
                    case 2: setImage(verbImage); theWord = verb; break;
                }
                break;
        }
    }
    
    /**
     * Loads the text of the file with the given filename. Do not change this.
     * 
     * @param filename
     *      The name of the file that should be loaded.
     * 
     * @return
     *      Returns a list of Strings consisting of the text of the file.
     *      Each line of the file is a new element of the list.
     */
    public java.util.List<String> loadFile(String filename) {
        ArrayList<String> fileText = new ArrayList<String>();
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader(filename));
            String input;
            while ((input = file.readLine()) != null) {
                fileText.add(input);
            }
        }
        catch (FileNotFoundException fnfe) {
            //fnfe.printStackTrace();
            return null;
        }
        catch (IOException ioe) {
            //ioe.printStackTrace();
            return null;
        }
        finally {
            try {
                file.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
            catch (NullPointerException npe) {
                //npe.printStackTrace();
            }
        }
        return fileText;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A soldier that shoots words.
 * 
 * @author Lac-Phong Nguyen, Daylen Boen, Guarav
 * @version 1
 */
public class Soldier extends Actor
{
    //public boolean - allowing for single key press
    public boolean upD = false; 
    public boolean downD = false;
    public boolean initialkey = false;
    public String[] words = {"run","walk","crawl","suck","build", "fortnite", "shield", "school", "tree", "mouse", "stupid","small","big","goofy","special"};
    public int r= (int)(Math.random() * 4);
    /**
     * This is a getter that takes in the words list defined above.
     */
    public String[] getwords(){
        return words;
    }
    /**
     * This is a getter that takes the random int defined below that serves as an index for the words array.
     */
    public int getindex(){
        return r;
    }
    /**
     * Defines how the soldier moves around the world and how he kills the "aliens" (words).
     */
    public void act() // Move Actor Up and down by 200 cells
    {
        if (Greenfoot.isKeyDown("up") && upD ==false) {
            upD = true;
            setLocation(getX(), getY()-200);
        }
        else if (!Greenfoot.isKeyDown("up") && upD ==true)
            upD = false; 
        if (Greenfoot.isKeyDown("down") && downD ==false) {
            downD = true;
            setLocation(getX(), getY()+200); 
        }
        else if (!Greenfoot.isKeyDown("down") ==true)
            downD = false;
        // Stop Actor from leaving World
        if (getY()>500) {
            setLocation(50, 500);
        }
        else if (getY()<100) {
            setLocation(50, 100);
        }
        /* Fire bullets whenever user inserts correct letter for the given word and makes it so that it iterates
         * through the letters of the word taken from the random int
           */
        
        for (int i=0;i<(words[r].length()-1);i++){
            if (Greenfoot.isKeyDown(String.valueOf((words[r].charAt(i)))) && initialkey==false){
                initialkey = true;

                Greenfoot.playSound("bullet.wav"); // play sound

                Bullet Bullet = new Bullet();//creates bullet object
                getWorld().addObject(Bullet, getX(), getY());//adds object
            }
            else if (!Greenfoot.isKeyDown(String.valueOf((words[r].charAt(i)))) == true){
                initialkey = false;
            }
        }
        Actor Alien =getOneIntersectingObject(Alien.class);   

        if(Alien != null) {//if alien hits soldier soldier dies and it displays gameover
            Greenfoot.playSound("game_over.mp3");
            GameOver gameover = new GameOver();
            getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }    
    }
}

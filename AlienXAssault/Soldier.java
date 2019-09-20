import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldier extends Actor
{
    //public boolean - allowing for single key press
    public boolean upD = false; 
    public boolean downD = false;
    public boolean initialkey = false;
    public String[] words = {"run","walk","crawl","suck","build", "fortnite", "shield", "school", "tree", "mouse", "stupid","small","big","goofy","special"};
    public int r= (int)(Math.random() * 4);
    public String[] getwords(){
        return words;
    }
    public int getindex(){
        return r;
    }
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
        // Fire bullet
        
        for (int i=0;i<(words[r].length()-1);i++){
            if (Greenfoot.isKeyDown(String.valueOf((words[r].charAt(i)))) && initialkey==false){
                initialkey = true;

                Greenfoot.playSound("bullet.wav"); // play sound

                Bullet Bullet = new Bullet();
                getWorld().addObject(Bullet, getX(), getY());
            }
            else if (!Greenfoot.isKeyDown(String.valueOf((words[r].charAt(i)))) == true){
                initialkey = false;
            }
        }
        Actor Alien =getOneIntersectingObject(Alien.class);   

        if(Alien != null) {
            Greenfoot.playSound("game_over.mp3");
            GameOver gameover = new GameOver();
            getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }    
    }
}

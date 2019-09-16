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
    String[] verbs = {"run","walk","crawl","suck","build"};
    String[] nouns = {"fortnite", "shield", "school", "tree", "mouse"};
    String[] adj = {"stupid","small","big","goofy","special"};
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
        int r= (int)(Math.random() * 4);
        for (int i=0;i<=(verbs[r].length()-1);i++){
            if (Greenfoot.isKeyDown(String(verbs[r].charAt(i))) && initialkey==false){
                initialkey = true;

                Greenfoot.playSound("bullet.wav"); // play sound

                Bullet Bullet = new Bullet();
                getWorld().addObject(Bullet, getX(), getY());
            }
            else if (!Greenfoot.isKeyDown("space") ==true)
                initialkey = false;
        }
        for (int i=0;i<=(nouns[r].length()-1);i++){
            if (Greenfoot.isKeyDown(String(verbs[r].charAt(i))) && initialkey==false){
                initialkey = true;

                Greenfoot.playSound("bullet.wav"); // play sound

                Bullet Bullet = new Bullet();
                getWorld().addObject(Bullet, getX(), getY());
            }
            else if (!Greenfoot.isKeyDown("space") ==true)
                initialkey = false;
        }
        for (int i=0;i<=(adj[r].length()-1);i++){
            if (Greenfoot.isKeyDown(String(verbs[r].charAt(i))) && initialkey==false){
                initialkey = true;

                Greenfoot.playSound("bullet.wav"); // play sound

                Bullet Bullet = new Bullet();
                getWorld().addObject(Bullet, getX(), getY());
            }
            else if (!Greenfoot.isKeyDown("space") ==true)
                initialkey = false;
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

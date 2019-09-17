import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Alien extends Actor
{
    int SPEED = -2; // Speed of 10 in left direction "-"
    public Alien() {
        
    }

    public void act() 
    {
        move (SPEED); //calls SPEED function
        String[] verbs = {"run","walk","crawl","suck","build"};
        Actor Bullet = getOneIntersectingObject(Bullet.class); 
        GreenfootImage image = new GreenfootImage(verbs[(int)(Math.random() * 4)], 5, Color.BLACK, Color.WHITE);
        // If alien touches left side of screen - Game Over
         if (getX()<0) {
             Greenfoot.playSound("game_over.mp3");
            GameOver gameover = new GameOver();
            getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
        // If Bullet touches alien - Game Over
        if (Bullet !=null) {
            Greenfoot.playSound("explosion.wav");
            getWorld(). removeObject(Bullet);

            ((SpaceLand)(getWorld())).score.add(50);

            getWorld(). removeObject(this); //remove alien from screen 
        }
        
       
    }
}
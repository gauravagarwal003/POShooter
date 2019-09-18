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
        int tempType = (int)((Math.random() * 3) + 1);
        if (tempType == 1) {
           SpaceLand spaceWorld = (SpaceLand) getWorld();
           Soldier verb = spaceWorld.getV();
           verb.getV();
           setImage(image);
        }
        else {
           setImage("Alien.png");
        }

        // If alien touches left side of screen - Game Over
         if (getX()<0) {
            if (tempType == 1){
                Greenfoot.playSound("game_over.mp3");
                GameOver gameover = new GameOver();
                getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
                Greenfoot.stop();
            }   
            else {
            }
        }
        // If Bullet touches alien - Game Over
        if (Bullet !=null) {
            if (tempType==1){
                Greenfoot.playSound("explosion.wav");
                getWorld(). removeObject(Bullet);

                ((SpaceLand)(getWorld())).score.add(50);

                getWorld(). removeObject(this); //remove alien from screen 
        
            }
        
            else if (tempType == 2){
            
            }
            else if (tempType == 3){
            
            }
            else {
                Greenfoot.playSound("game_over.mp3");
                GameOver gameover = new GameOver();
                getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
                Greenfoot.stop();
            }
        }
}
}
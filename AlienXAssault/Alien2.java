import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Alien2 extends Actor
{
    int SPEED = -2; // Speed of 10 in left direction "-"
    public Alien2() {
        
    }

    public void act() 
    {
        move (SPEED); //calls SPEED function
        String[] nouns = {"fortnite", "shield", "school", "tree", "mouse"};
        Actor Bullet = getOneIntersectingObject(Bullet.class); 
        GreenfootImage image = new GreenfootImage(nouns[(int)(Math.random() * 4)], 5, Color.BLACK, Color.WHITE);
        int tempType = (int)((Math.random() * 3) + 1);
        if (tempType == 2) {
           setImage(image);
        }
        else {
           setImage("Alien.png");
        }

        // If alien touches left side of screen - Game Over
         if (getX()<0) {
            if (tempType == 2){
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
            if (tempType==2){
                Greenfoot.playSound("explosion.wav");
                getWorld(). removeObject(Bullet);

                ((SpaceLand)(getWorld())).score.add(50);

                getWorld(). removeObject(this); //remove alien from screen 
        
            }
        
            else if (tempType == 1){
            
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
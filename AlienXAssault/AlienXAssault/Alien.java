import greenfoot.*;
  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Alien extends Actor
{
    int SPEED = -7; // Speed of 10 in left direction "-"
    int tempType = (int)((Math.random() * 3) + 1);
    
    public Alien() {
    }
    
    public void act() {
       move (SPEED);
       
       Actor Bullet = getOneIntersectingObject(Bullet.class); 
       
       if (tempType == 2) {
           setImage("Soldier.png");
       }else {
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
          else {}
       }
        // If Bullet touches alien - Game Over
       if (Bullet !=null) {
          if (tempType == 2){
              Greenfoot.playSound("explosion.wav");
              getWorld(). removeObject(Bullet);

              ((SpaceLand)(getWorld())).score.add(50);

              getWorld().removeObject(this); //remove alien from screen
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
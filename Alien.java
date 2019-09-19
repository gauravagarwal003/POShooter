import greenfoot.*;

  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Alien extends Actor
{
    int SPEED = -7; // Speed of 10 in left direction "-"
    int tempType = (int)(Math.random() * ((2-0) + 1));
    int controlType = 0;
    int moduleThree = 0;
    
    public Alien() {
    
    }
    
    public void act() {
       move (SPEED);
       for (int i = 0; i<=10;i = i+1) 
       {
           if(i == 10) {
               controlType++;
               moduleThree = controlType % 3;
               if(moduleThree == 0){
                  ((SpaceLand)(getWorld())).pos.swap("bee");
               }
               else if(moduleThree  == 1){
                  ((SpaceLand)(getWorld())).pos.swap("alien");
               }
               else if(moduleThree  == 2){
                  ((SpaceLand)(getWorld())).pos.swap("soldier");
               }      
               
           }
        
       } 
       Actor Bullet = getOneIntersectingObject(Bullet.class); 

       if (tempType == 2) {
           setImage("Soldier.png");
       }
       else if (tempType == 1){
           setImage("Alien.png");
       }
       else {
           setImage("bee.png");
       }
       


       // If alien touches left side of screen - Game Over
       if (getX()<0) {
          if (tempType == moduleThree){
              /**
           Greenfoot.playSound("game_over.mp3");
           GameOver gameover = new GameOver();
           getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
           Greenfoot.stop();
           **/
          }
          else {}
       }
        // If Bullet touches alien - Game Over
       if (Bullet !=null) {
          if (tempType == moduleThree){
              Greenfoot.playSound("explosion.wav");
              getWorld(). removeObject(Bullet);

              ((SpaceLand)(getWorld())).score.add(50);

              getWorld().removeObject(this); //remove alien from screen
          }
          else {
              /**
              Greenfoot.playSound("game_over.mp3");
              GameOver gameover = new GameOver();
              getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
              Greenfoot.stop();
              **/
          }
       }
    }
}
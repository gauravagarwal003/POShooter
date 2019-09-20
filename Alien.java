import greenfoot.*;

  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Alien extends Actor
{
    int SPEED = -7; // Speed of 10 in left direction "-"
    int tempType = (int)(Math.random() * ((2-0) + 1));
    int controlType = 0;
    long lastAdded = System.currentTimeMillis();
    String[] nouns = {"fortnite", "shield", "school", "tree", "mouse"};
    GreenfootImage noun = new GreenfootImage(nouns[(int)(Math.random() * 4)], 30, Color.BLACK, Color.WHITE);
    String[] verbs = {"run","walk","crawl","suck","build"};
    GreenfootImage verb = new GreenfootImage(verbs[(int)(Math.random() * 4)], 30, Color.BLACK, Color.WHITE);
    String[] adj = {"stupid","small","big","goofy","special"};
    GreenfootImage adject = new GreenfootImage(adj[(int)(Math.random() * 4)], 30, Color.BLACK, Color.WHITE);
    
    public Alien() {
    
    }
    
    public void act() {
       move (SPEED);
       var moduleThree = 0;
       int change = 0;
       long curTime = System.currentTimeMillis();
       if (curTime > lastAdded + 2000)//5000ms = 5s
       {
           controlType = controlType + 1;
           moduleThree = controlType % 3;
           change = moduleThree;
       }

       if(change == 0){
               ((SpaceLand)(getWorld())).pos.swap("noun");
           }
       else if(change  == 1){
               ((SpaceLand)(getWorld())).pos.swap("verb");
           }
       else if(change == 2){
               ((SpaceLand)(getWorld())).pos.swap("adjective");   
       }
       else {
        
       }
       
       /**
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
       **/
       Actor Bullet = getOneIntersectingObject(Bullet.class); 

       if (tempType == 2) {
           setImage(adject);
       }
       else if (tempType == 1){
           setImage(verb);
       }
       else {
           setImage(noun);
       }
       


       // If alien touches left side of screen - Game Over
       if (getX()<0) {
          if (tempType == 0){
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
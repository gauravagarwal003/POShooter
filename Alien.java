import greenfoot.*;

  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Alien extends Actor
{
    int SPEED = -7; // Speed of 10 in left direction "-"
    int tempType = (int)(Math.random() * ((2-0) + 1)); //generates random number to decide on type of alien
    int controlType = 0; //used to use in calculations for moduleThree
    long lastAdded = System.currentTimeMillis(); //gets time of application
    String[] nouns = {"fortnite", "shield", "school", "tree", "mouse"}; //strings used for nouns
    GreenfootImage noun = new GreenfootImage(nouns[(int)(Math.random() * 4)], 30, Color.WHITE, new Color(0,0,0)); //creates string from random element in array
    String[] verbs = {"run","walk","crawl","suck","build"}; //strings used for verbs
    GreenfootImage verb = new GreenfootImage(verbs[(int)(Math.random() * 4)], 30, Color.WHITE, new Color(0,0,0)); //creates string from random element in array
    String[] adj = {"stupid","small","big","goofy","special"}; //strings used for adjectives
    GreenfootImage adject = new GreenfootImage(adj[(int)(Math.random() * 4)], 30, Color.WHITE,new Color(0,0,0)); //creates string from random element in array
    
    public Alien() {
    
    }
    /**
     * Central code that affects everything
     * Moves aliens, sets overall mode of game, sets mode/type of each alien, communicates with POS actor, etc.
     * 
     */
    public void act() {
       move (SPEED);
       int moduleThree = 0; //ineteger used to create three cases for game
       int change = 0; //integer assigned to moduleThree, used in comparisons
       long curTime = System.currentTimeMillis(); //gets current time of application
       
       if (curTime > lastAdded + 2000) //timer used to change modes, is currenttly buggy and inconsistent
       {
           controlType = controlType + 1; //adds 1 to controlType 
           moduleThree = controlType % 3; //sets moduleThree to controlType module 3, meaning it is always either 0, 1, or 2
           change = moduleThree;
       }

       //sets mode based on what the value of change is
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
        * OLD METHOD OF SWITCHING BETWEEN MODES - LAGS GAME
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
       
       //sets mode for each mob
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
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Alien3 extends Actor
{
    int SPEED = -2; // Speed of 10 in left direction "-"
    Soldier sold;
    public Alien3() {
        
    }
/**
 * Intended to be words that fly through the screen and makes the user have to type out key letters to kill them
 * before they reach the death zone. Failed because we weren't able to figure out how to get the class to call other
 * classes. The idea was that once getting the list from the Soldier class, the Alien actor would be able to use the 
 * values from Soldier to change itself depending on the action. This would allow the actor to lose health for a given
 * word.
 */
    public void act() 
    {
        move (SPEED); //calls SPEED function
        SpaceLand spaceWorld = (SpaceLand) getWorld();//Gets objects from world
        String[] words = sold.words;//makes string array words set to Soldier's list
        Actor Bullet = getOneIntersectingObject(Bullet.class); //intersecting object is Bullet
        GreenfootImage image = new GreenfootImage(words[(int)(Math.random() * 4)], 5, Color.BLACK, Color.WHITE);//makes aliens image as words
        setImage(image);//sets alien as word
        int index = sold.r;//gets index of list from Soldier
        int health = words[index].length() - 1;//gets length of word and sets the health as number of letters
        // If alien touches left side of screen - Game Over
         if (getX()<0) {//if alien reaches x-value 0 display game over screen
                Greenfoot.playSound("game_over.mp3");
                GameOver gameover = new GameOver();
                getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
                Greenfoot.stop();
        }
        // If Bullet touches alien - Game Over
        
        if (Bullet !=null) {//if bullet hits subtract health
            health--;
            if (health==0){//if health is 0 alien explodes and dies and it adds to score
                Greenfoot.playSound("explosion.wav");
                getWorld(). removeObject(Bullet);

                ((SpaceLand)(getWorld())).score.add(50);

                getWorld(). removeObject(this); //remove alien from screen 
                Greenfoot.playSound("game_over.mp3");
                GameOver gameover = new GameOver();
                getWorld().addObject(gameover, getWorld().getWidth()/2, getWorld().getHeight()/2);
                Greenfoot.stop();
            }
        }
}
/*public void addedToWorld(World world){
     sold = getWorld().getObjects(Soldier.class);
}*/
}
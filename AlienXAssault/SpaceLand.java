import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SpaceLand extends World
{
    Score score;
    private Soldier sold;
    /**
     * Creates the space world which is made along with the Soldier and score
     */
    public SpaceLand()
    {    
        super(900, 600, 1, false); //creates world with dimensions of 900x600 pixels

        addObject (new Soldier(), 50, 300);//creates Soldier object
        sold = new Soldier();//makes sold as objects of Soldier
        score = new Score();//creates new Score object
        addObject(score, 500, 25);//adds score object to world
    }
    /**
     * Supposed to get the objects of Soldier but we weren't able to get it to work.
     */
    public Soldier getsold(){
        return sold;//returns objects of Soldier
    }
    /**
     * Creates the "aliens"(words) to spawn from the right side of the world.
     */
    public void act ()
    {
        int Alien = Greenfoot.getRandomNumber(101);//gets random number from 0-101
        if (Alien >99) {//if it is greater than 99 then it spawns a alien(word)
            addObject(new Alien(), 1000, 300);
            
        }
        int Alien2 = Greenfoot.getRandomNumber(101);
        if (Alien2 >99) {//if it is greater than 99 then it spawns a alien(word)
            addObject(new Alien2(), 1000, 100);
        }
        int Alien3 = Greenfoot.getRandomNumber(101);
        if (Alien3 >99) {//if it is greater than 99 then it spawns a alien(word)
            addObject(new Alien3(), 1000, 500);
        }
    }
}


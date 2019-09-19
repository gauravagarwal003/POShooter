import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SpaceLand extends World
{
    Score score;
    POS pos;
    public SpaceLand()
    {    
        super(900, 600, 1, false); 

        addObject (new Soldier(), 50, 300);
        
        score = new Score();
        pos = new POS();
        addObject(score, 500, 25);
        addObject(pos,150,25);
    }
    public void act ()
    {
        int Alien = Greenfoot.getRandomNumber(101);
        if (Alien >99) {
            addObject(new Alien(), 1000, 300);
        }
        int Alien2 = Greenfoot.getRandomNumber(101);
        if (Alien2 >99) {
            addObject(new Alien(), 1000, 100);
        }
        int Alien3 = Greenfoot.getRandomNumber(101);
        if (Alien3 >99) {
            addObject(new Alien(), 1000, 500);
        }
    }
}


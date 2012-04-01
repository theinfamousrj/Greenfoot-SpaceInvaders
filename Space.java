import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;



public class Space  extends World
{

    private Score theScore;
    private Rocket theRocket;
    private Invader theInvader;
    private int invaderCount;

    public Space()
    {    
        super(600, 400, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        theScore = new Score("Score: ");
        addObject(theScore, 45, 10);
        
        theRocket = new Rocket();
        addObject(theRocket, 300, 385);
        
        int n = 30;
        
        while(n <= 480)
        {
            invaderCount++;
            theInvader = new Invader();
            addObject(theInvader, n, 35);
            n = n + 90;
        }
    }
    
    public void increaseScore()
    {
        theScore.add(100);
    }
    
    public void decreaseInvaderCount()
    {
        invaderCount--;
        if(invaderCount == 0)
        {
            Greenfoot.playSound("youWin.wav");
            Greenfoot.stop();
        }
    }

}

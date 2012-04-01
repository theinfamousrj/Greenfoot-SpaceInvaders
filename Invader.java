import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Invader  extends Actor
{  
    int count;
    int xIncrement = 20;
    int yIncrement = 40;
    boolean movingRight;

    public Invader()
    {
        movingRight = true;
    }

    public void act() 
    {
        move();
    }
    
    public void move()
    {
        Space spaceWorld = (Space) getWorld();
        count++;
        
        if(count == 30)
        {
            if(getY() < 370)
            {
                if(atWorldEdge() && movingRight)
                {
                    moveDown();
                    movingRight = false;
                    moveLeftOrRight(movingRight);
                }
                else if(atWorldEdge() && !movingRight)
                {
                    moveDown();
                    movingRight = true;
                    moveLeftOrRight(movingRight);
                }
                else
                {
                    moveLeftOrRight(movingRight);
                }
            }
            else
            {
                Greenfoot.stop();
            }
            
            count = 0;
        }
    }
    
    public void hit()
    {
        Greenfoot.playSound("killSound.wav");
        
        Space theSpaceWorld = (Space) getWorld();
        
        theSpaceWorld.increaseScore();
        theSpaceWorld.decreaseInvaderCount();
        
        getWorld().removeObject(this);
    }
    
    public void moveLeftOrRight(boolean movingRight)
    {
        if(movingRight == true)
        {
            setLocation(getX() + xIncrement, getY());
        }
        else
        {
            setLocation(getX() - xIncrement, getY());
        }
    }
    
    public void moveDown()
    {
        setLocation(getX(), getY() + yIncrement);
    }
    
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
}

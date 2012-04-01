import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Bullet  extends Actor
{

    int speed; //the speed of the bullet

    public Bullet()
    {
        speed = 10;
    }

    public void act() 
    {
        moveBullet();
        if(checkHit() == false)
        {
            checkEdge();   
        }
    }    

    public void checkEdge()
    {
        if(getY() < 10)
        {
            getWorld().removeObject(this);
        }
    }
    
    public boolean checkHit()
    {
        Invader possibleInvader = (Invader) getOneIntersectingObject(Invader.class);
        
        if(possibleInvader != null)
        {
            getWorld().removeObject(this);
            possibleInvader.hit();
            return true;
        }
        else 
        {
            return false;
        }

    }
    
    public void moveBullet()
    {
        setLocation (getX(), getY() - speed);
    }
    
}

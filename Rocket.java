import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Rocket  extends Actor
{
    int gunReloadTime; //the number of steps before the ship can fire again
    int reloadDelayCount; //a counter to determine how many steps have passed since the counter was reset
    int speed = 5; //speed of the rocket

    public Rocket()
    {
        gunReloadTime = 40;
        reloadDelayCount = 20;
    }
    
    public void act() 
    {
        checkKeys();
        reloadDelayCount++;
    }  
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        if(Greenfoot.isKeyDown("left"))
        {
            moveLeft();
        }        
        if(Greenfoot.isKeyDown("right")) 
        {
            moveRight();
        }
        if(Greenfoot.isKeyDown("space")) 
        {
            fireBullet();
        }        
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fireBullet() 
    {
        if(reloadDelayCount >= gunReloadTime)
        {
            Bullet theBullet = new Bullet();
            getWorld().addObject(theBullet, getX(), getY());
            reloadDelayCount = 0;
        }
    }
    
    public void moveRight()
    {
        if(getX() < 570)
        {
            setLocation (getX() + speed, getY());
        }
    }
    
    public void moveLeft()
    {
        if(getX() > 30)
        {
            setLocation (getX() - speed, getY());
        }
    }
}

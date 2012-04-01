import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;


public class Score  extends Actor
{
    private static final Color textColor = new Color(255, 180, 150);
    private int value = 0;
    private String text;
    private int stringLength;

    public Score(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 10;

        setImage(new GreenfootImage(stringLength, 16));
        GreenfootImage image = getImage();
        image.setColor(textColor);

        updateImage();
    }
    
    public void add(int valueToAdd)
    {
        value = value + valueToAdd;
        
        updateImage();
    }

    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 12);
    }
}

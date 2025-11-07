import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  The upgraded version of red balloon
 * 
 * @author Robin Liu
 * @version 1.0
 */
public class BlueBalloon extends Balloon
{
    
    public BlueBalloon(){
        HP = 2;
        speed = 5;
        weightValue = 2;
        drawImage();
    }
    
    public void act()
    {
        super.act();
    }
    
    public void drawImage(){
        image = new GreenfootImage("BlueBalloon.png");
        image.scale(IMAGE_WIDTH, IMAGE_HEIGHT);
        setImage(image);
    }
}

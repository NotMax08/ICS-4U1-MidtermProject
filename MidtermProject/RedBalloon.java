import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  The most basic balloon type
 * 
 * @author Robin Liu
 * @version Nov 3
 */
public class RedBalloon extends Balloon
{
    
    public RedBalloon(){
        HP = 1;
        speed = 4;
        weightValue = 1;
        drawImage();
    }
    
    public void drawImage(){
        image = new GreenfootImage("RedBalloon.png");
        image.scale(IMAGE_WIDTH, IMAGE_HEIGHT);
        setImage(image);
    }
    
    public void act()
    {
        super.act();
        
    }
    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dart extends Projectiles
{
    public Dart()
    {
        super();
        speed = 50;
        damage = 1;
        range = 50000;
        
        // Create a small circular image
        GreenfootImage image = new GreenfootImage(10, 10); // width, height in pixels
        image.setColor(Color.RED); // choose your color
        image.fillOval(0, 0, 10, 10); // draw the circle
        setImage(image);
    }
    
    public void act()
    {
        super.act();
    }
    
    public void effect()
    {
        
    }
    
    
}




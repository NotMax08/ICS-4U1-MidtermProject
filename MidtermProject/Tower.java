import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Tower extends SuperSmoothMover
{
    protected int damage; //Damage of tower
    protected ArrayList<Balloon> targets; //List of all targets within Tower's range
    protected Balloon closestTarget; //Stores the closest target
    protected int greatestBalloonAge;
    protected int range; //Tower range
    protected GreenfootImage image;
    
    
    public Tower()
    {
        
    }
    
    public void act()
    {
        
    }
    
    public void getClosestTarget()
    {
        greatestBalloonAge = 0;
        targets = (ArrayList<Balloon>)getObjectsInRange(range, Balloon.class);
        
        if(targets != null)
        {
            for (Balloon b: targets)
            {
                if(b.getActCount() > greatestBalloonAge)
                {
                    greatestBalloonAge = b.getActCount();
                    closestTarget = b;
                }
            }
        }
    }
    
    public abstract void shoot();
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Projectiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Projectiles extends SuperSmoothMover
{
    protected int speed; //Projectile speed
    protected int damage; //Damage of the Projectile
    protected boolean damaged; //Checks true if projectile has damaged a balloon
    protected ArrayList<Balloon> targets; //List of all targets within Tower's range
    protected Balloon closestTarget; //Stores the closest target
    protected int greatestBalloonAge; //Stores Balloon with greatest act count
    protected int range; //range
    protected int startX; //Starting X coordinate
    protected int startY; //Starting Y coordinate
    protected GreenfootImage image;
    
    public Projectiles()
    {
        //startX = this.getX();
        //startY = this.getY();
    }
    
    public void act()
    {
        if (this != null)
        {
            getClosestTarget();
            if(closestTarget != null && closestTarget.getWorld() != null && !damaged)
            {
                turnTowards(closestTarget.getX(), closestTarget.getY());
                move(speed);
            }
            else if (closestTarget != null && closestTarget.getWorld() != null)
            {
                
            }
            
            Balloon b = (Balloon)getOneIntersectingObject(Balloon.class);
            if (b != null && !damaged)
            {
                effect();
                b.damageMe(damage);
                damaged = true;
            }
        }
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
    
    public abstract void effect();
    
    public double getDistance ()
    {
        return Math.hypot (startX - this.getX(), startY - this.getY());
    }
}




import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 *  This is a superclass for the enemy which are balloons
 *  Balloons float across the path and try to reach the end of the path
 *  Balloons vary by colour, health, speed, states
 * 
 *  Art Credits:
 *  Red Balloon - PNG Tree
 *  Pop Image - @Color Optimist on OpenGameArt.org
 *  
 * @author Robin Liu 
 * @version Nov 3
 */
public abstract class Balloon extends SuperSmoothMover
{
    protected int HP; 
    protected double speed; 
    protected int weightValue; //how heavy the balloon is ?
    protected GreenfootImage image;
    protected static GreenfootImage popImage = new GreenfootImage("popImage.png");
    protected boolean popped;
    protected int actCount; //counts how long the balloon has lived
    protected final int IMAGE_WIDTH = 40;
    protected final int IMAGE_HEIGHT = 60;

    // special balloon states 
    protected boolean camo; 
    protected boolean lead;
    
    //path following algorithms
    protected ArrayList <Coordinate> pathPoints;
    protected Coordinate currentPathPoint;
    protected Coordinate nextPathPoint;
    protected int currentPathPointNum;
    
    
    

    public Balloon(){
        enableStaticRotation();
        popImage.scale(50,50);
        popped = false;
        
        pathPoints = PathGenerator.getPathPoints();
        currentPathPointNum = 0;
        
    }

    public void act(){
        actCount++;
        if(popped){
            if(actCount == actCount + 20){
                removeMe();
            }else{
                popMe();
            }
        }else{
            move();
        }
    }

    public void move(){
        move(speed);
        followPath();
    }
    
    
    @Override
    protected void addedToWorld(World w){
        //sets the position of the balloon to the starting point of the path
        setLocation(pathPoints.get(0).getX(), pathPoints.get(0).getY());
        
    }
    
    protected void followPath(){
        //determine current waypoint
        //  - this determines which direction to go and where to move
        // determine if position reached
        //  - if position reached, then set current way point to waypoint that is reached
        
        //turning
        currentPathPoint = PathGenerator.getPathPoint(currentPathPointNum);
        nextPathPoint = PathGenerator.getPathPoint(currentPathPointNum + 1);
        double angle = determineAngle(currentPathPoint.getX(), currentPathPoint.getY(), nextPathPoint.getX(), nextPathPoint.getY());
        turn(angle);
        System.out.println("[" + currentPathPoint.getX() + ", " + currentPathPoint.getY() + "], [" + nextPathPoint.getX() + ", " + nextPathPoint.getY() + "]");
        System.out.println(isXReached());
        System.out.println(isYReached());
        //yPositino is not reached probably becasue of centering
        if (isPositionReached()){
            //checks to remove
            if (currentPathPointNum == PathGenerator.getPathPointSize()){
                getWorld().removeObject(this);
            }
            currentPathPointNum += 1;
        }
        
    }
    
    
    protected boolean isPositionReached(){
        return isXReached() && isYReached();
    }
    
    
    protected boolean isXReached(){
        return getXDifference() == 0;
    }
    protected boolean isYReached(){
        return getYDifference() == 0;
    }
    
    protected int getXDifference(){
        return Math.abs(nextPathPoint.getX() - getX());
    }
    
    protected int getYDifference(){
        return Math.abs(nextPathPoint.getY() - getY());
    }
    
    protected double determineAngle(int xi, int yi, int xf, int yf){
        return Math.toDegrees(Math.atan2((yf - yi), (xf - xi)));
    }
    
    
    public int getActCount(){
        return actCount;
    }

    /**
     *  Method to damage the balloon
     *  @param damage   removes health from balloon
     */
    public void damageMe(int damage){
        if(HP - damage <= 0){
            popped = true;
            //pop sound;
        }else{
            this.HP = HP - damage;
        }
    }

    /**
     *  Methods to get the state of the ballooon
     */
    public boolean isCamo(){
        return camo;
    }

    public boolean isLead(){
        return lead;
    }

    public void removeMe(){
        getWorld().removeObject(this);
    }

    public void popMe(){
        setImage(popImage);
    }
    
    public boolean isPopped(){
        return popped;
    }

}






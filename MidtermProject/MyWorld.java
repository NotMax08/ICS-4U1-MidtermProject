import greenfoot.*;  
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private ArrayList<Coordinate> pathPoints = new ArrayList<>();
    private PathGenerator pathGenerator;
    private GreenfootImage background; 

    // settings screen changes values below
    protected static int maxHealth = 100;
    protected static int currentHealth = 100;

    protected final greenfoot.Font FONT = new greenfoot.Font("Monospaced", false, false, 20);
    protected final Color TRANSPARENT = new Color(0, 0, 0, 0);
    protected final int STAT_WIDTH = 425;
    protected final int STAT_HEIGHT = 50;
    protected final Color HEALTH_COLOR = new Color(0, 128, 0);
    protected final Color MISSING_COLOR = new Color(210, 100, 102);
    protected final Color BORDER_COLOR = new Color(101, 67, 33);

    public MyWorld()
    {   
        super(1200, 800, 1); 

        addPathPoints();
        addObject(new PathGenerator(pathPoints, this.getWidth(), this.getHeight()), getWidth() / 2, getHeight() / 2);
        addObject(new SuperStatBar(maxHealth, currentHealth, null, STAT_WIDTH, STAT_HEIGHT, 0, HEALTH_COLOR, MISSING_COLOR, false, BORDER_COLOR, 3), 950, 50);
        String healthString = String.valueOf(currentHealth + "/" + maxHealth);

        addObject(new SuperTextBox(healthString, TRANSPARENT, Color.BLACK, FONT, false, 115, 0, TRANSPARENT), 965, 50);
    }

    public void act(){
        healthCheck();
        
        
    }
    
    public void healthCheck(){
        updateHealth();
        getHP();
    }
    
    public void updateHealth(){
        String healthString = String.valueOf(currentHealth + "/" + maxHealth);
        //SuperTextBox.update(healthString); not working currently idk why
    }

    public int getHP(){
        return currentHealth;
    }

    public void takeDamage(int damage){
        if(currentHealth - damage <= 0){
            // simulation over screen
        }else{
            currentHealth -= damage;
            // damage sfx
            // damage vfx? health bar flashes red
        }
    }

    private void addPathPoints(){
        pathPoints.add(new Coordinate(100, 100));
        pathPoints.add(new Coordinate(200, 100));
        pathPoints.add(new Coordinate(200, 200));
        pathPoints.add(new Coordinate(400, 200));
        pathPoints.add(new Coordinate(500, 200));
        pathPoints.add(new Coordinate(500, 400));
        pathPoints.add(new Coordinate(700, 400));
        pathPoints.add(new Coordinate(700, 500));
        pathPoints.add(new Coordinate(700, 600));
        pathPoints.add(new Coordinate(600, 600));
        pathPoints.add(new Coordinate(500, 600));
        pathPoints.add(new Coordinate(500, 700));
        //pathPoints.add(new Coordinate(500, 700));
    }
}


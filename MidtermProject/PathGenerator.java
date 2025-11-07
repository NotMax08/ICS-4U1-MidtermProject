import java.util.*;
import greenfoot.*;


/**
 * Path Generator Helper Class that helps generate the path with UI and points
 * 
 * @author Max 
 * @version 1.0
 */
public class PathGenerator extends Actor
{
    
    private static ArrayList<Coordinate> pathPoints = new ArrayList<>();
    
    private GreenfootImage pathImage;
    
    private Color MAIN_PATH_COLOR = new Color(194, 178, 128);
    
    private Color BORDER_PATH_COLOR = new Color(125, 113, 79);
    
    private final int P_WIDTH = 70;
    
    private final int P_OUTLINE = 30;
    
    private final int BORDER_THICKNESS = 1;
    
    public PathGenerator(ArrayList<Coordinate> pathPoints, int worldWidth, int worldHeight){
        this.pathPoints = pathPoints;
        pathImage = new GreenfootImage(worldWidth, worldHeight);
        /*
         * since greenfoot adds images based on order, we need to first add the border (which is a bigger and darker version) 
         * then add the main path
         */
        drawBorderPath();
        drawMainPath();
        setImage(pathImage);
    }
    
    public void drawMainPath(){
        //draw big, rectangles
        for (int i = 0; i < pathPoints.size() - 1; i++){
            Coordinate currentPathCoordinate = pathPoints.get(i);
            Coordinate nextPathCoordinate = pathPoints.get(i + 1);
            int currentX = currentPathCoordinate.getX();
            int currentY = currentPathCoordinate.getY();
            int nextX = nextPathCoordinate.getX();
            int nextY = nextPathCoordinate.getY();
            drawRectangleCentered(currentX, currentY, nextX, nextY, P_WIDTH / 2, pathImage, MAIN_PATH_COLOR);
        }
        
        for (int i = 0; i < pathPoints.size(); i++){
            Coordinate currentPathCoordinate = pathPoints.get(i);
            int currentX = currentPathCoordinate.getX();
            int currentY = currentPathCoordinate.getY();
            drawCircleCentered(currentX, currentY, P_WIDTH, pathImage, MAIN_PATH_COLOR);
        }
    
    }
    
    public void drawBorderPath(){
        for (int i = 0; i < pathPoints.size() - 1; i++){
            Coordinate currentPathCoordinate = pathPoints.get(i);
            Coordinate nextPathCoordinate = pathPoints.get(i + 1);
            int currentX = currentPathCoordinate.getX();
            int currentY = currentPathCoordinate.getY();
            int nextX = nextPathCoordinate.getX();
            int nextY = nextPathCoordinate.getY();
            drawRectangleOutline(currentX, currentY, nextX, nextY, P_WIDTH / 2, pathImage, BORDER_PATH_COLOR);
        }
        
        for (int i = 0; i < pathPoints.size(); i++){
            Coordinate currentPathCoordinate = pathPoints.get(i);
            int currentX = currentPathCoordinate.getX();
            int currentY = currentPathCoordinate.getY();
            drawCircleOutline(currentX, currentY, P_WIDTH, pathImage, BORDER_PATH_COLOR);
        }
    }
    
    public GreenfootImage getImage(){
        return pathImage;
    }
    
    /**
     * Draws a circle, centered for the parameter inputs, (x,y)
     * created bc greenfoot draws it in upper left coordinate which is not good
     */
    private void drawCircleCentered(int x, int y, int diameter, GreenfootImage image, Color color){
        image.setColor(color);
        image.fillOval(x - (diameter /2), y - (diameter / 2), diameter, diameter);
    }
    
    private void drawRectangleCentered(int x1, int y1, int x2, int y2, int halfWidth, GreenfootImage image, Color color){
        image.setColor(color);
        
        // determines top left corner ad top right corner
        int x_min = Math.min(x1, x2) - halfWidth / 2;
        int y_min = Math.min(y1, y2) + halfWidth / 2;
        int x_max = Math.max(x1, x2) - halfWidth / 2;
        int y_max = Math.max(y1, y2) + halfWidth / 2;
        
        int width = x_max - x_min;
        int height = y_max - y_min;
        
        //draws rectangle for horizontal and vertical cases, checks if x levels are the same (vertical), y levels are the same (horizontal)
        if (x1 == x2) {
            image.fillRect(x1 - halfWidth, y_min - halfWidth / 2, 2 * halfWidth, height);
        } else if (y1 == y2) {
            image.fillRect(x_min + halfWidth / 2, y1 - halfWidth, width, 2 * halfWidth);
        }
    }
    private void drawCircleOutline(int x, int y, int diameter, GreenfootImage image, Color color){
        image.setColor(color);
        image.fillOval(x - (diameter /2) - P_OUTLINE / 2, y - (diameter / 2) - P_OUTLINE / 2, diameter + P_OUTLINE, diameter + P_OUTLINE);
    }
    
    private void drawRectangleOutline(int x1, int y1, int x2, int y2, int halfWidth, GreenfootImage image, Color color){
        image.setColor(color);
        
        // determines top left corner ad top right corner
        int x_min = Math.min(x1, x2) - halfWidth / 2 - P_OUTLINE / 2;
        int y_min = Math.min(y1, y2) + halfWidth / 2 + P_OUTLINE / 2;
        int x_max = Math.max(x1, x2) - halfWidth / 2 - P_OUTLINE / 2;
        int y_max = Math.max(y1, y2) + halfWidth / 2 + P_OUTLINE / 2;
        
        int width = x_max - x_min;
        int height = y_max - y_min;
        
        //draws rectangle for horizontal and vertical cases, checks if x levels are the same (vertical), y levels are the same (horizontal)
        if (x1 == x2) {
            image.fillRect(x1 - halfWidth - P_OUTLINE / 2, y_min - halfWidth / 2 - P_OUTLINE / 2, 2 * halfWidth + P_OUTLINE, height + P_OUTLINE / 2);
        } else if (y1 == y2) {
            image.fillRect(x_min + halfWidth / 2 + P_OUTLINE / 2, y1 - halfWidth - P_OUTLINE / 2, width + P_OUTLINE / 2, 2 * halfWidth + P_OUTLINE);
        }
    }
    
    public static Coordinate getPathPoint(int index){
        return pathPoints.get(index);
    }
    
    public static ArrayList<Coordinate> getPathPoints(){
        return pathPoints;
    }
    
    public static int getPathPointSize(){
        return pathPoints.size() - 1;
    }
}



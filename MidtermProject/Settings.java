import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Write a description of class Settings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Settings extends World
{
    private TextBox input;
    private int typedValue = 0;
    
    public Settings()
    {    
        super(1200, 800, 1); 
        
        input = new TextBox();
        addObject (input, 350, 200);
    }
    
    public void act(){
        if(input != null && input.isDone()){
            typedValue = input.getValue();
        }
        
        showText("Current HP: " + typedValue, 350, 160);
    }
}



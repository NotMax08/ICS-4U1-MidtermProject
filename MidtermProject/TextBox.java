import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import java.lang.System;
import javax.swing.JOptionPane;
/**
 * Write a description of class TextBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    private String currentInput = "";
    private boolean inputActive = false;
    private boolean finished = false;
    public TextBox(){
        setImage(new GreenfootImage("Change HP", 24, Color.BLACK, null));
    }
    public void act()
    {
        if(!inputActive && Greenfoot.mouseClicked(this)){
            inputActive = true;
            finished = false;
            currentInput = "";
            updateImage();
        }
        if(inputActive){
            String kc = Greenfoot.getKey();// checks key
            if(kc != null){
                if(kc.equals("enter")){
                    inputActive = false;
                    finished = true;
                    updateImage();
                }else if(kc.equals("backspace") && currentInput.length() > 0){
                    currentInput = currentInput.substring(0, currentInput.length() - 1);
                    updateImage();
                }else if(kc.matches("[0-9]")){
                    currentInput += kc;
                    updateImage();
                }
            }
        }
        
    }
    
    private void updateImage(){
        GreenfootImage img = new GreenfootImage(300, 40);
        img.setColor(new Color(255, 255, 255, 100));
        img.fillRect(0, 0, 300, 40);
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, 299, 39);
        
        Font myFont = new Font("Times New Roman", true, false, 15);
        img.setFont(myFont);
        
        if(inputActive){
            img.drawString("Etner value: " + currentInput, 10, 25);
        }else if(finished){
            img.drawString("New Hp: " + currentInput + " (click to edit)", 10, 25);
        }else{
            img.drawString("Current HP: " + currentInput, 10, 25);
        }
        
        setImage(img);
    }
    
    public boolean isDone(){
        return finished;
    }
    
    public int getValue(){
        if(currentInput.isEmpty()){
            return 0;
        }
        return Integer.parseInt(currentInput);//this would conver string into a int
    }

}



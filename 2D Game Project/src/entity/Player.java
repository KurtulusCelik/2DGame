/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import main.GamePanel;
import main.KeyHandler;

/**
 *
 * @author kurtuluscelik
 */
public class Player extends Entity{
    
    //Attributes
    GamePanel gp;
    KeyHandler keyH;
    
    // Constructors
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        
        setDefaultValues();
    }
    
    // Methods
    public void setDefaultValues() {
        
        x = 100;
        y = 100;
        speed = 4;
    }
    public void update(){ // Player movements keyboard handlers
        
        if(keyH.upPressed == true){
            y -= speed;
        }
        else if(keyH.downPressed == true){
            y += speed;
        }
        else if(keyH.leftPressed == true){
            x -= speed;
        }
        else if(keyH.rightPressed == true){
            x += speed;
        }
        
    }
    public void draw(Graphics2D g2){
        
        g2.setColor(Color.white);
        
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        
    }
    
}

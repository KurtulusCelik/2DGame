/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author kurtuluscelik
 */
public class GamePanel extends JPanel implements Runnable{
    
    // Screen Settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    
    Thread gameThread;
    
    public GamePanel(){
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Size of the screen (Width & Height)
        this.setBackground(Color.black); // Background colour of the screen
        this.setDoubleBuffered(true);
        
        
    }
    
    public void startGameThread(){
        
        gameThread = new Thread(this);
        gameThread.start(); 
    }

    @Override
    public void run() {
        
        while(gameThread != null){
            
//          System.out.println("The game loop is running!");

            // 1 UPDATE: update information such as character positions
            update();
            // 2 DRAW: draw the screen with the updated information
            repaint(); // not paintComponent but repaint // this is how you call paintComponent method in Java
            
            // As the loops continues it keeps calling this update() and repaint() methods
        }
        
    }
    
    public void update(){
        
    }
    public void paintComponent(Graphics g){ // Standart method to draw things into the JPanel
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        
        g2.fillRect(100, 100, tileSize, tileSize);
        
        g2.dispose();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;

/**
 *
 * @author kurtuluscelik
 */
public class GamePanel extends JPanel implements Runnable{
    
    // Screen Settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    
    final int FPS = 60;
    
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);
    TileManager tileM = new TileManager(this);
       
    
    public GamePanel(){
        
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // Size of the screen (Width & Height)
        this.setBackground(Color.black); // Background colour of the screen
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); // Gamepanel can recognize key inputs now
        this.setFocusable(true);
        
        
    }
    
    public void startGameThread(){
        
        gameThread = new Thread(this);
        gameThread.start(); 
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS; // 0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while(gameThread != null){
            
//          System.out.println("The game loop is running!");
            
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            
            lastTime = currentTime;
            
            if(delta >= 1){
                
            // 1 UPDATE: update information such as character positions
            update();
            // 2 DRAW: draw the screen with the updated information
            repaint(); // not paintComponent but repaint // this is how you call paintComponent method in Java
            // As the loops continues it keeps calling this update() and repaint() methods  
            
            delta--;
            }   
            
        }
        
    }
    
    public void update(){
        
        player.update();
        
    }
    public void paintComponent(Graphics g){ // Standart method to draw things into the JPanel
        
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        
        tileM.draw(g2);
        
        player.draw(g2);
        
        g2.dispose();
    }
    
}

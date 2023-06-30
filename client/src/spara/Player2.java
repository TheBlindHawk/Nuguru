/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spara;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Player2 extends Thread implements KeyListener{
    private Rectangle2D player;
    private int x=700,y=400;
    private int d=70;
    private String direzione="";
    private Thread animation;
    private int delay=3;
    private String blockMove;
    Player2(JPanel panel){
        panel.setFocusable(true);
        panel.addKeyListener(this);
        panel.requestFocusInWindow();
        animation = new Thread(this);
        animation.start();
    }
    public Rectangle2D player2(){
        return player;
    }
    public String getDirezione(){
        return direzione;
    }
    public void setBlockMovement(String move){
        blockMove=move;
    }
    public void setDelay(int millisec){
        delay=millisec;
    }
    public void W(){
        direzione="su";
    }
    public void D(){
        direzione="destra";
    }
    public void A(){
        direzione="sinistra";
    }
    public void S(){
        direzione="giu";
    }
    public void paint(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.blue);
        player=new Rectangle2D.Double(x, y, d, d);
        g2.fill(player);  
    }
    public void disegna(){
        if(direzione.equals("su") && !(blockMove.equals("su"))){
            y--;
        }
        if(direzione.equals("giu") && !(blockMove.equals("giu"))){
            y++;
        }
        if(direzione.equals("destra") && !(blockMove.equals("destra"))){
            x++;
        }
        if(direzione.equals("sinistra") && !(blockMove.equals("sinistra"))){
            x--;
        }   
    }
    @Override
    public void run() {
        while(Thread.currentThread() == animation){
            aspetta(delay);
            disegna();
        }
    }
    public void aspetta(int millisec){
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException ex) {
            Logger.getLogger(Player2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        switch(key){
            case KeyEvent.VK_UP:{
                W();
            }
            break;
            case KeyEvent.VK_RIGHT:{
                D();
            }
            break;
            case KeyEvent.VK_LEFT:{
                A();
            }
            break;
            case KeyEvent.VK_DOWN:{
                S();
            }
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}

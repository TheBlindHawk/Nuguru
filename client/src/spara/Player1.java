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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Player1 extends Thread implements KeyListener,MouseListener{
    private Rectangle2D player;
    private int x=100,y=400;
    private int d=70;
    private String direzione="";
    private Thread animation;
    private int delay=3;
    private ArrayList <Proiettile>pr=new ArrayList<Proiettile>();
    private int index=0;
    private String blockMove;
    Player1(JPanel panel){
        panel.setFocusable(true);
        panel.addKeyListener(this);
        panel.requestFocusInWindow();
        panel.addMouseListener(this);
        animation = new Thread(this);
        animation.start();
    }
    public ArrayList<Proiettile> getArrayList(){
        return pr;
    }
    public Rectangle2D player1(){
        return player;
    }
    public String getDirezione(){
        return direzione;
    }
    public void setBlockMovement(String move){
        blockMove=move;
    }
    public void removeBullet(int i){
        pr.remove(i);
        index-=1;
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
        g2.setColor(Color.red);
        player=new Rectangle2D.Double(x, y, d, d);
        g2.fill(player); 
        int count;
        if(pr.size()!=0){
            count=index-1;
            do{
                if(count>=0){
                    pr.get(count).paint(g);
                    count--;
                }
            }while(count>=0);
        }
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
            Logger.getLogger(Player1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        switch(key){
            case KeyEvent.VK_W:{
                W();
            }
            break;
            case KeyEvent.VK_D:{
                D();
            }
            break;
            case KeyEvent.VK_A:{
                A();
            }
            break;
            case KeyEvent.VK_S:{
                S();
            }
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Proiettile p=new Proiettile(x+d/2,y+d/2,me.getX(), me.getY());
        pr.add(p);
        p.setP();
        index += 1;
    }

    @Override
    public void mousePressed(MouseEvent me) {
   
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spara;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class Proiettile extends Thread{
    private Rectangle2D pallottola;
    private double x,y,dx,dy,mx,my;
    private int d=20;
    private int delay=2;
    private Thread animation;
    Proiettile(int x,int y,int xf,int yf){
        animation = new Thread(this);
        animation.start();  
        this.x=x-d/2;
        this.y=y-d/2;
        dx=xf-x;
        dy=yf-y;
        mx=dx*dx/(dx*dx+dy*dy);
        if(dx<0)
            mx*=-1;
        my=dy*dy/(dy*dy+dx*dx);
        if(dy<0)
            my*=-1;
    }
    public void paint(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        if(pallottola!=null)
        g2.fill(pallottola);
    }
    public Rectangle2D getPallottola(){
        return pallottola;
    }
    public void setP(){
        pallottola=new Rectangle2D.Double(this.x,this.y,d,d);
    }
    public void aspetta(int millisec){
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException ex) {
            Logger.getLogger(Player1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
        while(Thread.currentThread() == animation){
            aspetta(delay);
            disegna();
        }
    }
    public void disegna(){
        x+=mx;
        y+=my;
        setP();
    }
}

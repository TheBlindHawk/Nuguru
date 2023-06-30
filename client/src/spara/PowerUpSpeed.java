/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spara;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author hp
 */
public class PowerUpSpeed {
    private int x=400,y=200;
    private int l=20;
    private boolean visible;

    PowerUpSpeed(){
  
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setvisible(boolean visible){
        this.visible=visible;
    }
    public boolean getvisible(){
        return visible;
    }
    public void paint(Graphics g){
        g.setColor(Color.green);
        if(visible==true)
            g.fillOval(x, y, l, l);
    }
    
}

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

/**
 *
 * @author hp
 */
public class VitaAvv {
    private Rectangle2D vita[];
    private int punti=5;
    private int x,y;
    private int d=20;
    VitaAvv(){
        caricaVettore();
        Caricamento();
    }
    public int getPunti(){
        return punti;
    }
    public void setPunti(int punti){
        this.punti=punti;
    }
    public void caricaVettore(){
        vita=new Rectangle2D[punti];
    }
    public void Caricamento(){
        x=1100;
        y=20;
        for(int i=0;i<punti;i++){
            vita[i]=new Rectangle2D.Double(x,y,d,d);
            x+=30;
        }
    }
    public void paint(Graphics g){
        Graphics2D g2=(Graphics2D)g;
        g2.setColor(Color.blue);
        for(int i=0;i<punti;i++){
            g2.fill(vita[i]);
        }
    }    
}

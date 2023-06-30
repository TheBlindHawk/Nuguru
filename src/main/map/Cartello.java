/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.map;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Cartello {
    private JPanel container=new JPanel();
    public int x=500,y=600;
    static boolean listenerPlayer=true;
    private int l=20;
    static boolean tabellone=false;
    private Tabellone tab;
    Cartello(JPanel panel){
        container=panel;
    }
    public void paint(Graphics g){
        if(tabellone==true)
            tab.paint(g);
        g.setColor(Color.blue);
        g.fillOval(x,y,l,l);
    }
    public void selezioneSfida(){
        tabellone=true;
        this.listenerPlayer=false;
        tab=new Tabellone(container);
        tab.listenerPlayer=true;
    }
    
}

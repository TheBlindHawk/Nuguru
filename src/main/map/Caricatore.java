/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.map;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Caricatore extends JPanel implements Runnable{
    private JPanel container=new JPanel();
    private Player p;
    private int L,H;
    private int delay=100;
    Caricatore(JPanel panel,int L,int H){
        container=panel;
        p=new Player(container,L,H);
        this.L=L;
        this.H=H;
        this.setBackground(Color.gray);
    }
    public void paint(Graphics g){
        super.paint(g);
        p.paint(g);
    }
    public void aspetta(int millisec){
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException ex) {
            Logger.getLogger(Caricatore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() { //Questo thread appena iniziato continua a disegnare il paint e aspetta da i millisecondi di pausa
        while(true)
        {
            repaint();
            aspetta(delay);
        }
    }
    
}

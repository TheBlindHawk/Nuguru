/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngnl;

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
    private int delay=5;
    private Musica music;
    private Player p;
    private Cartello c;
    private Mappa mappa;
    Caricatore(JPanel panel){
        music=new Musica(this);
        mappa=new Mappa();
        c=new Cartello(panel);
        p=new Player(panel,mappa,c);
        this.setBackground(Color.green);
    }
    public void paint(Graphics g){
        super.paint(g);
        mappa.paint(g);
        c.paint(g);
        p.paint(g);
        music.paint(g);
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
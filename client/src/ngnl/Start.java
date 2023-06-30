/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngnl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Start extends JPanel implements KeyListener{
    private JPanel container=new JPanel();
    private String start="PRESS ANY KEY TO CONTINUE";
    private int x=250,y=370;
    Start(JPanel panel){
        container=panel;
        this.setBackground(java.awt.Color.red);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(this);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.setColor(Color.BLACK);
        g.drawString(start, x, y);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        switch(key){
            default:{
                this.removeKeyListener(this);
                Caricatore img=new Caricatore(container);
                container.add(img);
                Thread thread=new Thread(img);
                thread.start();
                container.remove(this);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    
}
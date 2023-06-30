/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Start extends JPanel implements MouseListener{
    private JPanel container=new JPanel();
    private Rectangle2D rectangle;
    private String start="START";
    private int L,H;
    private int x=450,y=370;
    Start(JPanel panel,int L,int H){
        container=panel;
        this.L=L;
        this.H=H;
        this.setBackground(java.awt.Color.red);
        this.addMouseListener(this);
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2=(Graphics2D)g;
        g.setFont(new Font("Arial", Font.BOLD, 100));
        rectangle= g.getFontMetrics().getStringBounds(start, g);
        rectangle.setRect(x,y - g.getFontMetrics().getAscent(),rectangle.getWidth(),rectangle.getHeight());
        g2.setColor(Color.WHITE);
        g2.fill(rectangle);
        g.setColor(Color.BLACK);
        g.drawString(start, x, y);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if((e.getButton()==1) && (rectangle.contains(e.getX(),e.getY()))){
            Caricatore img=new Caricatore(container,L,H);
            Thread thread=new Thread(img);
            container.add(img);
            thread.start();
            this.removeMouseListener(this);
            container.remove(this);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
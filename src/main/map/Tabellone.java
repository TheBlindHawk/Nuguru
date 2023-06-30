/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import main.cards.briscola.briscola;
import main.supertris.Stris;
import main.tris.tris;

/**
 *
 * @author hp
 */
public class Tabellone implements KeyListener{
    private JPanel container=new JPanel();
    private int x=550,y=100;
    private int l=290,h=500;
    private int xlabel=600,ylabel=150;
    private int xf1=xlabel-30,xf2=xlabel-30,xf3=xlabel-10;
    private int yf1=ylabel-20,yf2=ylabel,yf3=ylabel-10;
    private int gFont=30;
    private String giochi[]={"TRIS","SUPER-TRIS","BRISCOLA"};
    public boolean listenerPlayer;
    Tabellone(JPanel panel){
        container=panel;
        container.setFocusable(true);
        container.requestFocusInWindow();
        container.addKeyListener(this);
    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(x, y, l, h);
        g.setFont(new Font("Arial", Font.BOLD, gFont));
        g.setColor(Color.BLACK);
        for(int i=0;i<giochi.length;i++){
            g.drawString(giochi[i], xlabel, ylabel);
            ylabel+=50;
        }
        ylabel=150;
        g.fillPolygon(new int[]{xf1,xf2,xf3}, new int[]{yf1,yf2,yf3}, 3);
    }
    public void W(){
        if(yf1==130 && yf2==150 && yf3==140){
            yf1=230;
            yf2=250;
            yf3=240;
        }
        else{
            yf1-=50;
            yf2-=50;
            yf3-=50;
        }
    }
    public void S(){
        if(yf1==230 && yf2==250 && yf3==240){
            yf1=130;
            yf2=150;
            yf3=140;
        }
        else{
            yf1+=50;
            yf2+=50;
            yf3+=50;
        }
    }
    public void Space(){
        container.add(new JPanel());
        container.removeAll();
        if(yf1==130 && yf2==150 && yf3==140){
            System.out.println("TRIS");
            tris s=new tris();
            container.add(s);
        }
        else if(yf1==180 && yf2==200 && yf3==190){
            System.out.println("SUPER-TRIS");
            Stris s=new Stris();
            container.add(s);
        }
        else if(yf1==230 && yf2==250 && yf3==240){
            System.out.println("BRISCOLA");
            new briscola().setVisible(true);
        }
    }
    public void Esc(){
        this.listenerPlayer=false;
        Cartello.tabellone=false;
        Cartello.listenerPlayer=true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(listenerPlayer==true){
            int key=e.getKeyCode();
            switch(key){
                case KeyEvent.VK_W:
                    W();
                break;
                case KeyEvent.VK_S:
                    S();
                break;
                case KeyEvent.VK_SPACE:
                    Space();
                break;
                case KeyEvent.VK_UP:
                    W();
                break;
                case KeyEvent.VK_DOWN:
                    S();
                break;
                case KeyEvent.VK_ENTER:
                    Space();
                break;
                case KeyEvent.VK_ESCAPE:
                    Esc();
                break;
                default:
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}

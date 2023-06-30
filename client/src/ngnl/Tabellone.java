/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngnl;

import cards.briscola.brisc;
import dotsandboxes.Pannello;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.Path;
import javax.swing.JPanel;
import supertris.Stris;
import tris.tris;
import scfls.Pannelloscfls;
import spara.Pannellos;

/**
 *
 * @author hp
 */
public class Tabellone implements KeyListener{
    private JPanel container=new JPanel();
    private Path currentPath=NGNL.getPath();
    private String slashPath=NGNL.getSlashPath();
    private int x=550,y=100;
    private int l=350,h=500;
    private int xlabel=600,ylabel=150;
    int start=150,end=400,distanza=50;
    private int xf1=xlabel-30,xf2=xlabel-30,xf3=xlabel-10;
    private int yf1=ylabel-20,yf2=ylabel,yf3=ylabel-10;
    private int gFont=30;
    private String giochi[]={"TRIS","SUPER-TRIS","DOTS AND BOXES","SHOOTER","SCFLS","BRISCOLA"};
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
        if(yf2==start){
            yf1=end-20;
            yf2=end;
            yf3=end-10;
        }
        else{
            yf1-=distanza;
            yf2-=distanza;
            yf3-=distanza;
        }
    }
    public void S(){
        if(yf2==end){
            yf1=start-20;
            yf2=start;
            yf3=start-10;
        }
        else{
            yf1+=distanza;
            yf2+=distanza;
            yf3+=distanza;
        }
    }
    public void Space(){
        switch(yf2)
        {
            case 150:
            container.removeAll();
            tris t=new tris();
            container.add(t);
            container.setVisible(false);
            container.setVisible(true);
            break;
            case 200:
            container.removeAll();
            Stris s=new Stris();
            container.add(s);
            container.setVisible(false);
            container.setVisible(true);
            break;
            case 250:
            container.removeAll();
            Pannello p=new Pannello();
            Thread thread=new Thread(p);
            thread.start();
            container.add(p);
            container.setVisible(false);
            container.setVisible(true);
            break;
            case 300:
            container.removeAll();
            container.setFocusable(false);
            Pannellos ps=new Pannellos(container);
            Thread thread2=new Thread(ps);
            thread2.start();
            container.add(ps);
            container.setVisible(false);
            container.setVisible(true); 
            break;
            case 350:
            container.removeAll();
            Pannelloscfls pscfls=new Pannelloscfls(currentPath,slashPath);
            container.add(pscfls);
            container.setVisible(false);
            container.setVisible(true);   
            break;            
            case 400:
            container.removeAll();
            brisc b=new brisc();
            container.add(b);
            container.setVisible(false);
            container.setVisible(true); 
            System.out.println("uno");
            break;
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

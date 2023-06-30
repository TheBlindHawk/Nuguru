/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spara;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Pannellos extends JPanel implements Runnable{
    private int larghezza=Spara.larghezza-85;
    private int altezza=Spara.altezza-115;
    private Player1 p1;
    private Player2 p2;
    private Vita v;
    private VitaAvv va;
    private CasualPowerUp cPU;
    public Pannellos(JPanel panel){
        this.setBackground(Color.gray);
        p1=new Player1(panel);
        p2=new Player2(panel);
        v=new Vita();
        va=new VitaAvv();
        cPU=new CasualPowerUp(p1,p2,v,va);
    }
    public void paint(Graphics g){
        super.paint(g);
        p1.paint(g);
        p2.paint(g);
        cPU.paint(g);
        v.paint(g);
        va.paint(g);
        collisionPlayer1();
        collisionPlayer2();
        collisionBullet();
    }
    public void collisionPlayer1(){
        if(p1.player1().getX()<=0)
            p1.setBlockMovement("sinistra");
        else if(p1.player1().getY()<=0)
            p1.setBlockMovement("su");
        else if(p1.player1().getX()>=larghezza)
            p1.setBlockMovement("destra");
        else if(p1.player1().getY()>=altezza)
            p1.setBlockMovement("giu");
        else
            p1.setBlockMovement("");        
    }
    public void collisionPlayer2(){
        if(p2.player2().getX()<=0)
            p2.setBlockMovement("sinistra");
        else if(p2.player2().getY()<=0)
            p2.setBlockMovement("su");
        else if(p2.player2().getX()>=larghezza)
            p2.setBlockMovement("destra");
        else if(p2.player2().getY()>=altezza)
            p2.setBlockMovement("giu");
        else
            p2.setBlockMovement("");
    }
    public void collisionBullet(){
        if(p1.getArrayList().size()!=0){
            for(int i=0;i<p1.getArrayList().size();i++){
                //aspetta(3);                
                if(p2.player2().intersects(p1.getArrayList().get(i).getPallottola())){
                    p1.removeBullet(i);
                    if(va.getPunti()!=0){
                        va.setPunti(va.getPunti()-1);
                        va.caricaVettore();
                        va.Caricamento();
                    }
                }
            }
        }
    }
    public void aspetta(int millisec){
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pannellos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
        while(true){
            repaint();
        }
    }
    
}

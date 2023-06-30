/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spara;

import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class CasualPowerUp extends Thread{
    private Thread orologio;
    private Player1 p1;
    private Player2 p2;
    private Vita v;
    private VitaAvv va;
    private int casual;
    private String casualPU[]={"velocità","vita"};
    private String scelta="";
    private int delay=1000;
    private PowerUpSpeed puS=new PowerUpSpeed();
    private LimitPowerUpSpeed lpuS=new LimitPowerUpSpeed();
    private PowerUpLife puL=new PowerUpLife();
    CasualPowerUp(Player1 p1,Player2 p2,Vita v,VitaAvv va){
        orologio=new Thread(this);
        orologio.start();
        this.p1=p1;
        this.p2=p2;
        this.v=v;
        this.va=va;
    }
    public void paint(Graphics g){
        switch(scelta){
            case "velocità":{
                if(puS.getvisible()==true)
                    puS.paint(g);
            }
            case "vita":{
                if(puL.getvisible()==true)
                    puL.paint(g);
            }
            break;
            default:
        }
    }
    public void setCasualTime(){
        casual=(int)(Math.random()*10);       
    }
    public void setCasualPowerUp(){
        int casual=(int)(Math.random()*casualPU.length);
        int casualPositionX=(int)(Math.random()*Spara.larghezza-100);
        int casualPositionY=(int)(Math.random()*Spara.altezza-150);
        scelta=casualPU[casual];
        switch(scelta){
            case "velocità":{
                puS.setX(casualPositionX);
                puS.setY(casualPositionY);
                puS.setvisible(true);
            }
            break;
            case "vita":{
                puL.setX(casualPositionX);
                puL.setY(casualPositionY);
                puL.setvisible(true);
            }
            break;
        }
    }
    public void powerupSpeed() {
        aspetta(1);
        if(puS.getvisible()==true){
            if(p1.player1().contains(puS.getX(), puS.getY())){
                puS.setvisible(false);
                p1.setDelay(1);
                lpuS=new LimitPowerUpSpeed();
            }
            else if(p2.player2().contains(puS.getX(), puS.getY())){
                puS.setvisible(false);
                p2.setDelay(1);
                lpuS=new LimitPowerUpSpeed();
            }
        } 
    }
    public void powerupLife(){
        aspetta(1);
        if(puL.getvisible()==true){
            if(p1.player1().contains(puL.getX(),puL.getY())){
                puL.setvisible(false);
                if(v.getPunti()!=0 && v.getPunti()!=5){
                    v.setPunti(v.getPunti()+1);
                    v.caricaVettore();
                    v.Caricamento();
                }
            }
            if(p2.player2().contains(puL.getX(),puL.getY())){
                puL.setvisible(false);
                if(va.getPunti()!=0 && va.getPunti()!=5){
                    va.setPunti(va.getPunti()+1);
                    va.caricaVettore();
                    va.Caricamento();
                }
            }            
        }       
    }
    @Override
    public void run() {
        while(true){
            setCasualTime();
            while((Thread.currentThread() == orologio)&&(casual>=0)){
                aspetta(delay);
                casual--;
            }
            setCasualPowerUp();
            while(puS.getvisible()==true){
                powerupSpeed();
            }
            do{
                aspetta(1);
                if(lpuS.getCount()==0){
                    p1.setDelay(3);
                    p2.setDelay(3);
                }                
            }while(lpuS.getCount()!=0);
            while(puL.getvisible()==true){
                powerupLife();
            }
        }
    } 
    public void aspetta(int millisec){
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException ex) {
            Logger.getLogger(Player1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

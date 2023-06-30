/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spara;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class LimitPowerUpSpeed extends Thread{
    private Thread orologio;  
    private int delay=1000;
    private int count=10;    
    LimitPowerUpSpeed(){
        orologio = new Thread(this);    
        orologio.start();           
    }
    public void aspetta(int millisec){
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException ex) {
            Logger.getLogger(Player1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getCount(){
        return count;
    }
    @Override
    public void run() {
        while((Thread.currentThread() == orologio)&&(count>0)){
            aspetta(delay);
            count--;
        }
    }   
}

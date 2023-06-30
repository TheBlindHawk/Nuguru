/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.FlowLayout;
import javax.swing.JFrame;
/**
 *
 * @author ecdl
 */
public class DotsAndBoxes {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frm=new JFrame();        
        Pannello pan=new Pannello();               
        frm.setBounds(200, 200, 650, 550);        
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        pan.setLayout(new FlowLayout());
        pan.setVisible(true);
        frm.add(pan);                    
        frm.setVisible(true);
        //Thread thread=new Thread(pan);
        //thread.start();        
    }   
}

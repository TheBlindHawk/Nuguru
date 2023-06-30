/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author ecdl
 */
public class Pannello extends JPanel implements Runnable{
    private Ellipse2D.Double punti[][]=new Ellipse2D.Double[4][4];
    private Linea lineO[][]=new Linea[3][4];
    private Linea lineV[][]=new Linea[4][3];
    private Box[][] box=new Box[3][3];
    private JButton reset=new JButton("reset");
    private String turn;            
    private String giocatoreUno;
    private String giocatoreDue;
    private int uno;
    private int due;   
    private boolean turno;    
    private boolean fl;
    public Pannello(){
       int i,j;  
       double l;       
       turno=true;
       fl=false;
       uno=0;
       due=0;    
       turn="turno gioacatore blu";
       for(i=0;i<4;i++)
           for(j=0;j<4;j++)
               punti[i][j]=new Ellipse2D.Double(i*50+25,j*50+25,8,8);                            
       for(i=0;i<3;i++)
           for(j=0;j<4;j++)                      
               lineO[i][j]=new Linea(this,i,j,true,40,10,50,0,10,0);               
       for(i=0;i<4;i++)
           for(j=0;j<3;j++)                     
               lineV[i][j]=new Linea(this,i,j,false,10,40,0,50,0,10); 
       l=Math.abs(lineO[0][0].getLine().getX2()-lineO[0][0].getLine().getX1());
       for(i=0;i<3;i++)
           for(j=0;j<3;j++)
               box[i][j]=new Box(lineO[i][j],lineV[i][j],lineV[i+1][j],lineO[i][j+1],l);
       this.add(reset);
       reset.setBounds(350, 100, 100, 75);
       reset.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
              int i,j;
              uno=0;
              due=0;
              turno=true;
              for(i=0;i<3;i++)
                for(j=0;j<4;j++){
                    lineO[i][j].setJustDraw(false);
                    lineO[i][j].setDraw(false);
                    lineO[i][j].delCol();
                }
              for(i=0;i<4;i++)
                for(j=0;j<3;j++){
                    lineV[i][j].setJustDraw(false);
                    lineV[i][j].setDraw(false);
                    lineV[i][j].delCol();
                }
              for(i=0;i<3;i++)
                for(j=0;j<3;j++){
                    box[i][j].setJustDraw(false);
                    box[i][j].delCol();
                    
                }
           }
       });
    }   
    
    @Override
    public void paint(Graphics g){       
        int i,j;
        super.paint(g);
        fl=false;
        Graphics2D g2=(Graphics2D)g;        
        g2.setColor(Color.black);       
        giocatoreUno="giocatore blu: "+uno;
        giocatoreDue="giocatore rosso: "+due;
        for(i=0;i<4;i++)
            for(j=0;j<4;j++)
                g2.fill(punti[i][j]);       
        if(!turno)
            g2.setColor(Color.red);
        else
            g2.setColor(Color.blue);       
        for(i=0;i<3;i++)
            for(j=0;j<4;j++)
                if(lineO[i][j].getDraw()==true ) {                  
                    if(!turno)
                       lineO[i][j].setCol(Color.red);
                    else
                       lineO[i][j].setCol(Color.blue); 
                   g2.setColor(lineO[i][j].getCol());   
                   g2.draw(lineO[i][j].getLine());                  
                   if(lineO[i][j].getJustDraw()==false){
                        fl=true;    
                        lineO[i][j].setJustDraw(true); 
                   }                   
               }
        for(i=0;i<4;i++)
            for(j=0;j<3;j++)  
                if(lineV[i][j].getDraw()==true ){                     
                    if(!turno)
                       lineV[i][j].setCol(Color.red);
                    else
                       lineV[i][j].setCol(Color.blue); 
                    g2.setColor(lineV[i][j].getCol());
                    g2.draw(lineV[i][j].getLine());
                       
                    if(lineV[i][j].getJustDraw()==false){
                        fl=true;   
                        lineV[i][j].setJustDraw(true);
                    }
                    
                }
        for(i=0;i<3;i++)
           for(j=0;j<3;j++)
               if(box[i][j].full()==true  ){ 
                   
                    if(box[i][j].getJustDraw()==false){  
                        fl=false;
                        if(!turno)
                            box[i][j].setCol(Color.red);
                        else
                            box[i][j].setCol(Color.blue);
                        
                        if(turno)
                           uno++;
                        else
                           due++; 
                        box[i][j].setJustDraw(true);
                        
                    }
                    g2.setColor(box[i][j].getCol());
                    g2.fill(box[i][j].getPunto());
                    
               }
        if(fl)
            turno=!turno;
        if(turno)
            turn="turno giocatore blu";
        else
            turn="turno giocatore rosso";         
        g2.setColor(Color.black);        
        g2.drawString(turn, 250, 100);
        g2.drawString(giocatoreUno, 250, 120);
        g2.drawString(giocatoreDue, 250, 140);
        if(uno+due==9){
            if(uno>due)
                g2.drawString("ha vinto il giocatore blu", 150, 250);
            else
                g2.drawString("ha vinto il giocatore rosso", 150, 250);
        }       
    }    
    public void setLinea(int i,int j,boolean c){
        if(c)
            lineO[i][j].setDraw(true);
        else
            lineV[i][j].setDraw(true);      
    }
    @Override
    public void run() {               
        while(true)           
            repaint();               
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
/**
 *
 * @author utente
 */
public class MyMouseListener implements MouseListener {
    private Shape s;
    private Pannello pan;
    private int i;
    private int j;
    private boolean oriz;   
    public MyMouseListener(Shape s,Pannello p,int x,int y,boolean c) {
        this.s=s;
        pan=p;
        i=x;
        j=y;
        oriz=c;   
    }
    @Override
    public void mouseClicked(MouseEvent e){
        
      if(SwingUtilities.isLeftMouseButton(e)&& s.contains(e.getX(), e.getY()))
            pan.setLinea(i,j,oriz);      
    }
    @Override
    public void mousePressed(MouseEvent me) {
        
    }
    @Override
    public void mouseReleased(MouseEvent me) {
        
    }
    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author ecdl
 */
public class Linea {
    private Rectangle2D.Double ret;  
    private MyMouseListener ml;    
    private Line2D.Double line;    
    private boolean draw;  
    private boolean justDraw;
    private Color col;
    Linea(Pannello p,int i,int j,boolean b,int dimx,int dimy,int dim1,int dim2,int d1,int d2)
    {     
       col=null;  
       ret=new Rectangle2D.Double(i*50+25+d1,j*50+25+d2 ,dimx ,dimy );  
       ml=new MyMouseListener(ret,p,i,j,b);
       p.addMouseListener(ml);
       line=new Line2D.Double(i*50+25+4,j*50+25+4 ,i*50+25+4+dim1 ,j*50+25+4+dim2 );
       draw=false;  
       justDraw=false;
    }
    public void delCol(){
        col=null;
    }
    public Color getCol(){
        return col;
    }
    public void setCol(Color c){
        if(col==null)
            col=c;       
    }
    public void setDraw(boolean b)
    {
        draw=b;
    }
    public boolean getDraw()
    {
        return draw;
    }
    public Rectangle2D.Double getRet()
    {
        return ret;
    }
    public void setJustDraw(boolean b)
    {
        justDraw=b;
    }
    public boolean getJustDraw()
    {
        return justDraw;
    }
    public Line2D.Double getLine()
    {
        return line;
    }
}

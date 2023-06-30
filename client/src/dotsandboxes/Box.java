/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotsandboxes;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
/**
 *
 * @author user
 */
public class Box {
    private Linea  l[]=new Linea[4];
    private Ellipse2D.Double punto;
    private boolean justDraw;
    private Color col;
    Box(Linea up,Linea left,Linea right,Linea down,double leng){ 
        double x=up.getLine().getX2();
        double y=left.getLine().getY2();               
        double dim=15.0;
        leng/=2.0;      
        x-=leng;
        y-=leng;
        x-=dim/2;
        y-=dim/2;
        l[0]=up;
        l[1]=right;
        l[2]=down;
        l[3]=left;
        punto=new Ellipse2D.Double(x,y,dim,dim);   
        justDraw=false;
        col=null;
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
    public Ellipse2D.Double getPunto(){
        return punto;
    }
    public boolean full(){
        for(int i=0;i<4;i++)
            if(l[i].getDraw()==false)
                return false;
        return true;
    }
    public void setJustDraw(boolean b)
    {
        justDraw=b;
    }
    public boolean getJustDraw()
    {
        return justDraw;
    }
}

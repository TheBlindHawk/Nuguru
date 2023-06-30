/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngnl;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class Mappa {
    private char mappa[][]={ {'X','X','X','X','X','X','X'} , 
                             {'X',' ',' ','X',' ',' ','X'} ,
                             {'X',' ',' ','X',' ',' ','X'} ,
                             {'X',' ',' ','X',' ',' ','X'} ,
                             {'X',' ',' ',' ',' ',' ','X'} ,
                             {'X',' ',' ',' ',' ',' ','X'} ,
                             {'X','X','X','X','X','X','X'}};
    private BufferedImage image[][]=new BufferedImage[7][7];
    private Path currentPath=NGNL.currentPath;
    private String slashPath=NGNL.slashPath;
    private String percorsoImmagini;
    private int x=0,y=0;
    private int newx=0,newy=0;
    Mappa(){
        percorsoImmagini=currentPath.toAbsolutePath().toString()+slashPath+"src"+slashPath+"immagini"+slashPath+"Oggetti"+slashPath;
        caricamento();
    }
    public void caricamento(){
        String d;
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                switch(mappa[i][j]){
                    case 'X':{
                        d="X";
                        try {
                            image[i][j]=ImageIO.read(new File(percorsoImmagini+d+".png"));
                        } catch (IOException ex) {
                            Logger.getLogger(Mappa.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                    default:
                }
            }
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        newx=x;
    }
    public void setY(int y){
        newy=y;
    }
    public void paint(Graphics g){
        int xx=x;
        String d;
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                xx+=250;
                g.drawImage(image[i][j],xx,y,null);
            }
            xx=x;
            y+=250;
        }
        x=newx;
        y=newy;
    }  
}
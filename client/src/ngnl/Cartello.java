/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngnl;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Cartello {
    private JPanel container=new JPanel();
    static boolean listenerPlayer=true;
    static boolean tabellone=false;
    private String slashPath=NGNL.slashPath;
    private Tabellone tab;
    private BufferedImage cartello;
    private Path currentPath=Paths.get("");
    private String percorso;
    private Rectangle2D rectangle;
    private int x=700,y=500;
    Cartello(JPanel panel){
        percorso=currentPath.toAbsolutePath().toString()+slashPath+"src"+slashPath+"immagini"+slashPath+"Oggetti"+slashPath+"Sio.png";
        container=panel;
        try {
            cartello=ImageIO.read(new File(percorso));
        } catch (IOException ex) {
            Logger.getLogger(Cartello.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public BufferedImage getImage(){
        return cartello;
    }
    public Rectangle2D getRectangle(){
        return rectangle;
    }
    public void paint(Graphics g){
        if(tabellone==true)
            tab.paint(g);
        g.drawImage(cartello, x, y, container);
        rectangle=new Rectangle2D.Double(x,y,cartello.getWidth(),cartello.getHeight());
    }
    public void selezioneSfida(){
        tabellone=true;
        this.listenerPlayer=false;
        tab=new Tabellone(container);
        tab.listenerPlayer=true;
    }
    
}

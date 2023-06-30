/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngnl;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Player implements KeyListener{
    private Path currentPath=NGNL.getPath();
    private String slashPath=NGNL.getSlashPath();
    private String percorso;
    private String azione="Down";
    private int currentFrame=0;
    private int x=700;
    private int y=500;
    private BufferedImage image[];
    private int incremento=5;
    private Rectangle2D rect;
    private Cartello c;
    private Mappa mappa;
    Player(JPanel panel,Mappa m,Cartello c){
        percorso=currentPath.toAbsolutePath().toString()+slashPath+"src"+slashPath+"immagini"+slashPath+"Pierluigio";
        this.c=c;
        mappa=m;
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(this);
        CaricaFrame();
    }
    public void CaricaFrame(){
        int count=0;
        String numero;
        File dir=new File(percorso);
        String files[]=dir.list();
        for(int i=0;i<files.length;i++){    //Questo ciclo crea un array lungo quanti sono le immagini che iniziano con l'azione corrente
            if(files[i].startsWith(azione))
                count++;
        }
        image=new BufferedImage[count];
        for(int i=0;i<image.length;i++){    //Viene caricato l'array
            numero=Integer.toString(i+1);
            try {
                image[i]=ImageIO.read(new File(percorso+slashPath+azione+" "+numero+".png"));
            } catch (IOException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void W(){
        if(!(azione.equals("Up")))
            currentFrame=0;
        else
            currentFrame++;
        if(currentFrame >= image.length)
            currentFrame=0;
        azione="Up";
        CaricaFrame();
        mappa.setY(mappa.getY()+20);
        c.setY(c.getY()+20);
    }
    public void A(){
        if(!(azione.equals("Left")))
            currentFrame=0;
        else
            currentFrame++;
        if(currentFrame >= image.length)
            currentFrame=0;
        azione="Left";
        CaricaFrame();
        mappa.setX(mappa.getX()+20);
        c.setX(c.getX()+20);
    }
    public void D(){
        if(!(azione.equals("Right")))
            currentFrame=0;
        else
            currentFrame++;
        if(currentFrame >= image.length)
            currentFrame=0;
        azione="Right";
        CaricaFrame();
        mappa.setX(mappa.getX()-20);
        c.setX(c.getX()-20);
    }
    public void S(){
        if(!(azione.equals("Down")))
            currentFrame=0;
        else
            currentFrame++;
        if(currentFrame >= image.length)
            currentFrame=0;
        azione="Down";
        CaricaFrame();
        mappa.setY(mappa.getY()-20);
        c.setY(c.getY()-20);
    }
    public void Space(){
        if(rect.intersects(c.getRectangle()))
            c.selezioneSfida();
    }
    public void paint(Graphics g){
        g.drawImage(image[currentFrame], x, y, null);
        rect=new Rectangle2D.Double(x,y,image[currentFrame].getWidth(),image[currentFrame].getHeight());    
        //Questo rettangolo invisibile circonda il personaggio in modo che si possa capire quando è in posizione del cerchio/cartello
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(c.listenerPlayer==true){
            int key=e.getKeyCode();
            switch(key){
                case KeyEvent.VK_W:
                    W();
                break;
                case KeyEvent.VK_A:
                    A();
                break;
                case KeyEvent.VK_D:
                    D();
                break;
                case KeyEvent.VK_S:
                    S();
                break;
                case KeyEvent.VK_SPACE:
                    Space();
                break;
                case KeyEvent.VK_UP:
                    W();
                break;
                case KeyEvent.VK_LEFT:
                    A();
                break;
                case KeyEvent.VK_RIGHT:
                    D();
                break;
                case KeyEvent.VK_DOWN:
                    S();
                break;
                case KeyEvent.VK_ENTER:
                    Space();
                break;
                default:
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(c.listenerPlayer==true)
            currentFrame=0;
    }
    
}

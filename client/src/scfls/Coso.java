/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scfls;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
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
public class Coso {
    private Rectangle2D.Double ret;
    private BufferedImage image;
    private char nome;
    private int x,y,l,w;
    private String percorso;
    private Path currentPath;
    private String slashPath;
    Coso(int x,int y,int l,int w,char nome,Path currentPath,String slashPath){
        this.slashPath=slashPath;
        this.currentPath=currentPath;
        percorso=currentPath.toAbsolutePath().toString()+slashPath+"src"+slashPath+"Immagini scfls"+slashPath;
        ret=new Rectangle2D.Double(x,y,l,w);
        this.nome=nome;
        this.x=x;
        this.y=y;
        this.l=l;
        this.w=w;
        CaricamentoImmagine(str(nome));
    }
    public String str(char b){
       switch(b){
            case 's':return "sasso";
            case 'c':return "carta";
            case 'f':return "forbici";
            case 'l':return "lizard";
            case 'k':return "spock";                          
        } 
       return "pippo";
    }   
    public char getNome(){
        return nome;
    }
    public Rectangle2D.Double getRet()
    {
        return ret;
    }
    public void CaricamentoImmagine(String scelta){
        try {
            image=ImageIO.read(new File(percorso+scelta+".png"));
        } catch (IOException ex) {
            Logger.getLogger(Coso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void paint(Graphics g){
        g.drawImage(image,x,y,null);
    }
    
}

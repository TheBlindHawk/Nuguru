/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngnl;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Musica implements MouseListener{
    private Clip clip;
    private String basesoundtrack;
    private Path currentPath=NGNL.currentPath;
    private String slashPath=NGNL.slashPath;
    private BufferedImage soundImage[]=new BufferedImage[2];
    private String percorso,percorsoImmagine,percorsoMusica;
    private Rectangle2D rect;
    private boolean plays=false;
    private AudioInputStream audioInputStream;
    Musica(JPanel panel){
        panel.addMouseListener(this);
        percorso=currentPath.toAbsolutePath().toString()+slashPath+"src";
        percorsoImmagine=percorso+slashPath+"immagini"+slashPath+"Oggetti";
        percorsoMusica=percorso+slashPath+"Musica";
        CaricamentoImmagini();
        basesoundtrack="No Game No Life 8 Bit.wav";
        Preparazione();
        if(plays==true){
            Play();
        }
        else{
            Stop();
        }        
    }
    public void paint(Graphics g){
        if(plays==true){
            g.drawImage(soundImage[0],0,0,null);
            rect=new Rectangle2D.Double(0,0,soundImage[0].getWidth(),soundImage[0].getHeight()); 
        }
        else{
            g.drawImage(soundImage[1],0,0,null);   
            rect=new Rectangle2D.Double(0,0,soundImage[1].getWidth(),soundImage[0].getHeight()); 
        }
   
    }
    public void CaricamentoImmagini(){
        try {
            soundImage[0]=ImageIO.read(new File(percorsoImmagine+slashPath+"Audio On.png"));
        } catch (IOException ex) {
            Logger.getLogger(Musica.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            soundImage[1]=ImageIO.read(new File(percorsoImmagine+slashPath+"Audio Off.png"));
        } catch (IOException ex) {
            Logger.getLogger(Musica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Preparazione(){
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(percorsoMusica+slashPath+basesoundtrack).getAbsoluteFile());
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Musica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Musica.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clip= AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Musica.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Musica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Musica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Play(){
        try {
            clip.start();
            clip.loop(0);
        } catch(Exception ex) {
            System.out.println("PLAY.");
            //ex.printStackTrace();
        }
    }
    public void Stop(){
        try {
            clip.stop();
        } catch(Exception ex) {
            System.out.println("STOP.");
            //ex.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(plays==true){
            if(rect.contains(e.getX(),e.getY())){
                plays=false;
                Stop();
            }
        }
        else{ 
            if(rect.contains(e.getX(),e.getY())){
                plays=true;
                Play();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}


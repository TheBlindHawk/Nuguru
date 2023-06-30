/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.cards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author user
 */
public class tipo {
    BufferedImage carta;
    tipo(int n,int d)
    {
        Path currentPath=Paths.get("");
        int num=n;
        int tipo=d;
        String percorso=currentPath.toAbsolutePath().toString()+"\\src\\immagini\\carte\\"+tipo+"-"+num+".png";
        try {
            carta=ImageIO.read(new File(percorso));
        } catch (IOException ex) {
            Logger.getLogger(tipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BufferedImage get()
    {
        return carta;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import ngnl.NGNL;


/**
 *
 * @author user
 */
public class tipo {
    ImageIcon carta;
    
    private String slashPath=NGNL.slashPath;
    tipo(int n,int d)
    {
        Path currentPath=Paths.get("");
        int num=n;
        int tipo=d;
        String percorso=currentPath.toAbsolutePath().toString()+slashPath+"src"+slashPath+"immagini"+slashPath+"carte"+slashPath+tipo+"-"+num+".png";
        carta=new ImageIcon(percorso);
    }
    public ImageIcon get()
    {
        return carta;
    }
}

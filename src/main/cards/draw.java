/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.cards;

import java.awt.Graphics;
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
 * @author hp
 */
public class draw extends JPanel{
    BufferedImage image;
    draw(BufferedImage image){
        this.image=image;
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image, 10, 10, this);
    }
    
}

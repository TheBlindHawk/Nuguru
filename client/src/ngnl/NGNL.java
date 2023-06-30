/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ngnl;

import java.awt.CardLayout;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class NGNL {

    /**
     * @param args the command line arguments
     */
    private static final String OS = System.getProperty("os.name").toLowerCase();
    public static String slashPath;
    public static Path currentPath=Paths.get("");
    public static final int L=1280;
    public static final int H=720;
    public static void main(String[] args) {
        if (isWindows()) {
            slashPath="\\";
        } else if (isMac()) {
            slashPath="\\";
        } else if (isUnix()) {
            slashPath="/";
        } else if (isSolaris()) {
            slashPath="/";
        } else {
            System.out.println("Your OS is not support!!");
        }
        JFrame window=new JFrame("Progetto");
        JPanel container=new JPanel(new CardLayout());
        Start start=new Start(container);
        window.add(container);
        container.add(start);
        window.setBounds(0,0,L,H);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static Path getPath(){
        return currentPath;
    }
    public static String getSlashPath(){
        return slashPath;
    }
    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

    public static boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }
    public static String getOS(){
        if (isWindows()) {
                return "win";
        } else if (isMac()) {
                return "osx";
        } else if (isUnix()) {
                return "uni";
        } else if (isSolaris()) {
                return "sol";
        } else {
                return "err";
        }
    }
    
}

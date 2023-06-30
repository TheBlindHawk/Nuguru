/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scfls;

import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFrame;

/**
 *
 * @author hp
 */
public class SCFLS {

    private static final String OS = System.getProperty("os.name").toLowerCase();
    private static String slashPath;
    private static Path currentPath=Paths.get("");
    private static final int L=1280;
    private static final int H=720;
    
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
        /*JFrame frm=new JFrame("Sasso Carta Forbici Lizard Spock");
        Pannelloscfls pan=new Pannelloscfls();
        frm.add(pan);
        frm.setBounds(0,0,L,H);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.map;

import java.awt.CardLayout;
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
    private static String OS = System.getProperty("os.name").toLowerCase();
    public static String slashPath;
    
    public static void main(String[] args) {
        System.out.println(OS);
        
        if (isWindows()) {
            slashPath="\\";
            System.out.println("This is Windows");
        } else if (isMac()) {
            slashPath="\\";
            System.out.println("This is Mac");
        } else if (isUnix()) {
            slashPath="/";
            System.out.println("This is Unix or Linux");
        } else if (isSolaris()) {
            slashPath="/";
            System.out.println("This is Solaris");
        } else {
            System.out.println("Your OS is not support!!");
        }
        JFrame window=new JFrame("start!");
        JPanel container=new JPanel(new CardLayout());
        int L=1280;
        int H=720;
        Start start=new Start(container,L,H);
        window.add(container);
        container.add(start);
        window.setBounds(0,0,L,H);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

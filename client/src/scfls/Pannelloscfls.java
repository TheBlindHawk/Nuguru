/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scfls;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.nio.file.Path;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class Pannelloscfls extends JPanel implements MouseListener{
    private Coso ret[]=new Coso[5];
    private char nomi[]={'s','c','f','l','k'};
    private char p;
    private char c;
    private final int D=200;
    private String stringa="";
    public Pannelloscfls(Path currentPath,String slashPath){
        this.addMouseListener(this);
        for(int i=0;i<5;i++){
            ret[i]=new Coso(i*(D+20)+50,150,D,D,nomi[i],currentPath,slashPath);
        }  
    }
    public void paint(Graphics g){
        super.paint(g);
        for(int i=0;i<5;i++){
            ret[i].paint(g);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,20));
        g.drawString(stringa, 200, 500);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {
        boolean fl=false;
        for(int i=0;i<5;i++)
            if(ret[i].getRet().contains(me.getX(),me.getY())){
                p=ret[i].getNome();
                fl=true;
            }
        if(fl){
            int n=(int)(Math.random()*5);
            switch(n){
                case 0:c='s';
                    break;
                case 1:c='c';
                    break;
                case 2:c='f';
                    break;
                case 3:c='l';
                    break;
                case 4:c='k';
                    break;

            }
            char l=this.chk();
            String s=str(p)+" contro "+str(c);
            if(l=='p')
                stringa="pareggio: "+s;
            if(l=='t')
                stringa="vittoria: "+s;
            if(l=='f')
                stringa="sconfitta: "+s;
            repaint();
        }

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
    public char chk(){
        if(c==p)
            return 'p';
        else
            switch(p){
                case's':{
                    if(c=='f'||c=='l')
                        return 't';
                    else
                        return 'f';                    
                }                
                case'c':{
                    if(c=='s'|| c=='k')
                        return 't';
                    else
                        return 'f';
                }
                case'f':{
                    if(c=='c'||c=='l')
                        return 't';
                    else
                        return 'f';
                }
                case'l':{
                    if(c=='c'||c=='k')
                        return 't';
                    else
                        return 'f';
                }
                case'k':{
                    if(c=='s'||c=='f')
                        return 't';
                    else
                        return 'f';
                }
            }
        return 'p';
    }
    @Override
    public void mousePressed(java.awt.event.MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent me) {
       
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
        
    }
}
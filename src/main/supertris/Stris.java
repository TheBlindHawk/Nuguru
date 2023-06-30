/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.supertris;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author user
 */
public class Stris extends javax.swing.JPanel {

    /**
     * Creates new form Stris
     */
    public Stris() {
        int i, y;
        initComponents();
        this.setBounds(500, 200, 1500, 1200);
        PosizionaBottoni();
        comandi(1, 1);
        //tabelle();
    }
    private int p = 0;
    JButton but[][] = new JButton[9][9];
    JButton vitt[][] = new JButton[3][3];
    boolean vit[][] = new boolean[3][3];

    public void PosizionaBottoni() {
        int i, y, n = 70;
        for (i = 0; i < 3; i++) {
            for (y = 0; y < 3; y++) {
                vitt[i][y] = new JButton("");
                vit[i][y] = true;
                System.out.println(y);
            }
        }
        for (i = 0; i < 9; i++) {
            for (y = 0; y < 9; y++) {
                but[i][y] = new JButton("");
                but[i][y].setName(Integer.toString(i) + "/" + Integer.toString(y));
                but[i][y].setBounds(i * n, y * n, n - 10, n - 10);
                this.add(but[i][y]);
                but[i][y].setBackground(java.awt.Color.lightGray);
            }
        }
    }

    public void comandi(int n1, int n2) {
        int i, y;
        for (i = 0; i < 3; i++) {
            for (y = 0; y < 3; y++) {
                if(but[n1 * 3 + i][n2 * 3 + y].getText().equals(""))
                {
                    but[n1 * 3 + i][n2 * 3 + y].setBackground(java.awt.Color.white);
                    but[n1 * 3 + i][n2 * 3 + y].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String pigiato[] = new String[2];
                            JButton pigio = (JButton) e.getSource();
                            pigiato = (pigio.getName()).split("/");
                            String play;
                            int i, y, j, b1, b2;
                            b1 = Integer.parseInt(pigiato[0]);
                            b2 = Integer.parseInt(pigiato[1]);
                            if (p == 0) {
                                play = "X";
                                but[b1][b2].setForeground(java.awt.Color.blue);
                                p = 1;
                            } else {
                                play = "O";
                                but[b1][b2].setForeground(java.awt.Color.red);
                                p = 0;
                            }
                            but[b1][b2].setText(play);
                            for (i = 0; i < 3; i++) {
                                for (y = 0; y < 3; y++) {
                                    but[n1 * 3 + i][n2 * 3 + y].setBackground(java.awt.Color.lightGray);
                                    ActionListener l[] = but[n1 * 3 + i][n2 * 3 + y].getActionListeners();
                                    int n = l.length;
                                    for (j = 0; j < n; j++) {
                                        but[n1 * 3 + i][n2 * 3 + y].removeActionListener(l[j]);
                                    }
                                }
                            }
                            while (b1 > 2) {
                                b1 -= 3;
                            }
                            while (b2 > 2) {
                                b2 -= 3;
                            }

                            vit[n1][n2] = controlla(n1, n2, but);
                            if (controlla(vitt)==true) 
                                vittoria(play);
                            else
                                if (vit[b1][b2]) 
                                    comandi(b1, b2);
                                else 
                                    comandi();

                        }
                    });
                }
            }
        }
    }

    public void comandi() {
        int i, y, j, x;
        for (i = 0; i < 3; i++) {
            for (y = 0; y < 3; y++) {
                for (j = 0; j < 3; j++) {
                    for (x = 0; x < 3; x++) {
                        if(but[i * 3 + j][y * 3 + x].getText().equals(""))
                        {
                            but[i * 3 + j][y * 3 + x].setBackground(java.awt.Color.white);
                            but[i * 3 + j][y * 3 + x].addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    String pigiato[] = new String[2];
                                    JButton pigio = (JButton) e.getSource();
                                    pigiato = (pigio.getName()).split("/");
                                    String play;
                                    int i, y, j, x, num, b1, b2;
                                    b1 = Integer.parseInt(pigiato[0]);
                                    b2 = Integer.parseInt(pigiato[1]);
                                    if (p == 0) {
                                        play = "X";
                                        but[b1][b2].setForeground(java.awt.Color.blue);
                                        p = 1;
                                    } else {
                                        play = "O";
                                        but[b1][b2].setForeground(java.awt.Color.red);
                                        p = 0;
                                    }
                                    but[b1][b2].setText(play);
                                    for (i = 0; i < 3; i++) {
                                        for (y = 0; y < 3; y++) {
                                            for (j = 0; j < 3; j++) {
                                                for (x = 0; x < 3; x++) {
                                                    but[i * 3 + x][y * 3 + j].setBackground(java.awt.Color.lightGray);
                                                    ActionListener l[] = but[i * 3 + x][y * 3 + j].getActionListeners();
                                                    int n = l.length;
                                                    for (num = 0; num < n; num++) {
                                                        but[i * 3 + x][y * 3 + j].removeActionListener(l[num]);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    int n1 = 0, n2 = 0;
                                    while (b1 > 2) {
                                        b1 -= 3;
                                        n1++;
                                    }
                                    while (b2 > 2) {
                                        b2 -= 3;
                                        n2++;
                                    }
                                    vit[n1][n2] = controlla(n1, n2, but);
                                    if (controlla(vitt)==true) 
                                        vittoria(play);
                                    else
                                        if (vit[b1][b2]) 
                                            comandi(b1, b2);
                                        else 
                                            comandi();
                                }
                            });
                        }
                    }
                }
            }
        }

    }

    public boolean controlla(int n1, int n2, JButton but[][]) {
        int i, y, j,p1,p2;
        p1=n1*3;
        p2=n2*3;
        String c1[] = new String[3];
        String c2[] = new String[3];
        for (i = 0; i < 3; i++) {
            for (y = 0; y < 3; y++) {
                c1[y] = but[p1 + i][n2 * 3 + y].getText();
                c2[y] = but[p1 + y][n2 * 3 + i].getText();
                if (c1[0].equals(c1[1]) && c1[1].equals(c1[2]) && (c1[0].equals("X") || c1[0].equals("O"))) {
                    vittoria(n1, n2, c1[0]);
                    return (false);
                }
                if (c2[0].equals(c2[1]) && c2[1].equals(c2[2]) && (c2[0].equals("X") || c2[0].equals("O"))) {
                    vittoria(n1, n2, c2[0]);
                    return (false);
                }
            }
        }
        if(but[p1][p2].getText().equals(but[p1+1][p2+1].getText()) && but[p1+1][p2+1].getText().equals(but[p1+2][p2+2].getText()) && (but[p1][p2].getText().equals("X") || but[p1][p2].getText().equals("O")))
        {
            vittoria(n1, n2, but[p1][p2].getText());
            return (false);
        }
        if(but[p1+2][p2].equals(but[p1+1][p2+1]) && but[p1+1][p2+1].equals(but[p1][p2+2]) && (but[p1][p2].getText().equals("X") || but[p1][p2].getText().equals("O")))
        {
            vittoria(n1, n2, but[p1+2][p2+0].getText());
            return (false);
        }
        return (true);
    }

    public boolean controlla(JButton vit[][]) {
        int i, y, j;
        String c1[] = new String[3];
        String c2[] = new String[3];
        for (i = 0; i < 3; i++) {
            for (y = 0; y < 3; y++) {
                c1[y] = vit[i][y].getText();
                c2[y] = vit[y][i].getText();
                if (c1[0].equals(c1[1]) && c1[1].equals(c1[2]) && (c1[0].equals("X") || c1[0].equals("O"))) {
                    return (true);
                }
                if (c2[0].equals(c2[1]) && c2[1].equals(c2[2]) && (c2[0].equals("X") || c2[0].equals("O"))) {
                    return (true);
                }
            }
        }
        if(vit[0][0].equals(vit[1][1]) && vit[1][1].equals(vit[2][2]))
            return (true);
        if(vit[2][0].equals(vit[1][1]) && vit[1][1].equals(vit[0][2]))
            return (true);
        return (false);
    }

    public void vittoria(int n1, int n2, String vv) {
        int i, y, n, num = 210;
        n = (n1 + 1) * (n2 + 1);
        for (i = 0; i < 3; i++) {
            for (y = 0; y < 3; y++) {
                this.remove(but[n1 * 3 + i][n2 * 3 + y]);
            }
        }
        vitt[n1][n2].setText(vv);
        vitt[n1][n2].setBackground(java.awt.Color.white);
        if(vv.equals("X"))
            vitt[n1][n2].setForeground(java.awt.Color.blue);
        else
            vitt[n1][n2].setForeground(java.awt.Color.red);
        this.add(vitt[n1][n2]);
        vitt[n1][n2].setBounds(n1 * num, n2 * num, num - 10, num - 10);
    }

    public void vittoria(String vv) {
        int i, y, j, x, num;
        for (i = 0; i < 3; i++) {
            for (y = 0; y < 3; y++) {
                for (j = 0; j < 3; j++) {
                    for (x = 0; x < 3; x++) {
                        but[i * 3 + x][y * 3 + j].setBackground(java.awt.Color.lightGray);
                        ActionListener l[] = but[i * 3 + x][y * 3 + j].getActionListeners();
                        int n = l.length;
                        for (num = 0; num < n; num++) {
                            but[i * 3 + x][y * 3 + j].removeActionListener(l[num]);
                        }
                    }
                }
            }
        }
        JLabel victory=new JLabel("VICTORY");
        victory.setBounds(1000, 200, 100, 100);
        //victory.setForeground(Color.white);
        if (vv.equals("X")) 
            victory.setForeground(Color.blue);
        else 
            victory.setForeground(Color.red);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

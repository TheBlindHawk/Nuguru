/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliamigliorini
 */
public class send implements Runnable{
    int x=0,y=0;
    Socket client;
    DataOutputStream out;
    GetDir dir;
    send(Socket client) throws IOException{
        this.client=client; 
        this.out= new DataOutputStream(client.getOutputStream());
        dir=new GetDir(this.client);
        Thread thread=new Thread(dir);
        thread.start();
    }
    @Override
    public void run() {
        switch(dir.Dir){
            case "A":
                x++;
                break;
            case "B":
                x--;
                break;
            case "S":
                y--;
                break;
            case "D":
                y++;
                break;
            case "F":
                break;
        }
        try {
            out.writeInt(x);
            out.writeInt(y);
        } catch (IOException ex) {
            Logger.getLogger(send.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

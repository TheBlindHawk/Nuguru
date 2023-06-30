/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliamigliorini
 */
public class GetDir implements Runnable{
    Socket client;
    DataInputStream in;
    String Dir;
    GetDir(Socket client) throws IOException{
        this.client=client;
        this.in=new DataInputStream(client.getInputStream());
    }
    @Override
    public void run() {
        try {
            Dir=in.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(GetDir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

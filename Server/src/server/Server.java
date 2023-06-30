/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Server {
    /**
     * @param args the command line arguments
     */
    /*static boolean controllo(ArrayList <Socket> listaSocket,String clientAddress) throws SocketException{
        if(listaSocket.size()==0)
            return true;
        for(int i=0;i<listaSocket.size();i++){
            if(clientAddress.equals(listaSocket.get(i).getInetAddress().getHostAddress()))
                return false;
        }
        return true;
    }
    static void sendData(ArrayList <Socket> listaSocket,String clientAddress,String packet,boolean isNew) throws IOException{
        for(int i=0;i<listaSocket.size();i++){
            DataOutputStream outToClient = new DataOutputStream(listaSocket.get(i).getOutputStream());
            if(!(clientAddress.equals(listaSocket.get(i).getInetAddress().getHostAddress())))
                outToClient.writeUTF(packet+" "+isNew);
            else
                outToClient.writeUTF("NULL");
        }
    }*/
    public static void main(String[] args) throws IOException {
        ServerSocket myServer=new ServerSocket(6789);
        ArrayList <send> listaSocket=new ArrayList();
        while(true){
                //boolean isNew=false;
                Socket client=myServer.accept();
                //String clientAddress=client.getInetAddress().getHostAddress();
                send s=new send(client);
                listaSocket.add(s);
                Thread thread=new Thread(s);
                thread.start();
                /*if(controllo(listaSocket,clientAddress)){
                    listaSocket.add(client);
                    isNew=true;
                }
                System.out.println(s);
                sendData(listaSocket,clientAddress,s,isNew);*/
        }
    }
}
package org.example;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SocketInfo {
    public static void main(String[] args) {
        String host = "java.sun.com";
        try{
            Socket theSocket = new Socket(host,80);
            System.out.println("Remote Address: "+ theSocket.getRemoteSocketAddress());
            System.out.println("Remote Port: "+ theSocket.getPort());
            System.out.println("Local Address: "+ theSocket.getLocalAddress());
            System.out.println("Local Port: "+ theSocket.getLocalAddress());
        }catch (UnknownHostException ex){
            System.out.println("I can't find " + host);
        }catch (SocketException ex){
            System.out.println("Could not connect to "+ host);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

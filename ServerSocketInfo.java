package org.example;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketInfo {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(9000);
            System.out.println("This server runs on port " + server.getLocalPort());
            System.out.println("This server runs on address" + server.getInetAddress());
        }catch (IOException ex){
            System.out.println(ex);

        }
    }
}

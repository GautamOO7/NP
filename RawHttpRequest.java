package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RawHttpRequest {
    public static void main(String[] args) {
        String server ="localhost";
        String resource ="/home";
        try{
            Socket socket = new Socket(server,8080);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("GET "+ resource + "HTTP/1.1");
            out.println("Host: "+server);
            out.println("Connection: close");
            out.println("");

            String line;
            while ((line = in.readLine()) !=null){
                System.out.println(line);
            }
            in.close();
            out.close();
            socket.close();
        }catch (IOException ex){
//            System.out.println(ex);;

            ex.printStackTrace();
        }
    }
}

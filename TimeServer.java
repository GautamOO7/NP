package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServer {

    public final static int PORT = 9001;
    public static void main(String[] args) {

        long differeceBetweenEpochs = 2208988800L;
        try(ServerSocket server = new ServerSocket(PORT)){
            System.out.println("Server Started");
            while (true){
            try(Socket connection = server.accept()){
                System.out.println("Client Connected");
                OutputStream out = connection.getOutputStream();
                Date now = new Date();
                long msSince1970 = now.getTime();
                long secondsSince1970 = msSince1970 / 1000;
                long secondSince1900 = secondsSince1970 + differeceBetweenEpochs;

                byte[] time = new byte[4];
                time[0] = (byte) ((secondsSince1970 & 0x00000000FF000000L) >> 24);
                time[1] = (byte) ((secondsSince1970 & 0x0000000000FF0000L) >> 16);
                time[2] = (byte) ((secondsSince1970 & 0x000000000000FF00L) >> 8);
                time[3] = (byte) (secondSince1900 & 0x00000000000000FFL);
                out.write(time);
                out.flush();
            }catch (IOException ex) {
                System.out.println(ex.getMessage());

            }
            }
            }catch (IOException ex){
            System.err.println(ex);
        }
    }
}

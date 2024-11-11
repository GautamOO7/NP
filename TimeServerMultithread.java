package org.example;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeServerMultithread {
    public final static int PORT = 9002;

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(PORT)){
            while (true){
                try{
                    Socket connection = server.accept();
                    Thread task = new DaytimeThread(connection);
                    task.start();
                }catch (IOException ex){

                }
            }

        }catch (IOException ex){
            System.out.println("Could not listen on port: ");
        }
    }
    private static class DaytimeThread extends Thread{
        private Socket connection;
        DaytimeThread(Socket connection){this.connection = connection;}

        @Override
        public void run(){
            System.out.println("Thread started: " + this.getName());
            try {
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                Date now = new Date();
                out.write(now.toString() + "\r\n");
                out.flush();
            }catch (IOException ex){
                System.out.println(ex);
            }finally {
                try{
                    connection.close();

                }catch (IOException ex){

                }
            }

        }
    }

}

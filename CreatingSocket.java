package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class CreatingSocket {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("time.nist.gov", 13);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            System.out.println(time);
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            if( socket != null){
                try{
                    socket.close();
                }catch(IOException ex){
                    System.out.println(ex + ".");
                }
            }
        }
    }
}

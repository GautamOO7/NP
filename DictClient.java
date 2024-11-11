package org.example;

import java.io.*;
import java.net.Socket;

public class DictClient {
    public static final String SERVER = "dict.org";
    public static final int PORT = 2628;
    public static final int TIMEOUT = 15000;

    public static void main(String[] args) {
        String[] queryList = {"gold", "uranium","silver", "Copper","lead"};
        Socket socket = null;
        try{
            socket = new Socket(SERVER,PORT);
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out,"UTF-8");
            writer = new BufferedWriter(writer);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(in, "UTF-8"));
            for(String word: queryList){
                define(word, writer, reader);
            }
            writer.write("quit\r\n");
            writer.flush();
        }catch (IOException ex){
            ex.printStackTrace();
            System.out.println(ex + ".");

        }finally {
            {
                if(socket != null){
                    try{
                        socket.close();
                    }catch (IOException ex){

                    }
                }
            }
        }
    }
    static void define(String word, Writer writer, BufferedReader reader)
        throws IOException, UnsupportedEncodingException{
        writer.write("Define rng-lat "+ word + "\r\n");
        writer.flush();
        for(String line = reader.readLine(); line != null; line = reader.readLine()){
            if(line.startsWith("20 ")){
                return;
            }else if(line.startsWith("552 ")){
                System.out.println("No definition foun for "+ word);
                return;

            }else if(line.matches("\\d\\d\\d"));
                else if(line.trim().equals("."));
                    else System.out.println(line);
        }
    }


}


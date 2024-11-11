package org.example;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Weblog {
    public static void main(String[] args) {
        try(FileInputStream fin = new FileInputStream("weblog.txt");
            Reader in = new InputStreamReader(fin);
            BufferedReader bin = new BufferedReader(in);){
            for (String entry = bin.readLine();
            entry != null;
            entry = bin.readLine()){
                int index = entry.indexOf(' ');
                String ip = entry.substring(0,index);
                String theRest = entry.substring(index);
                try{
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostAddress() + theRest);
                }catch (UnknownHostException ex){
                    System.out.println(entry);
                }
            }

            }catch (IOException ex){
            System.out.println("Exception" + ex);
        }
   }
}

package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadWebPageURLConnection {
    public static void main(String[] args) {
        String urlString = "https://www.w3schools.com/java/";
        try{
            URL u = new URL(urlString);
            URLConnection uc = u.openConnection();
            try(InputStream raw = uc.getInputStream()){
                InputStream buffer = new BufferedInputStream(raw);
                Reader reader = new InputStreamReader(buffer);
                int c;
                while((c = reader.read())!= -1){
                    System.out.print((char) c);
                }
            }
        }catch (MalformedURLException ex){
            System.out.println( urlString+ "is not a parseable URL");
        }catch (IOException ex){
            System.out.println(ex);
        }
    }
}
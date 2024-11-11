package org.example;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CommunicatingWithGet {
    public static void main(String[] args) {
        try{URL u = new URL("https://www.google.com/search?q=hello+world");
            try(InputStream in =new BufferedInputStream(u.openStream())){
                InputStreamReader theHTML = new InputStreamReader(in);
                int c;
                while ((c = theHTML.read()) != -1){
                    System.out.print((char) c);
                }
            }
        }catch( MalformedURLException ex){
            System.out.println(ex + ".");

        }catch(IOException e){
            System.err.println(e);
        }
    }
}

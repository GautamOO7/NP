package org.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CreatingURLConnection {
    public static void main(String[] args) {
        try{
            URL u = new URL("https://www.w3school.com/java");
            URLConnection uc = u.openConnection();

            System.out.println("URL Connection Created Successfully");
            System.out.println("Content Type: " + uc.getContentType());
        }catch (MalformedURLException ex){
            System.err.println(ex);

        }catch (IOException ex){
            System.err.println(ex);
        }
    }
}

package org.example;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateURL {
    public static void main(String[] args) {
        try{
            //Constructing a URL form a string
            URL u1 = new URL("https://tu.edu.np/");

            //Constructing a URL form its component parts
            URL u2 = new URL( "https", "tu.edu.np","/events");

            //Constructing relative URLs
            URL mainURL = new URL("https://tu.edu.np/");
            URL relative = new URL(mainURL, "/campuses");

        }catch(MalformedURLException ex){
            System.err.println(ex);
            ex.printStackTrace();

        }
    }
}

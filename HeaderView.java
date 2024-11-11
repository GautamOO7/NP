package org.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class HeaderView {
    public static void main(String[] args) {
        String urlString = "https://www.w3schools.com/java/";
        try{
            URL u = new URL(urlString);
            URLConnection uc = u.openConnection();
            System.out.println("Connect-Type: " + uc.getContentType());
            if( uc.getContentEncoding() != null){
                System.out.println("Content-Encoding: "+uc.getContentEncoding());
            }
            if(uc.getDate() != 0){
                System.out.println("Date: "+ new Date(uc.getDate()));
            }
            if(uc.getLastModified()!= 0){
                System.out.println("Last Modified: "+ new Date(uc.getLastModified()));
            }
            if (uc.getExpiration() != 0){
                System.out.println("Expiration date: "+ new Date(uc.getExpiration()));
            }
            if(uc.getContentLength() !=-1){
                System.out.println("Content-length: "+uc.getContentLength());
            }
        }catch (MalformedURLException ex){
            System.out.println(urlString + "is not a URL I understand");

        }catch (IOException ex){
            System.out.println(urlString + "is not a URL I understand");
        }
    }
}

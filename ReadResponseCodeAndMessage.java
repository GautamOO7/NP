package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadResponseCodeAndMessage {
    public static void main(String[] args) {
        String urlSting = "https://www.google.com";
        try{
            URL u = new URL(urlSting);
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();
            int code = uc.getResponseCode();
            String response = uc.getResponseMessage();
            System.out.println("HTTP/1.x "+ code + " " + response);
            for(int j = 1; ; j++){
                String header = uc.getHeaderField(j);
                String key = uc.getHeaderFieldKey(j);
                if(header == null || key == null) break;
                System.out.println(uc.getHeaderFieldKey(j) + ": "+ header);
            }
        }catch(MalformedURLException ex){
            System.out.println(urlSting + " is not a parameter URL");
        }catch (IOException ex){
            System.out.println(ex + ".");
        }
    }
}

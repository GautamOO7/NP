package org.example;

import java.net.MalformedURLException;
import java.net.URL;

public class URLSplitter {
    public static void main(String[] args) {
        String urlString = "https://example.com/path/to/resources?query=example#section";
        try{
            URL u = new URL(urlString);
            System.out.println("The URL is : "+u );
            System.out.println("The schema is :"+u.getProtocol());
            System.out.println("The host is :"+u.getHost());
            System.out.println("The authority is :"+u.getAuthority());
            System.out.println("The port is :"+u.getPort());
            System.out.println("The path is :"+u.getPath());
            System.out.println("The query string is :"+u.getQuery());
            System.out.println("The fragment is :"+u.getRef());
        }catch (MalformedURLException ex){
            System.out.println(urlString+ " is not a URL I understand.");

        }
        System.out.println();
    }
}

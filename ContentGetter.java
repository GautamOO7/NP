package org.example;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ContentGetter {
    public static void main(String[] args) {
        try {
            URL u = new URL("https://login.texasintl.duckdns.org/loginpages/tmpl_imgs4/msg_template/tic_only_logo.png");
            Object o = u.getContent();
            System.out.println("I got a " + o.getClass().getName());
        } catch (MalformedURLException ex) {
            System.out.println("Provided URL is not a parseable URl");
        } catch (IOException ex) {
            System.out.println("Exception" + ex);
        }
    }
}
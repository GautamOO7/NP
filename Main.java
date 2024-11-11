package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            //network address
            InetAddress al = InetAddress.getByName("www.texasintl.edu.np");
            System.out.println(al);

            //localhost address
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println(localhost);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}

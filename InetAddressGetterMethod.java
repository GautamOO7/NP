package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressGetterMethod {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.texasintl.edu.np");

            String hostName = inetAddress.getHostName();
            String canonicalHostName = inetAddress.getCanonicalHostName();
            byte[] address = inetAddress.getAddress();
            String hostAddress = inetAddress.getHostName();

            System.out.println(hostName);
            System.out.println(hostAddress);
            System.out.println(address);
            System.out.println(canonicalHostName);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}

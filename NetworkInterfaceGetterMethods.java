package org.example;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkInterfaceGetterMethods {
    public static void main(String[] args) {
        try{
            NetworkInterface ni = NetworkInterface.getByName("wlan1");
            if (ni == null){
                System.out.println("No such interface: wlan0");
            }
            System.out.println("Display name: "+ni.getDisplayName());
            System.out.println("name:"+ni.getName());
            Enumeration<InetAddress> inetAddress = ni.getInetAddresses();
            while(inetAddress.hasMoreElements()){
                InetAddress address = inetAddress.nextElement();
                System.out.println("Inet Address: "+address);
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

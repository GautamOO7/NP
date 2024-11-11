package org.example;


import java.net.InetAddress;
import java.net.UnknownHostException;


public class IPCharacteristics {
    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.texasintl.edu.np");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


        if (address.isAnyLocalAddress()) {
            System.out.println(address + "is a wildcard address");
        }
        if (address.isLoopbackAddress()) {
            System.out.println(address + "is a Loop-back address");
        }

        if (address.isLinkLocalAddress()) {
            System.out.println(address + "is a link address");
        }else if(address.isSiteLocalAddress()) {
            System.out.println(address + "is a site-address.");

        }else{
            System.out.println(address + "is a global address");
        }

        if(address.isMulticastAddress()){
            if(address.isMCGlobal()){
                System.out.println(address + "is a global multicast address");

            } else if (address.isMCLinkLocal()) {
                System.out.println(address + "is an Orgainzational wide multicastaddress.");


            } else if (address.isMCGlobal()) {
                System.out.println(address + "is a site wide multicast address");


            } else if (address.isMCLinkLocal()) {
                System.out.println(address + "is a subnet wide multicast address");


            } else if (address.isMCNodeLocal()) {
                System.out.println(address + "is an interface local multicast address.");

            }else{
                System.out.println(address + "is an unknown multicast address");
            }
            }else {
            System.out.println(address + "is a global unicast address");
        }
    }
}
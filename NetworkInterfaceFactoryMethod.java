package org.example;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class NetworkInterfaceFactoryMethod {
    public static void main(String[] args) {
        try{
            NetworkInterface ni = NetworkInterface.getByName("net0");
            if(ni == null){
                System.out.println("No such interface: net0");
            }

            InetAddress local = InetAddress.getByName("127.0.0.1");
            NetworkInterface ni2 = NetworkInterface.getByInetAddress(local);
            if(ni2 == null ){
                System.out.println("That's weird. No loop_back Address");
            }
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()){
                NetworkInterface nix = interfaces.nextElement();
                System.out.println(nix);
            }

        }catch (SocketException ex){
            System.out.println("Could not list sockets.");

        }catch (UnknownHostException e){
            throw new RuntimeException(e);
        }
    }
}

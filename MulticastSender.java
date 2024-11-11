package org.example.unit11;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MulticastSender {
    public static void main(String[] args) {
        InetAddress ai = null;
        int port = 4800;
        byte ttl = (byte) 1;

        try {
            ai = InetAddress.getByName("All- system.mcast.net");

        }catch (NumberFormatException | IndexOutOfBoundsException | UnknownHostException e) {
            System.out.println(e);
            System.out.println("Usage: java MulticastSender multicast_address port ttl");
            System.exit(1);
        }
        byte[] data = "Here's some multicast data\r\n".getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length,ai,port);
        try(MulticastSocket ms = new MulticastSocket()){
            ms.setTimeToLive(ttl);
            ms.joinGroup(ai);
            for( int i = 1; i<1; i++){
                ms.send(dp);
            }
            ms.leaveGroup(ai);
        }catch (Exception e){
            System.out.println(e);

        }
    }
}

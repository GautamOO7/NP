package org.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    private final static int PORT = 80;
    private static final String HOSTNAME = "localhost";
//    private static final String HOSTNAME = "njxmmx.net";
//    private final static int PORT = 17;

    public static void main(String[] args) {
        try{
            InetAddress address = InetAddress.getByName(HOSTNAME);
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket request = new DatagramPacket(new byte[1],1,address,PORT);
            socket.send(request);
            byte[] buffer = new byte[512];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);
            String quote = new String(buffer, 0,response.getLength());
            System.out.println(quote);
            System.out.println();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

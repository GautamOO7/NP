package org.example.unit11;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

public class MullticastClient {
    public static void main(String[] args) {
        try{
            MulticastSocket socket = new MulticastSocket(4000);

            InetAddress groupAddress = InetAddress.getByName("224.2.2.2");

            socket.joinGroup(groupAddress);

            byte[] buffer = new byte[8192];

            while(true){
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String message = new String(packet.getData(),0,packet.getLength(),"UTF-8");
                System.out.println("Received message: "+ message);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

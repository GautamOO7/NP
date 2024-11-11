package org.example.unit12;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client(){}

    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(9000);

            Hello stub = (Hello) registry.lookup("Hello");

            stub.printMsg();

        }catch (Exception e){
            System.out.println("Client exception:" + e.toString());
            e.printStackTrace();
        }
    }
}
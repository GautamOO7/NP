package org.example.unit12;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ImplExample{
    public Server(){}
    public static void main(String[] args){
        try{
            ImplExample obj = new ImplExample();

            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj,8081);

            Registry registry = LocateRegistry.createRegistry(9000);

            registry.bind("Hello", stub);
            System.out.println("Server is ready");
        }catch (Exception e){
            System.out.println("Server exception: "+ e.toString());
            e.printStackTrace();
        }
    }
}
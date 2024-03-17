package org.example;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = java.rmi.registry.LocateRegistry.getRegistry(args.length == 1 ? args[0] : "127.0.0.1", 1099);
        RemoteInterface remote = (RemoteInterface) registry.lookup("remote");
        remote.sayHello();
    }
}

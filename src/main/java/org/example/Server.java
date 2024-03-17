package org.example;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) throws RemoteException, InterruptedException {
        if (args.length == 1) {
            System.setProperty("java.rmi.server.hostname", args[0]);
        }
        Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1099);
        RemoteImpl remote = new RemoteImpl();
        registry.rebind("remote", UnicastRemoteObject.exportObject(remote, 0));
        Thread.sleep(Long.MAX_VALUE);
    }
}
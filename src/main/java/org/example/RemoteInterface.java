package org.example;

import java.rmi.Remote;

public interface RemoteInterface extends Remote {

    public void sayHello() throws java.rmi.RemoteException;
}

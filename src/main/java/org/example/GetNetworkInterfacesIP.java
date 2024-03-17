package org.example;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;

public class GetNetworkInterfacesIP {

    public static void main(String[] args) {
        try {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
            System.out.println(InetAddress.getLocalHost().getHostName());
            System.out.println(NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getDisplayName());
            System.out.println(NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getName());
        } catch (UnknownHostException e) {
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        try {
            Collections.list(NetworkInterface.getNetworkInterfaces()).forEach(netInterface -> {
                Collections.list(netInterface.getInetAddresses()).forEach(inetAddress -> {
                    if (!inetAddress.isLoopbackAddress() && inetAddress.isSiteLocalAddress()) {
                        System.out.println("Interface: " + netInterface.getName());
                        System.out.println("IP Address: " + inetAddress.getHostAddress());
                    }
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package org.example;

import java.net.NetworkInterface;
import java.util.Collections;

public class GetNetworkInterfacesIP {

    public static void main(String[] args) {
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

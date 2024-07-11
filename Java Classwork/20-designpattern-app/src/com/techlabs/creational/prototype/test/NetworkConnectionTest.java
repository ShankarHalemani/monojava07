package com.techlabs.creational.prototype.test;

import com.techlabs.creational.prototype.model.NetworkConnection;

public class NetworkConnectionTest {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        System.out.println("Creating Object Using prototype design");

        NetworkConnection networkConnection1 = new NetworkConnection();

        networkConnection1.loadVeryImportantData();

        networkConnection1.setIpAddress("172.34.45.10");
        System.out.println(networkConnection1);

        NetworkConnection networkConnection2 = (NetworkConnection) networkConnection1.clone();
        networkConnection2.setIpAddress("192.38.10.13");
        System.out.println(networkConnection2);

        NetworkConnection networkConnection3 = (NetworkConnection) networkConnection1.clone();
        networkConnection3.setIpAddress("10.10.10.10");
        System.out.println(networkConnection3);


    }
}

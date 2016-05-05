package com.Bocharov.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

/**
 * Created by Nodyke on 05.05.2016.
 */
public class RunServer {
    public static void main(String[] args) {
        try
        {

           final int count=3;
            ServerSocket server=new ServerSocket(3000,0, InetAddress.getByName("localhost"));
            System.out.println("Server Start\nWait client!");
            while (true) {
                new MyServer(count,server.accept());
            }
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}

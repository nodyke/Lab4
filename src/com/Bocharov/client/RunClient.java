package com.Bocharov.client;

import java.io.IOException;

/**
 * Created by Nodyke on 05.05.2016.
 */
public class RunClient {
    public static void main(String[] args) {
        try {
            new Client("localhost",3000).start();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}



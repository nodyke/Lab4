package com.Bocharov.client;

import com.Bocharov.input.Input;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Nodyke on 05.05.2016.
 */
public class Client extends Thread {
    Socket client;

    public Client(String hostname, int port) throws IOException {
        client = new Socket(InetAddress.getByName(hostname), port);
    }

    public void run() {
        try( DataOutputStream out = new DataOutputStream(client.getOutputStream());
             DataInputStream in = new DataInputStream(client.getInputStream());
             BufferedReader file = new BufferedReader(new FileReader(new Input().getFilename()));
        ) {
            StringBuilder data = new StringBuilder();
            String i = file.readLine();
                while (i != null) {
                    data.append(i);
                    i = file.readLine();
            }
            file.close();

            out.writeUTF(new String(data));
            out.flush();

            System.out.println(in.readUTF());



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}


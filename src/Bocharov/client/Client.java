package Bocharov.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Nodyke on 05.05.2016.
 */
public class Client extends Thread {
    Socket client;

    public Client(String hostname, int port) throws IOException {
        client = new Socket(InetAddress.getByName(hostname), port);
    }

    public void run() {
        try {


            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter filename:");

            String filename = scanner.nextLine();
            scanner.close();
            BufferedReader file = new BufferedReader(new FileReader(filename));
            StringBuilder data = new StringBuilder();


            String i = file.readLine();
            while (i != null) {
                data.append(i);
                i = file.readLine();
            }
            file.close();
            // InputStream sin = client.getInputStream();
            //OutputStream sout = client.getOutputStream();

            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            //System.out.println(data.toString());
            out.writeUTF(new String(data));
            out.flush();
            //out.close();
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println(in.readUTF());
            in.close();
            out.close();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}


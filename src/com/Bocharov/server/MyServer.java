package com.Bocharov.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by Nodyke on 05.05.2016.
 */
public class MyServer extends Thread {
    int count;
    Socket client;


    public MyServer(int count,Socket client) {
        this.client = client;
        this.count=count;
        setDaemon(true);
        this.start();
    }

    @Override
    public void run() {
        try {

            DataInputStream in=new DataInputStream(client.getInputStream());
            DataOutputStream out=new DataOutputStream(client.getOutputStream());
            String line = null;
            int n=0;

            while (true)
            {
                //System.out.println("work!");
                line=in.readUTF();
                StringBuilder output=new StringBuilder();
                String[] words=line.split("\\.|\\ |\\,|\\-");
                for (int i=0;i<words.length;i++)
                {   n=0;
                    for (String sl:words)
                    {
                        if (words[i].equals(sl))n++;
                    }
                    if (n>=count) {output.append(words[i]);break;}


                }
                if (n>=count) out.writeUTF(new String(output));
                else out.writeUTF(this.count+" Repeated  words are not founded!");
                out.flush();

            }




        } catch (IOException e) {}
    }
}

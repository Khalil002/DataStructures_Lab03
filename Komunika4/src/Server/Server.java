/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Packets.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private static final int PORT = 3000;

    public static HashSet<String> names = new HashSet<String>();

    private static HashSet<ObjectOutputStream> writers = new HashSet<ObjectOutputStream>();

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running.");
        InetAddress ipAddress = null;
        ipAddress = InetAddress.getByName("localhost");
        ServerSocket listener = new ServerSocket(PORT, 0, ipAddress);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    private static class Handler extends Thread {

        private String name;
        private Socket socket;
        private ObjectInputStream in;
        private ObjectOutputStream out;

        public Handler(Socket socket) {
            System.out.println("Connection Established with client " + socket);
            this.socket = socket;
        }

        public void run() {
            try {

                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());

                while (true) {
                    try {
                        Object o = in.readObject();
                        recieved(o);

                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {

                if (name != null) {
                    names.remove(name);
                }
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }

        void recieved(Object data) throws IOException {
            if (data instanceof AddUserPacket) {
                AddUserPacket aup = (AddUserPacket) data;
                names.add(aup.getUsername());
                writers.add(out);
                out.writeObject(new UserListPacket(names));
                for (ObjectOutputStream writer : writers) {
                    if(writer!=out){
                        writer.writeObject(data);
                    }
                }

            } else if (data instanceof RemoveUserPacket) {
                RemoveUserPacket rup = (RemoveUserPacket) data;
                names.remove(rup.getUsername());
                writers.remove(out);
                for (ObjectOutputStream writer : writers) {
                    if(writer!=out){
                        writer.writeObject(data);
                    }
                }
            }else if(data instanceof ChatPacket){
                for (ObjectOutputStream writer : writers) {
                    writer.writeObject(data);
                }
            } else if (data instanceof AudioPacket) {
                for (ObjectOutputStream writer : writers) {
                    if(writer!=out){
                        writer.writeObject(data);
                    }
                }
            }

        }
    }
}

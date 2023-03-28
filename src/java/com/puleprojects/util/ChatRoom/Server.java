/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleprojects.util.ChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author PULE
 */
public class Server implements Runnable {

    private ArrayList<ConnectionHandler> connections;
    private ServerSocket server;
    private boolean done;
    private ExecutorService pool;

    public Server() {
        connections = new ArrayList<>();
        done = false;
    }

    @Override
    public void run() {
        try {
            while (!done) {
                server = new ServerSocket(9999);
                pool = Executors.newCachedThreadPool();
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                pool.execute(handler);
            }
        } catch (IOException ex) {
            shutdown();
        }
    }

    public void broadcast(String message) {
        for (ConnectionHandler ch : connections) {
            if (ch != null) {
                ch.sendMessage(message);
            }
        }
    }

    public void shutdown() {
        done = true;
        if (!server.isClosed())
    try {
            server.close();
        } catch (IOException ex) {
            System.out.println("Error! " + ex.getMessage());
        }
        for (ConnectionHandler ch : connections) {
            ch.shutdown();
        }
    }

    class ConnectionHandler implements Runnable {

        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        private String username;

        public ConnectionHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out.println("Enter Username: ");
                username = in.readLine();
                System.out.println(username + " connected!");
                broadcast(username + "joined chat");
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("/pule ")) {
                        String[] msgSplit = message.split(" ", 2);
                        if (msgSplit.length == 2) {
                            broadcast(username + " renamed to " + msgSplit[1]);
                            System.out.println(username + " renamed to " + msgSplit[1]);
                            username = msgSplit[1];
                            out.println("Successfully renamed to " + username);
                        }
                    } else if (message.startsWith("/quit")) {
                        broadcast(username + "has left");
                        shutdown();
                    } else {
                        broadcast(username + ": " + message);
                    }
                }
                ServerSocket server = new ServerSocket(9999);
                Socket client = server.accept();
            } catch (IOException ex) {
                System.out.println("Error! " + ex.getMessage());
                shutdown();
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }

        public void shutdown() {
            try {
                in.close();;
                out.close();
                if (!client.isClosed()) {
                    client.close();;
                }
            } catch (IOException ex) {
                System.out.println("Error! " + ex.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}

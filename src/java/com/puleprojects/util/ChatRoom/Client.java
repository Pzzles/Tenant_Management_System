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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PULE
 */
public class Client implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private String username;
    private boolean done;

    @Override
    public void run() {
        try {
            Socket client = new Socket("127.0.0.1", 9999);
            out = new PrintWriter(client.getOutputStream(), true);
                       in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                       InputHandler inHandler = new InputHandler();
                       Thread t = new Thread();
                       t.start();
                       
                       String inMsg;
                       while((inMsg = in.readLine()) != null){
                           System.out.println(inMsg);
                       }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    class InputHandler implements Runnable {

        @Override
        public void run() {
BufferedReader inReader  = new BufferedReader(new InputStreamReader(System.in)) ;
      while (!done){
    try {
        String message = inReader.readLine();
        if(message.equals("/quit")){
            inReader.close();
            shutdown();
        } else{
            out.println(message);
        }
    } catch (IOException ex) {
shutdown();
    }
      }
        }
        
    }
    
    
        public void shutdown() {
               done =true;
            try {
           
                
                in.close();
                out.close();
                if (!client.isClosed()) {
                    client.close();;
                }
            } catch (IOException ex) {
            }
        }
        public static void main(String[] args) {
        Client client = new Client();
        
        client.run();
    }
}

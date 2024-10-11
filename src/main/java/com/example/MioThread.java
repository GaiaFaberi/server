package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread{
    Socket s;
    
    public MioThread(Socket s){
        this.s = s;
    }

    public void run(){

        try (BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            
            String stringaRicevuta;

            do{
                stringaRicevuta = in.readLine();
                
                if(!stringaRicevuta.equals("!")){
                    
                    System.out.println("La stringa ricevuta: " + stringaRicevuta);
                    String stringaMaiuscola = stringaRicevuta.toUpperCase();
                    out.writeBytes(stringaMaiuscola + '\n');
                }  
            }while(!stringaRicevuta.equals("!"));
            s.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    
}

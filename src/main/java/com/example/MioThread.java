package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.lang.*;
import java.io.*;
import java.util.*;

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

                switch(stringaRicevuta){
                    case "U":
                        out.writeBytes("frase?" + "\n");
                        String stringaMaiuscola = in.readLine().toUpperCase();
                        out.writeBytes(stringaMaiuscola + '\n');
                        break;

                    case "L":
                        out.writeBytes("frase?" + "\n");
                        String stringaMinuscola = in.readLine().toLowerCase();
                        out.writeBytes(stringaMinuscola + '\n');
                        break; 
                    
                    case "R": 
                        out.writeBytes("frase?" + "\n");
                        String input = in.readLine();
                        StringBuilder input1 = new StringBuilder();
                        input1.append(input);
                        input1.reverse();
                        input = input1.toString();
                        out.writeBytes(input + '\n');
                        break;
                    
                    case "C":
                        out.writeBytes("frase?" + "\n");
                        int cont = in.readLine().length();
                        stringaRicevuta = String.valueOf(cont);
                        out.writeBytes(stringaRicevuta + '\n');
                        break;
                    
                    case "!":
                        break;
                    
                    default:
                        out.writeBytes("!!" + '\n');
                        break;

                }

                
                
            }while(!stringaRicevuta.equals("!"));
            s.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    
}

package ru.sekury.netty.nettyapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try(
            Socket echoSocket = new Socket("localhost", 8080);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {

            String userInput = stdIn.readLine();
            while(userInput != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
                userInput = stdIn.readLine();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

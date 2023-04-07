package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static org.example.ServerConfig.HOST;
import static org.example.ServerConfig.PORT;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try(Socket socket = new Socket(HOST,PORT);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            writer.println("Диадон");

            System.out.println(reader.readLine());

            writer.println(scanner.nextLine());

            System.out.println(reader.readLine());

        }

    }
}
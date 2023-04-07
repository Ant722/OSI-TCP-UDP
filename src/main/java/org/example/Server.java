package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try(ServerSocket server = new ServerSocket(ServerConfig.PORT)) {

            System.out.println("Сервер запущен");

            while (true){
                try(Socket client = server.accept();
                    PrintWriter writer = new PrintWriter(client.getOutputStream(),true);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))){

                    System.out.println("Подключен клиент" + client.getPort());

                    writer.println("Hi from server!");
                    System.out.println(reader.readLine());
                }
            }
        }
    }
}
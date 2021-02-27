package lesson06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String... args) {
        startTextServer();
    }

    private static void startTextServer() {

        try (ServerSocket serverSocket = new ServerSocket(8180)) {

            System.out.println("Server is listening");

            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream());
                 Scanner sc = new Scanner(System.in)) {

                System.out.println("Client is connected");
                out.println("Hello client");
                out.flush();

                String message;

                Thread serverReader = new Thread(() -> {
                    String serverMessage;

                    while (!socket.isClosed()) {
                        serverMessage = sc.nextLine();
                        out.println("Server : " + serverMessage);
                        System.out.println("Server : " + serverMessage);
                        out.flush();
                    }
                });
                serverReader.start();

                do {
                    message = in.readLine();
                    out.println("Client : " + message);
                    System.out.println("Client : " + message);
                    out.flush();
                } while (!message.equalsIgnoreCase("stop"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
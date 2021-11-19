package com.ProjectDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private static final int serverPort = 12345;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            Server server = new Server(serverSocket);
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Onboarding() {
        boolean isRunning = true;
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        While(isRunning){
            try {String ans = input.readLine();

            switch (ans) {
                case "0" -> isRunning = false;
                case "1" -> // registration
                case "2" -> // login
            }
        } catch (IOException e){
                closeEverything(socket, output, input);}
    }


        System.out.println("username" + username);
        String password = input.readLine();
        System.out.println("password" + password);

    }
    public void startServer(){
        try {
            while (!serverSocket.isClosed()){
                Socket socket= serverSocket.accept();
                System.out.println("A new Client has connected");
                ClientHandler clientHandler = new ClientHandler(socket);

                Thread serverThread = new Thread(clientHandler);
                serverThread.start();
            }
        }catch (IOException e){
        }
    }
    public void closeServerSocket(){
        try {
            if(serverSocket != null){
                serverSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package com.ProjectDemo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;
    private static final String host = "localhost";
    private static final int port = 12345;

    public Client(Socket socket, String username){
        try{
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        }catch (IOException e){
            closeEverything(socket, bufferedWriter, bufferedReader);
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //put the username on the Active user map.

        System.out.println("Enter your username to join the chat: ");
        String username = scanner.nextLine();
        Socket socket = new Socket(host,port);
        Client client = new Client(socket,username);

        System.out.println("You joined the chat.");
        client.listenMessage();
        client.sendMessage();


    }
    //just display things here..?

    public void sendMessage(){
        try{
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()){
                String sendTo = scanner.nextLine();
                bufferedWriter.write(username+": "+sendTo);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }catch (IOException e){
            closeEverything(socket, bufferedWriter, bufferedReader);
        }
    }

    public void listenMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String messageFrom;
                while(socket.isConnected()){
                    try{
                        messageFrom = bufferedReader.readLine();
                        System.out.println(messageFrom);
                    }catch (IOException e){
                        closeEverything(socket, bufferedWriter, bufferedReader);
                    }
                }
            }
        }).start();
    }
    public void closeEverything(Socket socket, BufferedWriter bufferedWriter, BufferedReader bufferedReader){
        try{
            if(socket != null){
                socket.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

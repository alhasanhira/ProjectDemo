package com.ProjectDemo;

import com.ProjectDemo.ConstantTexts;
import com.ProjectDemo.Login;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class Client {
    private Socket clientSocket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private static final String host = "localhost";
    private static final Integer port = 1234;

    public Client(Socket clientSocket){
        try{
            this.clientSocket = clientSocket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            this. bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket(host, port);
        Client client = new Client(clientSocket);
        Scanner userInput = new Scanner(System.in);
        while (true){
            System.out.println("1.Register\n2.Login");
            String ans = userInput.nextLine();
            switch (ans) {
                case "0":
                    break;
                case "1":
                    System.out.println("Enter Your Username:");
                    String username = userInput.nextLine();
                    System.out.println("Enter a password:");
                    String password = userInput.nextLine();
                    String data = ConstantTexts.register + ":" + username + ":" + password;
                    client.sendMessage(data);
                    break;
                case "2":
                    Login.loginUser(userInput);
                    break;
            }
        }

    }

    public void sendMessage(String sendTo){
        try{
            bufferedWriter.write(sendTo);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        }catch (IOException e){
            closeEverything(clientSocket, bufferedWriter, bufferedReader);
        }
    }

    public void listenMessage(){
        String messageFrom;
        while(clientSocket.isConnected()){
            try{
                messageFrom = bufferedReader.readLine();
                System.out.println(messageFrom);
            }catch (IOException e){
                closeEverything(clientSocket, bufferedWriter, bufferedReader);
            }
        }
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

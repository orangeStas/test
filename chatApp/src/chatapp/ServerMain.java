/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author OrangeUser
 */
public class ServerMain implements Runnable{

    ArrayList clientOutputStreams;
    ArrayList<String> onlineUsers;

    
    /*Start server method*/
    public void run() {
        clientOutputStreams = new ArrayList();
        onlineUsers = new ArrayList();
        try {
            ServerSocket serverSock = new ServerSocket(5555);//initializing new server socket with port

            while (true) {
                Socket clientSock = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSock.getOutputStream()); // intializing writer for adding client to list of clients
                clientOutputStreams.add(writer);

                Thread listener = new Thread(new ServerMain.ClientHandler(clientSock, writer));//creating a new thread for a new client
                listener.start();
                System.out.println("Сервер создан.");
                System.out.println("Соединение установлено.");
            }
        } catch (Exception ex) {
            System.out.println("Ошибка установления соединения.");
        }

    }
    
    /*Class, that establish connection between server and clients, and get requests from clients*/
    public class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket socket;
        PrintWriter client;

        public ClientHandler(Socket clientSocket, PrintWriter user) {
            client = user;
            try {
                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader); //reader gets messages from sockets from clients
            } catch (Exception ex) {
                System.out.println("Ошибка инициализации потока");
            }

        }

        public void run() {
            String message, connect = "Connect", disconnect = "Disconnect", textMessage = "Message";
            String[] data;

            try {
                while ((message = reader.readLine()) != null) { //reader gets message and define command from client

                    System.out.println("Получено: " + message);
                    data = message.split(":");
                    String command = data[2], userName = data[0];
                   
                    /*if client try to connect to Server*/
                    if (command.equals(connect)) {
                        tellEveryone((userName + ":подключился." + ":" + textMessage));
                        userAdd(userName);
                    /*if client try to disconnect from Server*/
                    } else if (command.equals(disconnect)) {
                        tellEveryone((userName + ":отключился." + ":" + textMessage));
                        userRemove(userName);
                    /*if client send a message*/
                    } else if (command.equals(textMessage)) {
                        tellEveryone(message);
                    /*else server can't define command from client*/
                    } else {
                        System.out.println("Данные не получены.");
                    }

                }
            } catch (Exception ex) {
                System.out.println("Соединение потеряно.");
                ex.printStackTrace();
                clientOutputStreams.remove(client);
            }
        }
    }

    /*Method, that add a new user in chat*/
    public void userAdd(String data) {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        System.out.println(name + " добавлен.");
        onlineUsers.add(name);
        String[] tempList = new String[(onlineUsers.size())];
        onlineUsers.toArray(tempList);

        /*Server checks all users with a new user*/
        for (String token : tempList) {
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }

    /*Method, that remove user from chat*/
    public void userRemove(String data) {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        onlineUsers.remove(name);
        String[] tempList = new String[(onlineUsers.size())];
        onlineUsers.toArray(tempList);
        
        /*Server checks all users*/
        for (String token : tempList) {

            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
        Thread.currentThread().interrupt(); 
    }

    /*Method, that send server answers to connected users*/
    public void tellEveryone(String message) {
        Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                System.out.println("Отправка: " + message);
                writer.flush();

            } catch (Exception ex) {
                System.out.println("Ошибка сообщения.");
            }
        }
    }

}

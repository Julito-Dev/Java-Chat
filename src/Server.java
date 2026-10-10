package src;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.List;


// Esta clase deberia poder crear un server y dejarlo listo para escuchar a los clientes
public class Server{

    private static final List<ClientManager> clients = new ArrayList<>();

    public synchronized static void broadcast(String message, ClientManager from){
        for (ClientManager client : clients){
            if (client != from){
                client.send(message);
            }
        }
    }

    public synchronized static void removeClient(ClientManager client){
        clients.remove(client);
    }

    public static void main(String[] args) {

        try{
        // Create the server
        ServerSocket server = new ServerSocket(1020, 10);
        System.out.println("The Server is listening in the port 1020");

        /// LISTENING LOGIC
        
        while(true){
            Socket socket1 = server.accept(); 
            ClientManager client1 = new ClientManager(socket1);
            clients.add(client1);
            client1.start();
        }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
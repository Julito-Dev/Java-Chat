import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;


// Esta clase deberia poder crear un server y deejarlo listo para escuchar a los clientes
public class Server{
    public static void main(String[] args) {

        try{
        // Create the server
        ServerSocket server = new ServerSocket(1020, 10);
        System.out.println("The Server is listening in the port 1020");

        /// LISTENING LOGIC
        
        while(true){
            Socket socket1 = server.accept();  // For now, just one client
            ClientManager client1 = new ClientManager(socket1);
            client1.start();
        }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }
} q
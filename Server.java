import java.io.IOException;
import java.net.ServerSocket;

// Esta clase deberia poder crear un server y deejarlo listo para escuchar a los clientes
public class Server{
    public static void main(String[] args) {

        try{
        // Create the server
        ServerSocket server = new ServerSocket(1020, 10); // Only 10 clients in the Queue
        System.out.println("The Server is listening in the port 1020");

        /// LISTENING LOGIC
        

        
        //Closing the Server
        server.close();
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }
} 

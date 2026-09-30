import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;

// Esta clase deberia poder crear un server y deejarlo listo para escuchar a los clientes
public class Server{
    public static void main(String[] args) {

        try{
        // Create the server
        ServerSocket server = new ServerSocket(1020, 10); // Only 10 clients in the Queue
        System.out.println("The Server is listening in the port 1020");

        /// LISTENING LOGIC
        
        
        Socket socket1 = server.accept();  // For now, just one client

        // Config the inputStreams

        BufferedReader input = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        PrintWriter output = new PrintWriter(socket1.getOutputStream(), true);


        // Read the message from the client
        String inputLine;
        while ((inputLine = input.readLine()) != null) {
            System.out.print("Message received from the client: "+ inputLine);
            output.print("Server received: " + inputLine);
        } 
        
        
        //Closing the Server
        server.close();
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
    }
} 

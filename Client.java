import java.io.*;
import java.net.*;

class ClientManager extends Thread{
    private Socket socket;

    public ClientManager(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = input.readLine()) != null){
                System.out.print("Received from the client: " + inputLine);
                output.println("Server Received: "  + inputLine);
            }

            socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

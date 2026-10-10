package src;

import java.io.*;
import java.net.*;

class ClientManager extends Thread{
    private Socket socket;
    private PrintWriter output;

    public ClientManager(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            System.out.println("Client connected: " + socket.getInetAddress() + ":" + socket.getPort());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = input.readLine()) != null){
                System.out.println("Received Message: " + inputLine);
                Server.broadcast(inputLine, this);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            Server.removeClient(this);
            try { socket.close(); } catch (IOException ignored) {}
        }
    }

    public void send(String message){
        output.println(message);
    }
}
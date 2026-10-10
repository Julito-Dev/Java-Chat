package src;

import inter.ChatService;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class NetClient implements ChatService {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private final List<Consumer<String>> listeners = new ArrayList<>();

    public NetClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Hilo que recibe y llama a los listeners por mensaje
        new Thread(() -> {
            String line;
            try {
                while ((line = in.readLine()) != null) {
                    final String message = line;
                    listeners.forEach(l -> l.accept(message));
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public String sendMessage(String message){
        out.println(message);
        return message;
    }

    @Override
    public void addMessageListener(Consumer<String> listener){
        listeners.add(listener);
    } 
}
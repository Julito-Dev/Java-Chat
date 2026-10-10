package inter;

import java.util.function.Consumer;

public interface ChatService {

    // Enviar Mensaje
    public String sendMessage(String mensaje);

    // Recibir Mensaje
    public void addMessageListener(Consumer<String> listener); 


}
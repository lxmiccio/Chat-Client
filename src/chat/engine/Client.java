package chat.engine;

import chat.gui.JChat;
import java.io.*;
import java.net.*;

/**
 *
 * @author Alex
 */
public class Client implements Runnable {

    private JChat jChat;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Socket socket;
    private String name;

    public Client(String serverAddress, int port, String name) {
        if (serverAddress == null || serverAddress.length() <= 0) {
            throw new IllegalArgumentException("Server Address cannot be null");
        }
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("Port must be between 0 and 65535, inclusive");
        }
        try {
            this.socket = new Socket(serverAddress, port);
            this.objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (name == null || name.length() <= 0) {
            this.name = "Anonymous";
        } else {
            this.name = name;
        }
        this.jChat = new JChat(this);
        this.jChat.initialize();
    }

    @Override
    public void run() {
        this.writeName();
        this.readMessage();
    }

    private void writeName() {
        try {
            this.objectOutputStream.writeUTF(this.name);
            this.objectOutputStream.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void readMessage() {
        boolean listen = true;
        while (listen) {
            try {
                this.jChat.addMessage((Message) this.objectInputStream.readObject());
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }
}

package chat.client;

import chat.client.gui.chat.*;
import chat.engine.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author Alex
 */
public class Client implements Runnable {

    private JChat jChat;
    private Socket socket;
    private String name;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public Client(String serverAddress, int port, String name) {
        if (serverAddress == null || serverAddress.length() <= 0) {
            throw new IllegalArgumentException("Server Address cannot be null");
        }
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("Port must be between 0 and 65535, inclusive");
        }
        try {
            this.socket = new Socket(serverAddress, port);

            this.jChat = new JChat(this);
            this.jChat.initialize();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        if (name == null || name.length() <= 0) {
            this.name = "Anonymous";
        } else {
            this.name = name;
        }
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    @Override
    public void run() {
        try {
            this.objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
            this.objectOutputStream.flush();
            this.objectInputStream = new ObjectInputStream(this.socket.getInputStream());
            System.out.println("asad");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        try {
            this.objectOutputStream.writeUTF(this.name);
            this.objectOutputStream.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        boolean listen = true;
        while (listen) {
            try {
                Message m = (Message) this.objectInputStream.readObject();
                System.out.println(m.getText());
                this.jChat.addMessage(m);
            } catch (IOException exception) {
                exception.printStackTrace();
            } catch (ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}

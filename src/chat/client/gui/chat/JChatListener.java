package chat.client.gui.chat;

import java.awt.event.*;
import java.io.*;

/**
 *
 * @author Alex
 */
public class JChatListener implements ActionListener, WindowListener {

    private JChat jChat;

    public JChatListener(JChat jChat) {
        if (jChat == null) {
            throw new IllegalArgumentException("JChat cannot be null");
        }
        this.jChat = jChat;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.jChat.getBtnSend()) {
            try {
                this.jChat.getClient().getObjectOutputStream().writeUTF(this.jChat.getTxtMessage().getText());
                this.jChat.getClient().getObjectOutputStream().flush();
            } catch (IOException exception) {
                System.err.println("IOException");
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        try {
            this.jChat.getClient().getObjectOutputStream().writeUTF("Exit");
            this.jChat.getClient().getObjectOutputStream().flush();
            
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
    }
}

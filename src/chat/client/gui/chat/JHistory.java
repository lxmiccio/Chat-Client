package chat.client.gui.chat;

import chat.engine.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class JHistory extends JPanel {

    private ArrayList<JMessage> messages;
    private GridBagConstraints gridBagConstraints;

    public JHistory() {
        this.messages = new ArrayList<>();
    }

    public void initialize() {
        this.setLayout(new GridBagLayout());
        this.gridBagConstraints = new GridBagConstraints();

        this.gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.gridBagConstraints.gridheight = 1;
        this.gridBagConstraints.gridwidth = 1;
        this.gridBagConstraints.gridx = 0;
        this.gridBagConstraints.gridy = -1;
        this.gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        this.gridBagConstraints.weightx = 1;
        this.gridBagConstraints.weighty = 0;
    }

    public void addMessage(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        JMessage jMessage = new JMessage(message);
        jMessage.initialize();

        this.messages.add(jMessage);

        this.add(jMessage, this.gridBagConstraints);
        this.gridBagConstraints.gridy = this.gridBagConstraints.gridy + 1;

        this.revalidate();
    }
}
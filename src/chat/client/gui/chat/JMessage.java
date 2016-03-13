package chat.client.gui.chat;

import chat.engine.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class JMessage extends JPanel {

    private JLabel lblTime;
    private JLabel lblUsername;
    private JLabel lblText;

    public JMessage(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        this.lblTime = new JLabel(message.getTime());
        this.lblUsername = new JLabel(message.getUsername());
        this.lblText = new JLabel(message.getText());
    }

    public void initialize() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 30, 5, 15);
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        this.add(this.lblTime, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 15, 5, 15);
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        this.add(this.lblUsername, gridBagConstraints);

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 15, 5, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.lblText, gridBagConstraints);
    }
}

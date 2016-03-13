package chat.gui;

import chat.engine.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class JChat extends JFrame {

    private Client client;
    private JPanel pnlServices;
    private JScrollPane scrPnServices;
    private JTextField txtMessage;
    private JButton btnSend;
    private GridBagConstraints gridBagConstraints;

    public JChat(Client client) {
        this.client = client;
        this.pnlServices = new JPanel();
        this.pnlServices.setLayout(new GridBagLayout());
        this.scrPnServices = new JScrollPane();
        this.scrPnServices.setViewportView(this.pnlServices);
        this.txtMessage = new JTextField();
        this.btnSend = new JButton("Send");
        this.gridBagConstraints = new GridBagConstraints();
        this.gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.gridBagConstraints.gridheight = 1;
        this.gridBagConstraints.gridwidth = 1;
        this.gridBagConstraints.gridx = 0;
        this.gridBagConstraints.gridy = -1;
        this.gridBagConstraints.insets = new Insets(5, 10, 5, 10);
        this.gridBagConstraints.weightx = 1;
        this.gridBagConstraints.weighty = 0;
    }

    public void initialize() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(30, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        this.add(this.scrPnServices, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(15, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        this.add(this.txtMessage, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(15, 30, 30, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        this.add(this.btnSend, gridBagConstraints);
        this.setSize(new Dimension(750, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Chat");
        this.setVisible(true);
        this.btnSend.addActionListener(new JChatListener(this));
        this.addWindowListener(new JChatListener(this));
    }

    public Client getClient() {
        return client;
    }

    public void addMessage(Message message) {
        AdjustmentListener adjustmentListener = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
                adjustmentEvent.getAdjustable().setValue(adjustmentEvent.getAdjustable().getMaximum());
                scrPnServices.getVerticalScrollBar().removeAdjustmentListener(this);
            }
        };
        this.scrPnServices.getVerticalScrollBar().addAdjustmentListener(adjustmentListener);

        this.gridBagConstraints.gridy++;
        this.pnlServices.add(message.getJPanel(), this.gridBagConstraints);

        this.pnlServices.revalidate();
    }

    public JTextField getTxtMessage() {
        return txtMessage;
    }
}

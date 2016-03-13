package chat.gui;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Alex
 */
public class JForm extends JFrame {

    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblTaskIp;
    private JComboBox cmbByte1;
    private JLabel lblDot1;
    private JComboBox cmbByte2;
    private JLabel lblDot2;
    private JComboBox cmbByte3;
    private JLabel lblDot3;
    private JComboBox cmbByte4;
    private JLabel lblTaskPort;
    private JComboBox cmbPort;
    private JButton btnConnect;

    public JForm() {
        this.lblName = new JLabel("Enter your name");
        this.lblName.setHorizontalAlignment(SwingConstants.CENTER);
        this.txtName = new JTextField();
        this.lblTaskIp = new JLabel("Select the IP address of the server");
        this.lblTaskIp.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultComboBoxModel modelCmbByte1 = new DefaultComboBoxModel();
        this.cmbByte1 = new JComboBox(modelCmbByte1);
        this.lblDot1 = new JLabel(".");
        DefaultComboBoxModel modelCmbByte2 = new DefaultComboBoxModel();
        this.cmbByte2 = new JComboBox(modelCmbByte2);
        this.lblDot2 = new JLabel(".");
        DefaultComboBoxModel modelCmbByte3 = new DefaultComboBoxModel();
        this.cmbByte3 = new JComboBox(modelCmbByte3);
        this.lblDot3 = new JLabel(".");
        DefaultComboBoxModel modelCmbByte4 = new DefaultComboBoxModel();
        this.cmbByte4 = new JComboBox(modelCmbByte4);
        this.lblTaskPort = new JLabel("Select the port");
        this.lblTaskPort.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultComboBoxModel modelCmbPort = new DefaultComboBoxModel();
        this.cmbPort = new JComboBox(modelCmbPort);
        this.btnConnect = new JButton("Connect");
        for (int iterator = 0; iterator < 65536; iterator++) {
            if (iterator < 256) {
                modelCmbByte1.addElement(iterator);
                modelCmbByte2.addElement(iterator);
                modelCmbByte3.addElement(iterator);
                modelCmbByte4.addElement(iterator);
            }
            modelCmbPort.addElement(iterator);
            this.cmbByte1.setSelectedItem(127);
            this.cmbByte2.setSelectedItem(0);
            this.cmbByte3.setSelectedItem(0);
            this.cmbByte4.setSelectedItem(1);
            this.cmbPort.setSelectedItem(9999);
        }
    }

    public void initialize() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(30, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        this.add(this.lblName, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(15, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        this.add(this.txtName, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(15, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        this.add(this.lblTaskIp, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 30, 15, 3);
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 0;
        this.add(this.cmbByte1, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(25, 2, 15, 2);
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        this.add(this.lblDot1, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 2, 15, 2);
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 0;
        this.add(this.cmbByte2, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(25, 2, 15, 2);
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        this.add(this.lblDot2, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 2, 15, 2);
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 0;
        this.add(this.cmbByte3, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(25, 2, 15, 2);
        gridBagConstraints.weightx = 0;
        gridBagConstraints.weighty = 0;
        this.add(this.lblDot3, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 2, 15, 30);
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.weighty = 0;
        this.add(this.cmbByte4, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(15, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        this.add(this.lblTaskPort, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(15, 30, 15, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        this.add(this.cmbPort, gridBagConstraints);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new Insets(15, 30, 30, 30);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 0;
        this.add(this.btnConnect, gridBagConstraints);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Chat");
        this.setVisible(true);
        this.btnConnect.addActionListener(new JFormListener(this));
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JComboBox getCmbByte1() {
        return cmbByte1;
    }

    public JComboBox getCmbByte2() {
        return cmbByte2;
    }

    public JComboBox getCmbByte3() {
        return cmbByte3;
    }

    public JComboBox getCmbByte4() {
        return cmbByte4;
    }

    public JComboBox getCmbPort() {
        return cmbPort;
    }

    public JButton getBtnConnect() {
        return btnConnect;
    }
}

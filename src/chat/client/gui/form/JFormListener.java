package chat.client.gui.form;

import chat.client.*;
import java.awt.event.*;

/**
 *
 * @author Alex
 */
public class JFormListener implements ActionListener {

    private JForm jForm;

    public JFormListener(JForm jForm) {
        if (jForm == null) {
            throw new IllegalArgumentException("JForm cannot be null");
        }
        this.jForm = jForm;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.jForm.getBtnConnect()) {
            this.jForm.dispose();
            new Thread(new Client(this.jForm.getCmbByte1().getSelectedItem() + "." + this.jForm.getCmbByte2().getSelectedItem() + "." + this.jForm.getCmbByte3().getSelectedItem() + "." + this.jForm.getCmbByte4().getSelectedItem(), (int) this.jForm.getCmbPort().getSelectedItem(), this.jForm.getTxtName().getText())).start();
        }
    }
}

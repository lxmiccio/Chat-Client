package chat.gui;

import chat.engine.Client;
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
        this.jForm.dispose();
        new Thread(new Client(this.jForm.getCmbByte1().getSelectedItem() + "." + this.jForm.getCmbByte2().getSelectedItem() + "." + this.jForm.getCmbByte3().getSelectedItem() + "." + this.jForm.getCmbByte4().getSelectedItem(), (int) this.jForm.getCmbPort().getSelectedItem(), this.jForm.getTxtName().getText())).start();
    }
}

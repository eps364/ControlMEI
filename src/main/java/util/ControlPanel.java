package util;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ControlPanel {

    /**
     * Method responsible for clearing fields
     * @param pane - waits argument type JPanel
     */
    public static void clean(JPanel pane) {

        Component[] comp = pane.getComponents();
        for (Component c : comp) {
            if (c instanceof JTextField) {
                JTextField field = (JTextField) c;
                field.setText("");
            }
            if (c instanceof JDateChooser) {
                JDateChooser chooser = (JDateChooser) c;
                chooser.setDate(new java.util.Date());
            }

        }

    }

    public static void borderLabel(JPanel pane) {
        Component[] comp = pane.getComponents();
        for (Component c : comp) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setBorder(new EmptyBorder(0, 2, 0, 0));
            }

        }
    }

}

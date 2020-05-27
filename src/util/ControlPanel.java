/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author colpv
 */
public class ControlPanel {

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
                label.setBorder(new EmptyBorder(0,2,0,0));
            }

        }
    }

}

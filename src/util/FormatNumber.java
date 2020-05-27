/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import enu.FieldChar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatter;

/**
 *
 * @author colpv
 */
public class FormatNumber {

    public static void formatFieldPoint(JTextField field, FieldChar ch) {

        field.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent evt) {
                char ev = evt.getKeyChar();
                String charList = field.getText();
                if (Character.isLetter(ev)) {
                    evt.consume();
                } else {
                    switch (ch) {

                        case vk_comma:
                            if (ev < 47 || ev > 57) {
                                if (ev == KeyEvent.VK_COMMA) {
                                    for (char c : charList.toCharArray()) {
                                        if (ev == c) {
                                            evt.consume();
                                        }
                                    }
                                } else {
                                    evt.consume();
                                }
                            }
                            break;

                        case vk_period:
                            if (ev < 47 || ev > 57) {
                                if (ev == KeyEvent.VK_PERIOD) {
                                    for (char c : charList.toCharArray()) {
                                        if (ev == c) {
                                            evt.consume();
                                        }
                                    }
                                } else {
                                    evt.consume();
                                }
                            }
                            break;

                        default:
                            if (ev < 47 || ev > 57) {
                                evt.consume();
                            }
                            break;
                    }
                }

            }

        });

    }

    public static void spinnerNumber(JSpinner spinner) {
        JSpinner.NumberEditor jsEditor = (JSpinner.NumberEditor) spinner.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) jsEditor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        spinner.setEditor(jsEditor);
    }
}

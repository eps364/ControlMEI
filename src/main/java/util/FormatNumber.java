
package util;

import enu.FieldChar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatter;

 // Configure number format
public class FormatNumber {

   /**
    * @param field - insert value JTextField
    * @param fielChar - insert enumeration type FieldChar
    */
    public static void formatFieldPoint(JTextField field, FieldChar fielChar) {

        field.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent evt) {
                char ev = evt.getKeyChar();
                String charList = field.getText();
                if (Character.isLetter(ev)) {
                    evt.consume();
                } else {
                    switch (fielChar) {

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

    /**
     * @param spinner - Char insert blocked
     */
    public static void spinnerNumber(JSpinner spinner) {
        JSpinner.NumberEditor jsEditor = (JSpinner.NumberEditor) spinner.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) jsEditor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        spinner.setEditor(jsEditor);
    }
}

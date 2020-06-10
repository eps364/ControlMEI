package util;

import com.toedter.calendar.JDateChooser;
import enu.ButtonEnum;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ControlPanel {

    private static boolean newButton, saveButton, deleteButton;

    /**
     * Method responsible to clearing fields
     *
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

    public static boolean controlDialogButton(ButtonEnum enu, JButton delete, JButton nnew, JButton save) {

        switch (enu) {
            case NEW_BUTTON: // click newbutton
                saveButton = true;
                newButton = false;
                deleteButton = false;
                break;
            case MASTER_TABLE:// clicked masterTable

                newButton = false;
                saveButton = true;
                deleteButton = true;

                break;
            case SAVE_BUTTON: //clicked savebutton
                newButton = true;
                saveButton = false;
                deleteButton = false;
                break;

            default: //clicked cancelbutton
                newButton = true;
                saveButton = false;
                deleteButton = false;
                break;

        }

        delete.setEnabled(deleteButton);
        save.setEnabled(saveButton);
        nnew.setEnabled(newButton);
        return saveButton;
    }

    public static boolean optionPaneSave(String msg) {
        int continuer = JOptionPane.showConfirmDialog(null, msg.concat("\nDo you want to continue on this screen?"), "Continue...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return continuer == JOptionPane.NO_OPTION;

    }

    // Regex expression
    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern PATTERN = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public static boolean emailValidate(String email) {
        Matcher matcher = PATTERN.matcher(email);
        return matcher.matches();
    }

}

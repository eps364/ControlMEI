package util;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventJCalendar {

   private static int key;

    public static int keyEventCode(JDateChooser chooser) {

        chooser.getDateEditor().getUiComponent().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                key = e.getKeyChar();

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        return key;
    }

}

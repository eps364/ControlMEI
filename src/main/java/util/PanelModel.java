/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author colpv
 */
public class PanelModel extends JPanel{
    private final Image img;
    
        public PanelModel() {
        img = new ImageIcon(getClass().getResource("/img/photo.png")).getImage();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D dg = (Graphics2D) g;
        int width = (this.getWidth() / 2);
        int height = (this.getHeight() / 2);
        g.drawImage(img, 0, 0, width * 2, height * 2, this);

    }
    
    
    
    
    
}

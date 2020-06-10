package util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ControlImage {

    private ImageIcon icon;

    public ControlImage(String path) throws Exception {
        try {

            BufferedImage bufferedImage = ImageIO.read(new File(path));
            Image img = bufferedImage.getScaledInstance(170, 205, Image.SCALE_SMOOTH);
            icon = new ImageIcon(img);
        } catch (IOException e) {
            System.out.println("Image not found:\n".concat(e.getMessage()));
        }
    }

    //Method responsible for filtering the extensions
    public static FileNameExtensionFilter getFilter() {
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
                "Image size (170 X 205)", ImageIO.getReaderFileSuffixes());
        return imageFilter;
    }

    public ImageIcon imageIcon() {
        return icon;
    }

}

package util;

import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FilterImage {
    
    
    
//Method responsible for filtering the extensions
    public static FileNameExtensionFilter getFilter() {
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter(
                "Image size (176 X 196)", ImageIO.getReaderFileSuffixes());
        return imageFilter;
    }

}

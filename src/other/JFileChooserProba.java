package other;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author laszlo.nagy
 */
public class JFileChooserProba {
 
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        
        System.out.println("JFileChooserProba");
        
        //Ez azért kell, hogy bal oldalon megjelenjenek a gyorsgombok
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        //A file választó megjelenítése
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);
            
    }
}

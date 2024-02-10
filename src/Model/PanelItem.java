
package Model;

import java.awt.Color;
import javax.swing.JPanel;


public class PanelItem extends JPanel{
    
    public PanelItem(){
        setBackground(Color.WHITE);                 // arka plan rengi  beyaz
        setLayout(new WrapLayout(WrapLayout.LEFT,10,10));
    }
    
}

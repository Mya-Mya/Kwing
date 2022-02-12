package kwing.swing.ui;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(){
        super();
        setForeground(Colors.light);
        setBackground(Colors.dark);
        setFont(Fonts.middle);
        setOpaque(false);
        setFocusable(false);
    }
}

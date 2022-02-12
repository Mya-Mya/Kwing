package kwing.swing.ui;

import javax.swing.*;
import java.awt.*;

public class WrappableLabel extends JTextArea {
    public WrappableLabel() {
        super();
        setForeground(Colors.light);
        setBackground(Colors.dark);
        setFont(Fonts.middle);
        setLineWrap(true);
        setMargin(new Insets(20, 10, 20, 10));
        setEditable(false);
        setOpaque(false);
        setFocusable(false);
    }
}

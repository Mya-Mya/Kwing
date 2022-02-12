package kwing.swing.ui;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    public Panel() {
        super();
        setBackground(Colors.dark);
        setForeground(Colors.light);
        setLayout(new GridLayout(1, 1));
    }

    public Panel(boolean hasBorder) {
        this();
        if (hasBorder) {
            setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        }
    }
}

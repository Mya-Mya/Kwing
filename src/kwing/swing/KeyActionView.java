package kwing.swing;

import kwing.swing.ui.Colors;
import kwing.swing.ui.Label;
import kwing.swing.ui.Panel;

import java.awt.*;

public class KeyActionView extends Panel {
    public KeyActionView(String keyText, String description) {
        super();
        setBackground(Colors.gray);
        setLayout(new FlowLayout() {{
            setAlignment(FlowLayout.LEFT);
            setHgap(5);
        }});
        setPreferredSize(new Dimension(300, 30));
        Label left = new Label() {{
            setPreferredSize(new Dimension(30, 30));
            setText(keyText);
            setBackground(Colors.primary);
            setForeground(Colors.dark);
            setHorizontalAlignment(CENTER);
            setOpaque(true);
        }};
        Label center = new Label() {{
            setText(description);
        }};
        add(left, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
    }
}

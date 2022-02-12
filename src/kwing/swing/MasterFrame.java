package kwing.swing;

import kwing.core.KeyHandlerGroupManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MasterFrame extends JFrame {
    private final Container contentPane;
    private Scene scene;

    public MasterFrame() {
        super();
        setPreferredSize(new Dimension(720, 480));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyHandlerGroupManager.onKeyPressed(SwingKeys.getKwingKey(e.getKeyCode()));
            }
        });
        this.contentPane = getContentPane();
        pack();
        setVisible(true);
    }

    public void changeScene(Scene scene) {
        if (this.scene != null) {
            this.scene.onInactive();
        }
        this.scene = scene;
        this.scene.onActive();
        contentPane.removeAll();
        contentPane.add(this.scene);
        validate();
    }
}

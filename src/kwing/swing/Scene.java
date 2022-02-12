package kwing.swing;

import kwing.core.KeyHandler;
import kwing.core.KeyHandlerGroup;
import kwing.core.KeyHandlerGroupManager;
import kwing.core.KwingKey;
import kwing.swing.ui.Colors;
import kwing.swing.ui.Panel;
import kwing.swing.ui.ScrollPane;
import kwing.swing.ui.WrappableLabel;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class Scene extends Panel {
    private final Panel keyActionViewContainer;
    private final Panel contentPane;
    private final KeyHandlerGroup mKeyHandlerGroup;

    public Scene() {
        this(Collections.EMPTY_LIST);
    }

    public Scene(String message, List<KeyAction> actions) {
        this(new Panel() {{
            add(new ScrollPane(new WrappableLabel() {{
                setText(message);
            }}));
        }}, actions);
    }

    public Scene(List<KeyAction> actions) {
        this(new Panel() , actions);
    }

    public Scene(Panel vContentPane, List<KeyAction> actions) {
        super();
        this.contentPane = vContentPane;
        mKeyHandlerGroup = new KeyHandlerGroup();

        keyActionViewContainer = new Panel(true) {{
            setBackground(Colors.gray);
            setLayout(new GridLayout(-1, 1, 0, 0));
        }};
        Panel vKeyActionsPane = new Panel() {{
            setBackground(Colors.gray);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            add(Box.createVerticalGlue());
            add(keyActionViewContainer);
            add(Box.createVerticalGlue());
        }};

        setLayout(new BorderLayout());
        add(vContentPane, BorderLayout.CENTER);
        add(vKeyActionsPane, BorderLayout.WEST);

        actions.forEach(Scene.this::addKeyAction);
    }

    public void addKeyAction(KeyAction a) {
        keyActionViewContainer.add(new KeyActionView(a.keyText, a.description));
        mKeyHandlerGroup.addKeyHandler(a.toKeyHandler());
    }

    public Panel getContentPane() {
        return contentPane;
    }

    public void onActive() {
        KeyHandlerGroupManager.setActiveKeyHandlerGroup(mKeyHandlerGroup);
    }

    public void onInactive() {
        KeyHandlerGroupManager.setActiveKeyHandlerGroup(null);
    }

    public static class KeyAction {
        public final KwingKey key;
        public final String keyText;
        public final String description;
        public final Runnable handler;

        public KeyAction(KwingKey key, Runnable handler, String description) {
            this(key, handler, description, key.toString());
        }

        public KeyAction(KwingKey key, Runnable handler, String description, String keyText) {
            this.handler = handler;
            this.key = key;
            this.description = description;
            this.keyText = keyText;
        }

        public KeyHandler toKeyHandler() {
            return new KeyHandler(key, handler);
        }
    }
}

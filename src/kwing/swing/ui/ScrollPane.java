package kwing.swing.ui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ScrollPane extends JScrollPane {
    public ScrollPane(Component view) {
        super(view);
        setBorder(null);
        viewport.setBackground(Colors.dark);
        setBackground(Colors.dark);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBar(new ScrollBar());
    }

    private static class ScrollBar extends JScrollBar {
        public ScrollBar() {
            super();
            Color transparent = new Color(0, 0, 0, 0);
            setUI(new BasicScrollBarUI() {
                @Override
                protected JButton createIncreaseButton(int orientation) {
                    return new BasicArrowButton(orientation,
                            Colors.primary,
                            transparent,
                            transparent,
                            transparent);
                }

                @Override
                protected JButton createDecreaseButton(int orientation) {
                    return new BasicArrowButton(orientation,
                            Colors.primary,
                            transparent,
                            transparent,
                            transparent);
                }

                @Override
                protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                    if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
                        return;
                    }
                    int w = thumbBounds.width;
                    int h = thumbBounds.height;
                    g.translate(thumbBounds.x, thumbBounds.y);
                    g.setColor(isDragging ? Colors.gray : Colors.primary);
                    g.fillRect(0, 0, w, h);
                    g.translate(-thumbBounds.x, -thumbBounds.y);
                }

                @Override
                protected void paintDecreaseHighlight(Graphics g) {
                }

                @Override
                protected void paintIncreaseHighlight(Graphics g) {
                }

                @Override
                protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                    g.setColor(Colors.light);
                    g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
                }
            });
        }
    }
}

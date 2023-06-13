/*
 * StringPanel.java
 *
 * This is a specialized JPanel that will display strings that are
 * encapsulated in instances of DisplayString.  It will draw the strings
 * on itself using their specified font, colour and location.
 */
package uk.ac.gre.wg05.memory;

import java.awt.*;
import java.util.List;
import javax.swing.JPanel;

public class StringPanel extends JPanel {

    private List<DisplayString> list;
    private int width, height;

    public StringPanel() {
    }

    public StringPanel(List<DisplayString> list, int width, int height) {
        this.list = list;
        this.width = width;
        this.height = height;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (DisplayString ds : list) {
            if (ds.getColour() != null) {
                g.setColor(ds.getColour());
            }
            if (ds.getFont() != null) {
                g.setFont(ds.getFont());
            }
            g.drawString(ds.getTheWord(), ds.getX(), ds.getY());
        }
    }
}

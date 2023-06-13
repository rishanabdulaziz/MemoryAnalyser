/*
 * DisplayString.java
 *
 * Instances of this class represent strings to be displayed.
 * As well as the string itself each instance contains the 
 * font and colour that should be used for the display, the
 * height and width of the string and the x and y location
 * at which the string should be displayed within some
 * container.
 */
package uk.ac.gre.wg05.memory;

import java.awt.*;

public class DisplayString  {
    
    private String word;
    private Color colour;
    private Font font;
    private int height, 
                width,
                x,
                y;

    public DisplayString() {
        this(null, null, null, -1, -1, -1, -1);
    }
    public DisplayString(String word,
                       Color colour,
                       Font font,
                       int height,
                       int width,
                       int x,
                       int y) {
        this.word = word;
        this.colour = colour;
        this.font = font;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }    

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTheWord() {
        return word;
    }

    public void setTheWord(String word) {
        this.word = word;
    } 
}

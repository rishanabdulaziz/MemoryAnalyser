/*
 * StringPlacer.java
 *
 * An instance of this class works out the position at which variable length
 * strings should be displayed on some container.  The container's width is 
 * always passed to StringPlacer but the height may not be.  If the 
 * height is not supplied then StringPlacer works out the appropriate height.
 * The calculation of where the string should display is fairly crude although
 * it does attempt to centre them in the container.
 *
 */
package uk.ac.gre.wg05.memory;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class StringPlacer {

    private List<DisplayString> stringsToPlace;
    private int containerWidth, containerHeight;
    private int spaceBetweenRows, spaceBetweenColumns;

    /* Parameters to the constructor are:
     *
     * stringsToPlace - the list of strings to be placed - each string knows
     *                  it's height and width
     * containerWidth - the width of the container
     * containerHeight - the height of the container.  If this is passed as
     *                   a negative numerb then StringPlacer calculates the 
     *                   height itself.
     * spaceBetweenRows - number of pixels to be left between rows of strings.
     * spaceBetweenColumns - numer of pixels to be left between columns of strings
     */
    public StringPlacer(List<DisplayString> stringsToPlace,
            int containerWidth, int containerHeight,
            int spaceBetweenRows, int spaceBetweenColumns) {
        this.stringsToPlace = stringsToPlace;
        this.containerWidth = containerWidth;
        this.containerHeight = containerHeight;
        this.spaceBetweenRows = spaceBetweenRows;
        this.spaceBetweenColumns = spaceBetweenColumns;

    }

    public StringPlacer() {
        this(null, 0, 0, 0, 0);
    }

    public List<DisplayString> getStringsToPlace() {
        return stringsToPlace;
    }

    public int getContainerWidth() {
        return containerWidth;
    }

    public int getContainerHeight() {
        return containerHeight;
    }

    public int getSpaceBetweenRows() {
        return spaceBetweenRows;
    }

    public int getSpaceBetweenColumns() {
        return spaceBetweenColumns;
    }

    /* This is the method that does all the work of working out the location 
     * for the strings and optionally the required height of the container.
     */
    public void placeOnContainer()
            throws Exception {

        // Get the maximum height and width of strings. 
        int maxHeight = -1;
        for (DisplayString ds : stringsToPlace) {
            if (ds.getHeight() > maxHeight) {
                maxHeight = ds.getHeight();
            }
        }
        int maxWidth = -1;
        for (DisplayString ds : stringsToPlace) {
            if (ds.getWidth() > maxWidth) {
                maxWidth = ds.getWidth();
            }
        }

        // If both containerHeight and containerWidth have been set then
        // calculate to see if the strings will fit.  Otherwise
        // work out what containerHeight is needed given the supplied
        // containerWidth.

        int numberPerRow = (containerWidth - spaceBetweenColumns) / (maxWidth + spaceBetweenColumns);
        if (numberPerRow < 1) { // problem can't even fit one string per row
            throw new Exception("Might not fit - can't fit even one per row");
        }

        // Work out the width that will be taken up including spaceBetweenColumns
        // at each end of the row.
        int actualWidth = (numberPerRow * (maxWidth + spaceBetweenColumns)) + spaceBetweenColumns;
        int leftMargin = (containerWidth - actualWidth) / 2;

        // Work out the number of rows
        int numberOfRows = (int) Math.ceil((float) stringsToPlace.size() / numberPerRow);

        // Work out the height of container needed
        int heightNeeded = numberOfRows * (maxHeight + spaceBetweenRows);
        if (containerHeight > 0) {
            if (heightNeeded > containerHeight) {
                throw new Exception("Might not fit - container not high enough");
            }
        } else {
            containerHeight = heightNeeded;
        }

        // Loop through all the strings working out their x and y location on 
        // the container.
        int spaceOnThisRow = containerWidth - (spaceBetweenColumns + leftMargin);
        int currentYPos = maxHeight;
        for (DisplayString ds : stringsToPlace) {
            if (spaceOnThisRow < (maxWidth + spaceBetweenColumns)) {
                spaceOnThisRow = containerWidth - (spaceBetweenColumns + leftMargin);
                currentYPos += (maxHeight + spaceBetweenRows);
            }
            ds.setX(containerWidth - spaceOnThisRow);
            spaceOnThisRow -= (maxWidth + spaceBetweenColumns);
            ds.setY(currentYPos);
        }
    }

    // Main method just to carry out some crude testing and demonstrate the use 
    // of the class.
    public static void main(String[] args) throws Exception {
        DisplayString[] words = new DisplayString[]{
            new DisplayString("Hi", null, null, 10, 20, -1, -1),
            new DisplayString("Hi", null, null, 10, 20, -1, -1),
            new DisplayString("Hi", null, null, 10, 20, -1, -1),
            new DisplayString("Hi", null, null, 10, 20, -1, -1),
            new DisplayString("Hi", null, null, 10, 20, -1, -1),
            new DisplayString("Hi", null, null, 10, 20, -1, -1),
            new DisplayString("Hi", null, null, 10, 20, -1, -1),
            new DisplayString("Hi", null, null, 10, 20, -1, -1),
            new DisplayString("Hi", null, null, 10, 20, -1, -1)
        };

        final List<DisplayString> dWords = Arrays.asList(words);

        StringPlacer me = new StringPlacer(dWords, 350, 150, 20, 20);
        me.placeOnContainer();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                for (DisplayString ds : dWords) {
                    g.drawString(ds.getTheWord(), ds.getX(), ds.getY());
                }
            }
        };
        frame.add(panel);
        frame.setVisible(true);

        
        // Expect an exception
        me = new StringPlacer(dWords, 300, 10, 20, 20);
        me.placeOnContainer();
    }
}

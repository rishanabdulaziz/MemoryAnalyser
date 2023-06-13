/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.gre.wg05.memory;

import java.awt.Dimension;
import java.awt.Graphics;
import junit.framework.TestCase;

/**
 *
 * @author Rishan
 */
public class StringPanelTest extends TestCase {
    
    public StringPanelTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of getPreferredSize method, of class StringPanel.
     */
    public void testGetPreferredSize() {
        System.out.println("getPreferredSize");
        StringPanel instance = new StringPanel();
        Dimension expResult = null;
        Dimension result = instance.getPreferredSize();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class StringPanel.
     */
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        StringPanel instance = new StringPanel();
        //instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

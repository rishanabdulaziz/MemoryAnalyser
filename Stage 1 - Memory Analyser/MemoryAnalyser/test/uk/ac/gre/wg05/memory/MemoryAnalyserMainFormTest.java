/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.gre.wg05.memory;

import junit.framework.TestCase;

/**
 *
 * @author Rishan
 */
public class MemoryAnalyserMainFormTest extends TestCase {
    
    public MemoryAnalyserMainFormTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of finishedMemorising method, of class MemoryAnalyserMainForm.
     */
    public void testFinishedMemorising() {
        System.out.println("finishedMemorising");
        MemoryDataGenerator mdg = null;
        MemoryAnalyserMainForm instance = new MemoryAnalyserMainForm();
        //instance.finishedMemorising(mdg);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MemoryAnalyserMainForm.
     */
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MemoryAnalyserMainForm.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

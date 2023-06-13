/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.gre.wg05.memory;

import java.util.Set;
import junit.framework.TestCase;

/**
 *
 * @author Rishan
 */
public class StringGeneratorTest extends TestCase {
    
    public StringGeneratorTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of setParameters method, of class StringGenerator.
     */
    public void testSetParameters() throws Exception{
        System.out.println("setParameters");
        char[] charSet = null;
        int numbOfStrings = 0;
        int lengthOfStrings = 0;
        StringGenerator instance = new StringGenerator();
        //instance.setParameters(charSet, numbOfStrings, lengthOfStrings);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of returnSetOfStrings method, of class StringGenerator.
     */
    public void testReturnSetOfStrings() throws Exception{
        System.out.println("returnSetOfStrings");
        StringGenerator instance = new StringGenerator();
        Set<String> expResult = null;
        Set<String> result = instance.returnSetOfStrings();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class StringGenerator.
     */
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        //StringGenerator.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.gre.wg05.memory;

import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Rishan
 */
public class MemoryDataGeneratorTest extends TestCase {
    
    public MemoryDataGeneratorTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Test of setParameters method, of class MemoryDataGenerator.
     */
    public void testSetParameters() throws Exception{
        System.out.println("setParameters");
        boolean useLowerCase = false;
        boolean useUpperCase = false;
        boolean useDigits = false;
        boolean useSpecials = false;
        int numbOfStrings = 0;
        int lengthOfStrings = 0;
        MemoryDataGenerator instance = new MemoryDataGenerator();
        //instance.setParameters(useLowerCase, useUpperCase, useDigits, useSpecials, numbOfStrings, lengthOfStrings);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of generateData method, of class MemoryDataGenerator.
     */
    public void testGenerateData() throws Exception{
        System.out.println("generateData");
        MemoryDataGenerator instance = new MemoryDataGenerator();
        //instance.generateData();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of returnListOfItemsToMemorise method, of class MemoryDataGenerator.
     */
    public void testReturnListOfItemsToMemorise() throws Exception{
        System.out.println("returnListOfItemsToMemorise");
        MemoryDataGenerator instance = new MemoryDataGenerator();
        List<String> expResult = null;
        List<String> result = instance.returnListOfItemsToMemorise();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of returnListOfItemsToChooseFrom method, of class MemoryDataGenerator.
     */
    public void testReturnListOfItemsToChooseFrom() throws Exception{
        System.out.println("returnListOfItemsToChooseFrom");
        MemoryDataGenerator instance = new MemoryDataGenerator();
        List<String> expResult = null;
        List<String> result = instance.returnListOfItemsToChooseFrom();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MemoryDataGenerator.
     */
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        MemoryDataGenerator.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

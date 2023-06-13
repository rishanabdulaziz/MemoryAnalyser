/*
 * MemoryDataGenerator.java
 *
 * This class will generate a random set of strings
 * and a superset of that set of strings.  The idea is
 * that the first set (listOfItemsToMemorise) are for
 * the user to memorise.  The second set (listOfItemsToChooseFrom)
 * will be presented to the user and they try to select from it
 * the items they were asked to memorise.
 */
package uk.ac.gre.wg05.memory;
import java.util.*;

public class MemoryDataGenerator {

    /* character sets that will be used to 
     *   generate the random strings
     */
    private String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    private String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String digits = "0123456789";
    private String specials = "!$%^&*()+-={}@#";
    /* This value is used to determine how many
     * more items there will be in listOfItemsToChooseFrom than
     * in listOfItemsToMemorise e.g. if there are to be
     * 6 items to memorise then there will be 60 to choose
     * from
     */
    private final int itemToChoiceRatio = 10;
    // the full character set to use to generate the strings
    private char[] charSetToUse;
    private int numbOfStrings; // number of strings to be generated
    private int lengthOfStrings; // length of each string
    private StringGenerator generator; // class that actually does the string generation
    /* The two lists of strings - this is the product of
     * this class, a list of strings to memorise and a
     * list of strings which contains the ones to memorise
     * plus others from which the user attempts to select those
     * they memorised.
     */
    private List<String> listOfItemsToMemorise;
    private List<String> listOfItemsToChooseFrom;

    public MemoryDataGenerator() throws Exception {
        this(true, false, false, false, 2, 3); // default values just to test
    }
    /* Constructor.  The booleans are to tell the class which characters
     * to use in generating the strings.  The ints tell it how many strings
     * to generate and how long each one should be.
     */

    public MemoryDataGenerator(boolean useLowerCase, boolean useUpperCase, boolean useDigits, boolean useSpecials, int numbOfStrings, int lengthOfStrings) throws Exception {

        setParameters(useLowerCase,
                useUpperCase,
                useDigits,
                useSpecials,
                numbOfStrings,
                lengthOfStrings);
        generator = new StringGenerator();
    }

    public final void setParameters(boolean useLowerCase,
            boolean useUpperCase,
            boolean useDigits,
            boolean useSpecials,
            int numbOfStrings,
            int lengthOfStrings) {

        /* Assemble the array of characters from which to
         * generate the strings
         */
        StringBuilder charsToUse = new StringBuilder();
        if (useLowerCase) {
            charsToUse.append(lowerCase);
        }
        if (useUpperCase) {
            charsToUse.append(upperCase);
        }
        if (useDigits) {
            charsToUse.append(digits);
        }
        if (useSpecials) {
            charsToUse.append(specials);
        }
        charSetToUse = charsToUse.toString().toCharArray();
        this.numbOfStrings = numbOfStrings;
        this.lengthOfStrings = lengthOfStrings;
    }
    /* The method that generates the two lists 
     * It works by generating the superset (i.e. listOfItemsToChooseFrom)
     * and then selecting from that a subset of items that will be those
     * that are to be memorised
     */

    public void generateData() {
        // Tell the class that is going to do the generating what we want
        generator.setParameters(charSetToUse, numbOfStrings * itemToChoiceRatio, lengthOfStrings);
        Set<String> superSet = generator.returnSetOfStrings();
        listOfItemsToChooseFrom = new ArrayList<String>(superSet);
        Collections.shuffle(listOfItemsToChooseFrom); // randomise the order

        /* Get the first numbOfStrings elements from the superset to
         * be those that are to be memorised.
         */
        listOfItemsToMemorise = new ArrayList<String>(listOfItemsToChooseFrom.subList(0, numbOfStrings));
        Collections.shuffle(listOfItemsToChooseFrom);
        Collections.shuffle(listOfItemsToMemorise);
    }

    public List<String> returnListOfItemsToMemorise() {
        return listOfItemsToMemorise;
    }

    public List<String> returnListOfItemsToChooseFrom() {
        return listOfItemsToChooseFrom;
    }
    // main method just to demonstrate how the class is used

    public static void main(String[] args) throws Exception {
        MemoryDataGenerator mdg1 = new MemoryDataGenerator();
        mdg1.generateData();
        System.out.println(mdg1.returnListOfItemsToMemorise());
        System.out.println(mdg1.returnListOfItemsToChooseFrom());
        mdg1.setParameters(true, true, true, true, 3, 2);
        mdg1.generateData();
        System.out.println(mdg1.returnListOfItemsToMemorise());
        System.out.println(mdg1.returnListOfItemsToChooseFrom());
    }
}

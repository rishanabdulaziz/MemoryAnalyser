/*
 * GenerateStrings.java
 *
 * This class generates a random set of Strings.
 */
package uk.ac.gre.wg05.memory;
import java.util.*;
public class StringGenerator {
    
    char[] charSet; // generate string from this character set
    int numbOfStrings; // number of strings to be generated
    int lengthOfStrings; // length of each string
    Set<String> setOfStrings; // Set of strings generated
    
    public StringGenerator() throws Exception {
        this(new char[]{'a','b','c'}, 2, 1); // default settings just to test
    }
    
    /* Constructor - paramters are:
        charSet - set of characters from which to generate
                  the strings
        numbOfStrings - the number of random strings to
                           generate
        lengthOfStrings - length of each string to generate                
    */
    public StringGenerator(char[] charSet,
                            int numbOfStrings,
                            int lengthOfStrings) throws Exception {
        this.setParameters(charSet,
                            numbOfStrings,
                            lengthOfStrings);
    }
    
    public final void setParameters(char[] charSet,
                                int numbOfStrings,
                                int lengthOfStrings) {
        /* are we being asked the impossible? e.g. to
         * generate 10 random strings of length 2 from
         * the set of characters 'a', 'b', 'c' (only 9 are possible)
         */
        if (numbOfStrings > Math.pow(charSet.length, lengthOfStrings)) {
                throw new IllegalArgumentException("impossible to create " + 
                                     numbOfStrings +
                                     " of length " +
                                     lengthOfStrings +
                                     " from charSet of length " +
                                     charSet.length);
            
        }
                                    
        this.charSet = charSet;
        this.numbOfStrings = numbOfStrings;
        this.lengthOfStrings = lengthOfStrings;
    }
    
    // Generate the random set of strings for the 
    // character set.  Note that the use of the 
    // Set class will make sure that the generated strings
    // are unique.
    private void makeStrings(int number, int length) {
        setOfStrings = new HashSet<String>();
        while (setOfStrings.size() < number) {
            setOfStrings.add(makeAString(length));
        }
    }
    // Make one single random string of the required
    // length from the character set.
    private String makeAString(int length) {
        StringBuilder theString = new StringBuilder("");
        for (int i = 0; i < length; i++) {
                int ran = (int)(Math.random() * charSet.length);
                theString.append(charSet[ran]);
        }
        return theString.toString();
    }
    // Generate the set of string and return it.
    public Set<String> returnSetOfStrings() {
        makeStrings(numbOfStrings, lengthOfStrings);
        return setOfStrings;
    }
    
// Main method just to demonstrate how the class is used
    public static void main(String[] args) throws Exception {
            StringGenerator gs1 = new StringGenerator();
            gs1.setParameters("abcdefghijklmnopqrstuvwxyz".toCharArray(), 25, 1);
            System.out.println(gs1.returnSetOfStrings());
            gs1.setParameters("12345".toCharArray(), 10, 2);
            System.out.println(gs1.returnSetOfStrings());
    }
}

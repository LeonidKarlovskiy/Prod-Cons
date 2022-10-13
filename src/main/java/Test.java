import java.util.Arrays;
import java.util.Scanner;

/**
 * Two strings, a and  b , are called anagrams if they contain all the same characters in the same frequencies.
 * For this challenge, the test is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.
 * Function Description
 * Complete the isAnagram function in the editor.
 * isAnagram has the following parameters:
 * string a: the first string
 * string b: the second string
 * Returns
 * boolean: If  and  are case-insensitive anagrams, return true. Otherwise, return false.
 * Input Format
 * The first line contains a string .
 * The second line contains a string .
 */

public class Test {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");


    }


    static boolean isAnagram(String a, String b) {
        String loweredA = a.toLowerCase();
        String loweredB = b.toLowerCase();
        int[] stringA = loweredA.codePoints().sorted().toArray();
        int[] stringB = loweredB.codePoints().sorted().toArray();
        return Arrays.equals(stringA, stringB);
    }

}








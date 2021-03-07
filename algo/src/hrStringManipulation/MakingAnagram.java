/**
 * 
 */
package hrStringManipulation;

/**
 * @author vyomr
 *
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        //an array of integer for keeping count of total number of times a char appears in each string
        int totalDeletions = 0;
        int[] numberOfCharacters = new int[26];
        //adding count to array if char is present
        for (char c : a.toCharArray()){
            numberOfCharacters[c-'a']++;
        }
        for (char c : b.toCharArray()){
            numberOfCharacters[c-'a']--;
        }

        for (int i=0;i<26;i++){
            totalDeletions += Math.abs(numberOfCharacters[i]);
        }

    return totalDeletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

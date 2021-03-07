/**
 * 
 */
package hrwarmupchallenges;

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

public class RepeatedString {

    // Complete the repeatedString function below.
    //For a given string s of length 'n' containing repetition of 
    // s like 'aabaac' infinite times, find the number of 'a' in the string
    static long repeatedString(String s, long n) {   	
    	long initialACount = s.chars().filter(c -> c == 'a').count();
        long quotient = n/(s.length());
        int remainder =  (int) (n%(s.length()));        
        long numberOfa = initialACount*quotient+s.substring(0, (remainder)).chars().filter(c -> c == 'a').count();
        return numberOfa;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

      /*  bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}

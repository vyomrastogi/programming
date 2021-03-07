/**
 * 
 */
package hrhashtables;

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

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> magMap = new HashMap<String, Integer>();

        //check lengths of arrays, if note length is more than magazine, return No
        if (note.length > magazine.length){
            System.out.print("No");
            return;
        }
         

        //Form a map of words in magazine with their counts
        for (String s : magazine){
            if(!magMap.containsKey(s)){
                magMap.put(s,1);
            }else {
                magMap.put(s,magMap.get(s)+1);
            }
        }

        //for each word in Note, check if it is available in magMap, else return No
        for(String s : note){
            if(!magMap.containsKey(s)){
                System.out.print("No");
                return;
            }else {
                //subtract the count of words for every time a note words is iterated over
                if(magMap.get(s)>=1){
                    magMap.put(s,magMap.get(s)-1);
                }else { //if note words comes more than the counts available in mag, return No
                    System.out.print("No");
                    return;
                }
            }
        }

        System.out.print("Yes");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

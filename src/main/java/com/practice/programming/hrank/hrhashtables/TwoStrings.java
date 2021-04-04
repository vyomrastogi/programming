/**
 * 
 */
package com.practice.programming.hrank.hrhashtables;

/**
 * @author vyomr
 *
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TwoStrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	//----SOLUTION 1-----
        /*//for stream chars in s1, if any char matches s2, then substring is available
        if (s1.length()>=s2.length()){
            return s2.chars().anyMatch(c -> (s1.indexOf((char)c)>-1))?"YES":"NO";
        } else {
            return s1.chars().anyMatch(c -> (s2.indexOf((char)c)>-1))?"YES":"NO";
        }*/

        //the above method is not efficient when string length is huge
        //Try to build a Set of String, so that it contain's only unique characters. Maximum complexity possible with O(26) - number of unique characters
    	//----SOLUTION 2-----
        /*Set<String> s1Set = new HashSet(Arrays.asList(s1.split("")));
        Set<String> s2Set = new HashSet(Arrays.asList(s2.split("")));

        return s1Set.stream().anyMatch(s -> s2Set.contains(s))?"YES":"NO";*/

    	//----SOLUTION 3-----
        //Second solution had overhead of forming array and set, the below solution from discussion resolves all those overheads.
        for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()){
            if (s1.indexOf(c)>-1 && s2.indexOf(c)>-1)
            return "YES";
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


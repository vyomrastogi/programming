/**
 * 
 */
package com.practice.programming.hrank.hrStringManipulation;

/**
 * @author vyomr
 *
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockAndValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        int largestRepeatedCount =0;
        HashMap<Character,Integer> charToCountMap = new HashMap<Character,Integer>();
        for (char c : s.toCharArray()){
            if (charToCountMap.get(c) == null){
                charToCountMap.put(c,1);
            }else {
                charToCountMap.put(c,charToCountMap.get(c)+1);
            }

            if (charToCountMap.get(c)>largestRepeatedCount)
                largestRepeatedCount = charToCountMap.get(c);
        }
        int characterDeletionFound = 0;
        if (charToCountMap.size()>1){
                for (Map.Entry<Character,Integer> e : charToCountMap.entrySet()){
                    if (largestRepeatedCount-e.getValue()>1)
                        return "NO";
                    else if (largestRepeatedCount-e.getValue()==0)
                        characterDeletionFound++;
            }
        }else 
            return "YES";
        
        if (characterDeletionFound > 1){
             return "NO";
        } else 
            return "YES";
       
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


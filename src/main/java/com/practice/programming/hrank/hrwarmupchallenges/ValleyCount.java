package com.practice.programming.hrank.hrwarmupchallenges;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ValleyCount {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleyCount = 0;
        int downValleyCount = 0;
        String[] sArr = s.split("");
        for(int i=0;i<n;i++){
            if (sArr[i].equals("U")){
                valleyCount--;
            } else  if(sArr[i].equals("D")){
                valleyCount++;
            }

            if(valleyCount==0 && sArr[i].equals("U")){
                downValleyCount++;
            }
        }
        return downValleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

/**
 * 
 */
package com.practice.programming.hrank.hrarrays;

/**
 * @author vyomr
 *
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int totalSwaps = 0;
        boolean visited[] = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
                int j = i; 
                int nodesVisited = 0;
                while (!visited[j]) {
                        visited[j] = true;
                        j = arr[j] - 1;
                        nodesVisited++;
                }
                if (nodesVisited > 0)
                        totalSwaps += nodesVisited - 1;
        }
        return totalSwaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


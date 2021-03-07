/**
 * 
 */
package hrarrays;

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

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    	//Below is original approach which is simple but not efficient, and fails test case due to timeout error. For more details, understand uncommented part
        /*long[] arr = new long[n];
        long largestSum = 0;
        long totalSum =0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<queries.length;i++){
            for (int j=(queries[i][0]-1);j<=(queries[i][1]-1);j++){
                arr[j] += queries[i][2];
                if(arr[j]>largestSum){
                    largestSum=arr[j];
                }
            }
        }
        return largestSum;*/

        //There is concept called difference array which is useful to find the do range operation 'l r x' where l is left inclusive range , r is right inclusive and x is number to be added. According to it, to update some, after adding x to arr[l], same x is subtracted from arr[r+1] so that additional element [r+1] added doesn't change original sum value. 
        //D[i] = A[i]-A[i-1] (for 0 < i < N ) and D[0] = A[0] considering 0 based indexing
        long[] arr = new long[n + 1];        
        for (int i = 0; i < queries.length; i++) {
            arr[queries[i][0] - 1] += queries[i][2];
            arr[queries[i][1]] -= queries[i][2];
        }
        long largestSum = 0;
        long totalSum = 0;
        for (int i = 0; i < n + 1; i++) {
            totalSum += arr[i];
            if (totalSum > largestSum) {
                largestSum = totalSum;
            }
        }        
        return largestSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


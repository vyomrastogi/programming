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

public class TwoDArrayDS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int existingSum = -64;
        for (int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                int currentSum = findSum(i,j,arr);
                if(currentSum>existingSum){
                    existingSum=currentSum;
                }
            }
        }
    return existingSum;
    }

    static int findSum(int row, int column, int[][] arr){
        int sumTotal =0;
        if(column+2<6 && row+2<6){
            sumTotal += arr[row][column] + arr[row][column+1] +  arr[row][column+2] + arr[row+1][column+1] + arr[row+2][column] + arr[row+2][column+1] + arr[row+2][column+2];
        }else sumTotal=-64;
        return sumTotal;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        
        System.out.println(result);
/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}


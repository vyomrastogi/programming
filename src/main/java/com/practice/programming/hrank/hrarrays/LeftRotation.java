/**
 * 
 */
package com.practice.programming.hrank.hrarrays;

/**
 * @author vyomr
 *
 */
import java.io.IOException;
import java.util.Scanner;

public class LeftRotation {

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {

		int[] retArr = new int[a.length];
		if (a.length == d) {
			return a;
		}else {
			for (int i=0; i<a.length; i++) {
				int newIndex = (i+d)%(a.length);
				retArr[i] = a[newIndex];
			}
		}
		return retArr;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		int[] result = rotLeft(a, d);

		for (int i = 0; i < result.length; i++) {
			System.out.print(String.valueOf(result[i]));

			if (i != result.length - 1) {
				System.out.print(" ");
			}
		}

	/*	bufferedWriter.newLine();

		bufferedWriter.close();*/

		scanner.close();
	}
}

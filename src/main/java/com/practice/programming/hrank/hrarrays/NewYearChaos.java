/**
 * 
 */
package com.practice.programming.hrank.hrarrays;

import java.util.Scanner;

public class NewYearChaos {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {

		int totalCount = 0;
		int length = q.length;
		boolean tooChaotic = false;		
		for (int j = length - 1; j >= 0; j--) {
			if (q[j] - (j + 1) > 2) {
				tooChaotic = true;
				break;
			}
			for (int i = Math.max(0, q[j] - 2); i < j; i++) {
				if (q[i] > q[j])
					totalCount++;
			}
		}
		if (tooChaotic)
			System.out.println("Too chaotic");
		else
			System.out.println(totalCount);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}

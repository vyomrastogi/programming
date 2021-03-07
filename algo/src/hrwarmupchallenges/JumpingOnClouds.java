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

public class JumpingOnClouds {

	// Complete the jumpingOnClouds function below.
	//For the input 0 0 1 0 0 1 0 where  if c[i] == 1, it is thundercloud and to be avoided
	static int jumpingOnClouds(int[] c) {
		int jumpCount = 0;
		int i = 0;
		while (i < c.length) {
			if (((i + 2) < c.length) && c[i + 2] == 0) {
				jumpCount++;
				i = i + 2;
			} else if ((i + 1) < c.length) {
				jumpCount++;
				i++;
			} else {
				i++;
			}
		}
		return jumpCount;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] c = new int[n];

		String[] cItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int cItem = Integer.parseInt(cItems[i]);
			c[i] = cItem;
		}

		int result = jumpingOnClouds(c);
		System.out.println(result);
		/*
		 * bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		 * 
		 * bufferedWriter.close();
		 */

		scanner.close();
	}
}

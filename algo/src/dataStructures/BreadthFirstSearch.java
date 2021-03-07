package dataStructures;

import java.util.*;
import java.lang.*;
import java.io.*;

public class BreadthFirstSearch {

	private static int getShapeCount(int rows, int columns, String[][] shapeArr) {
		int count = 0;
		boolean[][] adjacentVisited = new boolean[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (shapeArr[i][j].equals("X")) {
					if (adjacentVisited[i][j])
						continue;
					count++;
					findAllAdjacentShapes(rows, columns, i, j, adjacentVisited, shapeArr);
				}

			}
		}

		return count;
	}

	private static void findAllAdjacentShapes(int rows, int columns, int currentRow, int currentColumn,
			boolean[][] adjacentVisited, String[][] shapeArr) {
		if (shapeArr[currentRow][currentColumn].equals("X") && !adjacentVisited[currentRow][currentColumn]) {
			adjacentVisited[currentRow][currentColumn] = true;
			//System.out.println(currentColumn +"---"+columns+"----"+currentRow+"-----"+rows);
			if (currentColumn + 1 < columns) {
				findAllAdjacentShapes(rows, columns, currentRow, currentColumn + 1, adjacentVisited, shapeArr);
			}
			if (currentColumn - 1 >= 0) {
				findAllAdjacentShapes(rows, columns, currentRow, currentColumn - 1, adjacentVisited, shapeArr);
			}
			if (currentRow + 1 < rows) {
				findAllAdjacentShapes(rows, columns, currentRow + 1, currentColumn, adjacentVisited, shapeArr);
			}
			if (currentRow - 1 >= 0) {
				findAllAdjacentShapes(rows, columns, currentRow - 1, currentColumn, adjacentVisited, shapeArr);
			}
		}
	}

	/* package whatever //do not write package name here */
	public static void main(String[] args) {
		// code

		Scanner sc = new Scanner(System.in);
		int numberOfSets = sc.nextInt();

		for (int inputs =0;inputs<numberOfSets;inputs++) {
			int numberOfRows = sc.nextInt();
			int numberOfColumns = sc.nextInt();

			String[][] twoDStrArray = new String[numberOfRows][numberOfColumns];

			for (int i = 0; i < numberOfRows; i++) {
				String[] nextElementArray = sc.next().split("");
				for (int j = 0; j < nextElementArray.length; j++) {
					twoDStrArray[i][j] = nextElementArray[j];
				}
			}
			System.out.println(getShapeCount(numberOfRows, numberOfColumns, twoDStrArray));
		}
		
	}

}

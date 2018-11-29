package com.pranav.hackerrank.floodfillalgorithm;

import java.util.Scanner;
//https://www.hackerearth.com/practice/algorithms/graphs/flood-fill-algorithm/tutorial/
public class MicroAndMaze {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int input[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				input[i][j] = s.nextInt();
			}
		}
		if (checkPath(0, 0, n - 1, m - 1, input)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static boolean checkPath(int sx, int sy, int dx, int dy, int[][] input) {
		if (sx == dx && sy == dy) {
			return true;
		}
		input[sx][sy] = 0;
		// up
		int x = sx - 1;
		int y = sy;
		if ((isCorrctIndex(x, y,dx,dy) && input[x][y] != 0)) {
			if (checkPath(x, y, dx, dy, input)) {
				return true;
			}
		}
		// right
		x = sx;
		y = sy + 1;
		if ((isCorrctIndex(x, y,dx,dy) && input[x][y] != 0)) {
			if (checkPath(x, y, dx, dy, input)) {
				return true;
			}
		}
		// down
		x = sx + 1;
		y = sy;
		if ((isCorrctIndex(x, y,dx,dy) && input[x][y] != 0)) {
			if (checkPath(x, y, dx, dy, input)) {
				return true;
			}
		}
		// left
		x = sx;
		y = sy - 1;
		if ((isCorrctIndex(x, y,dx,dy) && input[x][y] != 0)) {
			if (checkPath(x, y, dx, dy, input)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCorrctIndex(int x, int y, int dx, int dy) {
		if(x>=0 && x<=dx && y>=0 && y<=dy) {
			return true;
		}
		return false;
	}
}

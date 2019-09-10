package com.pranav.geeksforgeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Islands {
	static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M) {
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && list.get(i).get(j) == 1) {
					bfs(i, j, list, visited, N, M);
					result++;
				}
			}

		}
		return result;

	}

	private static void bfs(int i, int j, ArrayList<ArrayList<Integer>> list, boolean[][] visited, int n, int m) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(i, j));
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			Point current = queue.remove();
			for (Point neighbour : getNeighbours(current.getX(), current.getY(), n, m)) {
				if (!visited[neighbour.getX()][neighbour.getY()]
						&& list.get(neighbour.getX()).get(neighbour.getY()) == 1) {
					queue.add(neighbour);
					visited[neighbour.getX()][neighbour.getY()] = true;
				}
			}
		}
	}

	private static Set<Point> getNeighbours(int x, int y, int n, int m) {
		Set<Point> neighbours = new HashSet<Point>();
		if (isValid(x - 1, y - 1, n, m)) {
			neighbours.add(new Point(x - 1, y - 1));
		}

		if (isValid(x - 1, y, n, m)) {
			neighbours.add(new Point(x - 1, y));
		}
		if (isValid(x - 1, y + 1, n, m)) {
			neighbours.add(new Point(x - 1, y + 1));
		}

		if (isValid(x, y - 1, n, m)) {
			neighbours.add(new Point(x, y - 1));
		}

		if (isValid(x, y + 1, n, m)) {
			neighbours.add(new Point(x, y + 1));
		}
		if (isValid(x + 1, y - 1, n, m)) {
			neighbours.add(new Point(x + 1, y - 1));
		}
		if (isValid(x + 1, y, n, m)) {
			neighbours.add(new Point(x + 1, y));
		}
		if (isValid(x + 1, y + 1, n, m)) {
			neighbours.add(new Point(x + 1, y + 1));
		}
		return neighbours;
	}

	private static boolean isValid(int i, int j, int n, int m) {
		return i >= 0 && i < n && j >= 0 && j < m;
	}

	private static class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

	}
}
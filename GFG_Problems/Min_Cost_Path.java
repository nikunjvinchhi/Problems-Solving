/**
Problem
Min Cost Path | DP-6
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. The total cost of a path to reach (m, n) is the sum of all the costs on that path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1), and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
*/

public Solution{
	public static int minCost(int cost[][], int m, int n) {
	  int table[][] = new int[m][n];
	  table[0][0] = cost[0][0];//base case.

	  //row 0.
	  for (int i = 1; i < n; i++) {
		 table[0][i] = table[0][i - 1] + table[0][i];
	  }
	  //column 0;
	  for (int i = 1; i < n; i++) {
		 table[i][0] = table[i - 1][0] + table[i][0];
	  }
	  //for other row and column.
	  for (int i = 1; i < m; i++) {
		 for (int j = 1; j < n; j++) {
			table[i][j] = cost[i][j] + Math.min(Math.min(minCost(cost, i - 1, j - 1), minCost(cost, i - 1, j)), minCost(cost, i, j - 1));
		 }
	  }
	  return table[m - 1][n - 1];
	}
}
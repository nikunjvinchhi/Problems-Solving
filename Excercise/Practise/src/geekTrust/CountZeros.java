package geekTrust;

import java.util.Scanner;

public class CountZeros {

	/*
	 * 
0 2 1 0
0 1 0 1
1 1 0 1
1 1 1 0
	 */
	public static void main(String[] args) {
		
		
		int m = 0;
		Scanner s = new Scanner(System.in);
		m = s.nextInt();
		int n = s.nextInt();
		
		int[][] grid = new int[m][n];
		
		for(int i=0; i<m;i++) {
			for(int j=0; j<n;j++) {
				grid[i][j] = s.nextInt();
			}
		}
		for(int i=0; i<m;i++) {
			for(int j=0; j<n;j++) {
				if(grid[i][j] == 0) {
					System.out.println(count(grid, i, j, m ,n));
				}
			}
		}
		
	}
	public static int count(int[][] grid, int i, int j, int m, int n) {
		
		//base condition
		if(i < 0 || j < 0 || i >= m || j >= n) {
			return 0;
		}
		if(grid[i][j] != 0) {
			return 0;
		}
		
		grid[i][j] = m;
		int a = 1;
		
		int b = count(grid, i+1, j, m ,n);
		int c = count(grid, i-1, j, m ,n);
		int d = count(grid, i, j+1, m ,n);
		int e = count(grid, i, j-1, m ,n);
		int f = count(grid, i+1, j+1, m ,n);
		int g = count(grid, i-1, j-1, m ,n);
		int h = count(grid, i+1, j-1, m ,n);
		int p = count(grid, i-1, j+1, m ,n);
		
		return a+b+c+d+e+f+g+h+p;
	}
}

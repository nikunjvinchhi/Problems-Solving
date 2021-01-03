/**
Problem
Maximum path sum in matrix
Given a NxN matrix of positive integers. There are only three possible moves from a cell Matrix[r][c].

Matrix [r+1] [c]
Matrix [r+1] [c-1]
Matrix [r+1] [c+1]
â€‹Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
*/
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int index = 0;
        int max = 0;
        int dp[][] = new int[N][N];
        /*for(int i=0; i<N; i++){
            dp[0][i] = Matrix[0][i];
        }*/
        for(int i=N-2; i>=0;i--){
            for(int j=0; j<N; j++){
                if(j == 0)
                    Matrix[i][j] += Math.max(Matrix[i+1][j], Matrix[i+1][j+1]);
                else if(j == N-1)
                    Matrix[i][j] += Math.max(Matrix[i+1][j-1], Matrix[i+1][j]);
                else
                Matrix[i][j] += 
                    Math.max(Math.max(Matrix[i+1][j], Matrix[i+1][j-1]), Matrix[i+1][j+1]);
                //System.out.println(Matrix[i][j]);
            }
        }
        int ans = 0;
        for(int j =0; j<N; j++){
            //System.out.println(Matrix[0][j]);
            if(ans < Matrix[0][j]){
                ans = Matrix[0][j];
            }
        }
        return ans;    
    }
}
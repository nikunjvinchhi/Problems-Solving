package com.gtnexus.tms.rating.businesslogic;

//{ Driver Code Starts

//Driver Code
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Scanner;

class GFG {
 public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     for (int T = in.nextInt(); T-->0;) {
         int n = in.nextInt();

         Geeks obj = new Geeks();
         out.println(obj.count(n));
     }
 }
}// } Driver Code Ends

/**Problem statement
 * Reach a given score
 * Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find number of distinct combinations to reach the given score.
 * Similar to coin change. Here we need unique ways. if not unique then similar to stair case problem.
 * @author nvinchhi
 *
 */


//Complete this function!

class Geeks {
 public long count(int n) {
     long[] dp = new long[n+1];
     Arrays.fill(dp, 0);
     dp[0] = 1;

     for(int i =3; i<=n;i++){
         dp[i] = dp[i] + dp[i-3];
     }
     for(int i =5; i<=n;i++){
         dp[i] = dp[i] + dp[i-5];
     }
     for(int i =10; i<=n;i++){
         dp[i] = dp[i] + dp[i-10];
     }
     // Add your code here.

     return dp[n];
 }
}
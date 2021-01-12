/**
Minimum Energy
Given an array containing positive and negative numbers. The array represents checkpoints from one end to other end of street. Positive and negative values represent amount of energy at that checkpoint. Positive numbers increase the energy and negative numbers decrease. Find the minimum initial energy required to cross the street such that Energy level never becomes 0 or less than 0.

Note :  The value of minimum initial energy required will be 1 even if we cross street successfully without loosing energy to less than and equal to 0 at any checkpoint. The 1 is required for initial check point.

 

Example 1:

Input
N = 5
A[] = {4, -10, 4, 4, 4}
Output
7
Explanation
By having an initial energy of 7 we can
make sure that all the checkpoints are
visited and the fuel never reaches 0
or less value.
 

Example 2:

Input
N = 5
A[] = {3, 5, 2, 6, 1}
Output
1
Explanation
We need at least 1 initial energy
to reach first checkpoint.
*/
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.minEnergy(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {

    public static int minEnergy(int a[], int n)
    {
         // Your code goes here
         int x =0;
         int y = 0;
         boolean neg = true;
         for(int i=0; i<n;i++){
             x += a[i];
             if(x <= 0){
                 y += Math.abs(x) + 1;
                 x = 1;
                 neg = false;
             }
         }
         return neg ? 1 : y;
    }
}

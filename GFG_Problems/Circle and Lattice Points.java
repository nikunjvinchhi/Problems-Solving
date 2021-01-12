/**
Circle and Lattice Points 
Given an integer R which represents the radius of a circle that has (0,0) as its centre, find the total number of lattice points on the circumference. Lattice Points are points with coordinates as integers in 2-D space.

Example 1:

Input: R = 5
Output: 12
Explanation: (0,5), (0,-5), (5,0), 
(-5,0), (3,4), (-3,4), (-3,-4), (3,-4), 
(4,3), (-4,3), (-4,-3), (4,-3).
*/

// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int r = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.latticePoints(r));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    public int latticePoints(int r) 
    { 
        if(r == 0)
            return 0;
       //code here.
       //x^2+y^2 = r^2
       int ans = 4;//(0,r),(0,-r),(-r,-r),(-r,0)
       for(int i=1; i<r;i++){
           int j = (r*r) - (i*i);
           int k = (int)Math.sqrt(j);
           if(j == (k*k))
            ans += 4;//(i,j),(i,-j),(-i,-j),(-i,j)
       }
       return ans;
    } 
}
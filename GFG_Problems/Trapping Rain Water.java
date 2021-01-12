/**
Trapping Rain Water
Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

Input:
N = 4
arr[] = {7,4,0,9}
Output: 10
Explanation: Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
*/

// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Trap obj = new Trap();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends


class Trap{
    
    // function to find the trapped water in between buildings
    // arr: input array
    // n: size of array
    static int trappingWater(int arr[], int n) { 
        
        // Your code here
        //in this we are doing traversal two times.
        // int max = arr[0];
        // int water = 0;
        // int water1 = 0;
        // int index = 0;
        // boolean f = true;
        // for(int i=1;i<n;i++){
        //     if(max > arr[i]){
        //         water1 += (max - arr[i]);
        //     } else{
        //         max = arr[i];
        //         water += water1;
        //         water1=0;
        //         index = i;//key point. this will point to max like 
        //         // 1,5,4,10,1,2,7 so index will point to 10 and then loop to reverse.
        //     }
        // }
        // if(index < n){
        //     max = arr[n-1];
        //     for(int i=n-2; i>=index;i--){//if we find from reverse.
        //         if(max > arr[i]){
        //             water += (max - arr[i]);
        //         } else{
        //             max = arr[i];
        //         }
        //     }
        // }
        // return water;
        
        //we can use two pointer approach.
        int i = 0;
        int j =n-1;
        int max_l = 0;
        int max_r = 0;
        int ans=0;
        while(i < j){
            if(arr[i] < arr[j]){
                if(arr[i] < max_l){
                    ans += (max_l - arr[i]);
                } else{
                    max_l = arr[i];
                }
                i++;
            } else{
                if(arr[j] < max_r){
                    ans += (max_r - arr[j]);
                } else{
                    max_r = arr[j];
                }
                j--;
            }
        }
        return ans;
    } 
}
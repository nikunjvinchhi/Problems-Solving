/**
274. H-Index
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index.
*/
class Solution {
	public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int l =0;
        int n = citations.length;
        int h = n - 1;
        while(l <= h){
            int mid = l + (h - l)/2;
            //System.out.println(mid);
            if(citations[mid] == n-mid)
                return n-mid;
            else if(citations[mid] > n-mid)
                h = mid - 1;
            else
                l = mid + 1;
        }
        //System.out.println(l + " " + h);
        return n - l;
        
    }
    // public int hIndex(int[] citations) {
	//	First sort the array and then consider with index if
	// 	your citations[i] is greater then or equal to length - i;
	// 	0,1,3,4,5,6,7,8 --> here I have 4 papaers with at least 4 citations
	// 	5 >= 8-4(4) we have to return higher one so.
	//	0,1,3,5,6,7,8 --> here I have 4 papaers with at least 4 citations
	//	5 >= 7-3(4) 
    //     Arrays.sort(citations);
    //     int l = citations.length;
    //     for(int i=0; i< l; i++){
    //         if(citations[i] >= l-i){
    //             return l-i;
    //         }
    //     }
    //     return 0;
    // }
	// public int hIndex(int[] citations) {
    //     Arrays.sort(citations);
    //     int l = citations.length - 1;
    //     int h = 0;
    //     boolean found = false;
    //     for(int i=0; i< citations.length; i++){
    //         if(citations[i] > l){
    //             h = h + 1;
    //             found = true;
    //         }
    //         l--;
    //     }
    //     return found ? h : 0;
    // }
}
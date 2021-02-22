//https://leetcode.com/problems/arithmetic-slices/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n < 3)
            return 0;
        int count=0;
        int da=A[1]-A[0];
        int db = 0;
        int ans = 0;
        for(int i=1;i<n - 1;i++){
            db = A[i+1] - A[i];
            if(db == da)
                count++;
            else{
                da = db;
                count = 0;
            }
            ans += count;
        }
        return ans;
    }
}
//class Solution {
//     int ans = 0;
//     public int numberOfArithmeticSlices(int[] A) {
//         recursion(A, A.length - 1);
//         return ans;
//     }
//     int recursion(int[] A, int index){
//         if(index < 2){//base case
//             return 0;
//         }
//         int sub = 0;
//         if(A[index] - A[index-1] == A[index-1] - A[index - 2]){
//             sub = 1 + recursion(A, index - 1);
//             ans += sub;
        
//         } else{
//             recursion(A, index-1);
//         }
//         return sub;
//     }
// }
/**
Problem 121. Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.
*/
class Solution {
    //order of n^2 solution. attempt 1
//     public int maxProfit(int[] prices) {
//         int answer = 0;
        
//         for(int i =0; i<prices.length;i++){
//             for(int j= i+1; j<prices.length;j++){
//                 int t = prices[j] - prices[i];
//                 if(t > answer)
//                     answer = t;
//             }
//         }
//         return answer;
//     }
    //attempt 2 order of n
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int a = prices[0];
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > a){
                int t = prices[i] - a;
                if(t > max)
                    max = t;
            } else
                a = prices[i];
        }
        return max;
    }
}
package geekTrust;

class OnesAndZeros {
	
	public static void main(String[] args) {

		String[] strs = {"001", "110","0000","0000"};
		System.out.println(findMaxForm(strs,9,2));
	}
	
    public static int findMaxForm(String[] strs, int m, int n) {
        //System.out.println(strs.length);
        int[] dp = new int[strs.length];
        for(int i=0; i<strs.length;i++) dp[i] = 0;
        int answer = getAnswer(0, strs, m, n, strs.length, dp);
        return answer;
    }
    
//     public int getAnswer(int start, String[] st, int m, int n, int length) {
//         //System.out.println(start);
//         if(start == length) //Base-case
//             return 0;
        
//         if(m==0 && n==0) return 0; //Base Case
        
//         String s = st[start];
//         int countZero=0;
//         int countOne=0;
//         for(char c : s.toCharArray()) {
//             if(c == '0')
//                 countZero++;
//             else
//                 countOne++;
//         }
//         int answer = 0;
//         if(countZero <= m && countOne <= n){//I will consider that position
//             answer = 1 + getAnswer(start+1, st, m-countZero, n-countOne, length);
//         }
        
//         answer = Math.max(answer, getAnswer(start+1, st, m, n, length));//I won't consider
        
//         return answer;
//     }
    
    //Now think for Memoization 
    //This input is giving 
    //["11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"]
//90
//66
    
    public static int getAnswer(int start, String[] st, int m, int n, int length, int[] dp) {
        //System.out.println(start);
        if(start == length) //Base-case
            return 0;
        
        if(m==0 && n==0) return 0; //Base Case
        
        if(dp[start] != 0) return dp[start];
        
        String s = st[start];
        int countZero=0;
        int countOne=0;
        for(char c : s.toCharArray()) {
            if(c == '0')
                countZero++;
            else
                countOne++;
        }
        int answer = 0;
        if(countZero <= m && countOne <= n){//I will consider that position
            answer = 1 + getAnswer(start+1, st, m-countZero, n-countOne, length,dp);
        }
        
        dp[start] = Math.max(answer, getAnswer(start+1, st, m, n, length,dp));//I won't consider
        
        return dp[start];
    }
    
}

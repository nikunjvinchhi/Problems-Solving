class Solution {
    public int climbStairs(int n) {
        if(n < 3)
            return n;
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        return climbStair(n, cache);
    }
    public int climbStair(int n, int[] cache) {
        //Top down approach DP.
        //base cases.
        /*if(n == 1)
            return cache[1];
        if(n == 2)
            return cache[2];
        int s = 0;
        if(cache[n-1] == 0){
            s = climbStair(n-1, cache);
            cache[n-1] = s;
        }
        else
            s = cache[n-1];
        int t = 0;
        if(cache[n-2] == 0){
            t = climbStair(n-2, cache);
            cache[n-2] = t;
        }
        else
            t = cache[n-2];
        return s + t;*/
        
        
        //bottom up DP
        for(int i =3; i<=n;i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }
}
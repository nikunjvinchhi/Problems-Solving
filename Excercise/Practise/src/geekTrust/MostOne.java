package geekTrust;

import java.util.ArrayDeque;
import java.util.Queue;

public class MostOne {

	public static void main(String[] args) {
		int[] A = new int[] {1,1,1,0,0,0,1,1,1,1,0};
		longestOnes(A, 2);
	}
	
	public static int longestOnes(int[] A, int K) {
        Queue<Integer> que=new ArrayDeque<>();
        int i=0;
        int j=0;
        int ans=0;
       
        
        while(i!=A.length){
           if(A[i]==0){
               que.add(i);
           }
           if(que.size()==K+1){
               j=que.remove()+1;
           }
            ans=Math.max(i-j+1,ans);
            i++;
        }
        return ans;
    }
}

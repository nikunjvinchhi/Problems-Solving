package geekTrust;

public class JumpGame2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(jump(new int[] {2,1,1,1,1}));
	}
	
	public static int jump(int[] nums) {
        int x = 0;
        int jump = 0;
        int xjump=0;
        int ans=0;
        for(int i=0; i<nums.length-1; i++){
            
            x = i + nums[i];
            
            if(xjump < x){
                xjump = x;
            }
            
            if(i == jump){
                ans++;
                jump=xjump;
            }
        }
        return ans;
    }

}
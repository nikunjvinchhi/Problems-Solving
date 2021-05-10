package geekTrust;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] nums = new int[] { 5, 7, 7, 8, 8, 8, 10 };
//		//int[] nums = new int[] { 8, 8, 8 };
//		System.out.println(searchRange(nums, 8)[1]);
		
		int[] n = new int[] {10,15,20};
		System.out.println(minDPTabularConstant(n));
	}

	public static int[] searchRange(int[] nums, int target) {

		int i = 0;
		int j = nums.length - 1;
		int[] x = new int[2];
		x[0] = -1;
		x[1] = -1;

		while (i < j) {
			int mid = i + ((j - i) / 2);
			if (target <= nums[mid]) {
				j = mid;
			} else {
				i = mid + 1;
			}
		}
		if (nums[i] != target)
			return x;

		x[0] = i;
		i = 0;
		j = nums.length - 1;
		while (i < j) {
			int mid = i + ((j - i) / 2);
			if (target >= nums[mid]) {
				i = mid + 1;
			} else {
				j = mid;
			}
		}
		if(nums[i] == target)
			x[1] = i;
		else
			x[1] = i-1;

		return x;
	}
	
	public static int minDPTabularConstant(int[] cost){
        int x=0;
        int y=0;
        int ans=0;
        for(int i=2; i<cost.length+1; i++){
            ans = Math.min(cost[i-1] + y, x + cost[i-2]);
            x=y;
            y = ans;
        }
        return ans;
    }
}

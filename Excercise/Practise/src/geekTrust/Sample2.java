package geekTrust;

public class Sample2 {

	//[7,1,5,3,6,4]
	public static void main(String[] args) {

		int a[] = new int[6];
		a[0] = 7;
		a[1] = 1;
		a[2] = 5;
		a[3] = 3;
		a[4] = 6;
		a[5] = 4;
		System.out.println(maximizeProfit(a));
	}
	
	//[7,1,5,3,6,4]
	public static int maximizeProfit(int[] a) {
		int profit = 0;
		
		int currMin = a[0];
		
		for(int i=1; i<a.length; i++) {
			if(currMin < a[i]) {
				//profit = Math.max(a[i] - currMin, profit);
				if(profit < a[i] - currMin)
					profit =a[i] - currMin;
			} else {
				currMin = a[i];
			}
		}
		
		return profit;
	}

}

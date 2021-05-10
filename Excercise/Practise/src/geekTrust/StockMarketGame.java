package geekTrust;

public class StockMarketGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		game(new int[] {5,6,8,4,9,10,8,3,6,4}, new int[] {3,1,8});
	}

	public static void game(int[] x, int[] q) {
		int[] ans = new int[q.length];
		for(int i = 0; i<q.length; i++) ans[i] = -1;
		
		for(int i =0; i<q.length; i++) {
			int g = q[i] - 1;
			
			//find next smaller in left
			int t = g-1;
			boolean found = false;
			while(t >= 0) {
				if(x[g] > x[t]) {
					ans[i] = t+1;
					found = true;
					break;
				}
				t--;
			}
			if(!found) {
				t = g+1;
				while(t < x.length) {
					if(x[g] > x[t]) {
						ans[i] = t+1;
						break;
					}
					t++;
				}
			}
		}
		for(int a : ans) {
			System.out.println(a);
		}
	}

}

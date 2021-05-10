package geekTrust;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "11";
		List<String> t = new ArrayList<>(); 
		System.out.println(count(s, s.length(), t, ""));
		System.out.println(t.toString());

	}

	public static int count(String s, int n, List<String> tz, String prefix) {

		if (s.charAt(0) == '0')
			return 0;

		if (n == 0) {
			tz.add(new StringBuilder(prefix).reverse().toString());
			return 1;
		}
		if(n == 1) {
			tz.add(new StringBuilder(prefix + (char) (s.charAt(0) - '0' - 1 + 'a')).reverse().toString());
			return 1;
		}

		int count1 = 0;

		if (s.charAt(n - 1) > '0') {
			count1 = count(s, n - 1,tz,prefix+(char)(s.charAt(n - 1) - '0' - 1 + 'a'));
			int t = (int) (s.charAt(n - 1) - '0');
			int z = (int) (s.charAt(n - 2) - '0');
			z = (z * 10) + t;
			if (z >= 10 && z <= 26) {
				count1 += count(s, n - 2,tz,prefix+(char)(z - 1 + 'a'));
			}
		} else {
			if (s.charAt(n - 2) == '1' || s.charAt(n - 2) == '2') {
				int c = (((s.charAt(n - 2) - '0') * 10 + (s.charAt(n - 1)-'0')));
				prefix +=  (char) (c - '0' -1 + 'a');
				count1 += count(s, n - 2,tz,prefix);
			}
		}
		return count1;
	}
}

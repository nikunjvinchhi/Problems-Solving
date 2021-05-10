package geekTrust;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindTheSubString {

	public static final int x = Integer.MAX_VALUE;
	public static final int y = x-100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(firstOccurance("abcd", "b*d"));
		// System.out.println(firstOccurance("juliasamanthasamanthajulia", "has"));
		 System.out.println(firstOccurance("juliasamanthasamanthajulia", "ant*as"));
		// System.out.println(firstOccurance("mississippi", "issip"));
		//
		// System.out.println(usingRecursion("abcd", "b*d"));
		// System.out.println(usingRecursion("juliasamanthasamanthajulia", "has"));
		// System.out.println(usingRecursion("juliasamanthasamanthajulia", "ant*as"));
		// System.out.println(usingRecursion("mississippi", "issip"));

		// System.out.println(maximumScore(1, 8, 8));
		System.out.println(strStr("mississippi", "issip"));
		// System.out.println(strStr("hello", "ll"));

	}

	public static int firstOccurance(String s, String x) {
		if (x == null || x.isEmpty()) {
			return 0;
		}
		if (s == null || s == "" || s.isEmpty()) {
			return -1;
		}
		int i = 0;
		int j = 0;
		int start = 0;
		while (i < s.length()) {
			char a = s.charAt(i);
			char b = x.charAt(j);
			if (a == b || b == '*') {
				i++;
				j++;
				if (j == x.length())
					return start;
			} else {
				start++;
				i = start;
				j = 0;
			}
		}
		// return start - x.length() + 1; uncomment this and put comment on if (j == 0)
		return -1;
	}

	public static int usingRecursion(String s, String x) {
		return recur(s, x, 0);
	}

	private static int recur(String s, String x, int start) {
		if (start > s.length() - x.length()) {
			return -1;

		}
		int index = 0, end = x.length() + start;
		for (int i = start; i < end; i++) {
			if (s.charAt(i) == x.charAt(index) || x.charAt(index) == '*') {
				if (index == x.length() - 1) {
					return i - index;
				}
				index++;
				continue;
			}
			index = 0;
		}
		return recur(s, x, start + 1);
	}

	public static int strStr(String haystack, String needle) {
		
		String t = "length: 10";
		String g = "xyz: "+t.length();
		System.out.println(t==g);
		
		int count=0;
		for(int i=y;i<x;i++) count++;
		System.out.println(count);
		
		// if(needle == null || needle.isEmpty()){
		// return 0;
		// }
		// if(haystack == null || haystack == "" || haystack.isEmpty()){
		// return -1;
		// }
		// int a=0;
		// int b=0;
		// int c=0;
		// while(a < haystack.length()){
		// if(haystack.charAt(a) == needle.charAt(b)){
		// a++;
		// b++;
		// if(b == needle.length()){
		// return c;
		// }
		// } else{
		// c++;
		// a=c;
		// b=0;
		// }
		// }
		// return -1;

		if (needle == null || needle == "" || needle.isEmpty()) {
			return 0;
		}
		if (haystack == null || haystack == "" || haystack.isEmpty()) {
			return -1;
		}

		int i = 0;
		int j = 0;
		int k = 0;
		int freq = 0;
		while (i < haystack.length()) {
			if (haystack.charAt(i) != needle.charAt(j)) {
				k++;
				i = k;
				j = 0;
			} else {
				i++;
				j++;
				if (j == needle.length()) {
					freq++;
					j=0;
				}
			}
		}
		// return start - x.length() + 1; uncomment this and put comment on if (j == 0)
		return freq;
	}

	public static int maximumScore(int a, int b, int c) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		maxHeap.add(a);
		maxHeap.add(b);
		maxHeap.add(c);
		int ans = 0;
		while (checkTermination(maxHeap)) {

			a = maxHeap.poll();

			b = maxHeap.poll();

			a--;
			b--;
			maxHeap.add(a);
			maxHeap.add(b);
			ans++;
		}

		return ans;
	}

	public static boolean checkTermination(PriorityQueue<Integer> maxHeap) {
		int a = maxHeap.peek() == 0 ? 0 : -1;
		if (a == 0)
			maxHeap.poll();
		int b = maxHeap.peek() == 0 ? 0 : -1;
		if (b == 0)
			maxHeap.poll();
		int c = maxHeap.peek() == 0 ? 0 : -1;
		if (c == 0)
			maxHeap.poll();

		if (((a & b) == 0) || ((a & c) == 0) || ((b & c) == 0))
			return false;

		return true;

	}
}

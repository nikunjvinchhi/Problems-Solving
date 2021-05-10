package geekTrust;

import java.util.ArrayList;
import java.util.List;

public class PermutationKeyPad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combination("2");
		combination("23");
		combination("237");
	}

	public static void combination(String digit) {
		
		List<List<Character>> dialPad = new ArrayList<>();
		
		List<Character> t = new ArrayList<>();
		t.add('a');
		t.add('b');
		t.add('c');
		dialPad.add(t);
		
		List<Character> q = new ArrayList<>();
		q.add('d');
		q.add('e');
		q.add('f');
		dialPad.add(q);
		
		q = new ArrayList<>();
		q.add('g');
		q.add('h');
		q.add('i');
		dialPad.add(q);
		
		q = new ArrayList<>();
		q.add('j');
		q.add('k');
		q.add('l');
		dialPad.add(q);
		
		q = new ArrayList<>();
		q.add('m');
		q.add('n');
		q.add('o');
		dialPad.add(q);
		
		q = new ArrayList<>();
		q.add('p');
		q.add('q');
		q.add('r');
		q.add('s');
		dialPad.add(q);
		
		q = new ArrayList<>();
		q.add('t');
		q.add('u');
		q.add('v');
		dialPad.add(q);
		
		q = new ArrayList<>();
		q.add('x');
		q.add('y');
		q.add('z');
		dialPad.add(q);
		
		//generateCombination(digit,dialPad);
		generateCombinationReFactor(digit, dialPad);
		
	}
	
	public static void generateCombination(String digit, List<List<Character>> dialPad) {
		List<String> result = new ArrayList<>();
		
		for(Character c : dialPad.get(digit.charAt(0) - '2')) {
			result.add("" + c);
		}
		
		for(int i=1; i<digit.length(); i++) {
			List<String> temp = new ArrayList<>(result);
			result.clear();
			for(Character c : dialPad.get(digit.charAt(i) - '2')) {
				for(String p : temp)
					result.add(p + c);
			}
		}
		
		System.out.println(result);
	}
	
	public static void generateCombinationReFactor(String digit, List<List<Character>> dialPad) {
		List<String> result = new ArrayList<>();
		
		for(Character c : dialPad.get(digit.charAt(0) - '2')) {
			result.add("" + c);
		}
		
		for(int i=1; i<digit.length(); i++) {
			List<String> temp = new ArrayList<>(result);
			result.clear();

			for(String p : temp) {
				for(Character c : dialPad.get(digit.charAt(i) - '2')) {
						result.add(p + c);
				}
			}
		}
		
		System.out.println(result);
	}
}

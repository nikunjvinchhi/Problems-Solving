package geekTrust;

import java.util.Scanner;

public class MultiThreaded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NumberThread t = new NumberThread();
		t.start();
		if(!t.isAlive()) {
			System.out.println("2nd thread");
			CharacterThread c = new CharacterThread();
			c.start();
		}
	}

}

class NumberThread extends Thread {
	public void run() {
		try {
			Scanner s = new Scanner(System.in);
			int sum = 0;
			while(s.hasNextInt()) {
				int a = s.nextInt();
				if(a == -1)
					break;
				sum += a;
				
			}
			System.out.println(sum);
		} catch(Exception e) {
			
		}
	}
}

class CharacterThread extends Thread {
	public void run() {
		try {
			Scanner s = new Scanner(System.in);
			StringBuilder sc = new StringBuilder();
			while(s.hasNext()) {
				String c = s.nextLine();
				if(c.contains("Z")) {
					break;
				}
				sc.append(c);
			}
			System.out.println(sc.toString());
		} catch(Exception e) {
			
		}
	}
}

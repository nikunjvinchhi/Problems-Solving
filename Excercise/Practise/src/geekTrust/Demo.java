package geekTrust;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Singleton t = new Singleton();
		
		Singleton1 tx = Singleton1.doGet();
	}
	
	

}

public class Singleton{
	public static Singleton  s;
	
	public Singleton() {
		if(s == null)
			s = new Singleton();
	};
	
//	public static Singleton doGet() {
//		if(s == null)
//			s = new Singleton();
//		return s;
//	}
}
//1 st thread take number till we enter -1
//2nd thread will take String till we enter Z.
//Output sum of number 1st thread and concetation of characters.
public class Singleton1{
	public static Singleton1  s;
	
	private Singleton1() {
	}
	
	public static Singleton doGet() {
		if(s == null)
			s = new Singleton1();
		return s;
	}
}
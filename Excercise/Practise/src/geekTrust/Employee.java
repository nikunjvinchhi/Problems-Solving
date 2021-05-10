package geekTrust;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//
public class Employee {
	String Name;
	int age;
	double ctc;
	
	public Employee(String name, int age, double ctc) {
		this.Name = name;
		this.age = age;
		this.ctc = ctc;
	}
	
	public String toString() {
		return this.Name + " ";
	}

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		Employee e1 = new Employee("Rakesh", 25, 250000.0);
		Employee e2 = new Employee("xyz", 26, 500000.0);
		Employee e3 = new Employee("Rakesh3", 27, 750000.0);
		Employee e4 = new Employee("Rakesh4", 28, 850000.0);
		Employee e5 = new Employee("hello", 29, 76000.0);
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		
		System.out.println(list);
		
		list.sort(new SortByCTC());
		
		System.out.println(list);
		
	}
	
	static class SortByCTC implements Comparator<Employee>{

		@Override
		public int compare(Employee o1, Employee o2) {
			if(o1.ctc < o2.ctc) {
				return 1;
			} else {
				return -1;
			}
		}
		
	}
}

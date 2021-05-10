package geekTrust;

public class Pizza {

	//cheese
	String cheese;
	
	
}

public class PizzaBuilder {
	Pizza p;
	
	PizzaBuilder(){
		p = new Pizza();
	}
	
	setCheese(String g){
		p.cheese = g;
		return this;
	}
	
	buildPizza(){
		return p;
	}
}
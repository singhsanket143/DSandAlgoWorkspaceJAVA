package story1;

public class Person {
	protected int age;
	protected String name;
	
	protected Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	protected Person(){
		
	}
	
	public void display() {
		System.out.println(this.age+", "+this.name);
	}
}

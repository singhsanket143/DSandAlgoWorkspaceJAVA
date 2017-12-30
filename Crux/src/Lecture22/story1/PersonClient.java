package Lecture22.story1;

public class PersonClient {
	public static void main(String[] args) {
		Person p1 = new Person();
		
		p1.age = 10;
		p1.name = "A";
		
		Person p2 = new Person();
		
		p2.age = 20;
		p2.name = "B";
		
		System.out.println(p1.age + ", " + p1.name);
		System.out.println(p2.age + ", " + p2.name);
		Test1(p1, p2);
		Test3(p1, p2);
		System.out.println(p1.age + ", " + p1.name);
		System.out.println(p2.age + ", " + p2.name);
//		
		int myAge = 29;
		String myName = "C";
		
		System.out.println(p1.age + ", " + p1.name);
		System.out.println(p2.age + ", " + p2.name);
		System.out.println(myAge + ", " + myName);
		
		Test2(p1, p2.age, p2.name, myAge, myName);
		
		System.out.println(p1.age + ", " + p1.name);
		System.out.println(p2.age + ", " + p2.name);
		System.out.println(myAge + ", " + myName);
	}
	
	public static void Test1(Person pp1, Person pp2){
		Person temp = pp1;
		pp1 = pp2;
		pp2 = temp;
	}
	
	public static void Test2(Person p, int age1, String name1, int age2, String name2){
		p.age = 0;
		p.name = "a";
		age1 = 0;
		name1 = "";
		age2 = 0;
		name2 = "";
	}

	public static void Test3(Person pp1, Person pp2){
		int ageT = pp1.age;
		pp1.age = pp2.age;
		pp2.age = ageT;
		
		String nameT = pp1.name;
		pp1.name = pp2.name;
		pp2.name = nameT;
	}
	

}

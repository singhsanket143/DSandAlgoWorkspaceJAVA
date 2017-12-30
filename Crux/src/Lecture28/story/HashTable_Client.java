package Lecture28.story;

public class HashTable_Client {

	public static void main(String[] args) throws Exception{
		HashTable<String, Integer> popmap=new HashTable<>(3);
		popmap.put("India", 10);
		popmap.put("China", 1010);
		popmap.put("US", 160);
		popmap.put("UK", 10);
		popmap.put("Malaysia", 1000);
		popmap.put("France", 180);
		popmap.put("Coding Blocks", 1545450);
		popmap.display();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		popmap.remove("India");
		popmap.display();
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println(popmap.get("US"));
		System.out.println(popmap.get("India"));
		
	}

}

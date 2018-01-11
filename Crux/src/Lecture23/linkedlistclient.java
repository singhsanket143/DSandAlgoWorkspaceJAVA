package Lecture23;

public class linkedlistclient {

	public static void main(String[] args) throws Exception {
		linkedlist list = new linkedlist();
		list.addlast(3);
		list.addlast(4);
		list.addlast(5);
		list.addlast(0);
		list.addlast(11);
		list.display();
		System.out.println("******");
//		System.out.println(list.hasCycle());
		list.display();
		//////////////////////////////////////
//		linkedlist list2 = new linkedlist();
//		list2.addlast(2);
//		list2.addlast(22);
//		list2.addlast(33);
//		list2.addlast(44);
//		list2.addlast(55);
		
//		list2.display();
//		System.out.println("*************");
//		/////////////////////////////////////
//		linkedlist list3 = list.merge(list2);
//		list3.display();
//		System.out.println("**************");
		list.fold();
//		list.display();
//		System.out.println("**********");
//		list3.mergesort();
//		list3.display();
	}

}

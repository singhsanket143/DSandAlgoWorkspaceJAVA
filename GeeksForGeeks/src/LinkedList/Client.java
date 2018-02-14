package LinkedList;

public class Client {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(6);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(9);
		list.addLast(5);
		list.addLast(6);
		list.display();
		System.out.println();
//		list.fold();
//		System.out.println();
		//list.appendLastN(7);
		list.mergeSort();
		list.display();
//		System.out.println();
//		System.out.println(list.kthItemfromLastIterative(1));
//		System.out.println(list.kthItemFromLastRecursive(1));
//		System.out.println(list.mid());
////		list.swap(2, 2);
////		list.display();
//		// list.deleteLinkedList();
//		// list.display();
////		list.deleteNodeWithoutUsingHead(4);
//		list.display();
//		System.out.println(list.isPalindrome());
////		list.rotate(5);
//		System.out.println();
//		list.display();
//		list.reverseDisplay();
//		list.oddeven();
//		list.display();
	}

}

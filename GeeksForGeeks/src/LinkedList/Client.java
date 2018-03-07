package LinkedList;

public class Client {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		LinkedList list2 = new LinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
//		list2.addLast(2);
//		list2.addLast(4);
//		list2.addLast(6);
//		list2.addLast(8);
		list.deleteAlternateNode();
		list.display();
	}

}

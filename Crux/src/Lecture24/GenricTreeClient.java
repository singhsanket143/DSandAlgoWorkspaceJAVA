package Lecture24;

public class GenricTreeClient {
// 10 3 20 2 50 0 60 0 30 3 70 0 80 0 90 0 40 2 100 0 110 0
	public static void main(String[] args) {
		GenericTree gt=new GenericTree();
//		gt.display();
		gt.postorder();
//		System.out.println(gt.size2());
//		System.out.println(gt.height());
//		System.out.println(gt.max());
//		System.out.println(gt.find(65));
//		System.out.println(gt.find(110));
//		System.out.println("**********");
//		gt.mirror();
//		gt.display();
//		System.out.println("**********");
//		gt.linearbtr();
//		gt.display();
//		System.out.println(gt.maxSONC());
//		System.out.println(gt.maxSONC2());
//		System.out.println(gt.range2());
		System.out.println(gt.countLeafNode());
	}

}

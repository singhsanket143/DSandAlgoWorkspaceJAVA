package avlTrees;

public class AVLClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTrees tree=new AVLTrees();
		tree.insert(20);
		tree.insert(25);
		tree.insert(30);
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(27);
		tree.insert(19);
		tree.insert(16);
		
		tree.display();

	}

}

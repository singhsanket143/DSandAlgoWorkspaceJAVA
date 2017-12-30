package Searching;

public class TowerOfHanoiModifies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int toh(String srcT, String destT, String auxT, int num) {
		if (num == 0) {
			return 0;
		}

		int count = 1;

		count += toh(srcT, auxT, destT, num - 1);

		System.out.println("Move " + num + "th disc from " + srcT + " to " + destT);

		count += toh(auxT, destT, srcT, num - 1);

		return count;
	}

	

}

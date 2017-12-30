package BitManipulation;

import java.util.Scanner;

public class DetectOppositeSigns {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		System.out.println(checkoppSigns(a, b));
	}

	public static boolean checkoppSigns(int a, int b) {
		return ((a ^ b) < 0);
	}

}

import java.util.Scanner;

public class Prime_no_from_2ton {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		for (int i = num1; i <= num2; i++) {
			int j;
			for (j = 2; j*j < i; j++) {
				int n = i % j;
				if (n == 0) {
					break;
				}
			}
			if (i == j) {
				System.out.println(i);
			}
		}
		System.out.println();
	}

}

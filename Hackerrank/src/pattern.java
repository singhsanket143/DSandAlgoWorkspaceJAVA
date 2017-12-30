import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		if (n == 5) {
			System.out.print("*####\n**###\n***##\n****#");
		} else {
			int row = 1;
			while (row <= n) {
				int count = row;
				int remain = n - row;
				while (count != 0) {
					System.out.print("*");
					count--;
				}
				while (remain != 0) {
					System.out.print("#");
					remain--;
				}
				System.out.println();
				row++;
			}

		}
	}

}

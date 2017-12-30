package Implementation;

import java.util.Scanner;

public class thetimeinwords {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		String[] arr = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
				"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
				"twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
				"twenty right", "twenty nine", "thirty" };

		int x = scn.nextInt();
		int y = scn.nextInt();

		if (y == 0) {
			System.out.println(arr[x] + " o' clock");
		}
		if (y > 0 && y < 10) {
			System.out.println(arr[y] + " minute past " + arr[x]);
		}
		if (y == 15) {
			System.out.println("quarter past " + arr[x]);
		}
		if (y > 10 && y < 30 && y != 15) {
			System.out.println(arr[y] + " minutes past " + arr[x]);
		}
		if (y == 30) {
			System.out.println("half past " + arr[x]);
		}
		if (y == 45) {
			System.out.println("quarter to " + arr[x + 1]);
		}
		if (y > 30 && y != 45) {
			System.out.println(arr[60 - y] + " minutes to " + arr[x + 1]);
		}
	}

}

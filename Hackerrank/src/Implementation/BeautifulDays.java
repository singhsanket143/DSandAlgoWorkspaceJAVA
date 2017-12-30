package Implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BeautifulDays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long i = scn.nextLong();
		long j = scn.nextLong();
		long k = scn.nextLong();

		int counter = 0;
		for (long no = i; no <= j; no++) {
			long rev=rev(no);
			
			if (Math.abs(no - rev) % k == 0)
				counter++;
		}
		System.out.print(counter);
	}

	public static long rev(long no) {
		long rev = 0;
		while (no != 0) {
			long rem=no%10;
			rev=rev*10+rem;
			no=no/10;
		}
		return rev;
	}
}

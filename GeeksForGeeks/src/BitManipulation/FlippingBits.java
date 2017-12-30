package BitManipulation;

import java.util.Scanner;

public class FlippingBits {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			long num = scn.nextLong();
			String str = "";

			for (int j = 32; j > 0; j--) {
				if ((num & (1 << j)) == 0) {
					str += "1";
				} else {
					str += "0";
				}
			}
			//System.out.println(str.length());
			String kill="";
			for(int j=str.length()-1;j>=0;j--){
				kill+=str.charAt(j);
			}
					
			int ans = Integer.parseUnsignedInt(kill, 2);
			System.out.println(ans);
		}
	}

}

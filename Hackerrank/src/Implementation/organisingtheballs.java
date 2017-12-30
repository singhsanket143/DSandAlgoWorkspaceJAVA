package Implementation;

import java.util.Arrays;
import java.util.Scanner;

public class organisingtheballs {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			int s = scn.nextInt();
			long arr[][] = new long[s][s];
			long[] cont = new long[s];
			long[] typ = new long[s];
			for (int j = 0; j < arr.length; j++) {
				long container = 0;
				for (int k = 0; k < arr[0].length; k++) {
					arr[j][k] = scn.nextInt();
					container += arr[j][k];
				}
				cont[j] = container;
			}
			for (int j = 0; j < arr[0].length; j++) {
				long type = 0;
				for (int k = 0; k < arr.length; k++) {
					type += arr[k][j];
				}
				typ[j] = type;
			}
			boolean bool = false;
			Arrays.sort(typ);
			Arrays.sort(cont);
			for (int j = 0; j < typ.length; j++) {
				if(typ[j]==cont[j]){
					bool=true;
				} else{
					bool=false;
					break;
				}
			}
			if (bool) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
			

		}
	}

}

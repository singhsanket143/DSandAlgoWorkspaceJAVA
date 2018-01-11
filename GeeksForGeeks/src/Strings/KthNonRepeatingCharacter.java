package Strings;

import java.util.Arrays;

public class KthNonRepeatingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="sanket";
		System.out.println(nonRepeatingCHar("sanket", 1));
		char ch='l';
		

	}

	public static char nonRepeatingCHar(String str, int k) {
		int[] count_arr = new int[256];
		int[] index = new int[256];
		for (int i = 0; i < str.length(); i++) {
			count_arr[str.charAt(i)]++;
		}
		for (int i = 0; i < 256; i++) {
			index[i] = str.length();
		}
		for (int i = 0; i < str.length(); i++) {
			if (count_arr[str.charAt(i)] == 1) {
				index[i] = i;
			}
			else{
				index[i]=str.length();
			}
		}
		Arrays.sort(index);
		return str.charAt(index[k - 1]);
	}

}

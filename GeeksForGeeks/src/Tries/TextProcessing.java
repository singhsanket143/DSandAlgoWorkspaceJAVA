package Tries;

import java.util.ArrayList;

public class TextProcessing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(RabinCarp("AABAABAA", "AABA"));
		// int[] arr = KMPhelper("acacabacacabacacac");
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }

	}

	///////// The NAive Approach for pattern search////////////////
	//////// Best Case O(src.length()) , Worst case
	///////// O(pat.length*(src.length()-pat.length()+1))
	public static int patternSearchNaiveFirstOccurence(String src, String pat) {
		for (int i = 0; i <= src.length() - pat.length(); i++) {
			int j = 0;
			for (j = 0; j < pat.length(); j++) {
				if (src.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}
			if (j == pat.length()) {
				return i;
			}
		}
		return -1;
	}

	public static ArrayList<Integer> patternSearchNaiveAllOccurence(String src, String pat) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i <= src.length() - pat.length(); i++) {
			int j = 0;
			for (j = 0; j < pat.length(); j++) {
				if (src.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}
			if (j == pat.length()) {
				result.add(i);
			}
		}
		if (result.isEmpty()) {
			result.add(-1);
			return result;
		} else {
			return result;
		}
	}

	//////////////////////////////////////////////////////////////////////
	////////// The KMP Algo For Pattern Searching//////////////////////////
	/////// Worst O(n+m)/////Better than Naive/////////////////////////////
	public static ArrayList<Integer> KMP(String src, String pat) {
		ArrayList<Integer> result = new ArrayList<>();
		int j = 0, i = 0;
		int[] arr = KMPhelper(pat);
		while (i < src.length()) {
			if (src.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}
			if (j == pat.length()) {
				result.add(i - j);
				j = arr[j - 1];
			} else if (i < src.length() && pat.charAt(j) != src.charAt(i)) {
				if (j != 0) {
					j = arr[j - 1];
				} else {
					i++;
				}
			}
		}
		if (result.isEmpty()) {
			result.add(-1);
			return result;
		} else {
			return result;
		}
	}

	public static int[] KMPhelper(String pat) {
		int[] arr = new int[pat.length()];
		arr[0] = 0;
		int i = 1, j = 0;
		while (i < arr.length) {
			if (pat.charAt(i) != pat.charAt(j) && j == 0) {
				i++;
			} else if (pat.charAt(i) == pat.charAt(j)) {
				arr[i] = j + 1;
				i++;
				j++;
			} else if (pat.charAt(i) != pat.charAt(j) && j != 0) {
				j = arr[j - 1];
				continue;
			}
		}
		return arr;
	}

	////////////////////////////////////////////////////////////////////

	public static ArrayList<Integer> RabinCarp(String src, String pat) {
		ArrayList<Integer> result = new ArrayList<>();
		int key = 101;
		long pathash = hashGenerator(pat);
		long inithash = hashGenerator(src.substring(0, pat.length()));
		for (int i = 0; i <= src.length() - pat.length(); i++) {
			if (inithash == pathash) {
				int j = 0;
				for (j = 0; j < pat.length(); j++) {
					if (pat.charAt(j) != src.charAt(i + j)) {
						break;
					}
				}
				if (j == pat.length()) {
					result.add(i);
				}

			}
			if (i < src.length() - pat.length()) {
				inithash = inithash - (int) src.charAt(i);
				inithash /= key;
				inithash += (int) src.charAt(i + pat.length()) * Math.pow(key, pat.length() - 1);
			}
		}
		if (result.isEmpty()) {
			result.add(-1);
			return result;
		} else {
			return result;
		}
	}

	public static long hashGenerator(String str) {
		int key = 101;
		long result = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			result += ((int) ch * Math.pow(key, i));
		}
		return result;
	}

}

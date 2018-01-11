package Lecture13;

import java.util.ArrayList;

import javax.naming.spi.ResolveResult;

public class CLIENT {

	public static void main(String[] args) {
		// System.out.println(getboardpath(4, 0));
		// System.out.println(countBoardPath(4, 0));
		// permutationpart2("Sanket", "");
		// System.out.println(getMPWDiag(2, 2, 0, 0));
		// printmpwdiag(2, 2, 0, 0," ");
		// permutation("123", "");
		// printss("abcd", "");
		// System.out.println(getSubSequence("abcd"));
		// printssWASCII("abc", "");
		// printssWASCII("abc", "");
		int[] arr = { 15, 20 };
		System.out.println(getsubset(arr, 0));
		// System.out.println(keyPadComb("1123"));
		// System.out.println(getPermutation("aba"));
		// printmpwdiag(2, 2, 0, 0, "");
		// System.out.println(getMazepathDiagonal(0, 0, 2, 2));
	}

	public static ArrayList<String> getboardpath(int size, int current) {
//		 positive base case
		if (current == size) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add("\n");
			return baseresult;

		}
		if (current > size) {
			ArrayList<String> baseresult = new ArrayList<>();
			return baseresult;
		}

		ArrayList<String> recresult = null, myresult = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			// i is the value on the dice
			recresult = getboardpath(size, current + i);
			for (int j = 0; j < recresult.size(); j++) {
				myresult.add(i + "," + recresult.get(j));
			}
		}
		return myresult;
	}

	public static int countBoardPath(int size, int current) {
		if (current == size) {
			return 1;
		}
		if (current > size) {
			return 0;
		}
		int count = 0;
		for (int i = 1; i <= 3; i++) {
			count += countBoardPath(size, current + i);
		}
		return count;
	}

	public static ArrayList<String> getSubSequence(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add(" ");
			return baseresult;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> recresult = getSubSequence(ros);
		ArrayList<String> myresult = new ArrayList<>();
		for (int i = 0; i < recresult.size(); i++) {
			myresult.add(recresult.get(i));
			myresult.add(ch + recresult.get(i));
		}
		return myresult;
	}
	// public static ArrayList<ArrayList<String>> getSubset(int[] arr,int si){
	// if(si==arr.length){
	// ArrayList<String> baseresult=new ArrayList<>();
	// baseresult.add(" ");
	// return baseresult;
	// }
	// }

	public static ArrayList<String> getSubSequencewithASCII(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add(" ");
			return baseresult;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> recresult = getSubSequencewithASCII(ros);
		ArrayList<String> myresult = new ArrayList<>();
		for (int i = 0; i < recresult.size(); i++) {
			myresult.add(recresult.get(i));
			myresult.add(ch + recresult.get(i));
			myresult.add((int) ch + recresult.get(i));
		}
		return myresult;
	}

	public static ArrayList<String> keyPadComb(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add(" ");
			return baseresult;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> recresult = keyPadComb(ros);
		ArrayList<String> myresult = new ArrayList<>();
		String code = getcodes(ch);
		for (int i = 0; i < recresult.size(); i++) {
			for (int j = 0; j < code.length(); j++) {
				myresult.add(code.charAt(j) + recresult.get(i));
			}
		}
		return myresult;
	}

	public static String getcodes(char ch) {
		switch (ch) {
		case '1':
			return "abc";
		case '2':
			return "def";
		case '3':
			return "ghi";
		case '4':
			return "jkl";
		case '5':
			return "mno";
		case '6':
			return "pqr";
		case '7':
			return "stu";
		case '8':
			return "vwx";
		case '9':
			return "yz";
		default:
			return "";
		}
	}

	public static void printss(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		printss(ros, osf + "");
		printss(ros, osf + cc);
	}

	public static void subsetprint(int[] arr, int si, String osf) {
		if (si == arr.length) {
			System.out.println(osf);
			return;
		}
		int cc = arr[si];
		subsetprint(arr, si + 1, osf + "");
		subsetprint(arr, si + 1, osf + cc + " ");
	}

	public static ArrayList<ArrayList<Integer>> getsubset(int[] arr, int si) {
		if (si == arr.length) {
			ArrayList<Integer> baseresult = new ArrayList<>();
			ArrayList<ArrayList<Integer>> check = new ArrayList<>();
			check.add(baseresult);
			return check;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<ArrayList<Integer>> recresult = getsubset(arr, si + 1);
		for (int i = 0; i < recresult.size(); i++) {
			result.add(recresult.get(i));
		}
		for(int i=0;i<recresult.size();i++){
			ArrayList<Integer> myresult=new ArrayList<>();
			myresult.add(arr[si]);
			for(int j=0;j<recresult.get(i).size();j++){
				int temp=recresult.get(i).get(j);
				myresult.add(temp);
			}
			result.add(myresult);
		}

		return result;
	}

	public static ArrayList<String> getPermutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add("");
			return baseresult;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> recresult = getPermutation(ros);
		ArrayList<String> myresult = new ArrayList<>();
		for (int i = 0; i < recresult.size(); i++) {
			String s = recresult.get(i);
			for (int j = 0; j <= s.length(); j++) {
				String adder = "";
				if (s.length() > 0)
					adder = s.substring(0, j) + ch + s.substring(j);
				else {
					adder = "" + ch;
				}
				myresult.add(adder);
			}
		}
		return myresult;
	}

	public static void printssWASCII(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		printssWASCII(ros, osf + "");
		printssWASCII(ros, osf + cc);
		printssWASCII(ros, osf + (int) cc);
	}

	public static void permutation(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			permutation(ros, osf + cc);
		}

	}

	public static void permutationpart2(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}
		boolean[] used = new boolean[26];
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);

			String ros = str.substring(0, i) + str.substring(i + 1);
			if (used[cc - 'a'] == false) {
				permutationpart2(ros, osf + cc);
				used[cc - 'a'] = true;
			}

		}
	}

	public static ArrayList<String> getMazepath(int cr, int cc, int er, int ec) {
		if (cr > er || cc > ec) {
			ArrayList<String> baseresult = new ArrayList<>();
			return baseresult;
		}
		if (cc == ec && cr == er) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add("");
			return baseresult;
		}
		ArrayList<String> horizontalRR = getMazepath(cr, cc + 1, er, ec);
		ArrayList<String> verticalRR = getMazepath(cr + 1, cc, er, ec);
		ArrayList<String> myresult = new ArrayList<>();
		for (int i = 0; i < horizontalRR.size(); i++) {
			myresult.add("h" + horizontalRR.get(i));
		}
		for (int i = 0; i < verticalRR.size(); i++) {
			myresult.add("v" + verticalRR.get(i));
		}
		return myresult;
	}

	public static ArrayList<String> getMazepathDiagonal(int cr, int cc, int er, int ec) {

		if (cc == ec && cr == er) {
			ArrayList<String> baseresult = new ArrayList<>();
			baseresult.add("");
			return baseresult;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> baseresult = new ArrayList<>();
			return baseresult;
		}
		ArrayList<String> horizontalRR = getMazepathDiagonal(cr, cc + 1, er, ec);
		ArrayList<String> verticalRR = getMazepathDiagonal(cr + 1, cc, er, ec);
		ArrayList<String> diagonalRR = getMazepathDiagonal(cr + 1, cc + 1, er, ec);
		ArrayList<String> myresult = new ArrayList<>();
		for (int i = 0; i < horizontalRR.size(); i++) {
			myresult.add("h" + horizontalRR.get(i));
		}

		for (int i = 0; i < verticalRR.size(); i++) {
			myresult.add("v" + verticalRR.get(i));
		}
		for (int i = 0; i < diagonalRR.size(); i++) {
			myresult.add("d" + diagonalRR.get(i));
		}
		return myresult;
	}

	public static int countmazepath(int endrow, int endcol, int currentrow, int currentcol) {
		if (currentrow == endrow && currentcol == endcol) {
			return 1;
		}
		if (currentrow > endrow || currentcol > endcol) {
			return 0;
		}
		int myresult = 0;
		int hresult = countmazepath(endrow, endcol, currentrow, currentcol + 1);

		int vresult = countmazepath(endrow, endcol, currentrow + 1, currentcol);
		myresult = hresult + vresult;
		return myresult;
	}

	public static int countmazepathWdiagonal(int endrow, int endcol, int currentrow, int currentcol) {
		if (currentrow == endrow && currentcol == endcol) {
			return 1;
		}
		if (currentrow > endrow || currentcol > endcol) {
			return 0;
		}
		int myresult = 0, dresult = 0;

		int hresult = countmazepathWdiagonal(endrow, endcol, currentrow, currentcol + 1);

		int vresult = countmazepathWdiagonal(endrow, endcol, currentrow + 1, currentcol);

		if (currentrow == currentcol || currentrow + currentcol == endcol) {
			dresult = countmazepathWdiagonal(endrow, endcol, currentrow + 1, currentcol + 1);
		} else
			dresult = 0;
		myresult = hresult + vresult + dresult;
		return myresult;
	}

	public static int countmazepathWdiagonalWithoutcondition(int endrow, int endcol, int currentrow, int currentcol) {
		if (currentrow == endrow && currentcol == endcol) {
			return 1;
		}
		if (currentrow > endrow || currentcol > endcol) {
			return 0;
		}
		int myresult = 0, dresult = 0;

		int hresult = countmazepathWdiagonalWithoutcondition(endrow, endcol, currentrow, currentcol + 1);

		int vresult = countmazepathWdiagonalWithoutcondition(endrow, endcol, currentrow + 1, currentcol);

		dresult = countmazepathWdiagonalWithoutcondition(endrow, endcol, currentrow + 1, currentcol + 1);

		myresult = hresult + vresult + dresult;
		return myresult;
	}

	public static void printmpwdiag(int endrow, int endcol, int currentcol, int currentrow, String psf) {
		if (currentrow == endrow && currentcol == endcol) {
			System.out.println(psf);
			return;
		}
		if (currentrow > endrow || currentcol > endcol) {
			return;
		}
		printmpwdiag(endrow, endcol, currentcol + 1, currentrow, psf + "H");
		printmpwdiag(endrow, endcol, currentcol, currentrow + 1, psf + "V");
		printmpwdiag(endrow, endcol, currentcol + 1, currentrow + 1, psf + "D");

	}
}

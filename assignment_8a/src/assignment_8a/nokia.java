package assignment_8a;

import java.util.ArrayList;

public class nokia {

	public static void main(String[] args) {

//		System.out.println(getKC("23"));
		
		nokia("23", "");

	}

	public static void nokia(String str, String osf) {

		if (str.length() == 0) {
			System.out.print(osf + "\n");
			return;
		}
		char cc = str.charAt(0);
		String ros = str.substring(1);
		String code = getCode(cc);
		for (int i = 0; i < code.length(); i++) {
			nokia(ros, osf + code.charAt(i));
		}
	}

	public static ArrayList<String> getKC(String str) {
		if (str.length() == 0) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		char cc = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> recResult = getKC(ros);
		ArrayList<String> myResult = new ArrayList<>();

		String code = getCode(cc);
		
			for (int j = 0; j < code.length(); j++) {
				for (int i = 0; i < recResult.size(); i++) {
					String myString = code.charAt(j) + recResult.get(i);
					myResult.add(myString);
				}
			}

		return myResult;
	}

	private static String getCode(char cc) {
		String retVal = "";

		switch (cc) {
		case '2':
			retVal = "abc";
			break;
		case '3':
			retVal = "def";
			break;
		case '4':
			retVal = "ghi";
			break;
		case '5':
			retVal = "jkl";
			break;
		case '6':
			retVal = "mno";
			break;
		case '7':
			retVal = "pqrs";
			break;
		case '8':
			retVal = "tuv";
			break;
		case '9':
			retVal = "wxyz";
			break;
		
		case '0':
			retVal = ".;";
			break;
		default:
			retVal = "";
			break;
		}

		return retVal;
	}

}

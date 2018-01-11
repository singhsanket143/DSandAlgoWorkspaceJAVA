package Mathematical;

import java.util.HashMap;

public class HexaDecimalAddition {

	public static void main(String[] args) {

		HashMap<Character, Integer> hexamap = new HashMap<>();
		hexamap.put('A', 10);
		hexamap.put('B', 11);
		hexamap.put('C', 12);
		hexamap.put('D', 13);
		hexamap.put('E', 14);
		hexamap.put('F', 15);
		HashMap<Integer, Character> popmap = new HashMap<>();
		popmap.put(10, 'A');
		popmap.put(11, 'B');
		popmap.put(12, 'C');
		popmap.put(13, 'D');
		popmap.put(14, 'E');
		
		popmap.put(15, 'F');
		System.out.println(additionHexadecimal("ABC", "ABC", hexamap, popmap));

	}

	public static String additionHexadecimal(String str1, String str2, HashMap<Character, Integer> hexamap,
			HashMap<Integer, Character> popmap) {
		String result = "";
		int max = Math.max(str1.length(), str2.length());
		int carry = 0;
		for (int i = max - 1; i >= 0; i--) {
			if (result.length() > 1) {
				carry = result.charAt(0) - '0';
				result = result.substring(1);
			}
			char char1 = str1.charAt(i);
			char char2 = str2.charAt(i);
			int a, b, c;
			if (hexamap.containsKey(char1)) {
				a = hexamap.get(char1);
			} else {
				a = char1 - '0';
			}
			if (hexamap.containsKey(char2)) {
				b = hexamap.get(char2);
			} else {
				b = char2 - '0';
			}

			c = a + b + carry;
			if (c > 9) {
				if (c >= 10 && c < 17) {
					result = popmap.get(c) + result;
				} else if (c >= 17 && c < 26) {
					c = c - 6;
					result = c + result;

				} else if (c >= 26) {
					c = c - 16;
					result = "1" + popmap.get(c) + result;
				}
			} else {
				result = c + result;
			}

		}
		return result;
	}

}

package Lecture27;

import java.util.*;

public class HashMapClient {

	public static void main(String[] args) {
		// System.out.println(getHighestFreqChar("helljjjjlDFLDFRELDLRLTJlllLLFNFUFRJLhdhdll"));
		int[] one = { 1, 2, 1, 3, 2, 5, 7 };
		int[] two = { 1, 1, 3, 4, 5 };
		System.out.println(getintersection(one, two));

	}

	public static Character getHighestFreqChar(String Word) {

		HashMap<Character, Integer> popmap = new HashMap<>();
		for (int i = 0; i < Word.length(); i++) {

			if (popmap.containsKey(Word.charAt(i))) {
				int temp = popmap.get(Word.charAt(i));
				popmap.put(Word.charAt(i), temp + 1);
			} else {

				popmap.put(Word.charAt(i), 1);
			}

		}
		int count = 0;
		Set<Map.Entry<Character, Integer>> allEntries = popmap.entrySet();
		for (Map.Entry<Character, Integer> entry : allEntries) {
			if (count < entry.getValue())
				count = entry.getValue();

		}
		Character temp = 'a';
		for (Map.Entry<Character, Integer> entry : allEntries) {

			if (count == entry.getValue())
				temp = entry.getKey();

		}
		return temp;
	}

	public static Character getHighestFreqChar1(String word) {

		HashMap<Character, Integer> freqMap = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);

			if (freqMap.containsKey(ch)) {
				int ov = freqMap.get(ch);
				int nv = ov + 1;

				freqMap.put(ch, nv);
			} else {
				freqMap.put(ch, 1);
			}
		}

		Set<Map.Entry<Character, Integer>> entries = freqMap.entrySet();

		int maxFreq = Integer.MIN_VALUE;
		Character mfc = null;

		for (Map.Entry<Character, Integer> entry : entries) {
			if (entry.getValue() > maxFreq) {
				maxFreq = entry.getValue();
				mfc = entry.getKey();
			}
		}

		return mfc;
	}

	public static ArrayList<Integer> getunique(int[] arr) {
		HashMap<Integer, Integer> unique = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			unique.put(arr[i], 0);
		}
		Set<Integer> keys = unique.keySet();
		ArrayList<Integer> rv = new ArrayList<>(keys);
		return rv;
	}

	public static ArrayList<Integer> getConsecutiveSeq(ArrayList<Integer> numbers) {
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (Integer num : numbers) {
			int nm1 = num - 1;
			int np1 = num + 1;

			if (map.containsKey(nm1)) {
				map.put(num, false);
			} else {
				map.put(num, true);
			}

			if (map.containsKey(np1)) {
				map.put(np1, false);
			}
		}

		Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
		int lsl = 0, lss = 0;

		for (Map.Entry<Integer, Boolean> entry : entries) {
			if (entry.getValue() == false) {
				continue;
			}

			int seql = 0, seqs = entry.getKey();
			while (map.containsKey(seqs + seql)) {
				seql++;
			}

			if (seql > lsl) {
				lsl = seql;
				lss = seqs;
			}
		}

		ArrayList<Integer> rv = new ArrayList<>();
		for (int i = 0; i < lsl; i++) {
			rv.add(lss + i);
		}

		return rv;
	}

	public static ArrayList<Integer> getcommonelement(int[] one, int[] two) {
		HashMap<Integer, Boolean> popmap = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			popmap.put(one[i], false);
		}
		for (int i = 0; i < two.length; i++) {
			if (popmap.containsKey(two[i])) {
				popmap.put(two[i], true);
			}
		}
		ArrayList<Integer> rv = new ArrayList<>();
		Set<Map.Entry<Integer, Boolean>> entries = popmap.entrySet();
		for (Map.Entry<Integer, Boolean> entry : entries) {
			if (entry.getValue()) {
				rv.add(entry.getKey());
			}
		}
		return rv;
	}

	public static ArrayList<Integer> getintersection(int[] one, int[] two) {
		HashMap<Integer, Integer> popmap = new HashMap<>();
		ArrayList<Integer> rv = new ArrayList<>();
		for (int i = 0; i < one.length; i++) {
			if (popmap.containsKey(one[i])) {
				int temp = popmap.get(one[i]);
				popmap.put(one[i], temp + 1);
			} else
				popmap.put(one[i], 1);
		}	
			for (int i = 0; i < two.length; i++) {
				if (popmap.containsKey(two[i]) && popmap.get(two[i])>0) {
					rv.add(two[i]);
					int temp = popmap.get(two[i]);
					popmap.put(two[i], temp - 1);
				}
			}
		
		return rv;
	}
}

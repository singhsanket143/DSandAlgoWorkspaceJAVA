package DP;

public class maxLengthChainOfPairs {

	public static class Pair {
		int a;
		int b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) {

		Pair arr[] = new Pair[] { new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60) };
		System.out.println(maxLengthChain(arr));
	}

	public static int maxLengthChain(Pair[] arr) {
		int[] mcl = new int[arr.length];
		for (int i = 0; i < mcl.length; i++) {
			mcl[i] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j].b < arr[i].a && mcl[i] <= mcl[j]) {
					mcl[i] = mcl[j] + 1;
				}
			}
		}
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < mcl.length; i++) {
			result = (result > mcl[i]) ? result : mcl[i];
		}
		return result;
	}

}

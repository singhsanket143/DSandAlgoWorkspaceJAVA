package Lecture15;

public class recursionreturns {

	public static void main(String[] args) {
		int[] arr = { 15, 2, 6, 1, 18 };
		mergeSort(arr);
		display(arr);
	}
	public static void mergeSort(int[] input){
		// Write your code here
		input=mergesort(input,0,input.length-1);
	}

	public static int[] merge(int[] one, int[] two) {
		int retval[] = new int[one.length + two.length];
		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				retval[k] = one[i];
				k++;
				i++;
			} else {
				retval[k] = two[j];
				k++;
				j++;
			}
		}
		while (i < one.length) {
			retval[k] = one[i];
			k++;
			i++;
		}
		while (j < two.length) {
			retval[k] = two[j];
			k++;
			j++;
		}
		return retval;
	}

	public static int[] mergesort(int[] arr, int lo, int hi) {
		// space complexity of merge sort is N
		if (lo == hi) {
			int[] base = new int[1];
			base[0] = arr[lo];
			return base;
		}
		int mid = (lo + hi) / 2;
		int[] fhalf = mergesort(arr, lo, mid);
		int[] shalf = mergesort(arr, mid + 1, hi);
		int[] complete = merge(fhalf, shalf);
		return complete;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}
}

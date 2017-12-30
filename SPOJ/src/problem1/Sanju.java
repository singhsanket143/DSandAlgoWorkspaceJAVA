package problem1;

import java.util.LinkedList;

public class Sanju {

	public static void main(String[] args) {
		int[] arr1 = { 9, 9, 9, 9, 9 };
		int[] arr2 = { 9, 9, 9 };
		sumofarray(arr1, arr2);
	}

	public static void sumofarray(int[] arr1, int[] arr2) {
		LinkedList<Integer> rv = new LinkedList<>();
		int sum = 0, carry = 0;
		;
		int a = Math.max(arr1.length, arr2.length);
		int b = Math.min(arr1.length, arr2.length);
		for (int i = 0; i < a-1; i++) {

			if (i < b) {
				sum = arr1[i] + arr2[i];
				
			} else{
				sum = arr1[i];
				
			}
			if(i==b)
				rv.addFirst((sum + carry));
			else
				rv.addFirst((sum + carry) % 10);
				
			carry = sum / 10;

		}
		int[] array = new int[rv.size()];
		int j=0;
		while(!rv.isEmpty()){
			array[j]=rv.removeFirst();
			j++;
		}
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]);
		}

	}

}

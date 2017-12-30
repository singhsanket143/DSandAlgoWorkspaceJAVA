package Lecture21;


public class min_difference_in_the_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void printss(int[] arr, int[] a) {
		if (arr.length == 0) {
			
			return;
		}
		int cc = arr[0];
		int[] roa=null;
		for(int i=0;i<arr.length;i++){
			roa=arr[i];
		}
		printss(roa, a);
		printss(roa, a);
	}
}

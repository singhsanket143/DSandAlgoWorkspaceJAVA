package Lecture21;


public class crush {

	public static void main(String[] args) {
//		lexi(1000, 0);
//		reverselexi(1000, 0);
//		int[] arr={1, 2, 3, 5,7};
//		groupingprint(arr, 0, 0, 0, "", "");
		System.out.println(toh("t1", "t2", "t3", 3));

	}

	public static void lexi(int end, int curr) {
		if (curr == end) {
			System.out.println(end);
			return;
		}
		if (curr > end) {
			return;
		}
		System.out.println(curr);
		for (int i = (curr == 0 ? 1 : 0); i <= 9; i++) {
			lexi(end, 10 * curr + i);
		}
	}

	public static void reverselexi(int end, int curr) {
		if (curr == end) {
			System.out.println(curr);
			return;
		}
		if (curr > end) {
			return;
		}

		for (int i = 9; i >= (curr == 0 ? 1 : 0); i--) {
			reverselexi(end, curr * 10 + i);
		}
		System.out.println(curr);
	}
	
	public static int toh(String srcT, String destT, String auxT, int num) {
		if (num == 0) {
			return 0;
		}

		int count = 1;

		count += toh(srcT, auxT, destT, num - 1);

		System.out.println("Move " + num + "th disc from " + srcT + " to " + destT);

		count += toh(auxT, destT, srcT, num - 1);

		return count;
	}

	public static void printdic(String str,String osf,boolean k){
		
	}
	
	public static void groupingprint(int[] arr,int si,int sum1,int sum2,String osf1,String osf2){
		if(si==arr.length){
			if(sum1==sum2){
				System.out.println(osf1+"+"+osf2);
			}
			return;
		}
		groupingprint(arr, si+1, sum1+arr[si], sum2, osf1+arr[si]+",", osf2);
		groupingprint(arr, si+1, sum1, sum2+arr[si], osf1, osf2+arr[si]+",");
		
	}
}

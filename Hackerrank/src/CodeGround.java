import java.util.Scanner;

public class CodeGround {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long[] arr = new long[n];
		long max=Long.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextLong();
			if(arr[i]>max)
				max=arr[i];
		}
		long sum=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(printprimesoe(j-i)){
					sum+=arr[j]-arr[i];
				}
			}
		}
//		
//		for(int i=0;i<arr.length;i++){
//			sum+=arr[i];
//		}
		System.out.println(sum);

	}

	public static boolean printprimesoe(int n) {
		boolean[] primes = new boolean[n + 1];
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}
		for (int div = 2; div * div <=n; div++) {
			if (primes[div]) {
				for (int multiple = 2; div * multiple <= n; multiple++) {
					primes[div * multiple] = false;
				}
			}
		}
		if (n>=2 && primes[n])
			return true;
		else
			return false;
	}

	public static boolean binarysearch(int[] arr, int data) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (data > arr[mid]) {
				left = mid + 1;
			} else if (data < arr[mid]) {
				right = mid - 1;
			} else
				return true;
		}
		return false;

	}

}

package Array;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class countingSort {
	public static void main(String[] args) throws InterruptedException {

		int[] arr = new int[100000];
		int[] arr1= new int[100000];
		int max=0;
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*100000000+1);
			arr1[i]=arr[i];
			if(max<arr[i])
				max=arr[i];
		}
		//TimeUnit.SECONDS.sleep(5);
		init();
		arr = countingSort(arr, max);
		System.out.println("duration is " + duration());
		init();
		Arrays.sort(arr1);
		System.out.println("duration is " + duration());
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
	}
	public static long startTime = 0;
	public static long endTime = 0;

	public static void init() {
		startTime = System.currentTimeMillis();
	}

	public static long duration() {
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public static int[] countingSort(int[] arr, int max) {
		int[] helperarr = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			helperarr[arr[i]]++;
		}
		for (int i = 1; i < helperarr.length; i++) {
			helperarr[i] += helperarr[i - 1];
		}
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[helperarr[arr[i]] - 1] = arr[i];
			--helperarr[arr[i]];
		}

		return result;
	}
}

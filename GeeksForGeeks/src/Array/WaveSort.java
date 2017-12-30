package Array;

public class WaveSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={10, 5, 6, 3, 2, 20, 100, 80};
		waveSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}

	}

	public static void waveSort(int[] arr) {
		for (int i = 0; i < arr.length; i += 2) {
			if (i > 0 && arr[i - 1] > arr[i]) {
				swap(arr,i-1,i);
			} else if (i < arr.length - 1 && arr[i] < arr[i + 1]) {
				swap(arr,i,i+1);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}

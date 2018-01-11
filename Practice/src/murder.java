
public class murder {
	public static int inverse = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1,1,8 };
		mergesort(arr, 0, arr.length - 1);
		System.out.println(inverse);
	}

	public static int[] merge(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int k = 0, i = 0, j = 0;
		int mid = ((result.length + 1) / 2);
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				result[k] = arr1[i];
				inverse += arr1[i]*(arr2.length-j);
				i++;
				k++;
			} else {
				result[k] = arr2[j];
				j++;
				k++;
			}
		}
		while (i < arr1.length) {
			result[k] = arr1[i];

			k++;
			i++;

		}
		while (j < arr2.length) {
			result[k] = arr2[j];

			k++;
			j++;
		}

		return result;

	}

	public static int[] mergesort(int[] arr, int si, int li) {
		if (si == li) {
			int[] base = new int[1];
			base[0] = arr[li];
			return base;
		}
		int mid = (si + li) / 2;
		int[] fhalf = mergesort(arr, si, mid);
		int[] shalf = mergesort(arr, mid + 1, li);
		int[] result = merge(fhalf, shalf);
		return result;
	}

}

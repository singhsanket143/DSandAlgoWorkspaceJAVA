
public class TestClass {
	public static void main(String[] args) {
		int sol[] = { 10, 13, 12, 14, 15 };
		System.out.println(solution(sol, 5));
	}

	public static int solution(int arr[], int n) {
		int result = 1;

		int min[] = new int[10005];
		int max[] = new int[10005];
		for (int i = 0; i < n; i++) {
			int max_el = Integer.MAX_VALUE;
			int max_el_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] > arr[i] && arr[j] < max_el) {
					max_el = arr[j];
					max_el_idx = j;
				}
			}
			if (max_el != Integer.MAX_VALUE) {
				max[i] = max_el_idx;
			} else {
				max[i] = i;
			}

		}
		for (int i = 0; i < n; i++) {
			int min_el = Integer.MIN_VALUE;
			;
			int min_el_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[i] && arr[j] > min_el) {
					min_el = arr[j];
					min_el_idx = j;
				}
			}
			if (min_el != Integer.MIN_VALUE) {
				min[i] = min_el_idx;
			} else {
				min[i] = i;
			}
		}
		int traversal = 0;
		for (int i = 0; i < n; i++) {
			traversal = i;
			int jump = 1;
			while (traversal < n) {
				if (jump % 2 != 0) { // odd jump
					int temp = traversal;
					traversal = max[traversal];
					if (traversal == temp) {
						break;
					}
				} else {
					int temp = traversal;
					traversal = min[traversal];
					if (traversal == temp) {
						break;
					}
				}
				if (traversal == n - 1) {
					result++;
				}
				jump++;
			}
		}

		return result;
	}
}
import java.util.Scanner;

public class ninja {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int q = scn.nextInt();
		int[] arr = new int[n];
		int[] check = new int[n];
		int max=0;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			check[i] = arr[i];
			if(max<arr[i]){
				max=arr[i];
			}
		}
		int[] arr1 = new int[500];
		for (int i = 0; i < q; i++) {
			int t = scn.nextInt();
			if (t == 1) {
				int a = scn.nextInt();
				int b = scn.nextInt();
				for (int j = a - 1; j <= b - 1; j++) {
					arr1[arr[j]]++;
				}
				int c = 0;
				for (int k = 0; k < max; k++) {
					if (arr1[k] != 0)
						c++;
				}
				System.out.println(c);
			} else {
				int a = scn.nextInt();
				int b = scn.nextInt();
				char c = scn.next().charAt(0);
				rotate(arr, check, a-1, b-1, c);
				for(int m=0;m<arr.length;m++){
					check[m]=arr[m];
				}
			}
		}
		System.exit(0);
	}

	public static void rotate(int[] arr, int[] check, int a, int b, char c) {
		if (c == 'R') {
			for (int i = a; i <= b; i++) {
				if (i != b) {
					arr[i + 1] = check[i];
				} else {
					arr[a] = check[i];
				}
			}
		} else{for(int i=b;i>=a;i--){
			if(i!=a){
				arr[i-1]=check[i];
			} else{
				arr[b]=check[i];
			}
		}
			
		}
	}

}

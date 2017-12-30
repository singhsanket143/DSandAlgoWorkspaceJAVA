import java.util.Scanner;

public class groupsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int k=scn.nextInt();
		targetSubset(arr, 0, k, "");
		System.out.println(boole);
	}
	
	public static boolean boole=false;

	public static boolean targetSubsetbool(int[] arr, int si, int target, String osf) {
		if (si == arr.length) {
			if (target == 0) {
				System.out.println(osf);
				return true;
			}
			return false;
		}
		if (targetSubsetbool(arr, si + 1, target, osf)) {
			return true;
		} else if (targetSubsetbool(arr, si + 1, target - arr[si], osf + arr[si] + " ")) {
			return true;
		} else {
			return false;
		}
	}

	public static void targetSubset(int[] arr, int si, int target, String osf) {
		if (si == arr.length) {
			if (target == 0) {
				boole=true;
//				System.out.println(osf);
			}
			return;
		}
		int cc = 0;
		for (int i = si; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1])
				break;
			cc++;
		}
		if (cc > 0) {
			int temp = target;
			String str="";
			for(int i=0;i<osf.length();i++){
				str+=osf.charAt(i);
			}
			for (int i = 0; i <= cc; i++) {
				
				target -= arr[si];
				osf+=arr[si]+" ";
				si++;
			}
			targetSubset(arr, si, temp, str);
			targetSubset(arr, si, target, osf);
		} else {
			targetSubset(arr, si + 1, target, osf);
			targetSubset(arr, si + 1, target - arr[si], osf + arr[si] + " ");
		}
	}

}

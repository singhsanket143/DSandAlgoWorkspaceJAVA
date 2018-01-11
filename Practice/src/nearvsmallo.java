import java.util.Arrays;
import java.util.Scanner;

public class nearvsmallo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		
		int[] arr=new int[n];
		for(int i=0;i<arr.length;i++){
			arr[i]=scn.nextInt();
		}
		System.out.println(rearrange(arr));
	}
	
	public static int rearrange(int[] arr){
		Arrays.sort(arr);
		int[] newarr=new int[arr.length];
		int c=0;
		for(int i=arr.length-1;i>=0;i-=2){
			newarr[c]=arr[i];
			if(i-1>=0)
				newarr[newarr.length-c-1]=arr[i-1];
			c++;
		}
		return rainWatertrap(newarr);
		
	}
	
	public static int rainWatertrap(int[] arr) {
		int result = 0;

		int[] auxarr1 = new int[arr.length];
		int[] auxarr2 = new int[arr.length];
		// auxarr1[0] = 0;
		// auxarr1[arr.length - 1] = 0;
		int maxL = 0, maxR = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxL) {
				maxL = arr[i];
			}
			auxarr1[i] = maxL;
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > maxR) {
				maxR = arr[i];
			}
			auxarr2[i] = maxR;
		}
		for (int i = 1; i < arr.length - 1; i++) {
			result += Math.min(auxarr1[i], auxarr2[i]) - arr[i];
		}

		return result;
	}

}

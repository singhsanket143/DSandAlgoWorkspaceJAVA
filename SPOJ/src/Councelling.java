import java.util.Arrays;
import java.util.Scanner;

public class Councelling {

	public static void main(String[] args) {

		int[] goals = { 4,8,1,0,5};
		//int swapped = 0;
		reversearray(goals,0);
	}

	public static void pri(int[] goals,int i) {
		if(i==goals.length-1){
			return;
		}
		pri(goals, i++);
		System.out.println(goals[i]);
		return;
	}
	public static void reversearray(int[] arr,int si){
		if(si==arr.length-1){
			System.out.println(arr[si]);
			return;
		}
		reversearray(arr, si+1);
		System.out.println(arr[si]);
		return;
	}
}


package ArrayWorkshop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PairThatSumToTarget {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int tar=scn.nextInt();
		countPairs(arr, tar);
	}
	
	public static void countPairs(int[] arr,int tar){
		int result=0;
		int lo=0,hi=arr.length-1;
		Arrays.sort(arr);
		while(lo < hi){
			if(arr[lo]+arr[hi]==tar){
				System.out.println(arr[lo]+"and"+arr[hi]);
				hi--;
			} else if(arr[lo]+arr[hi]<tar){
				lo++;
			} else 
				hi--;
		}
		
	}
	public static int countPairsbtr(int[] arr, int tar) {
		int count = 0;
		HashMap<Integer, Integer> popmap=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(!popmap.containsKey(arr[i]))
				popmap.put(arr[i], 1);
			else
				popmap.put(arr[i], popmap.get(arr[i])+1);
			
		}
		for(int i=0;i<arr.length;i++){
//			System.out.println(popmap.get(tar-arr[i]));
			if(popmap.containsKey(tar-arr[i]))
				count+=popmap.get(tar-arr[i]);
			if(tar-arr[i]==arr[i])
				count--;
		}
		return count/2;
	}

}

package Implementation;

import java.util.Scanner;

public class minimum_distances {

	public static void main(String[] args) {

		Scanner scn=new Scanner (System.in);
		int n=scn.nextInt();
		int[] arr= new int[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int l=0,r=arr.length-1,min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length;j++){
				if(i==j)
					continue;
				if(arr[i]==arr[j]){
					if(min>Math.abs(j-i))
						min=Math.abs(j-i);
				}
			}
		}
		if(min!=Integer.MAX_VALUE)
			System.out.println(min);
		else
			System.out.println("-1");
		
	}

}

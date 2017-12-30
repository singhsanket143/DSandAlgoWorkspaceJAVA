package CodeMocha;

import java.util.Scanner;

public class ques1 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String[] arr= new String[2];
		for(int i=0;i<2;i++){
			arr[i]=scn.next();
		}
		System.out.println(arr[0]+" "+arr[1]);
		int k=scn.nextInt();
		for(int i=0;i<k;i++){
			String s1=scn.next();
			String s2=scn.next();
			for(int j=0;j<2;j++){
				if(arr[j].equals(s1)){
					arr[j]=s2;
				}	
			}
			System.out.println(arr[0]+" "+arr[1]);
		}

	}
}

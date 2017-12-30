package BitManipulation;

import java.util.ArrayList;
import java.util.Scanner;

public class whatsNext {

	public static void main(String[] args) {

		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t>0){
			int n=scn.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scn.nextInt();
			}
			StringBuilder sb=new StringBuilder("");
			for(int i=0;i<n;i++){
				if(i%2==0){
					for(int j=0;j<arr[i];j++){
						sb.append("1");
					}
				} else {
					for(int j=0;j<arr[i];j++){
						sb.append("0");
					}
				}
			}
			String str=sb.toString();
			
			int noOne=brianKernighan(Integer.parseInt(str,2));
			boolean bool=false;
			int m=sb.length()-2;
			while(bool==false && m>=0){
				if(sb.charAt(m)=='0'){
					sb.replace(m, m+1, "1");
					sb.replace(m+1, m+2, "0");
					bool=true;
				} else{
					m--;
				}
			}
			String newstr=sb.toString();
			int c=1;
			int d=0;
			ArrayList<Integer> a=new ArrayList<>();
			for(int i=0;i<newstr.length()-1;i++){
				if(newstr.charAt(i)==newstr.charAt(i+1))
					c++;
				else{
					//System.out.print(c+" ");
					a.add(c);
					d++;
					c=1;
				}
			}
			//System.out.print(c);
			a.add(c);
			System.out.println(d+1);
			for(int j=0;j<a.size();j++){
				System.out.print(a.get(j)+" ");
			}
			t--;
		}
	}
	
	public static int brianKernighan(int num){
		int count=0;
		while(num>0){
			num=num & (num-1);
			count++;
		}
		return count;
	}

}

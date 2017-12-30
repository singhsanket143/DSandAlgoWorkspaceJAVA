import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class nums {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			int x = in.nextInt();
			int sum=0;
			boolean flag = false;
			for (int i = 0; i < s.length(); i++) {

				int j=i;
				while (j<s.length()&&sum<x){
					sum=sumf(s.substring(i, j));
					if(sum==x)
					{
						System.out.println("Yes");
						flag=true;
						break;
					}
//					else{
//						j++;
//					}
				}
				if(flag)
					break;
				else System.out.println("No");
				
			}
		}
	}
	
	public static int sumf(String s)
	{
		int sum=0;
		for(int i=0;i<s.length();i++)
			sum+=s.charAt(i);
			
		return sum-(('a'-1)*s.length());	
	}

}
package Implementation;

import java.util.Scanner;

public class JumpToEqual {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();
		int c1 = x1;
		int c2 = x2;
		 while(c1!=c2 && c1<=10000000 && c2<=10000000){
			 if(x2>x1 && v2>v1){
				 break;
			 }
	            c1+=v1;
	            c2+=v2;
	            
	        }
	        if(c1==c2){
	                System.out.println("YES");
	        } else
	            System.out.println("NO");
	}

}

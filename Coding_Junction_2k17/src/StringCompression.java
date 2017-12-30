import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn= new Scanner(System.in);
		String str=scn.next();
		int c=1;
		String result;
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				c++;
			}
			
		}

	}

}

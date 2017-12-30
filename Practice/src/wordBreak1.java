import java.util.Scanner;

public class wordBreak1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		String[] arr=new String[n];
		for(int i=0;i<n;i++){
			arr[i]=scn.next();
		}
		String str=scn.next();
		wordBreak(str, "", arr);
	}
	
	public static boolean contains(String[] arr, String str){
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(str))
				return true;
		}
		return false;
	}
	
	public static void wordBreak(String str,String res,String[] arr){
		if(str.length()==0){
			System.out.println(res);
		}
		
		for(int i=1;i<=str.length();i++){
			String prefix=str.substring(0, i);
			if(contains(arr,prefix)){
				wordBreak(str.substring(i), res+prefix+" ", arr);
			}
		}
		
	}

}

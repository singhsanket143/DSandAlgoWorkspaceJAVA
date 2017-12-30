package Lecture21;


public class assignments {

	public static void main(String[] args) {
//		int arr[]={2,5,3,4,1,0};
//		inverse(arr, 0);
//		display(arr);
//		System.out.println(suminstring("1234", 0));
		System.out.println(stringtoint("1234"));
	}
	public static void inverse(int[] arr,int i){
		int b;
		if(i==arr.length){
			return;
		}
			b=arr[i];
			inverse(arr, i+1);
			arr[b]=i;
			
		
	}
//	public static int suminstring(String str,int si){
//		int val,b;
//		if(si==str.length()){
//			return val;
//		}
//		val=val+str.charAt(si)-'0';
//		suminstring(str, si+1);
		
//	}
	public static int stringtoint(String str){
		int val=0;
		
		char c=str.charAt(str.length()-1);
		if(str.length()==1)
			return str.charAt(0)-'0';
		String sub=str.substring(0, str.length()-1);
		int recrsult=stringtoint(sub);
		int myresult=recrsult*10+c-'0';
		return myresult;
		
	}
	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + ", ");
		}
		System.out.println("end");
	}

}

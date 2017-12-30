package ArrayWorkshop;

public class alone2 {
	
	public static void main(String[] args) {

		int[] arr={1,2,3,5,6,7,8};
		int result1=0;
		int result2=0;
		for(int i=1;i<=arr.length+1;i++){
			result1=result1^i;
		}
		for(int i=0;i<arr.length;i++){
			result2=result2^arr[i];
		}
		System.out.println(result1^result2);
	}

}

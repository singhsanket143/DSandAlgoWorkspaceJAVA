package ArrayWorkshop;

public class alone1 {

	public static void main(String[] args) {

		int[] arr={2,2,3,4,3,4,10,6,6};
		int result=0;
		for(int i=0;i<arr.length;i++){
			result=result^arr[i];
		}
		System.out.println(result);
	}
	

}

package Array;

public class lostelementFromDuplicatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,2,3,4,5};
		int[] arr2= {2,3,1,4};
		System.out.println(duplicate(arr1, arr2));
	}
	
	public static int duplicate(int[] arr1, int[] arr2) {
		int retVal=0;
		for(int i=0;i<arr1.length;i++) {
			retVal^=arr1[i];
		}
		for(int i=0;i<arr2.length;i++) {
			retVal^=arr2[i];
		}
		return retVal;
	}

}

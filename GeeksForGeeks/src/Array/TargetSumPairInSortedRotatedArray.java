package Array;

public class TargetSumPairInSortedRotatedArray {

	public static void main(String[] args) {
		
		int[] arr={9,10,11,1,2,3,7,8};
		TargetPair(arr, 10);
	}
	
	public static void TargetPair(int[] arr,int tar){
		int l=-1,r=-1;
		for(int j=0;j<arr.length-1;j++){
			if(arr[j]>arr[j+1]){
				r=j;
				l=(j+1)%arr.length;
				break;
			}
		}
		int counter=0;
		while(l!=r && counter<=arr.length/2){
			if(arr[l]+arr[r]==tar){
				System.out.println(arr[l]+" , "+arr[r]);
				l=(l+1)%arr.length;
				r=(arr.length+r-1)%arr.length;
				counter++;
			} else if(arr[l]+arr[r]<tar) {
				l=(l+1)%arr.length;
				counter++;
			} else {
				r=(arr.length+r-1)%arr.length;
				counter++;
			}
		}
		return;
	}

}

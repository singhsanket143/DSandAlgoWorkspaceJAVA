import java.util.Arrays;
import java.util.PriorityQueue;

public class kthlargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,6,10,11,13,4,1,20};
		System.out.println(kthlargest(arr, 4));

	}
	
	public static int kthlargest(int [] arr,int k){
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		int[] newarr=new int[max+1];
		for(int i=0;i<arr.length;i++){
			newarr[arr[i]]++;
		}
		int result=0;
		for(int i=newarr.length-1;i>=0;i--){
			if(newarr[i]==0){
				continue;
			} else {
				while(newarr[i]>0 && k>0){
					k--;
					if(k==0){
						result= i;
						break;
					}
					newarr[i]--;
				}
			}
		}
		return result;
		
	}
	
}

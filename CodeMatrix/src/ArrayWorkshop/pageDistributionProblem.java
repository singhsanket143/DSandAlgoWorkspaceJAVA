package ArrayWorkshop;

public class pageDistributionProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={1,2,8,4,9};
		int k=3;
		System.out.println(pageDistribution(arr, k));
	}

	public static int pageDistribution(int[] arr, int students) {
		int total_pages=0;
		for(int i=0;i<arr.length;i++){
			total_pages+=arr[i];
		}
		int lo=arr[0],hi=total_pages,result=0;
		while(lo<=hi){
			int mid=(lo+hi)/2;
			if(isValid(arr,students,mid)){
				result=mid;
				hi=mid-1;
			} else {
				lo=mid+1;
			}
		}
		return result;
	}
	
	public static boolean isValid(int[] arr,int students,int ans){
		int s=1;
		int current_pages=0;
		for(int i=0;i<arr.length;i++){
			if(current_pages+arr[i]>ans){
				current_pages=arr[i];
				s++;
				if(s>students){
					return false;
				}
			}else{
				current_pages+=arr[i];
			}
		}
		return true;
	}

}

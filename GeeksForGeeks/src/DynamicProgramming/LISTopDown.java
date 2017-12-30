package DynamicProgramming;

public class LISTopDown {
	public static int ref;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={10, 22, 9, 33, 21 ,22, 9, 33, 21, 50, 41, 22,22 ,50, 41, 60};
		System.out.println(LIS(arr,arr.length));

	}
	
	public static int LISTopDon(int[] arr, int n,int[] strg) {
		if (n == 1) {
			return 1;
		}
		if(strg[n]!=0){
			return strg[n];
		}
		int result = 1, recresult;
		for (int i = 1; i < n; i++) {
			recresult = LISTopDon(arr, i, strg);
			if (arr[i - 1] < arr[n - 1] && recresult + 1 > result) {
				result = recresult + 1;
			}
		}
		if(ref<result){
			ref=result;
		}
		strg[n]=result;
		return result;
	}
	
	public static int LIS(int[] arr,int n){
		ref=1;
		int[] strg=new int[arr.length+1];
		LISTopDon(arr, n,strg);
		return ref;
	}

}

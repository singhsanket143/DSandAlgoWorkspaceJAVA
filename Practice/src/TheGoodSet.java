import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;


public class TheGoodSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			t--;
			int n = scn.nextInt();
			
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i]=scn.nextInt();
			}
			Arrays.sort(arr);
			for(int i=0;i<arr.length/2;i++){
				int temp=arr[i];
				arr[i]=arr[arr.length-i-1];
				arr[arr.length-i-1]=temp;
			}
			System.out.println(getsubset(arr, 0));
			System.out.println(countGoodSet(arr));

		}
	}
	
	public static int countGoodSet(int[] arr){
		return getsubset(arr, 0).size()-1;
	}
	public static ArrayList<ArrayList<Integer>> getsubset(int[] arr, int si) {
		if (si == arr.length) {
			ArrayList<Integer> baseresult = new ArrayList<>();
			ArrayList<ArrayList<Integer>> check = new ArrayList<>();
			check.add(baseresult);
			return check;
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<ArrayList<Integer>> recresult = getsubset(arr, si + 1);
		for (int i = 0; i < recresult.size(); i++) {
			result.add(recresult.get(i));
		}
		for(int i=0;i<recresult.size();i++){
			ArrayList<Integer> myresult=new ArrayList<>();
			myresult.add(arr[si]);
//			for(int j=0;j<recresult.get(i).size();j++){
//				int temp=recresult.get(i).get(j);
//				myresult.add(temp);
//			}
//			result.add(myresult);
			if(recresult.get(i).size()==0|| arr[si]%recresult.get(i).get(0)==0){
				for(int j=0;j<recresult.get(i).size();j++){
					int temp=recresult.get(i).get(j);
					myresult.add(temp);
				}
				result.add(myresult);
			}
		}

		return result;
	}

}

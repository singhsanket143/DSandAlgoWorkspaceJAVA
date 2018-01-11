import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;import java.util.Map;
import java.util.Set;

public class longestConsecutiveSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 15,13,23,21,19,11,16};
		System.out.println(longestSubsequence(arr));

	}

	public static ArrayList<Integer> longestSubsequence(int[] arr) {
		// Write your code here
		HashMap<Integer, Integer> popmap = new HashMap<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			popmap.put(arr[i], i);
		}
		map.put(arr[0], 0);
		for(int i=0;i<arr.length;i++){
			if(!popmap.containsKey(arr[i]-1)){
				int j=arr[i];
				while(popmap.containsKey(j)){
					j++;
				}
				if(map.size()<j-arr[i]){
					map=new HashMap<>();
					while(j>arr[i]){
						map.put(--j, 0);
					}
				}
			}
		}
		ArrayList<Integer> res=new ArrayList<>();
		Set<Map.Entry<Integer, Integer>> all=map.entrySet();
		for(Map.Entry<Integer, Integer> a:all){
			res.add(a.getKey());
		}
		return res;

	}

}

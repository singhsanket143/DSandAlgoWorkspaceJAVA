import java.util.HashMap;
import java.util.Vector;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {30,20,150,100,40};
		System.out.println(getPairsCount(arr, 5, 60));

	}
	
	static int getPairsCount(int[] arr, int n, int sum)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
 
        for (int i=0; i<n; i++){
             
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i],0);
                 
            hm.put(arr[i], hm.get(arr[i])+1);
        }
        int ans = 0;
        int vo=0;
        for (int i=0; i<n; i++)
        {
            if(hm.get(sum-arr[i]%sum) != null)
            	vo =sum-arr[i]%sum;
                ans += hm.get(sum-arr[i]%sum);
 
            if (sum-arr[i]%sum == arr[i])
                ans--;
        }
 
        return ans/2;
    }

}

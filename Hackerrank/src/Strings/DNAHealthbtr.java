package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DNAHealthbtr {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] arr = new String[n];
		int[] health = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.next();
		}
		for (int i = 0; i < arr.length; i++) {
			health[i] = scn.nextInt();
		}
		int t = scn.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int j = 0; j < t; j++) {
			int first = scn.nextInt();
			int last = scn.nextInt();
			String str = scn.next();
			int x=printsubstrings(str, first, last, health, arr);
			if(x<min){
				min=x;
			}
			if(x>max){
				max=x;
			}
		}
		System.out.println(min+" "+max);
	}
	
	public static int printsubstrings(String str, int f, int l, int[] arr, String[] a) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = f; i <= l; i++) {
			if (map.containsKey(a[i])) {
				int temp = map.get(a[i]);
				map.put(a[i], temp + arr[i]);
			} else {
				map.put(a[i], arr[i]);
			}
		}
		int sum=0;
//		for(int i=f;i<=l;i++){
//			if(KMP(str, a[i])){
//				sum+=arr[i];
//			}
//		}
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			if(KMP(str,entry.getKey())){
				sum+=entry.getValue();
			}
		}
		return sum;
	}
	
	 public static boolean KMP(String text, String pattern){
	        
	        int lps[] = computeTemporaryArray(pattern);
	        int i=0;
	        int j=0;
	        while(i < text.length() && j < pattern.length()){
	            if(text.charAt(i) == pattern.charAt(j)){
	                i++;
	                j++;
	            }else{
	                if(j!=0){
	                    j = lps[j-1];
	                }else{
	                    i++;
	                }
	            }
	        }
	        if(j == pattern.length()){
	            return true;
	        }
	        return false;
	    }
	 
	 public static int[] computeTemporaryArray(String pattern){
	        int [] lps = new int[pattern.length()];
	        int index =0;
	        for(int i=1; i < pattern.length();){
	            if(pattern.charAt(i) == pattern.charAt(index)){
	                lps[i] = index + 1;
	                index++;
	                i++;
	            }else{
	                if(index != 0){
	                    index = lps[index-1];
	                }else{
	                    lps[i] =0;
	                    i++;
	                }
	            }
	        }
	        return lps;
	    }

}

package Implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ClassRoom {

	public static void main(String[] args) {

		HashMap<Integer, Integer> popmap=new HashMap<>();
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		for(int i=0;i<n;i++){
			int data=scn.nextInt();
			
			if(popmap.containsKey(data)){
				int temp=popmap.get(data);
				popmap.put(data, temp+=1);
			} else{
				popmap.put(data, 1);
			}
		}
		int c=0;
		Set<Map.Entry<Integer, Integer>> allEntries = popmap.entrySet();
		for (Map.Entry<Integer, Integer> entry : allEntries) {
			int d=entry.getValue();
			if(d==1){
				continue;
			} else if(d%2==0){
				c+=d/2;
			} else if(d%2!=0 && d!=1){
				c+=(d-1)/2;
			}
		}
		System.out.println(c);
	}
}

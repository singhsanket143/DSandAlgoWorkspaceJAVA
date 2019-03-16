package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SortGame {
	
	static class employee implements Comparable<employee>{
		String name;
		int salary;
		employee(String name, int salary) {
			 this.name = name;
			 this.salary = salary;
		 }
		@Override
		public int compareTo(employee arg0) {
			// TODO Auto-generated method stub
			if(this.salary == arg0.salary) {
				if(this.name.compareTo(arg0.name) < 0) {
					return -1;
				} else {
					return 1;
				}
			}
			return arg0.salary-this.salary;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		int n = scn.nextInt();
		employee arr[] = new employee[n];
		for(int i=0;i<n;i++) {
			arr[i] = new employee(scn.next(), scn.nextInt());
		}
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			if(arr[i].salary > x) {
				System.out.println(arr[i].name+ " " + arr[i].salary);
			}
		}

	}

}

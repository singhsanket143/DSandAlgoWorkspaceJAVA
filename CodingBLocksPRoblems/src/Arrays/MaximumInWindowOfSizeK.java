package Arrays;

import java.util.LinkedList;
import java.util.Scanner;

public class MaximumInWindowOfSizeK {

	public static void MAxInWindow(int arr[], int k) 
    { 
		if(k>arr.length) {
			System.out.println("Window size is greater than length");
			return;
		}
		LinkedList<Integer> qu = new LinkedList<Integer>(); 
        int i; 
        for(i = 0; i < k; ++i) 
        { 
            while(!qu.isEmpty() && arr[i] >= arr[qu.peekLast()]) 
                qu.removeLast();  
            qu.addLast(i); 
        } 
        for( ;i < arr.length; ++i) 
        { 
            System.out.print(arr[qu.peek()] + " "); 
            while((!qu.isEmpty()) && qu.peek() <= i-k) 
                qu.removeFirst(); 
            while((!qu.isEmpty()) && arr[i] >= arr[qu.peekLast()]) 
                qu.removeLast(); 
            qu.addLast(i); 
        } 
        System.out.print(arr[qu.peek()]); 
    } 
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++ ) {
			arr[i] = scn.nextInt();
		}
		MAxInWindow(arr, k);
//		for(int el: arr) {
//			System.out.println(el);;
//		}
		
	}

}

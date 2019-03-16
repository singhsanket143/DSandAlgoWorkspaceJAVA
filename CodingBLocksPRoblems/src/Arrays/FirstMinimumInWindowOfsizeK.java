package Arrays;

import java.util.LinkedList;
import java.util.Scanner;

public class FirstMinimumInWindowOfsizeK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<arr.length;i++ ) {
			arr[i] = scn.nextInt();
		}
		FirstMinInWindow(arr, k);
//		for(int el: arr) {
//			System.out.println(el);;
//		}

	}

	public static void FirstMinInWindow(int arr[], int k) 
    { 
		if(k>arr.length) {
			System.out.println("Window size is greater than length");
			return;
		}
		LinkedList<Integer> qu = new LinkedList<Integer>(); 
        int i; 
        for(i = 0; i < k; ++i) 
        { 
            if(arr[i]<0)
            		qu.addLast(i); 
        } 
        for( ;i < arr.length; ++i) 
        { 
        		if(!qu.isEmpty())
        			System.out.print(arr[qu.peek()] + " "); 
        		else
        			System.out.println(0);
            while((!qu.isEmpty()) && qu.peek() <= i-k) 
                qu.removeFirst(); 
            
            if(arr[i]<0)
        			qu.addLast(i); 
        } 
        if(!qu.isEmpty())
			System.out.print(arr[qu.peek()] + " "); 
		else
			System.out.println(0);
    } 
}

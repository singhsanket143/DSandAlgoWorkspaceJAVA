package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class ArithmeticExpression {

	static void recursiveArithmeticExpression(int[] arr, String osf, long x, int i) {
	    if(x%101==0) {
	    	System.out.println(x);
	    		String ret = "";
	        for (int j = i; j<arr.length; j++) {
	            ret += "*" + (arr[j]);
	        }
	        System.out.println(osf+ret);
	        System.exit(0);
            return;
	    }
		if(i>=arr.length) {
	        if((x)%101==0) {
	        		System.out.println(x);
	            System.out.println(osf);
	            System.exit(0);
	            return;
	        }
	        return;
	    }
//	    if(x>101)  x = (x)%101;

	    x = (x+101)%101;
	    recursiveArithmeticExpression(arr, osf+"+"+arr[i], (x+arr[i]), i+1);
	    recursiveArithmeticExpression(arr, osf+"-"+(arr[i]), (x-arr[i]), i+1);
	    recursiveArithmeticExpression(arr, osf+"*"+arr[i], (x*arr[i]), i+1);

	}
	static String arithmeticExpressions(int[] arr) {

	    recursiveArithmeticExpression(arr, ""+arr[0],arr[0], 1 );
	    return "";
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
            arr[i] = (Integer.parseInt(scn.next()));         
        }
		arithmeticExpressions(arr);
	}
	

}

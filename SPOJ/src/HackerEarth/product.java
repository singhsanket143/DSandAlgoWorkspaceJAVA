package HackerEarth;

import java.util.*;
public class product {

    public static void main(String args[] ) throws Exception {
       Scanner scn=new Scanner(System.in);
       int n=scn.nextInt();
       int[] arr=new int[n];
       for(int i=0;i<n;i++){
           int data=scn.nextInt();
           arr[i]=data;
       }
       long f=1;
       for(int i=0;i<arr.length;i++){
           f=f*arr[i];
       }
       System.out.println(f);
    }
}

package Warmup;

import java.util.*;

 class ques1 {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long size = scn.nextLong();
        long[] arr = takeinput(size);
        long k=scn.nextLong();
        System.out.println(max(arr,k));
        System.out.println(arr[arr.length-1]);
        System.exit(0);
    }

    public static long max(long[] arr,long k) {
        Arrays.sort(arr);
        long kth=arr[(int) (arr.length-k)];
        return kth;
    }
    public static long[] takeinput(long size) {
        long[] rv = null;
        rv = new long[(int) size];
        for (int i = 0; i < rv.length; i++) {    
            rv[i] = scn.nextLong();
        }
        return rv;
    }
}
package Implementation;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class migratory_birds {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] types = new int[n];
        int t1=0,t2=0,t3=0,t4=0,t5=0;
        for(int types_i=0; types_i < n; types_i++){
            types[types_i] = in.nextInt();
            if(types[types_i]==1){
                t1++;
            } else if(types[types_i]==2){
                t2++;
            } else if(types[types_i]==3){
                t3++;
            } else if(types[types_i]==4){
                t4++;
            } else {
                t5++;
            } 
        }
        int c=(Math.max(t1,Math.max(t2,Math.max(t3,Math.max(t4,t5)))));
        if(c==t1){
        	System.out.println("1");
        } else if(c==t2){
        	System.out.println("2");
        } else if(c==t3){
        	System.out.println("");
        } else if(c==t4){
        	System.out.println("4");
        } else if(c==t5){
        	System.out.println("5");
        } 
        // your code goes here
    }
}

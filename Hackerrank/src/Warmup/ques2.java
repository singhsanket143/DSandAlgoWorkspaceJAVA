package Warmup;

import java.util.Scanner;

class ques2 {

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
    
        double x1 = scn.nextDouble() ;double  y1 = scn.nextDouble();
        

        distance(x1, y1);
        System.exit(0);
        
    }
        

    public static void distance(double x1, double x2) {
        long diff = (long) (x1 - x2);
        System.out.println(diff);
        if (diff % 2.0 == 0) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }

    }

}

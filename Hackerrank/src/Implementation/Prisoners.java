package Implementation;

import java.util.*;

public class Prisoners {

    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        int t=scn.nextInt();
        for(int i=0;i<t;i++){
        int n=scn.nextInt();
        int m=scn.nextInt();
        int s=scn.nextInt();
            if((m%n==0))
                System.out.println(s);
            else 
                System.out.println((m+s-1)%n);
        }
    }
    
}
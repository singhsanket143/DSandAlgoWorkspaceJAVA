package Implementation;

import java.util.*;


public class AppendAndDelete {

    public static void main(String[] args) {
  
       Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String t = scn.next();
		int k = scn.nextInt();
		int x = Math.min(s.length(), t.length()), n = 0, d = 0;
        for(int i=0;i<x;i++){
            if(s.charAt(i)!=t.charAt(i)){
                n=i;
                break;
            } else if(i==x-1 && n==0){
                n=i;
            }
        }
        d=s.length()-n+t.length()-n;
        if(d<=k && d%2==k%2 || k>s.length()+t.length() ){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }
   
}

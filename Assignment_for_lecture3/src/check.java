import java.util.Scanner;

public class check {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

	      int N1 = scn.nextInt();
	      int N2 = scn.nextInt();
	      
	      printArmstrong(0,1000);
	   }

	   public static void printArmstrong(int begin, int end) {
	       int num;
	       for(num=begin;num<=end;num++){}
	       int k;
		   int rem=0;
		   k=num;
		   while(k!=0){
		       int	j=k%10;
		       rem=rem+(j*j*j);
		       k=(int)k/10;}
				
		   if((int)rem==num){
	        System.out.println(rem);}
	       
	   
	}

}

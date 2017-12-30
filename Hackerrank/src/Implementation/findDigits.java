package Implementation;


import java.util.Scanner;

public class findDigits {

	public static void main(String[] args) {


        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        long[] arr= new long[n];
        for(int i=0;i<n;i++){
        	arr[i]=scn.nextLong();
        }
        for(int i=0;i<arr.length;i++){
            long data=arr[i];
            int counter=0;
            long m=data;
            while(m>0){
                long rem=m%10;
                if(rem==0){
                	m/=10;
                    continue;
                } else if(data%rem==0){
                    counter++;
                }
                m/=10;
            }
            System.out.println(counter);
            
        }
        
	}

}

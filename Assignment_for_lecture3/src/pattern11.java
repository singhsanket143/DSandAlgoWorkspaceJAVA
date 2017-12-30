import java.util.Scanner;

public class pattern11 {

	public static void main(String[] args) {
		int i = 1, j = 1,value=0;

		Scanner scn = new Scanner(System.in);

		
		int n = scn.nextInt();

		i=1;
		j=1;
		while(i<=n)
		{
			value=1;
			while(j<i+1)
			{
				System.out.print(value+"\t");
				j++;
				value++;
			}
			j=(2*n-3)-2*(i-1);
			while(j>0)
			{
				
				System.out.print("\t");
				j--;
			}
			j=1;
			if(i==n)
				value-=2;
			else
				value--;
			while(j<i+1)
			{
				if(value!=0){
				System.out.print(value+"\t");
				j++;
				value--;}
				else
					break;
			}
			System.out.print("\n");
			i++;
			j=1;
			
			
		}

	}

}

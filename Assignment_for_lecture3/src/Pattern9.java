import java.util.Scanner;

public class Pattern9 {

	public static void main(String[] args) {
		int i = 1, j = 1;

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter number ");
		int n = scn.nextInt();

		while(i<=n)
		{
			while(j<=n-i+1)
			{
				System.out.print("*"+"\t");
				j++;
			}
			j=1;
			while(j<=2*i-1)
			{
				System.out.print(" "+"\t");
				j++;
			}
			j=1;
			while(j<=n-i+1)
			{
				System.out.print("*"+"\t");
				j++;
			}
			j=1;
			System.out.print("\n");
			i++;
			
		}
		i=1;
		j=1;
		while(i<n)
		{
			while(j<=i+1)
			{
				System.out.print("*"+"\t");
				j++;
			}
			j=(2*n-3)-2*(i-1);
			while(j>0)
			{
				System.out.print(" "+"\t");
				j--;
			}
			j=1;
			while(j<=i+1)
			{
				System.out.print("*"+"\t");
				j++;
			}
			System.out.print("\n");
			i++;
			j=1;
			
			
		}
		}

}

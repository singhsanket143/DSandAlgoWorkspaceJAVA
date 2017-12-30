package assignment_6;

public class ques_4 {

	public static void main(String[] args) {
		pascalrecurrsive(6, 1, 1,1);

	}
	public static void pascalrecurrsive(int n, int row, int col,int num) {
		
		if (row>n) {
			return;
		}
		
		if (row == col) {
			System.out.println(1);
			System.out.println();
			num=1;
			col = 1;
			pascalrecurrsive(n, row + 1, col,num);

		}
		else if(col==1){
			System.out.print(1+"\t");
			pascalrecurrsive(n, row, col+1,num);
		}
		
		else if (col <= row) {
			
			
			num = num*(row-col+1)/(col-1);
			
			System.out.print(num+"\t");
			
			pascalrecurrsive(n, row, col + 1,num);
		}

	}

}

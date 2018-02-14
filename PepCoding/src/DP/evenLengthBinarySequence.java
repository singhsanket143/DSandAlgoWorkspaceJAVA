package DP;

public class evenLengthBinarySequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] strg=new int[1000][1000];
		System.out.println(evenLengthSequence(5, 0, strg));

	}
	
	public static int evenLengthSequence(int n, int diff, int[][] strg) {
		if(Math.abs(diff)>n) {
			return 0;
		}
		if(n==1 && diff == 0) {
			return 2;
		}
		if(n==1 && Math.abs(diff)==1) {
			return 1;
		}
		if(strg[n][Math.abs(diff)]!=0) {
			return strg[n][Math.abs(diff)];
		}
		int result = evenLengthSequence(n-1, diff-1, strg) + evenLengthSequence(n-1, diff+1, strg) + 2*evenLengthSequence(n-1, diff, strg);
		strg[n][Math.abs(diff)]=result;
		return result;
	}

}

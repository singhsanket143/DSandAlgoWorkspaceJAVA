import java.util.*;

class Main {


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long arrx[] = new long[100000];
		long arry[] = new long[100000];
		for(int i=0;i<n;i++) {
			arrx[i] = scn.nextLong();
			arry[i] = scn.nextLong();
		}
		Arrays.sort(arrx);
		Arrays.sort(arry);
		long ansx=0,ansy=0;
	    long px=0,py=0;
	    for(int i=0;i<n;i++){
	        ansx=Math.max(ansx,arrx[i]-px);
	        ansy=Math.max(ansy,arry[i]-py);
	    }
	    System.out.println((ansx-1)*(ansy-1));
	}
	
}
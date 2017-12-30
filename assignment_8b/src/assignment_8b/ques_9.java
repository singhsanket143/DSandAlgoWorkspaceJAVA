package assignment_8b;

public class ques_9 {

	public static void main(String[] args) {
		System.out.println(countmazepathWdiagonalsuper(2, 2, 0, 0));

	}

	public static int countmazepathWdiagonalsuper(int endrow, int endcol, int currentrow, int currentcol) {
		if (currentrow == endrow && currentcol == endcol) {
			return 1;
		}
		if (currentrow > endrow || currentcol > endcol) {
			return 0;
		}
		int myresult = 0, dresult = 0, hresult = 0, vresult = 0,r1result=0,r2result=0,r3result=0,r4result=0;
		r1result=countmazepathWdiagonalsuper(endrow, endcol, currentrow+1, currentcol+2);
		r2result=countmazepathWdiagonalsuper(endrow, endcol, currentrow+2, currentcol-1);
		r3result=countmazepathWdiagonalsuper(endrow, endcol, currentrow+2, currentcol+1);
		r4result=countmazepathWdiagonalsuper(endrow, endcol, currentrow+1, currentcol-2);
		if (currentcol == 0 || currentrow == 0 || currentcol == endcol || currentrow == endrow) {
			hresult = countmazepathWdiagonalsuper(endrow, endcol, currentrow, currentcol + 1);

			vresult = countmazepathWdiagonalsuper(endrow, endcol, currentrow + 1, currentcol);
		}
		if (currentrow == currentcol || currentrow + currentcol == endcol) {
			dresult = countmazepathWdiagonalsuper(endrow, endcol, currentrow + 1, currentcol + 1);
		} else
			dresult = 0;
		myresult = hresult + vresult + dresult+r1result+r2result+r3result+r4result;
		return myresult;
	}

}

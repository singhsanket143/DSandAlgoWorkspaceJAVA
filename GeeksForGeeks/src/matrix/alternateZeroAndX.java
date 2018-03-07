package matrix;

public class alternateZeroAndX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		alternate(4,4);

	}

	public static void alternate(int m, int n) {
		char[][] arr = new char[m][n];
		int k = 0, l = 0;
		char x = 'X';
		while (k < m && l < n) {
			for (int i = l; i < n; i++) {
				arr[k][i] = x;
			}
			k++;
			for (int i = k; i < m; i++) {
				arr[i][n- 1] = x;
			}
			n--;
			if(k<m) {
				for(int i=n;i>=l;i--) {
					arr[m-1][i]=x;
				}
				m--;
			}
			if(l<n) {
				for(int i=m;i>=k;i--) {
					arr[i][l]=x;
				}
				l++;
			}
			
			x=(x=='X')?'0':'X';
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

}

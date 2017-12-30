package Implementation;


import java.util.Scanner;

public class BomberMan {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		int c = scn.nextInt();
		int n = scn.nextInt();
		char[][] arr = new char[r][c];
		char[][] bom = new char[r][c];
		char[][] imp = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = scn.next();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				bom[i][j] = 'O';
				imp[i][j] = 'O';
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 'O') {
					if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
						if (i == 0 && j == 0) {
							bom[i][j] = '.';
							bom[i][j + 1] = '.';
							bom[i + 1][j] = '.';
						}
						if (i == 0 && j != 0 && j != c - 1) {
							bom[i][j] = '.';
							bom[i][j - 1] = '.';
							bom[i][j + 1] = '.';
							bom[i + 1][j] = '.';
						}
						if (i == 0 && j == c - 1) {
							bom[i][j] = '.';
							bom[i][j - 1] = '.';
							bom[i + 1][j] = '.';
						}
						if (j == 0 && i != 0 && i != r - 1) {
							bom[i][j] = '.';
							bom[i][j + 1] = '.';
							bom[i - 1][j] = '.';
							bom[i + 1][j] = '.';
						}
						if (j == c - 1 && i != 0 && i != r - 1) {
							bom[i][j] = '.';
							bom[i][j - 1] = '.';
							bom[i - 1][j] = '.';
							bom[i + 1][j] = '.';
						}
						if (i == r - 1 && j == 0) {
							bom[i][j] = '.';
							bom[i][j + 1] = '.';
							bom[i - 1][j] = '.';
						}
						if (i == r - 1 && j == c - 1) {
							bom[i][j] = '.';
							bom[i][j - 1] = '.';
							bom[i - 1][j] = '.';
						}
						if (i == r - 1 && j != 0 && j != c - 1) {
							bom[i][j] = '.';
							bom[i][j - 1] = '.';
							bom[i][j + 1] = '.';
							bom[i - 1][j] = '.';
						}

					} else {
						bom[i][j] = '.';
						bom[i + 1][j] = '.';
						bom[i - 1][j] = '.';
						bom[i][j + 1] = '.';
						bom[i][j - 1] = '.';

					}
				}
			}
		}
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(arr[i][j]=='.')
					arr[i][j]='O';
				else
					arr[i][j]='.';
			}
		}
		if(n%2==0){
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(imp[i][j]);
				}
				System.out.println();
			}
		} else if(((n-1)/2)%2!=0){
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(bom[i][j]);
				}
				System.out.println();
			}
		} else{
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
		
	}

}

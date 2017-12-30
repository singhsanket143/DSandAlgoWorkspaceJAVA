package Implementation;

import java.util.ArrayList;
import java.util.Scanner;

public class LisaWorkbook {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int counter = 0;
		int page = 0;
		for (int m = 0; m < n; m++) {

			int t = scn.nextInt();
			page++;
			int ques = 0;
			int no = k;
			for(int i=0;i<t;i++){
				ques++;
				if(ques==page){
					counter++;
				}
				if(ques%k==0 && ques!=t){
					page++;
				}
			}
		}
		System.out.println(counter++);
	}

}

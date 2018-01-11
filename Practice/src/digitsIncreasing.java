
public class digitsIncreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		print("", 2);
	}

	public static void printIncreasing(String osf, int n) {

		if (osf.length() == n) {
			System.out.println(osf);
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if(osf.length()==0){
				printIncreasing(osf+i, n);
			}
			else if(osf.charAt(osf.length()-1)-'0'<i){
				printIncreasing(osf+i, n);
			}
		}
	}

	public static void lexi(long s, long num) {
		if (s == num) {
			System.out.println(s);
			return;
		}
		if (s > num) {
			return;
		}

		System.out.println(s);
		for (int i = (s == 0 ? 1 : 0); i <= 9; i++) {

			lexi(10 * s + i, num);

		}
	}

}

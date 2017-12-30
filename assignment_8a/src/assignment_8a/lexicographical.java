package assignment_8a;

public class lexicographical {

	public static void main(String[] args) {
		lexi(1, 1000);

	}

	public static void lexi(int si, int li) {
		if(si==li){
			System.out.println(si);
		}
		if (si <li) {
			System.out.println(si);

			lexi(si * 10, li);

		} else {
			si /= 10;
			int k = si;
			for (int i = 0; i <= 8; i++) {
				si++;
				if (si <= li)
					System.out.println(si);

			}
			int r = (k / 10) + 1;
			if(r/10!=k/100 && r/10!=li/100)
				System.out.println(r/10);
			if (r * 10 < li)
				lexi(r, li);
		}
	}
}

import java.util.*;

class PartitionTheNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int tcases = scn.nextInt();
		for (int test = 0; test < tcases; test++) {
			int rmv = scn.nextInt();
			int Num = scn.nextInt();

			long sum = (((long) (Num) * (Num + 1))) / 2;
			zeroOneseq(Num, rmv, sum);
			System.out.println();
		}
	}

	public static void zeroOneseq(int Num, int rmv, long sum) {
		long actualsum = (sum - rmv) / 2;
		// System.out.println(sum - rmv);
		long calcsum = 0;
		long remove = rmv;
		HashMap<Long, Integer> index = new HashMap<>();

		for (long j = 1; j <= Num; j++) {
			if (j == remove) {
				index.put(j, 2);
			} else {
				index.put(j, 1);
			}

		}

		if (Num > 3) {
			
			if ((sum - rmv) % 2 == 0) {
				for (long i = Num; i > 0; i--) {
					if (calcsum < actualsum) {
						long diff = actualsum - calcsum;
						if ((i != rmv) && i <= diff) {
							calcsum += i;
							index.put(i, 0);
						} else if ((i != rmv) && i > diff) {
							if (diff != rmv) {
								calcsum += diff;
								index.put(diff, 0);
							} else {
								long a = diff - 1;
								calcsum += (a);
								index.put(a, 0);
								calcsum += 1;
								long one = 1;
								index.put(one, 0);
							}
						}
					}
					if (calcsum == actualsum) {
						break;
					}
				}
				for (int j = 1; j <= Num; j++) {
					System.out.println(index.get(j));
				}
			} else {
				System.out.print("impossible");
			}
		} else {
			System.out.print("impossible");
		}

	}

}

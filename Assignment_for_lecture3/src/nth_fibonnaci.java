import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class nth_fibonnaci {
//	private Fibo() { }

    public static int getNthfibo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The fibo value cannot be negative");
        }

        if (n <= 1) return n;

        int[][] result = {{1, 0}, {0, 1}}; // identity matrix.
        int[][] fiboM = {{1, 1}, {1, 0}};

        while (n > 0) {
            if (n%2 == 1) {
                multMatrix(result, fiboM);
            }
            n = n / 2;
            multMatrix(fiboM, fiboM);
        }

        return result[1][0];
    }

    private static void multMatrix(int[][] m, int [][] n) {
        int a = m[0][0] * n[0][0] +  m[0][1] * n[1][0];
        int b = m[0][0] * n[0][1] +  m[0][1] * n[1][1];
        int c = m[1][0] * n[0][0] +  m[1][1] * n[0][1];
        int d = m[1][0] * n[0][1] +  m[1][1] * n[1][1];

        m[0][0] = a;
        m[0][1] = b;
        m[1][0] = c;
        m[1][1] = d;
    }


//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(getNthfibo(i));
//        }
//    }
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		ArrayList<Integer> input = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		int N = 0;
		while (t-- > 0) {
			N = scn.nextInt();
			max = (N > max) ? N : max;
			input.add(N);
		}
		HashMap<Integer, Long> map = new HashMap<>();
		long a = 0, b = 1, sum = 0;
		// int N = scn.nextInt();
		for (int i = 1; i <= max; i++) {
			sum = a + b;

			a = b;
			b = sum;
			map.put(i, a);
		}
		for (int i = 0; i < input.size(); i++) {
			long z = map.get(input.get(i));
			String str = Long.toString(z);
			if (str.length() > 2) {
				System.out.println(str.substring(str.length() - 2));
			} else {
				System.out.println(str);
			}
		}
	}
}

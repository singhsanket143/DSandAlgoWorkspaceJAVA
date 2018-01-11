import java.util.HashMap;
import java.util.Stack;

public class stockSpan {

	public static void main(String[] args) {
		// TODO Auto-genera1ted method stub
		int[] arr = {60,70,80,100,90,75,80,120};
		int[] result = new int[arr.length];
		result = stockSpan(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public static int[] stockSpan(int[] arr) {
		Stack<Integer> st = new Stack<>();
		Stack<Integer> s = new Stack<>();
//		HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[arr.length];
		st.push(arr[0]);
		s.push(1);
//		map.put(arr[0], 1);
		for (int i = 0; i < arr.length; i++) {
			result[i] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			int c = i;
			while (!st.isEmpty() && !s.isEmpty() && st.peek() < arr[i]) {
//				result[c] += map.get(st.pop());
				result[c]+=s.pop();
				st.pop();
			}
			st.push(arr[i]);
			s.push(result[c]);
//			map.put(arr[i], result[c]);
		}
		return result;
	}
	
}

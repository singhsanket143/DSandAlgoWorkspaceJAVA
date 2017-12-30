
public class UniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(unique("!abcc!ca"));
	}

	public static String unique(String str) {
		int[] arr = new int[95];
		for (int i = 0; i < str.length(); i++) {
			if (arr[str.charAt(i) - '!'] == 0) {
				arr[str.charAt(i) - '!']++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (arr[str.charAt(i) - '!'] > 0) {
				sb.append(str.charAt(i));
				arr[str.charAt(i) - '!'] = 0;
			}
		}
		return sb.toString();
	}

}

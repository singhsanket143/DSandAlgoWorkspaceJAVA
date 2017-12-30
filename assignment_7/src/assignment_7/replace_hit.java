package assignment_7;

public class replace_hit {

	public static void main(String[] args) {
		System.out.println(replace_hit("hihithi"));

	}
	public static String replace_hit(String s) {
		if (s.length() == 0)
			return "";
		
		if (s.length() == 1) {
			String d = "";
			d = d + s.charAt(0);
			return d;
		}
		String osf = "";

		if (s.charAt(0) == 'h' && s.charAt(1) == 'i' && s.length() != 2 && s.charAt(2) != 't')
			osf = "bye" + replace_hit(s.substring(2));
		
		else if (s.charAt(0) == 'h' && s.charAt(1) == 'i' && s.length() == 2)
			return "bye" ;
		
		else
			osf = s.charAt(0) + replace_hit(s.substring(1));

		return osf;

	}

}

package assignment_7;

public class ques_5 {

	public static void main(String[] args) {
		System.out.println(strngreppetitive("heelloo"));

	}

	public static String strngreppetitive(String s) {
		String osf = "";
		String val = s;
		if (s.length() == 1)
			return val.substring(val.length() - 1);
		osf = strngreppetitive(s.substring(1));
		if (s.charAt(0) == s.charAt(1))
			osf = s.charAt(0) + "*" + osf;
		else
			osf = s.charAt(0) + osf;
		return osf;

	}

}

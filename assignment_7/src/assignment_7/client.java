package assignment_7;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println(Stringsumdigits("1234"));

		// System.out.println(stringreversecom("1234","4321",0));

		// System.out.println(stringpallindrome("1234321",0,6));

		// System.out.println(strngreppetitive("hellloooo"));

		// System.out.println(removereppetitive("hellloooo"));

		// System.out.println(putxatlast("helloxjh"));

		System.out.println(replace_hit("hithi"));
	}

	public static int Stringsumdigits(String s) {
		if (s.length() == 0)
			return 0;
		char c = s.charAt(0);
		int d = Stringsumdigits(s.substring(1));
		d = d + c - '0';
		return d;
	}

	public static int str2int(String s) {
		if (s.length() == 1)
			return s.charAt(0) - '0';
		char c = s.charAt(s.length() - 1);

		int d = str2int(s.substring(0, s.length() - 1));
		d = d * 10 + c - '0';
		return d;

	}

	public static boolean stringreversecom(String s1, String s2, int si) {
		if (s1.length() != s2.length())
			return false;
		if (si == s1.length())
			return true;
		if (s1.charAt(si) != s2.charAt(s2.length() - si - 1))
			return false;
		else
			return stringreversecom(s1, s2, si + 1);
	}

	public static boolean stringpallindrome(String s, int l, int r) {
		if (l >= r)
			return true;
		if (s.charAt(l) != s.charAt(r))
			return false;
		else
			return stringpallindrome(s, l + 1, r - 1);
	}

	public static String strngreppetitive(String s) {
		String osf = "";
		if (s.length() == 1) {
			String d = "";
			d = d + s.charAt(0);
			return d;
		}

		osf = strngreppetitive(s.substring(1));
		if (s.charAt(0) == s.charAt(1))
			osf = s.charAt(0) + "*" + osf;
		else
			osf = s.charAt(0) + osf;
		return osf;

	}

	public static String removereppetitive(String s) {
		String osf = "";
		if (s.length() == 1) {
			String d = "";
			d = d + s.charAt(0);
			return d;
		}

		osf = removereppetitive(s.substring(1));
		if (s.charAt(0) != s.charAt(1))
			osf = s.charAt(0) + osf;

		return osf;

	}

	public static String putxatlast(String str) {
		if (str.length() == 0)
			return "";
		String ros = str.substring(1);
		String mr = "";
		char ch = str.charAt(0);
		String recresult = putxatlast(ros);
		if (ch == 'x')
			mr = recresult + ch;
		else
			mr = ch + recresult;
		return mr;
	}

	public static int count_hi(String s) {

		if (s.length() == 1)
			return 0;
		int count = 0;
		if (s.charAt(0) == 'h' && s.charAt(1) == 'i')
			count = 1 + count_hi(s.substring(2));
		else
			count = count_hi(s.substring(1));

		return count;

	}

	public static String remove_hi(String s) {
		if (s.length() == 0)
			return "";
		if (s.length() == 1) {
			String d = "";
			d = d + s.charAt(0);
			return d;
		}
		String osf = "";

		if (s.charAt(0) == 'h' && s.charAt(1) == 'i')
			osf = remove_hi(s.substring(2));
		else
			osf = s.charAt(0) + remove_hi(s.substring(1));

		return osf;

	}

	public static String replace_hi(String s) {
		if (s.length() == 0)
			return "";
		if (s.length() == 1) {
			String d = "";
			d = d + s.charAt(0);
			return d;
		}
		String osf = "";

		if (s.charAt(0) == 'h' && s.charAt(1) == 'i')
			osf = "bye" + replace_hi(s.substring(2));
		else
			osf = s.charAt(0) + replace_hi(s.substring(1));

		return osf;

	}

	public static int count_hit(String s) {

		if (s.length() == 1)
			return 0;
		int count = 0;
		if (s.charAt(0) == 'h' && s.charAt(1) == 'i' && s.length() != 2 && s.charAt(2) != 't')
			count = 1 + count_hit(s.substring(2));
		else if (s.charAt(0) == 'h' && s.charAt(1) == 'i' && s.length() == 2)
			count = 1;

		else
			count = count_hit(s.substring(1));

		return count;

	}

	public static String remove_hit(String s) {
		if (s.length() == 0)
			return "";
		if (s.length() == 1) {
			String d = "";
			d = d + s.charAt(0);
			return d;
		}
		String osf = "";

		if (s.charAt(0) == 'h' && s.charAt(1) == 'i' && s.length() != 2 && s.charAt(2) != 't')
			osf = remove_hit(s.substring(2));
		else if (s.charAt(0) == 'h' && s.charAt(1) == 'i' && s.length() == 2)
			osf = remove_hit(s.substring(2));
		else
			osf = s.charAt(0) + remove_hit(s.substring(1));

		return osf;

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
			return "bye";

		else
			osf = s.charAt(0) + replace_hit(s.substring(1));

		return osf;

	}

}

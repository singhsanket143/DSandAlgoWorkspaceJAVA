
public class firstnonreapeatingcharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nonrepeatingfirst("aDcadhc"));
	}

	public static char nonrepeatingfirst(String str) {
		int[] auxarr1 = new int[26];
		int[] auxarr2 = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch=str.charAt(i);
			if(ch>='a' && ch<='z'){
				auxarr1[ch-'a']++;
			} else if(ch>='A' && ch<='Z'){
				auxarr2[ch-'A']++;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			char ch=str.charAt(i);
			if(ch>='a' && ch<='z'){
				if(auxarr1[ch-'a']==1)
					return ch;
			} else if(ch>='A' && ch<='Z'){
				if(auxarr2[ch-'A']==1)
					return ch;
			}
		}
		return str.charAt(0);
	}

}

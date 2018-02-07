package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(makeLargestSpecial("011011100110"));

	}
	public static String makeLargestSpecial(String S) {
        if (S.length() == 0) return S;
        int anchor = 0, bal = 0;
        List<String> mountains = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '1' ? 1 : -1;
            if (bal == 0) {
                mountains.add("1" + makeLargestSpecial(S.substring(anchor+1, i)) + "0");
                anchor = i+1;
            }
        }
        Collections.sort(mountains, Collections.reverseOrder());
        StringBuilder ans = new StringBuilder();
        for (String mtn: mountains)
            ans.append(mtn);
        return ans.toString();
    }

}

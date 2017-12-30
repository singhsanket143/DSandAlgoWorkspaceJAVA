package Lecture31;


public class encodedecodeclient {

	public static void main(String[] args) {
		HCoder hcoder=new HCoder("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccdd");
		System.out.println(hcoder.encode("abcabcac"));
		System.out.println(hcoder.decode("1010011010011001"));
		
	}

}


public class replaceCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeconsecutiveduplicates("aabbbaacaaa",""));
	}
	
	public static String replace(String input,char c1,char c2){
		StringBuilder str=new StringBuilder(input);
		String k=""+c2;
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)==c1){
				str.replace(i, i+1, k);
			}
		}
		return str.toString();
		
	}
	public static String removeconsecutiveduplicates(String input,String ans){
		if(input.length()==1){
			return ans+input;
		}
		char ch=input.charAt(0);
		String ros=input.substring(1);
//		String result="";
//		if(ros.length()>=1){
			if(ch!=ros.charAt(0)){
				ans=removeconsecutiveduplicates(ros, ans+ch);
			} else {
				ans=removeconsecutiveduplicates(ros, ans);
			}
//		}
		return ans;
	}

}

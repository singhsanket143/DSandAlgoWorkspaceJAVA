package DP;

public class longestEventLengthSubstrSumFirstSecondHalf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(equalLengthSum("123123"));

	}

	
	public static int equalLengthSum(String str) {
		int ans = 0;
		for(int i=0;i<str.length()-2;i++) {
			int lsum=0, rsum=0;
			int l=i, r=i+1;
			while(l>=0 && r<str.length()) {
				lsum+=str.charAt(l)-'0';
				rsum+=str.charAt(r)-'0';
				if(lsum==rsum) {
					ans = Math.max(ans, r-l+1);
				}
				l--;
				r++;
			}
		}
		return ans;
	}
}

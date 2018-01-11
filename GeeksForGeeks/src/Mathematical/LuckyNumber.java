package Mathematical;

public class LuckyNumber {
	public static void main(String[] args) {

		System.out.println(isLucky(17));
	}
	public static int counter=2;
	public static boolean isLucky(int n){
		if(counter>n){
			return true;
		}
		if(n%counter==0){
			return false;
		}
		n-=n/counter;
		counter++;
		return isLucky(n);
	}
}

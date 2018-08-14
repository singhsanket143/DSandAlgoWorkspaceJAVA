import java.util.Random;
import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
		Random ran = new Random();
		char arr[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(int i=0;i<100000;i++) {
			System.out.print(arr[(ran.nextInt(26))]);
		}
	}

}
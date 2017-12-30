package assignment_8b;

import java.util.Scanner;

public class snakes_ladders {

	public static void main(String[] args) {
		countBoardPathsBtr(100, 1, storage)

	}
	public static void snakesandladders(int n){
		takeinput();
		
	}
	
	public static boolean IsPrimeNumber(int number){
		 
		for(int i=2; i*i<= number; i++){
			if( number % i == 0)
				return false;
		}
		
		return true;
	}
	public static int isprimereverse(int number){
		for(int i=number-1;i>=0;i--){
			if(number%i==0){
				return 0;
			}
		}
		return number;
	}

	
	public static int countBoardPathsBtr(int last, int curr, int[] storage) {
		if (curr == last) {
			return 1;
		}

		if (curr > last) {
			return 0;
		}

		if (storage[curr] != 0) {
			return storage[curr];
		}

		int count = 0;

		for (int i = 1; i <= 6; i++) {
			if(IsPrimeNumber(curr)){
				count+=countBoardPathsBtr(last, isprimereverse(last), storage);
			}
			else
				count += countBoardPathsBtr(last, curr + i, storage);
		}

		storage[curr] = count;
		return count;
	}

	

}

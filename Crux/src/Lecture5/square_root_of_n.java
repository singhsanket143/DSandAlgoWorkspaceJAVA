package Lecture5;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class square_root_of_n {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N = scn.nextInt();
		int P = scn.nextInt();

		System.out.println(sqrtper(N, P));
	}

	public static double squarerootpercision(int n, int p) {
		int v = p;
		double sqrt = 0;
		int ihelper = 1;
		double dhelper = 0.1;
		int i = 1;
		double d = 1.0;
		// double check = 0.1;
		while (sqrt * sqrt <= n) {
			sqrt += ihelper;
		}
		sqrt -= 1;
		while (p != 0) {
			// check /= 10;
			// dhelper = check;
			i *= 10;
			d *= 10;
			while ((sqrt * sqrt <= n)) {
				sqrt += dhelper;
			}
			sqrt -= dhelper;
			dhelper /= 10;
			p--;

		}
		// double c=Math.pow(10, v);
		// double k=Math.round(sqrt*c);
		// return sqrt;
		return (Math.round(sqrt * i) / d);
	}

	public static double squareRoot(int N, int P) {
		double sqrt = 0;
		double increment = 1;
		double dHelper = 1.0;
		int iHelper = 1;

		while (P != 0) {
			increment = increment * 0.1;
			dHelper *= 10;
			iHelper *= 10;

			P--;
		}

		while (sqrt * sqrt <= N) {
			sqrt += increment;

		}

		sqrt = sqrt - increment;

		return (Math.round(sqrt * iHelper) / dHelper);

	}
	public static double sqrtper(int n,int p){
		double sqrt=0;
		double increment=1;
		double dHelper=1.0;
		while(sqrt*sqrt<=n){
			sqrt++;
		}
		while(p!=0){
			dHelper*=0.1;
			while(sqrt*sqrt<=n){
				sqrt+=dHelper;
			}
			sqrt-=0.1;
			p--;
		}
		return sqrt;
	}

}

package DP;

import java.util.Scanner;

public class textJustification {

	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		int w=scn.nextInt();
		String words1[] = new String[n];
		for(int i=0;i<n;i++) {
			words1[i]=scn.next();
		}
//		init();
        System.out.println(justify(words1, w));
//        System.out.println(duration());
	}
	
	public static long startTime = 0;
	public static long endTime = 0;

	public static void init() {
		startTime = System.currentTimeMillis();
	}

	public static long duration() {
		endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

	public static String justify(String[] words, int width) {
		int[][] cost = new int[words.length][words.length];

		for (int i = 0; i < words.length; i++) {
			cost[i][i] = width - words[i].length();
			for (int j = i + 1; j < words.length; j++) {
				cost[i][j] = cost[i][j - 1] - words[j].length() - 1;
			}
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (cost[i][j] < 0) {
					cost[i][j] = Integer.MAX_VALUE;
				} else {
					cost[i][j] = (int) Math.pow(cost[i][j], 2);
				}
			}
		}
		
		int[] minCost = new int[words.length];
		int[] result=new int[words.length];
		for(int i=words.length-1;i>=0;i--) {
			minCost[i]=cost[i][words.length-1];
			result[i]=words.length;
			for(int j=words.length-1;j>i;j--) {
				if(cost[i][j-1]==Integer.MAX_VALUE) {
					continue;
				}
				if(minCost[i]> minCost[j]+cost[i][j-1]) {
					minCost[i]=minCost[j]+cost[i][j-1];
					result[i]=j;
				}
			}
		}
		int i=0,j;
		System.out.println(minCost[0]);
		StringBuilder sb=new StringBuilder();
		do {
			j=result[i];
			for(int k=i;k<j;k++) {
				sb.append(words[k]+" ");
			}
			sb.append("\n");
			i=j;
		} while(j<words.length);
		return sb.toString();
	}

}

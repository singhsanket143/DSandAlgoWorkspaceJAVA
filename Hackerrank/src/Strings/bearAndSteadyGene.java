package Strings;

import java.util.HashMap;
import java.util.Scanner;

public class bearAndSteadyGene {

	 public static void main(String[] args) {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        Scanner scan = new Scanner(System.in);
	        int size = scan.nextInt();
	        String gene = scan.next();
	        
	        int limiter = size/4;
	        HashMap<Character, Integer> contents = new HashMap<Character, Integer>();
	        contents.put('G', -1 * limiter);
	        contents.put('A', -1 * limiter);
	        contents.put('C', -1 * limiter);
	        contents.put('T', -1 * limiter);
	        for(int i = 0; i < gene.length(); i++){
	            contents.put(gene.charAt(i), (int)contents.get(gene.charAt(i)) + 1);
	        }
	        int min = Integer.MAX_VALUE;
	        int i = 0;
	        int j = 0;
	        while(i < gene.length() && j < gene.length()){
	            if(!validity(contents)){
	                contents.put(gene.charAt(j), (int)contents.get(gene.charAt(j)) - 1);
	                j++;
	            }
	            else{
	                min = Math.min(min, j-i);
	                contents.put(gene.charAt(i), (int)contents.get(gene.charAt(i)) + 1);
	                i++;
	            }
	        }
	        System.out.println(min);
	    }
	    
	    public static boolean validity(HashMap contents){
	        return (int)contents.get('G') <= 0 && (int)contents.get('A') <= 0 && (int)contents.get('C') <= 0 && (int)contents.get('T') <= 0;
	    }

}

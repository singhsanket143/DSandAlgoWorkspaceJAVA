package DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class jobScheduling {
	
	class jobs {
		int start;
		int end;
		int profit;
		
		jobs(int start, int end, int profit) {
			this.start = start;
			this.end = end;
			this.profit = profit;
		}
	}
	
	class finishComparator implements Comparator<jobs> {

		@Override
		public int compare(jobs arg0, jobs arg1) {
			if(arg0.end <= arg1.end){
	            return -1;
	        }else{
	            return 1;
	        }
		}
	}
	
	public static jobScheduling s=new jobScheduling();

	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		jobs jobs[] = new jobs[n];
		for(int i=0;i<n;i++) {
			int a=scn.nextInt();
			int b=scn.nextInt();
			int c=scn.nextInt();
			jobs[i]=s.new jobs(a, b, c);
		}
//        jobs[0] = s.new jobs(3, 10, 20);
//        jobs[1] = s.new jobs(1, 2, 50);
//        jobs[2] = s.new jobs(6, 19, 100);
//        jobs[3] = s.new jobs(2, 100, 200);
//        jobs[4] = s.new jobs(5,8,11);
//        jobs[5] = s.new jobs(7,9,2);
        System.out.println(schedule(jobs));
	}
	
	public static int jobSchedule(jobs[] jobs) {
		finishComparator f = s.new finishComparator();
		int[] dp = new int[jobs.length];
		dp[0]=jobs[0].profit;
		Arrays.sort(jobs, f);
		for(int i=0;i<jobs.length;i++) {
			dp[i]=Math.max(dp[0],jobs[i].profit);
			for(int j=0;j<=i;j++) {
				if(jobs[i].start>=jobs[j].end) {
					dp[i]=Math.max(jobs[i].profit+dp[j],dp[i]);
				}
			}
		}
		int maxVal = Integer.MIN_VALUE;
        for (int val : dp) {
            if (maxVal < val) {
                maxVal = val;
            }
        }
        return maxVal;
	}
	
	static public int schedule(jobs jobs[])
    {
        // Sort jobs according to finish time
		finishComparator f = s.new finishComparator();
        Arrays.sort(jobs, f);
 
        // Create an array to store solutions of subproblems.
        // table[i] stores the profit for jobs till jobs[i]
        // (including jobs[i])
        int n = jobs.length;
        int table[] = new int[n];
        table[0] = jobs[0].profit;
 
        // Fill entries in M[] using recursive property
        for (int i=1; i<n; i++)
        {
            // Find profit including the current job
            int inclProf = jobs[i].profit;
            int l = binarySearch(jobs, i);
            if (l != -1)
                inclProf += table[l];
 
            // Store maximum of including and excluding
            table[i] = Math.max(inclProf, table[i-1]);
        }
 
        return table[n-1];
    }
	
	static public int binarySearch(jobs jobs[], int index)
    {
        // Initialize 'lo' and 'hi' for Binary Search
        int lo = 0, hi = index - 1;
 
        // Perform binary Search iteratively
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (jobs[mid].end <= jobs[index].start)
            {
                if (jobs[mid + 1].end <= jobs[index].start)
                    lo = mid + 1;
                else
                    return mid;
            }
            else
                hi = mid - 1;
        }
 
        return -1;
    }
}

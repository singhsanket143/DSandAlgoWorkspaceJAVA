package DP;

import java.util.Arrays;
import java.util.Comparator;

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

	public static void main(String[] args) {
		jobScheduling s=new jobScheduling();
		jobs jobs[] = new jobs[6];
        jobs[0] = s.new jobs(1,3,5);
        jobs[1] = s.new jobs(2,5,6);
        jobs[2] = s.new jobs(4,6,5);
        jobs[3] = s.new jobs(6,7,4);
        jobs[4] = s.new jobs(5,8,11);
        jobs[5] = s.new jobs(7,9,2);
        System.out.println(jobSchedule(jobs));
	}
	
	public static int jobSchedule(jobs[] jobs) {
		jobScheduling s=new jobScheduling();
		finishComparator f = s.new finishComparator();
		int[] dp = new int[jobs.length];
		dp[0]=jobs[0].profit;
		Arrays.sort(jobs, f);
		for(int i=1;i<jobs.length;i++) {
			dp[i]=Math.max(dp[0],jobs[i].profit);
			for(int j=0;j<i;j++) {
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
}

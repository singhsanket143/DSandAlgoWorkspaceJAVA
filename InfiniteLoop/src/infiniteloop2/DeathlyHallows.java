package infiniteloop2;

import java.util.Scanner;
import java.util.*;
import java.io.*;

public class DeathlyHallows {

	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
	public static void main(String args[]) {
		FastReader scn=new FastReader();
		PrintWriter printer=new PrintWriter(System.out);
		int t = scn.nextInt();
		while (t-- > 0) {
			System.out.println(reachNumber(scn.nextLong()));
		}

	}

	public static long reachNumber(long target) {
		target = Math.abs(target);
		long k = 0;
		while (target > 0)
			target -= ++k;
		return target % 2 == 0 ? k : k + 1 + k % 2;
	}
}

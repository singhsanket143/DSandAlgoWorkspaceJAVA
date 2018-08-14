package graphs;

import java.util.*;
import java.io.*;

public class permutationSwaps {

	static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Reader scn = new Reader();
		PrintWriter pw=new PrintWriter(System.out);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n=scn.nextInt();
			int m=scn.nextInt();
			List<Integer>[] edges =new List[n];
			for(int i=0;i<edges.length;i++) {
				edges[i]=new ArrayList();
			}
			int[] p = new int[n];
			int[] q = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = scn.nextInt();
			}
			for (int i = 0; i < n; i++) {
				q[i] = scn.nextInt();
			}
			for(int i=0;i<m;i++) {
				int j=scn.nextInt();
				int k=scn.nextInt();
				edges[j-1].add(k-1);
				edges[k-1].add(j-1);
			}
			
			ArrayList<ArrayList<Integer>> result = connectedComponents(edges, n);
			boolean r = false;
			for (int i = 0; i < result.size(); i++) {
				ArrayList<Integer> c = result.get(i);
				boolean bool = false;
				HashMap<Integer,Integer> a1 = new HashMap<>();
				for (int j = 0; j < c.size(); j++) {
					a1.put(p[c.get(j)],1);
				}
				for(int j=0;j<c.size();j++) {
					if(!a1.containsKey(q[c.get(j)])) {
						pw.println("NO");
						pw.flush();
						r=true;break;
					}
				}
				if(r) {
					break;
				}
			}
			if (!r) {
				pw.println("YES");
				pw.flush();
			} 
		}

	}

	public static ArrayList<ArrayList<Integer>> connectedComponents(List<Integer>[] edges, int n) {
		boolean[] visited = new boolean[n];
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				ArrayList<Integer> component = new ArrayList();
				dfs(edges, i, component, visited);
				output.add(component);
			}
		}
		return output;
	}

	public static void dfs(List<Integer>[] edges, int start, ArrayList<Integer> component, boolean[] visited) {
		visited[start] = true;
		component.add(start);
		for (int i = 0; i < edges[start].size(); i++) {
			int next = edges[start].get(i);
			if (!visited[next]) {
				dfs(edges, next, component, visited);
			}
		}
	}
}

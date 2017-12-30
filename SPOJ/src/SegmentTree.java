import java.util.HashMap;
import java.util.Scanner;

class SegmentTree {
	private class Node {
		long data;
		int si;
		int ei;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public SegmentTree(int[] arr, long p) {
		root = construct(arr, 0, arr.length - 1, p);
	}

	private Node construct(int[] arr, int si, int ei, long p) {
		if (si == ei) {
			Node base = new Node();
			this.size++;

			base.data = arr[si] % p;
			base.si = base.ei = si;
			return base;
		}
		int mid = (si + ei) / 2;

		Node node = new Node();
		this.size++;
		node.si = si;
		node.ei = ei;

		node.left = construct(arr, si, mid, p);
		node.right = construct(arr, mid + 1, ei, p);

		node.data = ((node.left.data % p) * (node.right.data % p)) % p;

		return node;
	}

	public long query(int qsi, int qei, long p) {
		return query(root, qsi, qei, p);

	}

	private long query(Node node, int qsi, int qei, long p) {
		// node entirely in the query
		if (node.si >= qsi && node.ei <= qei) {
			return node.data % p;
		}
		// node entirely out of query
		else if (node.ei < qsi || node.si > qei) {
			return 1;
		}
		// overlap
		else {
			long lsc = query(node.left, qsi, qei, p);
			long rsc = query(node.right, qsi, qei, p);
			return ((lsc % p) * (rsc % p)) % p;
		}

	}

	public void update(int idx, int data) {
		update(root, idx, data);
	}

	private void update(Node node, int idx, int data) {

		if (node.si == idx && node.ei == idx) {
			node.data = data;
			return;
		}

		int mid = (node.si + node.ei) / 2;
		if (idx > mid) {
			update(node.right, idx, data);
		} else {
			update(node.left, idx, data);
		}

		node.data = (node.left.data * node.right.data);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			long p = scn.nextLong();
			int q = scn.nextInt();
			HashMap<Integer, Long> map = new HashMap<>();
			int[] A = new int[n];
			for (int i = 0; i < n; i++) {
				A[i] = scn.nextInt();
				A[i] %= p;
			}
			SegmentTree tree = new SegmentTree(A, p);
			int[] arr = new int[(int) Math.floor(q / 64) + 2];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			int x = 0;
			int li = 0, ri = 0;
			long a = 0;
			for (int i = 0; i <= q; i++) {
				x = (i == 0) ? 0 : (int) ((a % p + 1) % p);
				if (i % 64 == 0) {
					li = (((arr[i / 64] % n) + (x % n)) % n);
					// li %= n;
					ri = (((arr[(i / 64) + 1] % n) + (x % n)) % n);
					// ri %= n;
				} else {
					li = (((li % n) + (x % n)) % n);
					ri = (((ri % n) + (x % n)) % n);
				}
				if (li > ri) {
					int temp = li;
					li = ri;
					ri = temp;

				}
				String s = "" + li + "_" + ri;

				if (map.containsKey(s.hashCode())) {
					String[] one = s.split("_");
					if (Integer.parseInt(one[0]) == li && Integer.parseInt(one[0]) == ri)
						a = map.get(s.hashCode())%p;
					else
						a = tree.query(li, ri, p) % p;
				} else {
					a = tree.query(li, ri, p) % p;
					map.put(s.hashCode(), a);
				}

			}
			System.out.println((x) % p);
		}
	}
}
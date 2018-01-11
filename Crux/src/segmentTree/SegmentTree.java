package segmentTree;

public class SegmentTree {
	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;
	}

	private Node root;
	private int size;
	private ISegmentOperator operator;

	public void changeOperator(ISegmentOperator operator) {
		this.operator = operator;
		updateToNewOperator(root, operator);
	}

	private void updateToNewOperator(Node node, ISegmentOperator operator) {
		if (node.si == node.ei)
			return;

		updateToNewOperator(node.left, operator);
		updateToNewOperator(node.right, operator);

		node.data = this.operator.operation(node.left.data, node.right.data);

	}

	public SegmentTree(int[] arr, ISegmentOperator operator) {
		this.operator = operator;
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int si, int ei) {
		if (si == ei) {
			Node base = new Node();
			this.size++;

			base.data = arr[si];
			base.si = base.ei = si;
			return base;
		}
		int mid = (si + ei) / 2;

		Node node = new Node();
		this.size++;
		node.si = si;
		node.ei = ei;

		node.left = construct(arr, si, mid);
		node.right = construct(arr, mid + 1, ei);

		node.data = this.operator.operation(node.left.data, node.right.data);

		return node;
	}

	public int query(int qsi, int qei) {
		return query(root, qsi, qei);

	}

	private int query(Node node, int qsi, int qei) {
		// node entirely in the query
		if (node.si >= qsi && node.ei <= qei) {
			return node.data;
		}
		// node entirely out of query
		else if (node.ei < qsi || node.si > qei) {
			return this.operator.defaultValue();
		}
		// overlap
		else {
			int lsc = query(node.left, qsi, qei);
			int rsc = query(node.right, qsi, qei);
			return this.operator.operation(lsc, rsc);
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

		node.data = this.operator.operation(node.left.data, node.right.data);
	}
}

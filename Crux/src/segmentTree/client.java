package segmentTree;

public class client {

	public static void main(String[] args) {
		int[] arr = { 10, 2, -3, 7, 6 };

		SegmentTree st = new SegmentTree(arr, new SegmentMaxOperator());

		System.out.println(st.query(0,3));
//		System.out.println(st.query(3, 7));
//
//		st.changeOperator(new SegmentMinOperator());
//		st.update(3, -7);
//		
//		System.out.println(st.query(2, 5));
//		System.out.println(st.query(3, 7));

	}

}

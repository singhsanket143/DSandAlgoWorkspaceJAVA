package segmentTree;

public class SegmentMaxOperator implements ISegmentOperator{

	@Override
	public int operation(int lsv, int rsv) {
		return Math.max(lsv, rsv);	
	}

	@Override
	public int defaultValue() {
		return Integer.MIN_VALUE;
	}
}

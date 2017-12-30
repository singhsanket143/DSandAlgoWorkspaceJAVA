package segmentTree;

public class SegmentMinOperator implements ISegmentOperator{

	@Override
	public int operation(int lsv, int rsv) {
		return Math.min(lsv, rsv);	
	}

	@Override
	public int defaultValue() {
		return Integer.MAX_VALUE;
	}
}

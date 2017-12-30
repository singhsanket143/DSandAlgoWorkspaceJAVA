package segmentTree;

public class SegmentProductOperator implements ISegmentOperator {

	@Override
	public int operation(int lsv, int rsv) {
		return lsv * rsv;
	}

	@Override
	public int defaultValue() {
		return 1;
	}
}

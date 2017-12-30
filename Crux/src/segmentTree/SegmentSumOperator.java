package segmentTree;

public class SegmentSumOperator implements ISegmentOperator{

	@Override
	public int operation(int lsv, int rsv) {
		return lsv+rsv;		
	}

	@Override
	public int defaultValue() {
		return 0;		
	}

}

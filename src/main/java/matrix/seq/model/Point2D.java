package matrix.seq.model;

/**
 * 
 * @author vaamarques
 *
 */
public class Point2D extends Point {

	public Point2D(int x, int y) {
		super(x, y);
	}

	/**
	 * Check if this point and otherPoint are adjacent. Assume that adjacent points
	 * should share the same column or the same row
	 * 
	 * @param otherPoint
	 * @return
	 */
	public boolean isAdjacent(Point2D otherPoint) {

		if (x == otherPoint.getX() || y == otherPoint.getY()) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return "Point 2D [x=" + x + ", y=" + y + "]";
	}

}

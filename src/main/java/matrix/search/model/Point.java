package matrix.search.model;

/**
 * 
 * @author vaamarques
 *
 */
public class Point {
	protected int x;
	protected int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Check if otherPoint is adjacent Assume that adjacent points should share the
	 * same column or the same row
	 * 
	 * @param otherPoint
	 * @return
	 */
	public boolean isAdjacent(Point otherPoint) {

		if (x == otherPoint.getX() || y == otherPoint.getY()) {
			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}

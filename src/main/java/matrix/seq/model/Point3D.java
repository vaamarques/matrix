package matrix.seq.model;

/**
 * Point in 3D Dimension
 * 
 * @author vaamarques
 *
 */
public class Point3D extends Point {

	private int z;

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return "Point3D [x= " + x + ", y= " + y + ", z=" + z + "]";
	}
}

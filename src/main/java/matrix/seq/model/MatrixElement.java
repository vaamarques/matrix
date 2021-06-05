package matrix.seq.model;

/**
 * Element of a matrix that represents a point with an value
 * @author vaamarques
 *
 * @param <T> Point
 */
public class MatrixElement<T extends Point> {
	
	protected Integer value;
	protected T point;

	public MatrixElement(Integer value, T point) {
		this.value = value;
		this.point = point;
	}
	
	public Integer getValue() {
		return value;
	}

	public T getPoint() {
		return point;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + point.getX();
		result = prime * result + point.getY();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrixElement<?> other = (MatrixElement<?>) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (point == null)
			if (other.getPoint() != null)
				return false;
		if (other.getPoint() == null)
			if (point != null)
				return false;
		if (point.getX() != other.getPoint().getX())
			return false;
		if (point.getY() != other.getPoint().getY())
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MatrixElement [value=" + value + ", Point=" + point + "]";
	}
	
}

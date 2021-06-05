package matrix.seq.model;

/**
 * Exception throw when matrix is not valid
 * @author vaamarques
 *
 */
public class InvalidMatrixExcpetion extends Exception {
	private static final long serialVersionUID = -5246941640146664888L;

	public InvalidMatrixExcpetion(String message) {
		super(message);
	}
}

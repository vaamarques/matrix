package matrix.search.exception;

/**
 * Exception when matrix is not valid
 * @author vaamarques
 *
 */
public class InvalidMatrixException extends Exception {
	private static final long serialVersionUID = -5246941640146664888L;

	public InvalidMatrixException(String message) {
		super(message);
	}
}

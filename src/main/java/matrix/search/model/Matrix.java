package matrix.search.model;

import java.util.List;

/**
 * Base class for Matrix
 * 
 * @author vaamarques
 *
 */
public abstract class Matrix<T extends MatrixElement<? extends Point>> {

	/**
	 * Print matrix legibly to output
	 * <p>
	 * Each column element is separated by one space (or several spaces if make
	 * legible) and each row in a single line
	 * </p>
	 * 
	 * @throws Exception
	 */
	public abstract void printMatrix() throws Exception;

	/**
	 * Find the longest sequence of values sorted in ascendant order in adjacent
	 * positions
	 * 
	 * @return longest sequence of matrix values
	 * @throws Exception
	 */
	public abstract List<T> getLongestSequence() throws Exception;

	/**
	 * Print longest sequence legibly to output
	 * <p>
	 * Each value must be separated by space
	 * </p>
	 * 
	 * @throws Exception
	 */
	public abstract void printLongestSequence() throws Exception;

}

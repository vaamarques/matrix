package matrix.search.model;

import java.util.List;

/**
 * Matrix with unique elements
 * @author vaamarques
 *
 */
public abstract class Matrix<T extends MatrixElement<? extends Point>> {

	/**
	 * Print matrix legibly to output
	 * @throws Throwable
	 */
	public abstract void printMatrix() throws Throwable;

	/**
	 * Find the longest sequence of values sorted in ascendant order in adjacent coordinates
	 * @return
	 * @throws Throwable
	 */
	public abstract List<T> getLongestSequence() throws Throwable;
	
	/**
	 * Print longest sequence legibly to output
	 * @throws Throwable
	 */
	public abstract void printLongestSequence() throws Throwable;

}

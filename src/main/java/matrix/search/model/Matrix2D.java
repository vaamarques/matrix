package matrix.search.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import matrix.search.exception.InvalidMatrixException;
import matrix.search.exception.LongestSequenceMatrixException;

/**
 * Matrix in 2D with unique value elements
 * 
 * @author vaamarques
 *
 */
public class Matrix2D extends Matrix<MatrixElement<Point>> {

	protected int numColumns;
	protected int numRows;
	protected Set<MatrixElement<Point>> elements = new HashSet<MatrixElement<Point>>();

	/**
	 * Create a matrix two dimensions with <code> numColums </code> columns and
	 * <code> numRows </code> rows
	 * 
	 * @param numColumns
	 * @param numRows
	 */
	public Matrix2D(int numColumns, int numRows) {
		this.numColumns = numColumns;
		this.numRows = numRows;
	}

	/**
	 * Create a matrix two dimensions with <code> numColums </code> columns,
	 * <code> numRows </code> rows and with elements <code>elements</code>
	 * 
	 * @param numColumns
	 * @param numRows
	 * @param elements
	 * @throws InvalidMatrixExcpetion
	 */
	public Matrix2D(int numColumns, int numRows, Set<MatrixElement<Point>> elements) throws InvalidMatrixException {
		this.numColumns = numColumns;
		this.numRows = numRows;
		this.elements = elements;
		validateElements();
	}

	/**
	 * Calculate the total number of elements
	 * 
	 * @return total number of elements
	 */
	private int getTotalNumberOfElements() {
		return numColumns * numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public int getNumRows() {
		return numRows;
	}

	/**
	 * Return matrix elements
	 * 
	 * @return Set elements
	 */
	public Set<MatrixElement<Point>> getElements() {
		return elements;
	}

	/**
	 * Set elements <code>elements</code> to matrix
	 * 
	 * @param elements
	 * @throws InvalidMatrixExcpetion
	 */
	public void setElements(Set<MatrixElement<Point>> elements) throws InvalidMatrixException {
		this.elements = elements;
		validateElements();
	}

	/**
	 * Calculate the number of spaces needed to draw the Matrix
	 * 
	 * @param value
	 * @return number of spaces
	 */
	private int getNumSpaces(Integer value) {
		String val = Integer.toString(value);
		String numMax = Integer.toString(getTotalNumberOfElements());
		return numMax.length() - val.length();
	}

	/**
	 * Within position x <code>x</code> and y <code>y</code> return the respective
	 * value
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @throws InvalidMatrixExcpetion
	 */
	public Integer getMatrixPointValue(int x, int y) throws InvalidMatrixException {
		for (MatrixElement<Point> el : elements) {
			if (el.getPoint().getX() == x && el.getPoint().getY() == y) {
				if (el.getValue() != null) {
					return el.getValue();
				}
			}
		}
		String message = String.format("Point(%s,%s) does not have value", x, y);
		throw new InvalidMatrixException(message);
	}

	/**
	 * Sort matrix elements values in ascendant order
	 * 
	 * @return matrix values sorted in ascendant order
	 */
	public LinkedList<MatrixElement<Point>> getElementsSortedByValue() {
		return getElements().stream().sorted(Comparator.comparing(MatrixElement::getValue))
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Fill matrix with random and unique values The elements must be unique and
	 * must have a valid size accordingly with matrix dimensions
	 * 
	 * @throws InvalidMatrixExcpetion
	 */
	public void fillMatrixRandomly() throws InvalidMatrixException {
		elements.clear();
		List<Integer> listValues = getListValues();
		// Shuffle the values
		Collections.shuffle(listValues);

		int indexValue = 0;
		for (int x = 1; x <= numRows; x++) {
			for (int y = 1; y <= numColumns; y++) {
				int value = listValues.get(indexValue);
				Point point = new Point(x, y);
				MatrixElement<Point> matrixElement = new MatrixElement<Point>(value, point);
				elements.add(matrixElement);
				indexValue++;
			}
		}

		validateElements();
	}

	/**
	 * Validate the size of elements
	 * 
	 * @throws InvalidMatrixExcpetion
	 */
	private void validateElements() throws InvalidMatrixException {
		if (elements.size() != getTotalNumberOfElements()) {
			String message = String.format(
					"Matrix does not have the valid size of elements. Elements are %s and must be %s", elements.size(),
					getTotalNumberOfElements());
			throw new InvalidMatrixException(message);
		}
	}

	/**
	 * Build a list of unique values, begin at 1 until total number of matrix
	 * elements
	 * 
	 * @return list unique values
	 */
	private List<Integer> getListValues() {
		List<Integer> values = new ArrayList<>();
		for (int x = 1; x <= getTotalNumberOfElements(); x++) {
			values.add(x);
		}
		return values;
	}

	/**
	 * Find last value of collection
	 * 
	 * @param <T>
	 * @param elements
	 * @return last value
	 */
	public static <T> T getLastElement(final Iterable<T> elements) {
		T lastElement = null;

		for (T element : elements) {
			lastElement = element;
		}

		return lastElement;
	}

	@Override
	public void printMatrix() throws InvalidMatrixException {
		for (int x = 1; x <= numRows; x++) {
			for (int y = 1; y <= numColumns; y++) {
				Integer value = getMatrixPointValue(x, y);
				System.out.print(value + "  ");
				int numSpaces = getNumSpaces(value);
				for (int i = 0; i < numSpaces; i++) {
					System.out.print(" ");
				}
			}

			System.out.println();
		}
	}

	@Override
	public List<MatrixElement<Point>> getLongestSequence() throws LongestSequenceMatrixException {
		// Get elements ordered by value
		List<MatrixElement<Point>> elementsOrderedByValue = getElementsSortedByValue();
		List<MatrixElement<Point>> longestSequence = new LinkedList<>();

		// First element is 1
		longestSequence.add(elementsOrderedByValue.get(0));
		// Check elements after position 1
		for (int i = 1; i < elementsOrderedByValue.size(); i++) {
			MatrixElement<Point> matrixElement = elementsOrderedByValue.get(i);
			// Get last element
			MatrixElement<Point> longestSequenceLastElement = getLastElement(longestSequence);
			// Next point must be adjacent of longest sequence last element
			if (matrixElement.getPoint().isAdjacent(longestSequenceLastElement.getPoint())) {
				longestSequence.add(matrixElement);
			} else {
				break;
			}
		}

		return longestSequence;
	}

	@Override
	public void printLongestSequence() throws LongestSequenceMatrixException {
		List<MatrixElement<Point>> longestSequence = getLongestSequence();
		for (MatrixElement<Point> el : longestSequence) {
			System.out.print(el.getValue() + " ");
		}
	}
}

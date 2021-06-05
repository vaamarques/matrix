package matrix.search.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import matrix.search.exception.InvalidMatrixExcpetion;

/**
 * 
 * @author vaamarques
 *
 */
public class Matrix2D extends Matrix<MatrixElement<Point>> {

	protected int numColumns;
	protected int numRows;
	protected Set<MatrixElement<Point>> elements = new HashSet<MatrixElement<Point>>();

	public Matrix2D(int numColumns, int numRows) throws InvalidMatrixExcpetion {
		this.numColumns = numColumns;
		this.numRows = numRows;
	}

	public Matrix2D(int numColumns, int numRows, Set<MatrixElement<Point>> elements) throws InvalidMatrixExcpetion {
		this.numColumns = numColumns;
		this.numRows = numRows;
		this.elements = elements;
		if (this.elements.size() != numTotalElements()) {
			throw new InvalidMatrixExcpetion("Matrix does not have a valid number of elements");
		}
	}

	/**
	 * Calculate the total number of elements
	 * @return
	 */
	private int numTotalElements() {
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
	 * Calculate the number of spaces needed to draw the Matrix
	 * 
	 * @param value
	 * @return number of spaces
	 */
	private int getNumSpaces(Integer value) {
		String val = Integer.toString(value);
		String numMax = Integer.toString(numColumns * numRows);
		return numMax.length() - val.length();
	}

	/**
	 * Within position x,y return the respective value
	 * 
	 * @param x
	 * @param y
	 * @return value of position x,y
	 */
	public Integer getMatrixPointValue(int x, int y) {
		for (MatrixElement<Point> el : elements) {
			if (el.getPoint().getX() == x && el.getPoint().getY() == y) {
				return el.getValue();
			}
		}
		return null;
	}

	/**
	 * Sort matrix elements in ascendant order
	 * 
	 * @return values sorted in ascendant order
	 */
	public LinkedList<MatrixElement<Point>> getElementsOrderedByValue() {
		return getElements().stream().sorted(Comparator.comparing(MatrixElement::getValue))
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Fill matrix with random and unique values
	 */
	public void fillMatrix() {
		elements.clear();
		List<Integer> listValues = getListValues();
		// Shuffle the values
		Collections.shuffle(listValues);

		int indexValue = 0;
		for (int x = 1; x <= numColumns; x++) {
			for (int y = 1; y <= numRows; y++) {
				int value = listValues.get(indexValue);
				Point point = new Point(x, y);
				MatrixElement<Point> matrixElement = new MatrixElement<Point>(value, point);
				elements.add(matrixElement);
				indexValue++;
			}
		}

	}

	/**
	 * Build a list of unique values
	 * 
	 * @return
	 */
	private List<Integer> getListValues() {
		List<Integer> values = new ArrayList<>();
		for (int x = 1; x <= numColumns * numRows; x++) {
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
	public void printMatrix() {
		for (int x = 1; x <= numRows; x++) {
			for (int y = 1; y <= numColumns; y++) {
				Integer value = getMatrixPointValue(x, y);
				System.out.print(value + "   ");
				int numSpaces = getNumSpaces(value);
				for (int i = 0; i < numSpaces; i++) {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	@Override
	public List<MatrixElement<Point>> getBiggerSequence() {
		List<MatrixElement<Point>> elementsOrderedByValue = getElementsOrderedByValue();
		List<MatrixElement<Point>> biggerSequence = new LinkedList<>();

		biggerSequence.add(elementsOrderedByValue.get(0));
		for (int i = 1; i < elementsOrderedByValue.size(); i++) {
			MatrixElement<Point> matrixElement = elementsOrderedByValue.get(i);
			MatrixElement<Point> biggerSequenceLastElement = getLastElement(biggerSequence);
			if (matrixElement.getPoint().isAdjacent(biggerSequenceLastElement.getPoint())) {
				biggerSequence.add(matrixElement);
			} else {
				break;
			}
		}

		return biggerSequence;
	}
}

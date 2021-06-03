package matrix.seq.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Matrix {

	int numColumns;
	int numRows;
	List<MatrixElement> elements = new ArrayList<MatrixElement>();

	public Matrix(int numColumns, int numRows) {
		this.numColumns = numColumns;
		this.numRows = numRows;
	}

	public int getNumColumns() {
		return numColumns;
	}

	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public List<MatrixElement> getElements() {
		return elements;
	}

	public void setElements(List<MatrixElement> elements) {
		this.elements = elements;
	}

	public void print() throws Exception {

		for (int x = 1; x <= numRows; x++) {
			for (int y = 1; y <= numColumns; y++) {
				System.out.print(getXYElement(x, y) + " ");
			}
			System.out.print("\n");
		}
	}

	public Integer getXYElement(int x, int y) throws Exception {

		for (MatrixElement el : elements) {

			if (el.getX() == x && el.getY() == y) {

				return el.getValue();
			}
		}

		return null;
	}

	public List<MatrixElement> getElementsOrderedByValue() {
		return getElements().stream().sorted(Comparator.comparing(MatrixElement::getValue))
				.collect(Collectors.toList());
	}

	public void fillMatrix() {
		elements = new ArrayList<>();

		for (int x = 1; x <= numColumns; x++) {

			for (int y = 1; y <= numRows; y++) {

				int randomNumber = getRandomNumber();

				MatrixElement matrixElement = new MatrixElement();
				matrixElement.setValue(randomNumber);
				matrixElement.setX(x);
				matrixElement.setY(y);
				elements.add(matrixElement);
			}
		}

	}

	public boolean containsValue(Integer value) {
		return getElements().stream().anyMatch(element -> element.getValue() == value);
	}

	private Integer getRandomNumber() {
		Random r = new Random();
		int result = r.nextInt(numColumns * numRows - 1) + 1;

//		while (containsValue(result)) {
//			result = r.nextInt(numColumns * numRows - 1) + 1;
//		}

		return result;
	}

	public List<MatrixElement> getBiggerSequence() {
		List<MatrixElement> elementsOrderedByValue = getElementsOrderedByValue();
		List<MatrixElement> biggerSequence = new ArrayList<>();

		for (int i = 0; i < elementsOrderedByValue.size(); i++) {

			MatrixElement matrixElement = elementsOrderedByValue.get(i);
			MatrixElement matrixElement2 = elementsOrderedByValue.get(i + 1);

			if (i + 1 < elementsOrderedByValue.size()) {
				if (matrixElement.getX() == matrixElement2.getX() || matrixElement.getY() == matrixElement2.getY()) {
					biggerSequence.add(matrixElement);
					biggerSequence.add(matrixElement2);
				} else {
					biggerSequence.add(matrixElement);
					return biggerSequence;
				}
			}
		}
		return biggerSequence;
	}
}

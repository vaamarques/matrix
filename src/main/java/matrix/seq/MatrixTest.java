package matrix.seq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import matrix.seq.model.Matrix;
import matrix.seq.model.MatrixElement;

public class MatrixTest {

	public static void main(String[] args) throws Exception {
		List<MatrixElement> matrixElements = new ArrayList<MatrixElement>();
		int numColumns = 3;
		int numRows = 3;
		int minValue = 1;
		int maxValue = numColumns * numRows;

		for (int x = 1; x <= numColumns; x++) {

			for (int y = 1; y <= numRows; y++) {

				MatrixElement matrixElement = new MatrixElement();
				matrixElement.setValue(x*y);
				matrixElement.setX(x);
				matrixElement.setY(y);

				matrixElements.add(matrixElement);
			}
		}
		Matrix matrix = new Matrix(numColumns, numRows);
		matrix.setNumColumns(numColumns);
		matrix.setNumRows(numRows);
		matrix.setElements(matrixElements);
		
		 matrix.print();
		
		 
//		 
//		List<MatrixElement> biggerSeq = new ArrayList<MatrixElement>();
//		
//		for(int i = 0; i< matrixElementsOrdered.size(); i ++) {
//			
//			if(i+1<matrixElementsOrdered.size()) {
//				if(matrixElementsOrdered.get(i).getX() == matrixElementsOrdered.get(i+1).getX() 
//						|| matrixElementsOrdered.get(i).getY() == matrixElementsOrdered.get(i+1).getY()) {
//					
//						biggerSeq.add(matrixElementsOrdered.get(i));
//				}
//			}
//		}
//		
//		System.out.println("Bigger seq " + biggerSeq);
	}

}

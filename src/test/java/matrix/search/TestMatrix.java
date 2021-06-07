package matrix.search;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

import matrix.search.exception.InvalidMatrixException;
import matrix.search.model.Matrix2D;
import matrix.search.model.MatrixElement;
import matrix.search.model.Point;
import matrix.search.model.Point3D;

/**
 * 
 * @author vaamarques
 *
 */
public class TestMatrix {

	@Test
	public void testPoints() throws Exception {

		Point x = new Point(1, 1);
		Point3D x3D = new Point3D(1, 1, 1);
		MatrixElement<Point> el = new MatrixElement<Point>(1, x);
		MatrixElement<Point3D> el2 = new MatrixElement<Point3D>(2, x3D);
		assertNotEquals(el, el2);
	}

	@Test
	public void testNotValidMatrix2D3x3() throws Exception {

		System.out.println("Not valid Matrix2D 3x3 ");

		Matrix2D matrix = new Matrix2D(3, 3);

		assertThrows(InvalidMatrixException.class, () -> matrix.setElements(getNotValidMatrixElements(3, 3)));

	}

	@Test
	public void testMatrix2D3x3() throws Exception {

		System.out.println("Matrix2D 3x3 ");

		Matrix2D matrix = new Matrix2D(3, 3);

		matrix.fillMatrixRandomly();

		matrix.printMatrix();

		matrix.printLongestSequence();

		System.out.println();
	}

	@Test
	public void testMatrix2D4x4() throws Exception {

		System.out.println("Matrix2D 4x4 ");

		Matrix2D matrix = new Matrix2D(4, 4);

		matrix.fillMatrixRandomly();
		matrix.printMatrix();

		matrix.printLongestSequence();

		System.out.println();
	}

	@Test
	public void testMatrix2D6x6() throws Exception {

		System.out.println("Matrix2D 6x6 ");

		Matrix2D matrix = new Matrix2D(6, 6);

		matrix.fillMatrixRandomly();
		matrix.printMatrix();
		matrix.printLongestSequence();

		System.out.println();
	}

	@Test
	public void testMatrix2D9x9() throws Exception {

		System.out.println("Matrix2D 9x9 ");

		Matrix2D matrix = new Matrix2D(9, 9);

		matrix.fillMatrixRandomly();
		matrix.printMatrix();
		matrix.printLongestSequence();

		System.out.println();
	}

	@Test
	public void testMatrix2D2x2() throws Exception {

		System.out.println("Matrix2D 2x2 ");

		Matrix2D matrix = new Matrix2D(2, 2);

		matrix.fillMatrixRandomly();
		matrix.printMatrix();
		matrix.printLongestSequence();

		System.out.println();
	}

	@Test
	public void testMatrix2D2x6() throws Exception {

		System.out.println("Matrix2D 2x6 ");

		Matrix2D matrix = new Matrix2D(2, 6);

		matrix.fillMatrixRandomly();
		matrix.printMatrix();
		matrix.printLongestSequence();

		System.out.println();
	}
	
	
	@Test
	public void testMatrix2D10x5() throws Exception {

		System.out.println("Matrix2D 10x5 ");

		Matrix2D matrix = new Matrix2D(10, 5);

		matrix.fillMatrixRandomly();
		matrix.printMatrix();
		matrix.printLongestSequence();

		System.out.println();
	}

	public Set<MatrixElement<Point>> getNotValidMatrixElements(int numRows, int numColumns) {

		Set<MatrixElement<Point>> elements = new LinkedHashSet<MatrixElement<Point>>();
		for (int i = 1; i <= numRows * numColumns; i++) {
			Point point = new Point(1, 1);
			MatrixElement<Point> matrixElement = new MatrixElement<Point>(1, point);
			elements.add(matrixElement);
		}

		return elements;
	}
}

package matrix.search;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

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
	public void testMatrix2D3x3() throws Exception {

		System.out.println("Matrix2D 3x3 ");

		Matrix2D matrix = new Matrix2D(3, 3);

		matrix.fillMatrix();

		matrix.printMatrix();

		matrix.printLongestSequence();

		System.out.println();
	}

	@Test
	public void testMatrix2D4x4() throws Exception {

		System.out.println("Matrix2D 4x4 ");

		Matrix2D matrix = new Matrix2D(4, 4);

		matrix.fillMatrix();

		matrix.printMatrix();

		matrix.printLongestSequence();

		System.out.println();
	}

	@Test
	public void testMatrix2D6x6() throws Exception {

		System.out.println("Matrix2D 6x6 ");

		Matrix2D matrix = new Matrix2D(6, 6);

		matrix.fillMatrix();
		matrix.printMatrix();

		matrix.printLongestSequence();

		System.out.println();
	}
}

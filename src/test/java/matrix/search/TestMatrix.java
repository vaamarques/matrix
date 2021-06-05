package matrix.search;

import org.junit.Test;

import matrix.search.model.Matrix2D;

/**
 * 
 * @author vaamarques
 *
 */
public class TestMatrix {

	@Test
	public void textMatrix2D3x3() throws Exception {

		System.out.println("Matrix2D 3x3 ");

		Matrix2D matrix = new Matrix2D(3, 3);

		matrix.fillMatrix();

		matrix.printMatrix();
		
		matrix.printLongestSequence();
		
		System.out.println();
	}

	@Test
	public void textMatrix2D4x4() throws Exception {

		System.out.println("Matrix2D 4x4 ");

		Matrix2D matrix = new Matrix2D(4, 4);

		matrix.fillMatrix();

		matrix.printMatrix();

		matrix.printLongestSequence();
		
		System.out.println();
	}

	@Test
	public void textMatrix2D6x6() throws Exception {

		System.out.println("Matrix2D 6x6 ");

		Matrix2D matrix = new Matrix2D(6, 6);

		matrix.fillMatrix();
		matrix.printMatrix();
		
		matrix.printLongestSequence();
		
		System.out.println();
	}
}

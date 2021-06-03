package matrix.seq;

import org.junit.Test;

import matrix.seq.model.Matrix;

public class TestMatrix {

	@Test
	public void textMatrix2x2() throws Exception {
		
		System.out.println("Matrix 2x2 ");

				Matrix matrix = new Matrix(2, 2);
		
		matrix.fillMatrix();
		
		matrix.print();
		
		System.out.println("Bigger sequence " + matrix.getBiggerSequence());
	}
	
	@Test
	public void textMatrix3x3() throws Exception {
		
		System.out.println("Matrix 3x3 ");

				Matrix matrix = new Matrix(3, 3);
		
		matrix.fillMatrix();
		
		matrix.print();
		
		System.out.println("Bigger sequence " + matrix.getBiggerSequence());
	}
	
	
	@Test
	public void textMatrix6x6() throws Exception {
		
		System.out.println("Matrix 6x6 ");
		
		Matrix matrix = new Matrix(6, 6);
		
		matrix.fillMatrix();
		
		matrix.print();
		
		System.out.println("Bigger sequence " + matrix.getBiggerSequence());
		
	}
	
	
	@Test
	public void textMatrix9x9() throws Exception {
		System.out.println("Matrix 9x9 ");
		
		Matrix matrix = new Matrix(9, 9);
		
		matrix.fillMatrix();
		matrix.print();
		
		System.out.println("Bigger sequence " + matrix.getBiggerSequence());
		
	}
	
	
	@Test
	public void textMatrix3x9() throws Exception {
		System.out.println("Matrix 3x9 ");
		
		Matrix matrix = new Matrix(3, 9);
		
		matrix.fillMatrix();
		matrix.print();
		
		System.out.println("Bigger sequence " + matrix.getBiggerSequence());
		
	}
	
}

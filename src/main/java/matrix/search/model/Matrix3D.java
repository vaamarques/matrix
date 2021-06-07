package matrix.search.model;

import java.util.List;

import matrix.search.exception.NotImplementedException;

/**
 * Matrix with 3D 
 * @author vaamarques
 *
 */
public class Matrix3D extends Matrix<MatrixElement<Point3D>>{

	@Override
	public void printMatrix() throws NotImplementedException {
		throw new NotImplementedException("No implemented");
	}

	@Override
	public List<MatrixElement<Point3D>> getLongestSequence() throws NotImplementedException {
		throw new NotImplementedException("No implemented");
	}

	@Override
	public void printLongestSequence() throws NotImplementedException {
		throw new NotImplementedException("No implemented");
	}

}

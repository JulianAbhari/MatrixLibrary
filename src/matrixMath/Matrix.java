package matrixMath;

import java.util.Random;

public class Matrix {
	int rows;
	int collumns;
	float[][] matrix;
	Random ran = new Random();
	
	public Matrix(int rows, int collumns) {
		this.rows = rows;
		this.collumns = collumns;
		this.matrix = new float[rows][collumns];
		
		for (int i = 0; i < rows; i += 1) {
			for (int j = 0; j < collumns; j += 1) {
				this.matrix[i][j] = 0;
			}
		}
	}
	
	public void multiply(float multiplier) {
		for (int i = 0; i < rows; i += 1) {
			for (int j = 0; j < collumns; j += 1) {
				this.matrix[i][j] *= multiplier;
			}
		}
	}
	
	public void multiply(Matrix multiplier) {
		for (int i = 0; i < rows; i += 1) {
			for (int j = 0; j < collumns; j += 1) {
				this.matrix[i][j] *= multiplier.getMatrix()[i][j];
			}
		}
	}
	
	public void add(float adder) {
		for (int i = 0; i < rows; i += 1) {
			for (int j = 0; j < collumns; j += 1) {
				this.matrix[i][j] += adder;
			}
		}
	}
	
	public void add(Matrix adder) {
		for (int i = 0; i < rows; i += 1) {
			for (int j = 0; j < collumns; j += 1) {
				this.matrix[i][j] += adder.getMatrix()[i][j];
			}
		}
	}
	
	public void randomize() {
		for (int i = 0; i < rows; i += 1) {
			for (int j = 0; j < collumns; j += 1) {
				this.matrix[i][j] = randomNumber();
			}
		}
	}
	
	public float randomNumber() {
		// This is setting ranNum to a random number between 0-1.
		float ranNum = (float) Math.random();
		// This is setting ranFiftyNum to a random int from 0-1.
		// This has a 50% chance of 0 or 1.
		int ranFiftyNum = ran.nextInt(2);
		// if the ranFiftyNum is 0 than the ranNum will be negative, otherwise
		// positive.
		if (ranFiftyNum == 0) {
			return ranNum * -1;
		} else {
			return ranNum;
		}
	}
	
	public float[][] getMatrix() {
		return this.matrix;
	}
	
	public static void main(String[] args) {
		Matrix matrix = new Matrix(3, 2);
		
		matrix.randomize();
		for (int i = 0; i < matrix.getMatrix().length; i += 1) {
			for (int j = 0; j < matrix.getMatrix()[i].length; j += 1) {
				System.out.println(matrix.getMatrix()[i][j]);
			}
		}
		
		matrix.multiply(10);
		for (int i = 0; i < matrix.getMatrix().length; i += 1) {
			for (int j = 0; j < matrix.getMatrix()[i].length; j += 1) {
				System.out.println(matrix.getMatrix()[i][j]);
			}
		}
	}
}

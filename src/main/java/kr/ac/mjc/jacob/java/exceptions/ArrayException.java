package kr.ac.mjc.jacob.java.exceptions;

/**
 * p.155 예제 3-16
 */
public class ArrayException {

	public static void main(String[] args) {
		int[] intArray = new int[5];
		try {
			for (int i = 0; i < 5; i++) {
				intArray[i + 1] = intArray[i] + 1;
				System.out.format("intArray[%d] = %d\n", i, intArray[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}

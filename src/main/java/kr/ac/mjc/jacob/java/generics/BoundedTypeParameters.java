package kr.ac.mjc.jacob.java.generics;

public class BoundedTypeParameters {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		NumberBox<Integer> integerBox = new NumberBox<>(); // Ok
		NumberBox<Double> doubleBox = new NumberBox<>(); // Ok

		/*
		 * NumberBox<String> stringBox = new StringBox<>(); // error
		 */
	}
}

class NumberBox<N extends Number> { // N : bounded type parameter
	private N n;

	public void set(N n) {
		this.n = n;
	}

	public N get() {
		return n;
	}
}
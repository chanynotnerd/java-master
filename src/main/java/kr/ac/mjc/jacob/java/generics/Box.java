package kr.ac.mjc.jacob.java.generics;

/**
 * Generic version of the SimpleBox class
 */
public class Box<T> { // T : type parameter
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}
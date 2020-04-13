package kr.ac.mjc.jacob.java.concurrency;

/**
 * 참조:
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html
 */
public class Counter {

	private int c = 0;

	public void increment() {
		c++;
	}

	public void decrement() {
		c--;
	}

	public int value() {
		return c;
	}
}

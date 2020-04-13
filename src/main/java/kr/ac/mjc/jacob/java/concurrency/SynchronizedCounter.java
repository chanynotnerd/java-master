package kr.ac.mjc.jacob.java.concurrency;

/**
 * 참조:
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html
 */
public class SynchronizedCounter {

	private int c = 0;

	public synchronized void increment() {
		c++;
	}

	public synchronized void decrement() {
		c--;
	}

	public synchronized int value() {
		return c;
	}
}

package kr.ac.mjc.jacob.java.concurrency;

public class LazyMethods {

	/**
	 * offset 부터 count 개의 숫자를 출력한다.<br>
	 * 스레드 이름과 숫자를 출력한다. 한 개 출력 후에 milliseconds 동안 실행을 멈춘다.
	 */
	public static void printNumbers(final int offset, final int count,
			final int millis) {
		for (int i = offset; i < offset + count; i++) {
			System.out.format("%s : %d\n", Thread.currentThread().getName(), i);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		printNumbers(0, 5, 1000);
	}
}

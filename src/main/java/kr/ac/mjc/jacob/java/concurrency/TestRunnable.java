package kr.ac.mjc.jacob.java.concurrency;

import java.lang.Thread;

/*
 * p.699 Thread를 만드는 방법 2. Runnable 인터페이스를 implements
 */
class TimerRunnable implements Runnable {
	@Override
	public void run() {
		LazyMethods.printNumbers(0, 5, 1000);
	}
}

public class TestRunnable {
	public static void main(String[] args) {
		System.out.println("main 스레드 시작");
		Runnable r1 = new TimerRunnable();
		Thread th1 = new Thread(r1);
		th1.start(); // Thread-0

		new Thread(new TimerRunnable()).start(); // Thread-1

		// anonymous class 사용
		new Thread(new Runnable() {
			@Override
			public void run() {
				LazyMethods.printNumbers(100, 5, 500);
			}
		}).start(); // Thread-2

		// Lambda expression 사용
		new Thread(() -> {
			LazyMethods.printNumbers(1000, 5, 2000);
		}).start(); // Thread-3

		System.out.println("main 스레드 끝");
	}
}

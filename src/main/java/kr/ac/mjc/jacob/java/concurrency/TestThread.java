package kr.ac.mjc.jacob.java.concurrency;

import java.lang.Thread;

/*
 * p.694. Thread를 만드는 방법 1. Thread 클래스를 extends
 */
class TimerThread extends Thread {
	@Override
	public void run() {
		LazyMethods.printNumbers(0, 5, 1000);
	}
}

public class TestThread {
	public static void main(String[] args) {
		System.out.format("%s : 메인 스레드를 시작합니다.\n",
				Thread.currentThread().getName());
		Thread t1 = new TimerThread();
		t1.start();

		new TimerThread().start();
		System.out.format("%s : 메인 스레드가 종료합니다.\n",
				Thread.currentThread().getName());
	}
}



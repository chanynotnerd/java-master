package kr.ac.mjc.jacob.java.concurrency;

/**
 * 화장실 사용 동기화 예제
 */
public class SynchronizedRestroomEx {

	public static void main(String[] args) {
		// 한개의 화장실을 만든다.
		SynchronizedRestroom restroom = new SynchronizedRestroom();

		// 사람 스레드 3명이 1개의 화장실을 공유한다.
		new Thread(new Person(restroom)).start(); // Thread-0
		new Thread(new Person(restroom)).start(); // Thread-1
		new Thread(new Person(restroom)).start(); // Thread-2
	}
}

/**
 * 화장실
 */
class SynchronizedRestroom {
	// 동기화된 메서드
	public synchronized void use() {
		System.out.format("%s : 화장실에 들어갔다.\n",
				Thread.currentThread().getName());
		try {
			Thread.sleep(1000); // 1000ms 시간 소요
		} catch (InterruptedException e) {
		}
		System.out.format("%s : 화장실에서 나왔다.\n",
				Thread.currentThread().getName());
	}
}

class Person implements Runnable {
	private SynchronizedRestroom restroom;

	public Person(SynchronizedRestroom restroom) {
		this.restroom = restroom;
	}

	@Override
	public void run() {
		restroom.use();
	}
}

package kr.ac.mjc.jacob.java.concurrency;

public class SharedPrinterEx {
	public static void main(String[] args) {
		SharedPrinter printer = new SharedPrinter();

		new Thread(() -> {
			printer.print("ABCDE\n");
		}).start();

		new Thread(() -> {
			printer.print("abcde\n");
		}).start();
	}
}

class SharedPrinter {
	public synchronized void print(String str) {
		for (char c : str.toCharArray()) {
			System.out.print(c);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

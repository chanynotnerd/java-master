package kr.ac.mjc.jacob.java.exceptions;

import java.io.FileReader;
import java.io.IOException;

/**
 * p.452 예제 8-1
 */
public class FileReaderEx {

	public void go() {
		// try-with-resources 구문
		// AutoCloseable 인터페이스를 구현한 자원을 finally에서 close() 하고자 할때.
		try (FileReader in = new FileReader("/tmp/test.txt");) {
			char c = (char) in.read();
			System.out.println(c);
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("프로그램이 종료합니다.");
	}

	public static void main(String[] args) {
		new FileReaderEx().go();
	}
}

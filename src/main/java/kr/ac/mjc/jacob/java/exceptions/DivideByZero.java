package kr.ac.mjc.jacob.java.exceptions;

import java.util.Scanner;

/**
 * p.154 예제 3-15
 */
public class DivideByZero {

	public void go() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("분자를 입력하세요 : ");
		int dividend = scanner.nextInt();
		System.out.print("분모를 입력하세요 : ");
		int divisor = scanner.nextInt();
		int result = dividend / divisor;
		System.out.format("%d / %d = %d\n", dividend, divisor, result);
		scanner.close();
		System.out.println("스캐너를 닫고 프로그램을 정상적으로 종료합니다.");
	}

	public static void main(String[] args) {
		new DivideByZero().go();
	}
}

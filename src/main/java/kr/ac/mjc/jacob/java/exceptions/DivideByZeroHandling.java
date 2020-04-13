package kr.ac.mjc.jacob.java.exceptions;

import java.util.Scanner;

/**
 * p.154 예제 3-15
 */
public class DivideByZeroHandling {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("나뉨수(분자)를 입력하시요: ");
			int dividend = scanner.nextInt();
			System.out.print("나눗수(분모)를 입력하시요: ");
			int divisor = scanner.nextInt();
			try {
				System.out.format("%d / %d = %d\n", dividend, divisor, dividend / divisor);
				break;
			} catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다! 다시 입력하세요.");
			}
		}
		scanner.close();
	}

}

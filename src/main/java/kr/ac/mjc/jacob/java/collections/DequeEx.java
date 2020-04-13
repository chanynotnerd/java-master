package kr.ac.mjc.jacob.java.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * p424 예제 7-9 MyStack 수정<br>
 * Queue와 Deque를 구현한 ArrayDeque 테스트
 */
public class DequeEx {
	public static void main(String[] args) {

		Queue<String> queue = new ArrayDeque<>(); // First In First Out
		queue.offer("Seoul");
		queue.offer("Busan");
		queue.offer("LA");
		System.out.println(queue); // [Seoul, Busan, LA]

		System.out.println(queue.poll()); // Seoul
		System.out.println(queue.poll()); // Busan
		System.out.println(queue); // [LA]

		Deque<String> stack = new ArrayDeque<>(); // 양방향으로 넣고 뺄수 있음
		stack.offer("Seoul");
		stack.offer("Busan");
		stack.offer("LA");
		System.out.println(stack); // [Seoul, Busan, LA]

		System.out.println(stack.pollLast()); // LA
		System.out.println(stack.pollLast()); // Busan
		System.out.println(stack); // [Seoul]
	}
}
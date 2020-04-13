package kr.ac.mjc.jacob.java.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack<T> {

	private Deque<T> deque = new ArrayDeque<>();

	public Stack() {
	}

	public void push(T t) {
		deque.offer(t);
	}

	public T pop() {
		return deque.pollLast();
	}
}

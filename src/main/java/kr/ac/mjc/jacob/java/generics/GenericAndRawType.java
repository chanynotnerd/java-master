package kr.ac.mjc.jacob.java.generics;

/**
 * 참조: https://docs.oracle.com/javase/tutorial/java/generics/types.html
 */
public class GenericAndRawType {

	@SuppressWarnings({ "unused" })
	public static void main(String[] args) {

		SimpleBox box = new SimpleBox();
		box.set(5);
		Integer n1 = (Integer) box.get(); // type casting. Object -> Integer

		box.set("choi");
		String s1 = (String) box.get();

		// Integer : type argument
		// Box<Integer> : Box of Integer. parameterized type
		Box<Integer> integerBox = new Box<Integer>();
		integerBox.set(5);
		int n2 = integerBox.get();

		Box<String> stringBox = new Box<>(); // type inference
		stringBox.set("choi");
		String s2 = stringBox.get();

		// raw type : type argument가 없는 generic class나 interface
		// Box를 Box<T>의 raw type이라 한다.
		// 원래부터 generic type이 아닌 것은 raw type이 아니다. SimpleBox는 raw type이 아님.
		Box rawBox = new Box();
		rawBox.set(5);
		Integer n3 = (Integer) rawBox.get();
	}
}

/**
 * Simple Box class
 */
class SimpleBox {
	private Object object;

	public void set(Object object) {
		this.object = object;
	}

	public Object get() {
		return object;
	}
}

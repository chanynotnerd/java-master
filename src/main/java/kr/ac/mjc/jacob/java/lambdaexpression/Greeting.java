package kr.ac.mjc.jacob.java.lambdaexpression;

/**
 * 추상 메서드를 1개만 갖고있는 인터페이스를 functional interface라 한다.<br>
 * Functional interface는 메서드를 전달하기 위한 것이다.
 */
@FunctionalInterface
public interface Greeting {
	void greet(); // public abstract void greet();
}

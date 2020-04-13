package kr.ac.mjc.jacob.java.exceptions;

/**
 * @author Jacob
 */
public class CircleTestMain {

	public void go() {

		Circle c1 = new Circle();
		try {
			c1.setRadius(-5);
			System.out.format("c1의 반지름은 %d 입니다.\n", c1.getRadius());
		} catch (RadiusUnderZeroException e) {
			e.printStackTrace();
		}

		Circle c2;
		try {
			c2 = new Circle(10);
			System.out.format("c2의 반지름은 %d 입니다.\n", c2.getRadius());
		} catch (RadiusUnderZeroException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new CircleTestMain().go();
	}
}
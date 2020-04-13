package kr.ac.mjc.jacob.java.lambdaexpression;

import java.util.ArrayList;
import java.util.List;

/**
 * 참조:
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 */
public class PersonSearchEx {

	/**
	 * 사람 목록을 검색해서 조건에 맞는 사람을 출력하는 메서드
	 */
	public void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public void go() {
		List<Person> roster = new ArrayList<>();
		// TODO: roster에 사람들을 넣는다.

		// 18세 이상 20세 미만인 사람을 출력
		// 방법 1. functional interface를 구현한 로컬 클래스를 만든다.
		class TeenagerChecker implements CheckPerson {
			@Override
			public boolean test(Person p) {
				return 13 <= p.getAge() && p.getAge() < 20;
			}
		}
		printPersons(roster, new TeenagerChecker());

		// 방법 2. anonymous class로 만든다.
		CheckPerson teenagerChecker = new CheckPerson() {
			@Override
			public boolean test(Person p) {
				return 13 <= p.getAge() && p.getAge() < 20;
			}
		};
		printPersons(roster, teenagerChecker);

		// 방법 3. anonymous class를 메서드에 인자로 넣는다.
		printPersons(roster, new CheckPerson() {
			@Override
			public boolean test(Person p) {
				return 13 <= p.getAge() && p.getAge() < 20;
			}
		});

		// 방법 4. Lambda expression 사용
		// functional interface를 구현한 오브젝트는 lambda expression 으로 바꿀 수 있다.
		// lambda expression은 인터페이스 이름과 메서드 이름을 생략한 것이다.
		printPersons(roster, (p) -> {
			return 13 <= p.getAge() && p.getAge() < 20;
		});

		// 18세 이상 성인 남자
		printPersons(roster, (p) -> {
			return p.getGender() == Person.Gender.MALE && p.getAge() >= 18;
		});

		// 이메일이 gmail.com 인 사람
		printPersons(roster, (p) -> {
			return p.getEmail().endsWith("@gmail.com");
		});

		// 이름이 Jacob인 사람
		printPersons(roster, (p) -> {
			return "Jacob".equals(p.getName());
		});
	}

	public static void main(String[] args) {
		new PersonSearchEx().go();
	}
}

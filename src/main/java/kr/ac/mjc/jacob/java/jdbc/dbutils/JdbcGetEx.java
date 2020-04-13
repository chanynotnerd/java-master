package kr.ac.mjc.jacob.java.jdbc.dbutils;

import kr.ac.mjc.jacob.java.jdbc.Student;

/**
 * 1건 조회 예제
 * 
 * @author Jacob
 */
public class JdbcGetEx {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudent("5");
		System.out.println(student);
	}
}

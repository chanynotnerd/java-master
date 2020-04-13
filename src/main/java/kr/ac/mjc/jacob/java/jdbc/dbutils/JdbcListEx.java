package kr.ac.mjc.jacob.java.jdbc.dbutils;

import java.util.List;

import kr.ac.mjc.jacob.java.jdbc.Student;

/**
 * 목록 예제
 * 
 * @author Jacob
 */
public class JdbcListEx {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		List<Student> studentList = studentDao.listStudents();
		for (Student student : studentList)
			System.out.println(student);
	}
}

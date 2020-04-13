package kr.ac.mjc.jacob.java.jdbc.dao;

import java.util.List;

import kr.ac.mjc.jacob.java.jdbc.Student;

public class JdbcAddExUsingDao {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student student = new Student(null, "황우슬혜", "연예인");
		studentDao.addStudent(student);
		System.out.println("학생을 추가했습니다. " + student);

		List<Student> studentList = studentDao.listStudents();
		for (Student st : studentList)
			System.out.println(st);
	}
}

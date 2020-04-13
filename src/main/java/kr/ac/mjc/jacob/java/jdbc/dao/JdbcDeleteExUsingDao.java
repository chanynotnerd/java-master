package kr.ac.mjc.jacob.java.jdbc.dao;

import java.util.List;

import kr.ac.mjc.jacob.java.jdbc.Student;

public class JdbcDeleteExUsingDao {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		String deleteId = "2";
		int updatedRows = studentDao.deleteStudent(deleteId);
		if (updatedRows > 0)
			System.out.println("학생을 삭제했습니다. id=" + deleteId);
		else
			System.out.println("학생이 없어서 삭제할 수 없습니다. id=" + deleteId);

		// 목록 출력
		List<Student> studentList = studentDao.listStudents();
		for (Student st : studentList)
			System.out.println(st);
	}
}

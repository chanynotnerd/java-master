package kr.ac.mjc.jacob.java.jdbc.dao;

import kr.ac.mjc.jacob.java.jdbc.Student;

public class JdbcUpdateExUsingDao {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		Student student = new Student("3", "지자", "컴퓨터공학과");
		int updatedRows = studentDao.updateStudent(student);
		
		if (updatedRows > 0) {
			System.out.println("학생을 수정했습니다.");
			Student st = studentDao.getStudent("5");
			System.out.println(st);
		} else {
			System.out.println("학생이 없어서 수정할 수 없습니다. " + student);
		}
	}
}

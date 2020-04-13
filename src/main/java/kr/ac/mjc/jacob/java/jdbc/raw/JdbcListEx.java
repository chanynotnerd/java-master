package kr.ac.mjc.jacob.java.jdbc.raw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;

import kr.ac.mjc.jacob.java.jdbc.Student;

/**
 * p.861 예제 16-2 수정<br>
 * 학생 목록을 조회한다.
 */
public class JdbcListEx {

	/**
	 * 학생 목록 조회
	 */
	public List<Student> listStudents() {

		List<Student> studentList = new ArrayList<>();
		DataSource ds = new MariaDbDataSource(
				"jdbc:mariadb://localhost:3306/jdbc?user=jdbc&password=javaprogramming");
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"select id, name, dept from student")) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setDept(rs.getString("dept"));
				// 리스트에 학생을 넣는다.
				studentList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentList;
	}

	public static void main(String[] args) {
		List<Student> studentList = new JdbcListEx().listStudents();
		for (Student student : studentList)
			System.out.println(student);
	}
}

package kr.ac.mjc.jacob.java.jdbc.raw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;

import kr.ac.mjc.jacob.java.jdbc.Student;

/**
 * p.861 예제 16-2 수정<br>
 * 학생 1명을 조회한다.
 */
public class JdbcGetEx {

	/**
	 * 학생 1명 조회
	 */
	public Student getStudent(String id) {

		Student student = null;
		DataSource ds = new MariaDbDataSource(
				"jdbc:mariadb://localhost:3306/jdbc?user=jdbc&password=javaprogramming");
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(
						"select id, name, dept from student where id=?")) {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setDept(rs.getString("dept"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public static void main(String[] args) {
		Student student = new JdbcGetEx().getStudent("1"); // id=2인 학생 조회
		System.out.println(student);
	}
}

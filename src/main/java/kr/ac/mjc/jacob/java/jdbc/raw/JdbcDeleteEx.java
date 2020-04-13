package kr.ac.mjc.jacob.java.jdbc.raw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;

/**
 * p.863 예제 16-3 수정<br>
 * 삭제
 */
public class JdbcDeleteEx {
	/**
	 * 학생 1명 삭제
	 */
	public int deleteStudent(String id) {
		int updatedRows = 0;
		DataSource ds = new MariaDbDataSource(
				"jdbc:mariadb://localhost:3306/jdbc?user=jdbc&password=javaprogramming");
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con
						.prepareStatement("delete from student where id=?")) {
			ps.setString(1, id);
			updatedRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedRows;
	}

	public static void main(String[] args) {
		JdbcDeleteEx ex = new JdbcDeleteEx();

		// 학생 한명을 삭제한다.
		String deleteId = "1";
		int updatedRows = ex.deleteStudent(deleteId);
		if (updatedRows > 0)
			System.out.println("학생을 삭제했습니다. id=" + deleteId);
		else
			System.out.println("학생이 없어서 삭제할 수 없습니다. id=" + deleteId);
	}
}

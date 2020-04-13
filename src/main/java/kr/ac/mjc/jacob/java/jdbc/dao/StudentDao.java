package kr.ac.mjc.jacob.java.jdbc.dao;

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
 * Student Data Access Object
 */
public class StudentDao {

	private DataSource ds = null;

	private final String LIST_STUDENTS = "select id, name, dept from student";
	private final String GET_STUDENT = "select id, name, dept from student where id=?";
	private final String ADD_STUDENT = "insert student(id,name,dept) values(?,?,?)";
	private final String UPDATE_STUDENT = "update student set name=?, dept=? where id=?";
	private final String DELETE_STUDENT = "delete from student where id=?";

	public StudentDao() {
		ds = new MariaDbDataSource(
				"jdbc:mariadb://localhost:3306/jdbc?user=jdbc&password=javaprogramming");
	}

	/**
	 * 학생 목록 조회
	 */
	public List<Student> listStudents() throws DataAccessException {
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(LIST_STUDENTS)) {
			List<Student> studentList = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setDept(rs.getString("dept"));
				// 리스트에 학생을 넣는다.
				studentList.add(student);
			}
			return studentList;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}
	}

	/**
	 * 학생 1건 조회
	 */
	public Student getStudent(String id) throws DataAccessException {

		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_STUDENT)) {
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			Student student = null;
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setDept(rs.getString("dept"));
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}
	}

	/**
	 * 학생 추가
	 */
	public int addStudent(Student student) throws DataAccessException {
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(ADD_STUDENT)) {
			ps.setString(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getDept());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}
	}

	/**
	 * 학생 수정
	 */
	public int updateStudent(Student student) throws DataAccessException {
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_STUDENT)) {
			ps.setString(1, student.getName());
			ps.setString(2, student.getDept());
			ps.setString(3, student.getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}
	}

	/**
	 * 학생 삭제
	 */
	public int deleteStudent(String id) throws DataAccessException {
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_STUDENT)) {
			ps.setString(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e);
		}
	}
}
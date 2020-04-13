package kr.ac.mjc.jacob.java.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter/setter, toString(), hashCode(), equals() 추가
@NoArgsConstructor // default constructor 추가
@AllArgsConstructor // overloaded constructor 추가
public class Student {
	private String id;
	private String name;
	private String dept;
}
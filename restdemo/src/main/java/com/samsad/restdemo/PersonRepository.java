package com.samsad.restdemo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class PersonRepository {	
	
	Connection con = null;
	
	public PersonRepository() {
		String url = "jdbc:mysql://localhost:3306/test";
		String JdbcURL = "jdbc:mysql://localhost:3306/test?useSSL=false";
		String username = "root";
		String password = "samsad";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			//con = DriverManager.getConnection(JdbcURL +
				//                                   "user=root&password=samsad");
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
			
	}
	
	public List<Person> getPersons(){
		List<Person> personList = new ArrayList<>();
		String sql = "SELECT * from person";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPhone(rs.getString(4));
				p.setEmail(rs.getString(3));
				
				personList.add(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return personList;
	}
	
	public Person getPerson(int id) {	
		
		Person person = new Person();
		String sql = "select * from person where id="+id;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {				
				person.setId(rs.getInt(1));
				person.setName(rs.getString(2));
				person.setEmail(rs.getString(3));
				person.setPhone(rs.getString(4));		
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return person;
	}

	public void create(Person person) {
		String sql = "insert into person values(?,?,?,?)";

		System.out.println("insert into");
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, person.getId());
			st.setString(2, person.getName());
			st.setString(3, person.getEmail());
			st.setString(4, person.getPhone());
			st.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}		
		
	}

}

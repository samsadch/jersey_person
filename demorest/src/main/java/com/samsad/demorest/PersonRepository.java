package com.samsad.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class PersonRepository {	
	
	Connection con = null;
	
	public PersonRepository() {
		String url = "jdbc:mysql://localhost:3306/demorest";
		String username = "root";
		String password = "123";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
			
	}
	
	public List<Person> getPersons(){
		List<Person> personList = new ArrayList<>();
		String sql = "select * from person";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPhone(rs.getString(2));
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
				person.setPhone(rs.getString(2));
				person.setEmail(rs.getString(3));		
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return person;
	}

	public void create(Person person) {
		String sql = "insert into person where values(?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, person.getId());
			st.setString(2, person.getName());
			st.setString(3, person.getPhone());
			st.setString(4, person.getEmail());
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		
		
	}

}

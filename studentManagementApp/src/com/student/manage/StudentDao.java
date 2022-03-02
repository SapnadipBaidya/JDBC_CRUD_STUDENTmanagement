package com.student.manage;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDao {
public static boolean insertStudentToDB(StudentClass st) {
	boolean flag = false;
	try {
		//jdbc code
		Connection con = CP.createC();
		String q = "insert into students(sname,sphone,scity) values(?,?,?)";
		//preparedStatement
		PreparedStatement pstmt=con.prepareStatement(q);
		//set values of parameters
		pstmt.setString(1, st.getStudentName());
		pstmt.setString(2, st.getStudentPhone());
		pstmt.setString(3, st.getStudentCity());
		
		//execute
		pstmt.executeUpdate();
		flag=true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return flag;
	
  }

public static boolean deleteStudent(int usrID) {
	// TODO Auto-generated method stub
	boolean flag = false;
	try {
		//jdbc code
		Connection con = CP.createC();
		String q = "delete from students where sid=?";
		//preparedStatement
		PreparedStatement pstmt=con.prepareStatement(q);
		//set values of parameters
		pstmt.setInt(1, usrID);
		
		
		//execute
		pstmt.executeUpdate();
		flag=true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return flag;
	
}

public static void showAllStudents() {
	// TODO Auto-generated method stub
	boolean flag = false;
	try {
		//jdbc code
		Connection con = CP.createC();
		String q = "select * from students";
		//preparedStatement
		Statement stmt=con.createStatement();
		ResultSet set =stmt.executeQuery(q);
		while (set.next()) {
		int id = set.getInt(1);
		String name =set.getString(2);
		String phone =set.getString(3);
		String city =set.getString(4);	
		System.out.println("id "+id);
		System.out.println("name "+name);
		System.out.println("phone "+phone);
		System.out.println("city "+city);
		System.out.println("-----------------------------");
		
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}



}

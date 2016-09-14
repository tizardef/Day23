package ssa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
	
	

public class Student {

	static Connection myConn=null;
	static Statement stmt=null;
	static ResultSet rs=null;
	static String dburl;
	static String user;
	static String pass;
	
	
	
public static void main(String[] args) throws SQLException {
	
	//insertData();
	fetchData();
	//deleteRecord();
	
		
}
	
	public static void insertData() throws SQLException{
		try{
			
		     loadProperties();
			myConn= (Connection)DriverManager.getConnection(dburl, user, pass);
			
			myConn= (Connection)DriverManager.getConnection(dburl, user, pass);
			
			stmt= myConn.createStatement();
		String query= "insert into student values(11,'George','Washington', null, 1600, 4.0 )";
		int rowAffected =	stmt.executeUpdate(query);
		System.out.println("Row Affected = "  + rowAffected);
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			if(myConn!= null)
				myConn.close();
			if(stmt!= null)
				stmt.close();
		}
	}
	
	
	public static void myClose(Connection con, Statement stmt, ResultSet rs) throws SQLException{
		
		if(con!=null)
			con.close();
		if(stmt !=null)
			stmt.close();
		if(rs !=null)
			rs.close();
	}
	
	public static void fetchData() throws SQLException {
		
		try{
			
			loadProperties();
			myConn= (Connection)DriverManager.getConnection(dburl, user, pass);
			
			//fetchData();
			
			stmt= myConn.createStatement()	;
			
			ResultSet rs= stmt.executeQuery("select * from student");
			
			while(rs.next())
				System.out.println("Id " + rs.getInt("id") + " " + "FirstName " + rs.getString("first_name") + " " + "LastName " + rs.getString("last_name") + " "+ "Major " + rs.getInt("major_id") + " " + "SAT Score " + rs.getInt("sat" ) + " " + "GPA" + " " + rs.getDouble("gpa") );
			
			
			}catch(Exception exc){
				exc.printStackTrace();
				
			}finally{
				
				myClose(myConn, stmt, rs);
			}
		}

	public static void update() throws SQLException{
		try{
		
		loadProperties();
			myConn= (Connection)DriverManager.getConnection(dburl, user, pass);	
			
		myConn= DriverManager.getConnection(dburl, user, pass);
		stmt = myConn.createStatement();
		String sql= "update student set gpa= 3.5, sat= 1450, major_id= 1 where id=11";
		
		int rowAffected = stmt.executeUpdate(sql);
		
		System.out.println("Row Affected" + rowAffected);
	}catch(Exception ex){ ex.printStackTrace();
	}finally{
		if(myConn!= null)
			myConn.close();
		if(stmt !=null)
			stmt.close();
	}
	}

public static void fetchBasedOnIdData() throws SQLException {
		
		try{
			
			loadProperties();
			myConn= (Connection)DriverManager.getConnection(dburl, user, pass);
			
			//fetchData();
			
			stmt= myConn.createStatement()	;
			
			ResultSet rs= stmt.executeQuery("select * from student where id=11");
			
			while(rs.next())
				System.out.println("Id " + rs.getInt("id") + " " + "FirstName " + rs.getString("first_name") + " " + "LastName " + rs.getString("last_name") + " " + "Major " + rs.getInt("major_id") + " " + "SAT Score " + rs.getInt("sat" )+ " " + "GPA" + rs.getDouble("gpa") );
			
			
			}catch(Exception exc){
				exc.printStackTrace();
				
			}finally{
				
				myClose(myConn, stmt, rs);
			}
		}

public static void deleteRecord() throws SQLException{
	
	try{
		
		loadProperties();
		myConn= (Connection)DriverManager.getConnection(dburl, user, pass);
		
		myConn= (Connection)DriverManager.getConnection(dburl, user, pass);
		
		stmt = myConn.createStatement();
		
		String query= "delete from student where last_name = 'Washington' and sat= 1450";
		int rowAffected= stmt.executeUpdate(query);
		System.out.println(rowAffected + "row is affected");
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(myConn != null)
			myConn.close();
		if(stmt !=null)
			stmt.close();
		
		
		
		
	}

	
	}
public static void loadProperties() throws FileNotFoundException, IOException{
	Properties props = new Properties();
	props.load(new FileInputStream("student.properties"));
	
	 dburl = props.getProperty("dburl");
	 user = props.getProperty("userName");
     pass = props.getProperty("pass");
	
}

public static void fetchData4() throws SQLException {
	
	try{
		
		loadProperties();
		myConn= (Connection)DriverManager.getConnection(dburl, user, pass);
		
		//fetchData();
		
		stmt= myConn.createStatement()	;
		
		ResultSet rs= stmt.executeQuery("select * from student");
		
		while(rs.next())
			System.out.println("Id " + rs.getInt("id") + " FirstName " + rs.getString("first_name") + " " + "LastName " + rs.getString("last_name") +" Major " + rs.getInt("major_id") + " SAT Score " + rs.getInt("sat" )+ " " + "GPA" + " " + rs.getDouble("gpa") );
		
		
		}catch(Exception exc){
			exc.printStackTrace();
			
		}finally{
			
			myClose(myConn, stmt, rs);
		}
	}


}
		
		
		
		
		
	
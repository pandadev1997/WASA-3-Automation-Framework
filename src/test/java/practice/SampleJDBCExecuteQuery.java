package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws Exception {
		//driver for MYsql database
		
		Driver driverref=new Driver();
		
		//step 1:register the driver
		
		DriverManager.registerDriver(driverref);
		
		//step 2:get the connection from databases in url last database name
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dev ", "root", "root");
		
		//step 3:issue the create statement
		
		Statement state=con.createStatement();
		
		//step 4:execute query enter table name
		
		ResultSet result=state.executeQuery("select * from candidateinfo;");
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
		}
		
		//step 5:close the database
		con.close();
		System.out.println("database close");

	}

}

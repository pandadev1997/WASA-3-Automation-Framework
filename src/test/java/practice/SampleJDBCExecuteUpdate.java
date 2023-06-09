package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws Exception {
		// driver for my database
		Driver driverref=new Driver();
		
		//register the driver
		
		DriverManager.registerDriver(driverref);
		
		//get the connection
		Connection con=null;
		try {
		
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/dev", "root", "root");
		
		//issue create statement
		
		Statement state = con.createStatement();
		
		//execute a query
		
		String query="insert into candidateinfo values('apu',54,'berhampur');";
		int result=state.executeUpdate(query);
		if(result>=1) {
			System.out.println("data added to database");
		}
		ResultSet resul = state.executeQuery("select * from candidateinfo;");
		while(resul.next()) {
			System.out.println(resul.getString(1)+" "+resul.getInt(2)+" "+resul.getString(3));
		}
		}
		//step 5:close the database
		finally {
		con.close();System.out.println("db close");
		}
	}

}

package self_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Fetching_data_into_database {

	public static void main(String[] args) throws Exception {
		Driver d=new Driver();
		//register driver
		DriverManager.registerDriver(d);
		//get connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dev ", "root", "root");
		//create statements
		Statement state=con.createStatement();
		//execute query
		ResultSet result=state.executeQuery("select * from candidateinfo;");
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
		}
		//databse connection close
		con.close();

	}

}

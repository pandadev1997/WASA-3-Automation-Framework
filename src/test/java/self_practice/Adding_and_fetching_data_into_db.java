package self_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Adding_and_fetching_data_into_db {
	public static void main(String[] args) throws Exception {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dev ", "root", "root");
		Statement state=con.createStatement();
		String query="insert into candidateinfo values('sumati',34,'lanjipalli');";
		int resul=state.executeUpdate(query);
		if(resul>=1) {
			System.out.println("data added");	
		}
		ResultSet result=state.executeQuery("select * from candidateinfo;");
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
		}
		con.close();
		System.out.println("connection closed");
		
	}

}

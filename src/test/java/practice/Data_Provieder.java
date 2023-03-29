package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provieder {
	@Test(dataProvider = "phone")
	public void data(String phone,int price) {
		System.out.println(phone+"-->"+price);
	}
	@DataProvider(name = "phone")
	public Object[][] getData(){
		Object[][] data=new Object[3][2];
	
		data[0][0]="samsung";
		data[0][1]=12000;
		
		data[1][0]="nokia";
		data[1][1]=15000;
		
		data[2][0]="iphone";
		data[2][1]=25000;
		return data;
	}

}

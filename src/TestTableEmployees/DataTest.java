package TestTableEmployees;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataTest {	
	WebDriver MyD = new ChromeDriver()  ;
	Connection con ; 
	Statement stmt ; 
	ResultSet rs ; 
	String  Website = "https://magento.softwaretestingboard.com/customer/account/create/";
	String linkDB ="jdbc:mysql://localhost:3306/classicmodels";
	String userDB = "root";
	protected String passwordDB= "12345";
    String firstName = "";
  	String lastName = " " ; 
  	String email = "";
  	String password = "" ;
	
	public void callWithDatabase( String Qurey ) throws SQLException {
		stmt = con.createStatement();
		int InsertRow = stmt.executeUpdate(Qurey);
		assertEquals(InsertRow > 0,true);
		
	}
}

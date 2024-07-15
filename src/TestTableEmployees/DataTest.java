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
	String  Website = "https://magento.softwaretestingboard.com/customer/account/create/";
	
	Connection con ; 
	Statement stmt ; 
	ResultSet rs ;
	String linkDB ="jdbc:mysql://localhost:3306/classicmodels";
	String userDB = "root";
	protected String passwordDB= "12345";
    String firstName = "";
  	String lastName = " " ; 
  	String email = "";
  	String password = "" ;
  	
    String qureyDelete = "delete  from  employees where employeeNumber =1000"; 	
  	String queryGet  ="select * from employees where employeeNumber = 1000" ;
  	String qureyUpdate = "Update employees set extension = 'x9999',officeCode = 6" + " where employeeNumber = 1000 "; 
  	String queryInsert = "insert into employees (employeeNumber,lastName,firstName,extension,email,officeCode,reportsTo,jobTitle) " 			
			+ "values(1000,'AbuAisha','Khaled','x6532','St.AlAhmed@gmail.com',2,1002,'Doctor')";
  	
  	
	public void callWithDatabase( String Qurey ) throws SQLException {
		stmt = con.createStatement();
		int InsertRow = stmt.executeUpdate(Qurey);
		assertEquals(InsertRow > 0,true);
		
	}
}

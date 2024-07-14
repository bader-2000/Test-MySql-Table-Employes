package TestTableEmployees;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCases extends DataTest {
	
	
	
	@BeforeTest
	public void CallwaithDataBase() throws SQLException {
		con =  DriverManager.getConnection(linkDB,userDB,passwordDB); 
	} 
	
	

	// adding new Row from data to databases
	@Test (priority = 1  )
	public void InsertRowData() throws SQLException{
		String Query = "insert into employees (employeeNumber,lastName,firstName,extension,email,officeCode,reportsTo,jobTitle) "
				+ "values(1000,'AbuAisha','Khaled','x6532','St.AlAhmed@gmail.com',2,1002,'Doctor')";
		
		callWithDatabase(Query);
		
	}
	
	// Modifying some customer data from databases
	@Test (priority = 2)
	public void UpdateRowData() throws SQLException{
		String Qurey = "Update employees set extension = 'x9999',officeCode = 6" + " where employeeNumber = 1000 "; 		
		callWithDatabase(Qurey);
	}
	
	// Inquire about data and add it to the site
	@Test (priority = 3  )
	public void GetRowData() throws SQLException {
		String Query  ="select * from employees where employeeNumber = 1000" ;
		stmt = con.createStatement();
        rs = stmt.executeQuery(Query);	
        
		while (rs.next()){
			 firstName  = rs.getString("firstName");
			 lastName   = rs.getString("lastName");
 			 email      = rs.getString("email");
 			 password   = rs.getString("extension");
 			System.out.println(firstName + " - " + lastName  +" - "+email+" - "+ password);
		}
		
		MyD.get(Website);
		MyD.findElement(By.id("firstname")).sendKeys(firstName);
		MyD.findElement(By.id("lastname")).sendKeys(lastName);
		MyD.findElement(By.id("email_address")).sendKeys(email);
		MyD.findElement(By.id("password")).sendKeys(password);
		MyD.findElement(By.id("password-confirmation")).sendKeys(password);
		
	}
	
	
	// Delete the entire row from the database
	@Test (priority = 4)
	public void DeleteRowData() throws SQLException{
	    String Qurey = "delete  from  employees where employeeNumber =1000"; 		
		callWithDatabase(Qurey);
		
	}
	
	
}

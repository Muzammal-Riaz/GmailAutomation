package betechcom.betech.qa.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.betech.qa.base.TestBase;
import com.betech.qa.pages.*;
import com.google.code.javax.mail.MessagingException;



public class LoginTest extends TestBase {
	
	EmailPage Email;
	loginPage login;

	public LoginTest() throws IOException
	{
		super();
		
	}
	
	@BeforeMethod
	
	public void SetUp() throws IOException
	{
		
		initialization();
		login = new loginPage();
		
		
	}

	@Test
	
	public void test1() throws InterruptedException, IOException, MessagingException
	{
		
		
		try
		{
			driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			Email = new EmailPage();
			driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			Email = login.login();
		}
		catch (NullPointerException e)
		{
			driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			Email = new EmailPage();
			driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			Email = login.login();
			e.getStackTrace();
		}
		}
	
	@AfterMethod
	
	public void teardown()
	{
		System.out.println("********************************************************************************************************************************************************");
	//	driver.quit();	

	}
}

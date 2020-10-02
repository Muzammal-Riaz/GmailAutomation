package com.betech.qa.pages;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.betech.qa.base.TestBase;
import com.google.code.com.sun.mail.imap.IMAPFolder;
import com.google.code.javax.mail.Folder;
import com.google.code.javax.mail.Message;
import com.google.code.javax.mail.MessagingException;
import com.google.code.javax.mail.Session;
import com.google.code.javax.mail.Store;
import com.google.code.javax.mail.search.GmailRawSearchTerm;

public class loginPage extends TestBase{
	
	
	
	public static Properties Prop;
    Session session;
    Store store;
    IMAPFolder inbox;
    GmailRawSearchTerm rawTerm;
   
   public long last20minutes()
   {
 
   Date date = new Date();
   long total = date.getTime();
   long new1 = total - (20000*60);
   long new2 = new1/(1000*60);
   return new2;
   
   }
   
   
   
   
  //**************MUST READ*********************
  //use your own subject to search
  //********************************************


	
	public loginPage() throws IOException 
	{
		PageFactory.initElements(driver, this);	//constructor
		
	}

	@FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[2]/button[1]")
	WebElement google;
	@FindBy (id = "identifierId")
	WebElement user;
	@FindBy (xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement pass;
	@FindBy (xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/div[2]")
	WebElement nxt_btn_1;
	@FindBy (xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/div[2]")
	WebElement nxt_btn_2;
	

	public EmailPage login () throws InterruptedException, IOException, MessagingException
	{
		
		//*************************MUST READ******************************************************
		//logging in to gmail 
		//As due to privacy policy of gmail we cannot log in directly using http://gmail.com/login 
		//Hence we will log in using another Website
		//in my case i am using "Stackoverflow" login 
		//Before sending, I am erasing my login credentials
		//So before running this project make sure you write your own credentials where needed 
		//****************************************************************************************
		
		
		
		google.click();
		
		driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		user.click();
		
		driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	
		
		user.clear();
		
		driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//*******************************
		//use your own email address here
		//*******************************
		user.sendKeys("ajkdfjdhafljadkl@gmail.com"); 
		
		driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		nxt_btn_1.click();
		
		driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//*******************************
		// use your own password here 
		//*******************************
		
		pass.sendKeys("ajkdbfkbjkfb"); 
		
		driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		nxt_btn_2.click();
		
		driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		((JavascriptExecutor)driver).executeScript("window.open()");	//trying to switch into second tab to open my gmail inbox
		
		driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	    
		for ( String handle : driver.getWindowHandles()) {
			System.out.println(handle);
			driver.switchTo().window(handle);
			
		}
		
	 
		driver.manage().timeouts().pageLoadTimeout(com.betech.qa.util.TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(com.betech.qa.util.TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	   
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		
		//**********************************MUST READ***************************************
		//After logging in I am going to do the following things
		//(1) make connection to the gmail inbox using IMAPS
		//(2) will count the total number of emails 
		//(3) will search for the number of subject of emails that matches with my keyword
		//(4) will one by one print those subjects
		
		//Things to remember
		//Before logging in to any gmail account first make sure the option of
		//"Access to low secure app" is turned on otherwise authentication erro will be shown
		//use your own login credentials in "store.connect()" method 
		//***********************************************************************************
		
        Prop = System.getProperties();
        Prop.setProperty("mail.store.protocol", "imaps");
        session = Session.getDefaultInstance(Prop, null);
        store = session.getStore("imaps");
        store.connect("imap.gmail.com", "kjasdbfjkadfjk@gmail.com", "kasbfjdjlf");
        System.out.println("Connection established !!!!");
        inbox = (IMAPFolder) store.getFolder("INBOX");
        inbox.open(Folder.READ_WRITE);
        System.out.println("Total email counts in inbox : " + inbox.getMessageCount());
      
        Message messagesFound[] = inbox.getMessages();
        
        
        
        //comparing email received in last 20 minutes with the subject
        
        	for (Message message : messagesFound) {
        			String comp = message.getSubject();
        		
        			Date date = message.getReceivedDate();
        			long time = date.getTime();
        			long time1 = time/(1000*60);

        			long time2=last20minutes();
        			
        			System.out.println(time2 + "mins");
        			System.out.println(time2/(60*24) + "days");
        			
        		if (comp.contains("Hello") && time2 <= time1 )
            	{  
        			System.out.println();
        			System.out.println();
        			System.out.println();
        			System.out.println();
        			System.out.println("*****************************************************************************");  
        			System.out.println("Message Received in last 20 minutes");
        			System.out.println("*****************************************************************************"); 
        			System.out.println();
        			System.out.println();
        			System.out.println();
        			System.out.println();
            	}
                
            }
           
        System.out.println("Searching Completed !!!");
        System.out.println("Completed");
        return new EmailPage();
    
    }
}



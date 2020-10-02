package com.betech.qa.pages;

import java.io.IOException;


import org.openqa.selenium.support.PageFactory;

import com.betech.qa.base.TestBase;

public class EmailPage extends TestBase
{
	
	
	
	public EmailPage()  throws IOException
	{
		
		PageFactory.initElements(driver, this);
	}

}

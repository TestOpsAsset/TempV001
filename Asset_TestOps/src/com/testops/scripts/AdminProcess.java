package com.testops.scripts;

import org.testng.annotations.Test;

import com.testops.pages.HealthChecksPage;
import com.testops.pages.HomePage;



public class AdminProcess extends setBrowser {

	@Test (priority=1)
	public void login(){
		HomePage hp = new HomePage(driver);
		hp.logIn(data.User, data.pwd);
			
	}
	
	public void HealthChecks(){
		HealthChecksPage hc = new HealthChecksPage(driver);
		hc.healtCheck(3);
		System.out.println("-------------------------------------------");
	}
	
	
	
}

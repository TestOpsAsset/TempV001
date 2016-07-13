package com.testops.scripts;

import java.util.concurrent.TimeUnit;


import org.testng.annotations.Test;

import com.testops.pages.HomePage;
import com.testops.pages.ListofUsersPage;
import com.testops.pages.NewPwdPage;
import com.testops.pages.NewUserPage;

public class MainProcess extends setBrowser{

	@Test (priority=1)
	public void signIn(){
		HomePage hp = new HomePage(driver);
		hp.logIn(data.User,  data.pwd);
	}
	
	@Test (priority=2)
	public void addnewuser(){
		NewUserPage user = new NewUserPage(driver);
		int serial = (int)(Math.random()*500+1);
		String emailtemp = data.new_FName +"."+ data.new_LName + serial +"@accenture.com";
		user.insertData(data.new_User + serial, data.new_FName + serial,data.new_LName,emailtemp, serial);
	}
	
	@Test (priority=3)
	public void newpassword(){
		NewPwdPage cp = new NewPwdPage(driver);
		cp.changePassword();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}	
		
	@Test (priority=4)
	public void listofUsers(){
		ListofUsersPage userlist = new ListofUsersPage(driver);
		userlist.createListofUsers();
		}		
	
}

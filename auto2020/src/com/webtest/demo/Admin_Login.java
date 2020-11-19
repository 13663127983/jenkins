package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener;


@Listeners(WebTestListener.class)
public class Admin_Login  extends BaseTest{
	
	@Test
	public void testLogin1() {
		
		webtest.open("http://localhost:8032/mymovie/admin.php/Login/index.html");
		webtest.type("name=username", "admin");
		webtest.type("name=password", "admin");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("退出"));
		
	}
	
	@Test
	public void testLogin2() {
		
		webtest.open("http://localhost:8032/mymovie/admin.php/Login/index.html");
		webtest.type("name=username", "admin");
		webtest.type("name=password", "admi");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("退出1"));
		
	}

}

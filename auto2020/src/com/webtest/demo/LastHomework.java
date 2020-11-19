//package com.webtest.demo;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import com.webtest.core.BaseTest;
//
//public class LastHomework extends BaseTest{
//	@BeforeMethod
//	public void login() throws InterruptedException{
//		webtest.open("http://www.roqisoft.com/zhsx/");
//		webtest.click("link=��¼");
//		webtest.type("name=user", "admins");
//		webtest.type("name=pw", "123456");
//		webtest.click("xpath=//input[@value=' �� ¼']");
//		Thread.sleep(2000);
//	}
//	@Test(priority=0)
//	public void record() throws InterruptedException{
//		webtest.mouseToElement("xpath=*[@id=\"topnav\"]/font/li[8]/a/strong");
//		Thread.sleep(2000);
//		webtest.click("link=�����μ�");
//		webtest.click("link=����д�μ�");
//		Thread.sleep(2000);
//		//д�μ�
//		webtest.type("name=title", "�����μ�");
//		Thread.sleep(2000);
//		webtest.tapClick();
//		webtest.type("class=ke-edit-iframe", "���˷羰���续");
//		webtest.click("xpath=//input[@type='submit']");
//		Thread.sleep(2000);
//		//�޸��μ�
//		webtest.click("link=�����μ�");
//		webtest.typeAndClear("name=title", "��������");
//		Thread.sleep(2000);
//		webtest.tapClick();
//		webtest.typeAndClear("class=ke-edit-iframe","�����������");
//		webtest.click("xpath=//input[@type='submit']");
//	}
//	@Test(priority=1)
//	public void picture() throws InterruptedException{
//		webtest.mouseToElement("*[@id=\\\"topnav\\\"]/font/li[8]/a/strong");
//		Thread.sleep(2000);
//		webtest.click("link=�������");
//		webtest.click("xpath=//strong[contains(text(),'����ϴ�ͼƬ']");
//		Thread.sleep(2000);
//		webtest.enterFrame(0);
//		webtest.type("xpath=//input[@type='file']","E:\\ceshi\\1.jpg");
//		webtest.click("xpath=//input[@value='�ϴ�']");	
//	}
//	@Test(priority=2)
//	public void daddText(){
//		webtest.open("http://www.roqisoft.com/zhsx/blog/");
//		webtest.click("link=�����μ�");
//		webtest.type("name=comment","�ǳ�����");
//		webtest.click("xpath=//input[@type='submit']");
//	}
//}

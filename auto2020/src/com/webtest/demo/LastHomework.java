package com.webtest.demo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;

public class LastHomework extends BaseTest{
	@BeforeMethod
	public void login() throws InterruptedException{
		webtest.open("http://www.roqisoft.com/zhsx/");
		webtest.click("link=登录");
		webtest.type("name=user", "admins");
		webtest.type("name=pw", "123456");
		webtest.click("xpath=//input[@value=' 登 录']");
		Thread.sleep(2000);
	}
	@Test(priority=0)
	public void record() throws InterruptedException{
		webtest.mouseToElement("xpath=*[@id=\"topnav\"]/font/li[8]/a/strong");
		Thread.sleep(2000);
		webtest.click("link=个人游记");
		webtest.click("link=点我写游记");
		Thread.sleep(2000);
		//写游记
		webtest.type("name=title", "绍兴游记");
		Thread.sleep(2000);
		webtest.tapClick();
		webtest.type("class=ke-edit-iframe", "绍兴风景美如画");
		webtest.click("xpath=//input[@type='submit']");
		Thread.sleep(2000);
		//修改游记
		webtest.click("link=绍兴游记");
		webtest.typeAndClear("name=title", "绍兴人民");
		Thread.sleep(2000);
		webtest.tapClick();
		webtest.typeAndClear("class=ke-edit-iframe","绍兴民风质朴");
		webtest.click("xpath=//input[@type='submit']");
	}
	@Test(priority=1)
	public void picture() throws InterruptedException{
		webtest.mouseToElement("*[@id=\\\"topnav\\\"]/font/li[8]/a/strong");
		Thread.sleep(2000);
		webtest.click("link=个人相册");
		webtest.click("xpath=//strong[contains(text(),'点击上传图片']");
		Thread.sleep(2000);
		webtest.enterFrame(0);
		webtest.type("xpath=//input[@type='file']","E:\\ceshi\\1.jpg");
		webtest.click("xpath=//input[@value='上传']");	
	}
	@Test(priority=2)
	public void daddText(){
		webtest.open("http://www.roqisoft.com/zhsx/blog/");
		webtest.click("link=绍兴游记");
		webtest.type("name=comment","非常满意");
		webtest.click("xpath=//input[@type='submit']");
	}
}

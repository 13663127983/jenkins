package com.webtest.demo;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
import com.webtest.dataprovider.TxtDataProvider;



public class Remark extends BaseTest {
	//登陆
		@Test
		public void login() throws InterruptedException {
			webtest.open("http://www.roqisoft.com/zhsx/");
			webtest.click("link=登录");
			webtest.type("id=user", "lc");
			webtest.type("id=pw", "123456");
			webtest.click("xpath=//input[@type='submit']");
			
			
		}
		
		
//		//【我的空间】-【个人游记】-添加游记（参数化），修改游记
//		@Test(dataProvider="travel",dataProviderClass = NSDataProvider.class)
//		public void personalTravel(String s1, String s2) throws IOException  {
//			webtest.open("http://www.roqisoft.com/zhsx/");
//			webtest.click("partLink=我的空间");
//			webtest.click("partLink=点我写游记");
//			webtest.type("id=title", s1);
//			webtest.enterFrame1("class=ke-edit-iframe");
//			webtest.click("tag=body");
//			webtest.type("tag=body", s2);
//			webtest.leaveFrame();
//			webtest.click("xpath=//input[@type='submit']");
//			
//			
//		}
		
		
		@Test
		public void photo() throws InterruptedException {
			webtest.open("http://www.roqisoft.com/zhsx/");
			webtest.mouseToElement("xpath=//strong[text()='我的空间']");
			Thread.sleep(2000);
			webtest.click("link=个人相册");
			webtest.click("class=show_advset");
			webtest.enterFrame(0);
			webtest.type("//input[@type='file']", "D:\\AD\\a.png");
			webtest.click("name=html-upload");
			
			
		 
		}

}

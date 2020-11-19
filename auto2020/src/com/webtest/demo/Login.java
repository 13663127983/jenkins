package com.webtest.demo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class Login extends BaseTest {

	//默认测试方法的执行顺序是按照方法名的字典序(ascii)升序排序执行的。我没有指定执行顺序，而是选择默认。以下四个方法依次执行。
	// 登陆
	@Test
	public void login()  {
		webtest.open("http://www.roqisoft.com/zhsx/");
		webtest.click("link=登录");
		webtest.type("id=user", "lc");
		webtest.type("id=pw", "123456");
		webtest.click("xpath=//input[@type='submit']");

	}

	// 【我的空间】-【个人游记】-添加游记（参数化），修改游记
	@Test(dataProvider = "travel", dataProviderClass = NSDataProvider.class)
	public void personalTravel(String s1, String s2) throws IOException {
		//添加游记
		webtest.open("http://www.roqisoft.com/zhsx/");
		webtest.click("partLink=我的空间");
		webtest.click("partLink=点我写游记");
		webtest.type("id=title", s1);
		webtest.enterFrame1("class=ke-edit-iframe");
		webtest.click("tag=body");
		webtest.type("tag=body", s2);
		webtest.leaveFrame();
		webtest.click("xpath=//input[@type='submit']");
		
		//修改游记
		webtest.click("xpath=//a[contains(@href,'write_log.php?action=edit')]");
		webtest.type("id=title", "修改");
		webtest.click("xpath=//input[@type='submit']");

	}

	// 【我的空间】-【个人相册】-上传相册
	@Test
	public void photo() throws InterruptedException {
		webtest.open("http://www.roqisoft.com/zhsx/");
		webtest.mouseToElement("xpath=//strong[text()='我的空间']");
		Thread.sleep(2000);
		webtest.click("link=个人相册");
		webtest.click("class=show_advset");
		webtest.enterFrame(0);
		webtest.type("xpath=//input[@type='file']", "D:\\AD\\d.png");
		webtest.click("name=html-upload");
		webtest.leaveFrame();
		Thread.sleep(3000);
		
		
	 
	}

	// 地址栏输入：http://www.roqisoft.com/zhsx/blog/,选择任意一条文章进行评论
	@Test
	public void remark() {
		webtest.open("http://www.roqisoft.com/zhsx/blog/");
		webtest.click("xpath=//a[contains(@href,'http://www.roqisoft.com/zhsx/blog/?')]");
		webtest.type("name=comment", "so high qwweer ");
	    webtest.click("name=submit");
	}

}

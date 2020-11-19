package com.webtest.demo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class XinHu22 extends BaseTest {

	@BeforeMethod
	public void login() throws InterruptedException {
		webtest.open("http://127.0.0.1:8866/xinhu_utf8_v1.5.9/?m=index");
		webtest.type("name=adminuser", "admin");
		webtest.type("xpath=//input[@type='password']", "123456");
		webtest.click("name=button");

	}

	

	
	@Test
	public void subscribe() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(2));
		webtest.click("xpath=//button[@click='daochu']");
		webtest.click("xpath=//li[contains(text(),'订阅此列表')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[contains(text(),'订阅参数')]"));
	}
	@Test
	public void sendMessage() throws InterruptedException {
		webtest.click("xpath=//div[contains(text(),'个人中心')]");
		webtest.click("xpath=//div[contains(text(),'内部通讯录')]");
		webtest.click("xpath=//button[contains(text(),'发消息')]");
		String window = webtest.getCurrentWindow();
		webtest.openWindow();
		webtest.type("id=contentss", "你好呀，打工人");
		webtest.click("xpath=//a[text()='发送(S)']");
		
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'你好呀')]"));
		webtest.runJs("window.close()");
		webtest.switchToWindow(window);

	}
	@Test
	public void editGroup() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(4));
		// 点击第一个
		webtest.click(webtest.getLocator("xpath=//div[@style='padding-left:10px']").get(0));
		webtest.click("xpath=//a[@click='clicktypeeidt']");
		webtest.type("name=name", "测试");
		webtest.click("xpath=//button[contains(text(),'确定')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}
		
		
		// 新增通知24
		@Test(priority=2)
		public void addNotice() {
			webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(2));
			webtest.click("xpath=//button[contains(text(),'新增')]");
			webtest.enterFrame1("name=openinputiframe");
			webtest.clear("name=title");
			webtest.type("name=title", "魑魅魍魉");
			webtest.selectByValue("name=typename", "通知公告");
			webtest.click("id=AltS");
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'新增保存成功')]"));

		}
		
		// 提醒信息标为已读25
		@Test(priority = 3)
		public void readedNotice() {
			webtest.click("xpath=//a[contains(text(),'提醒信息')]");
			webtest.click("xpath=//input[@type='checkbox']");
			webtest.click("xpath=//button[@click='yidu,1']");
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

		}
		
		
		// 编辑第一条通知公告29
		@Test(priority = 2)
		public void editNotice() {
			webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(2));
			webtest.click("xpath=//a[contains(text(),'操作')]");
			webtest.click("xpath=//li[contains(text(),'编辑')]");
			webtest.enterFrame1("name=openinputiframe");
			webtest.clear("name=title");
			webtest.type("name=title", "编辑过的");
			webtest.click("id=AltS");
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'编辑保存成功')]"));

		}
		
		




	



	

}

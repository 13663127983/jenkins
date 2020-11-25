package com.webtest.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

/*
 * @author 白维扬
 * 	testcase number:50
 * status:success
 */

public class LiuCheng extends BaseTest {

	@BeforeMethod
	public void login() throws InterruptedException {
		webtest.open("http://127.0.0.1:81/?m=index");
		webtest.type("name=adminuser", "admin");
		webtest.type("xpath=//input[@type='password']", "123456");
		webtest.click("name=button");
		webtest.click("xpath=//span[text()='流程']");

	}

	@Test(dataProvider = "xinhu2", dataProviderClass = NSDataProvider.class)
	public void test_give_public_notice_1(String title, String content, String choose, String explain, String name,
			String others) throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='通知公告']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=title", title);
		webtest.selectByIndex("name=typename", 1);
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test(dataProvider = "xinhu2", dataProviderClass = NSDataProvider.class)
	public void test_give_public_notice_2(String title, String content, String choose, String explain, String name,
			String others) throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='通知公告']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=title", title);
		webtest.selectByIndex("name=typename", 1);
		webtest.enterFrame1("xpath=//iframe[@class='ke-edit-iframe']");
		webtest.click("xpath=//body[@class='ke-content']");
		webtest.type("xpath=//body[@class='ke-content']", content);
		webtest.leaveFrame();
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("xpath=//span[@id='div_url']//input", others);
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test(dataProvider = "xinhu2", dataProviderClass = NSDataProvider.class)
	public void test_give_public_notice_3(String title, String content, String choose, String explain, String name,
			String others) throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='通知公告']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=title", title);
		webtest.selectByIndex("name=typename", 1);
		webtest.type("id=filed_fengmian_inp", "C:\\ad\\g.jpg");

		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test(dataProvider = "xinhu2", dataProviderClass = NSDataProvider.class)
	public void test_meeting1(String title, String content, String choose, String explain, String name,
			String others) throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='会议']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=hyname", 1);
		webtest.type("name=title", title);
		// 日期控件
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('startdt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('enddt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='startdt']", DateTime);
		webtest.type("xpath=//input[@name='enddt']", DateTime.substring(0, 11) + "23:59:59");

		webtest.click("id=btnchange_joinname");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");

		webtest.click("id=AltS");

		if (webtest.isDisplayed("xpath=//span[text()='该会议室的时间段已经申请过了']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
		Thread.sleep(500);
	}

	@Test(dataProvider = "xinhu2", dataProviderClass = NSDataProvider.class)
	public void test_meeting2(String title, String content, String choose, String explain, String name,
			String others) throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='会议']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=hyname", 1);
		webtest.click("id=btnchange_jyname");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", choose);
		Thread.sleep(1000);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.type("name=title", title);
		// 日期控件
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('startdt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('enddt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='startdt']", DateTime);
		webtest.type("xpath=//input[@name='enddt']", DateTime.substring(0, 11) + "23:59:59");

		webtest.click("id=btnchange_joinname");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");

		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[text()='该会议室的时间段已经申请过了']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
		Thread.sleep(500);
	}

	@Test(dataProvider = "xinhu2", dataProviderClass = NSDataProvider.class)
	public void test_receive_thing1(String title, String content, String choose, String explain, String name,
			String others) throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='物品领用']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.click("xpath=//form[@name='myform']//a[@class='webbtn']");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		webtest.typeAndClear("xpath=//input[@name='count0_0']", "1");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test(dataProvider = "xinhu2", dataProviderClass = NSDataProvider.class)
	public void test_receive_thing2(String title, String content, String choose, String explain, String name,
			String others) throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='物品领用']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.click("xpath=//form[@name='myform']//a[@class='webbtn']");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		webtest.typeAndClear("xpath=//input[@name='count0_0']", "1");
		webtest.type("xpath=//textarea[@name='explain']", explain);
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test(dataProvider = "xinhu2", dataProviderClass = NSDataProvider.class)
	public void test_buy_thing1(String title, String content, String choose, String explain, String name,
			String others) throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='物品采购']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.click("xpath=//form[@name='myform']//a[@class='webbtn']");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		webtest.typeAndClear("xpath=//input[@name='count0_0']", "1");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));

	}

	@Test(dataProvider = "xinhu2", dataProviderClass = NSDataProvider.class)
	public void test_buy_thing2(String title, String content, String choose, String explain, String name,
			String others) throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='物品采购']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.click("xpath=//form[@name='myform']//a[@class='webbtn']");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		webtest.typeAndClear("xpath=//input[@name='count0_0']", "1");
		webtest.type("xpath=//input[@name='custname']", name);
		webtest.type("xpath=//input[@name='discount']", "100");
		webtest.type("xpath=//textarea[@name='explain']", explain);
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
	}

	@Test
	public void test_lend_book1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='图书借阅']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.click("xpath=//form[@name='myform']//a[@class='webbtn']");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		// 日期控件
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('yjdt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='yjdt']", DateTime);

		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[text()='该书数量不够了']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
	}

	@Test
	public void test_lend_book2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='图书借阅']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.click("xpath=//form[@name='myform']//a[@class='webbtn']");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		// 日期控件
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('yjdt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='yjdt']", DateTime);

		webtest.click("id=AltS");

		if (webtest.isDisplayed("xpath=//span[text()='该书数量不够了']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
	}

	@Test
	public void test_seal1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='印章']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=name", "name");
		webtest.selectByIndex("name=type", 1);
		webtest.click("xpath=//a[text()='选择']");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(500);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");

		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_seal2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='印章']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=name", "name");
		webtest.selectByIndex("name=type", 1);
		webtest.click("xpath=//a[text()='选择']");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(500);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");

		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(500);
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_seal3() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='印章']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=name", "name");
		webtest.selectByIndex("name=type", 1);
		webtest.click("xpath=//a[text()='选择']");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(500);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");

		webtest.type("id=filed_sealimg_inp", "C:\\ad\\g.jpg");

		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_apply_seal1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='印章申请']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=sealid", 1);
		webtest.selectByIndex("name=isout", 1);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_apply_seal2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='印章申请']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=sealid", 1);
		webtest.selectByIndex("name=isout", 1);
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_repair1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='维修报修']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=assetm", "what needs repair");
		webtest.type("name=reason", "tell me why");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_repair2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='维修报修']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=assetm", "what needs repair");
		webtest.type("name=reason", "tell me why");
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_turn_adjective1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='转正申请']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");

		// 日期控件
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('positivedt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='positivedt']", DateTime);

		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[text()='您已申请过了']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
		Thread.sleep(500);
	}

	@Test
	public void test_apply_resign1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='离职申请']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=redundtype", 1);
		webtest.type("xpath=//textarea[@name='redundreson']", "redundreson what 23333");

		// 日期控件
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('quitdt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='quitdt']", DateTime);

		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[text()='您已申请过了']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
	}

	@Test
	public void test_apply_resign2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='离职申请']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=redundtype", 1);
		webtest.type("xpath=//textarea[@name='redundreson']", "redundreson what 23333");
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");

		// 日期控件
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('quitdt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='quitdt']", DateTime);

		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[text()='您已申请过了']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
	}

	@Test
	public void test_increase_salary1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='调薪申请']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.typeAndClear("name=floats", "10");
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		// 日期控件
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('effectivedt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='effectivedt']", DateTime);

		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[text()='已有一单在申请中']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
	}

	@Test
	public void test_change_job1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='人事调动']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=trantype", 1);
		// 选择董事长
		webtest.click("id=btnchange_tranname");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(1000);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		// 选择调整后的部门
		webtest.click("id=btnchange_newdeptname");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.type("name=newranking", "anyjob");

		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[text()='该人员已申请过了']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}

		Thread.sleep(500);
	}

	@Test
	public void test_change_job2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='人事调动']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=trantype", 1);
		// 选择董事长
		webtest.click("id=btnchange_tranname");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(1000);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		// 选择调整后的部门
		webtest.click("id=btnchange_newdeptname");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.type("name=newranking", "anyjob");
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[text()='该人员已申请过了']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}

		Thread.sleep(500);
	}

	@Test
	public void test_reward_punish1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='奖惩处罚']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		// 选择董事长
		webtest.click("id=btnchange_object");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(1000);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(200);

		webtest.selectByIndex("name=type", 1);
		webtest.selectByIndex("name=result", 1);
		webtest.type("name=hapaddress", "where are u");
		webtest.typeAndClear("name=money", "1");

		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		// 日期控件
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('happendt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='happendt']", DateTime);

		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_report_daily1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='工作日报']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=content", "what's content");

		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[contains(text(),'已申请了')]")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
	}

	@Test
	public void test_report_daily2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='工作日报']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=content", "what's content");

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('enddt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='enddt']", DateTime);

		webtest.type("name=plan", "i don't have plan");

		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[contains(text(),'已申请了')]")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
	}

	@Test
	public void test_project1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='项目']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=type", 1);
		webtest.type("name=title", "this is a title");

		webtest.click("id=btnchange_fuze");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(1000);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.click("id=btnchange_runuser");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
	}

	@Test
	public void test_project2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='项目']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=type", 1);
		webtest.type("name=title", "this is a title");
		webtest.type("name=num", "num");

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('enddt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='enddt']", DateTime.substring(0, 11) + "23:59:59");

		webtest.click("id=btnchange_fuze");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(1000);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.click("id=btnchange_runuser");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);
		webtest.runJs("window.scroll(0,500)");
		webtest.selectByIndex("name=progress", 10);
		webtest.selectByIndex("name=status", 1);

		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
	}

	@Test
	public void test_task1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='任务']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=type", 1);
		webtest.selectByIndex("name=grade", 1);
		webtest.type("name=title", "this is a title");

		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_task2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='任务']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=type", 1);
		webtest.selectByIndex("name=grade", 1);
		webtest.type("name=title", "this is a title");
		webtest.selectByIndex("name=projectid", 1);

		webtest.click("id=btnchange_dist");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(1000);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		webtest.typeAndClear("xpath=//input[@name='score']", "1");

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('enddt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='enddt']", DateTime);

		webtest.click("id=btnchange_ddname");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(1000);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_schedule1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='日程']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=title", "this is a title");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_schedule2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='日程']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=title", "this is a title");
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('enddt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='enddt']", DateTime);

		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		webtest.selectByIndex("name=rate", 1);

		webtest.click("id=btnchange_recename");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
	}

	@Test
	public void test_email1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='邮件']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=title", "this is a title");
		webtest.selectByIndex("name=type", 1);

		webtest.click("id=btnchange_recename");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.enterFrame1("xpath=//iframe[@class='ke-edit-iframe']");
		webtest.click("xpath=//body[@class='ke-content']");
		webtest.type("xpath=//body[@class='ke-content']", "body");
		webtest.leaveFrame();
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");

		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_email2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='邮件']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=title", "this is a title");
		webtest.selectByIndex("name=type", 1);

		webtest.click("id=btnchange_recename");
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.click("id=btnchange_ccname");
		webtest.type("xpath=//input[starts-with(@id,'changekey')]", "董事长");
		Thread.sleep(1000);
		webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
		Thread.sleep(100);
		webtest.click("xpath=//input[starts-with(@id,'changeok')]");
		Thread.sleep(100);

		webtest.enterFrame1("xpath=//iframe[@class='ke-edit-iframe']");
		webtest.click("xpath=//body[@class='ke-content']");
		webtest.type("xpath=//body[@class='ke-content']", "body");
		webtest.leaveFrame();
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");

		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_addressbook1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='个人通讯录']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=name", "name");
		webtest.selectByIndex("name=sex", 1);
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_addressbook2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='个人通讯录']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=name", "name");
		webtest.selectByIndex("name=gname", 1);
		webtest.selectByIndex("name=sex", 1);
		webtest.type("name=mobile", "123456789");
		webtest.type("name=tel", "987654321");
		webtest.type("name=email", "987654321@qq.com");
		webtest.type("name=unitname", "hbsd");
		webtest.type("name=address", "hbsd");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_knowledge1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='知识']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=title", "this is a title");
		webtest.selectByIndex("name=typeid", 1);
		webtest.typeAndClear("name=sort", "1");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_knowledge2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='知识']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=title", "this is a title");
		webtest.selectByIndex("name=typeid", 1);
		webtest.typeAndClear("name=sort", "1");

		webtest.enterFrame1("xpath=//iframe[@class='ke-edit-iframe']");
		webtest.click("xpath=//body[@class='ke-content']");
		webtest.type("xpath=//body[@class='ke-content']", "body");
		webtest.leaveFrame();
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");

		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_question_bank1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='题库']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=typeid", 1);
		webtest.selectByIndex("name=type", 1);
		webtest.type("name=title", "this is a title");
		webtest.type("name=ana", "1");
		webtest.type("name=anb", "2");
		webtest.type("name=answer", "2");

		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_question_bank2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='题库']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=typeid", 1);
		webtest.selectByIndex("name=type", 1);
		webtest.type("name=title", "this is a title");
		webtest.type("name=ana", "1");
		webtest.type("name=anb", "2");
		webtest.type("name=answer", "2");

		webtest.enterFrame1("xpath=//iframe[@class='ke-edit-iframe']");
		webtest.click("xpath=//body[@class='ke-content']");
		webtest.type("xpath=//body[@class='ke-content']", "body");
		webtest.leaveFrame();
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");

		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_request_leave1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='请假条']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=qjkind", 1);

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('stime')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('etime')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='stime']", DateTime);
		webtest.type("xpath=//input[@name='etime']", DateTime.substring(0, 11) + "23:59:59");

		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		webtest.typeAndClear("name=totals", "1");
		Thread.sleep(500);
		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[text()='该时间段已申请过了']")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
	}

	@Test
	public void test_work_overtime1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='加班单']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('stime')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('etime')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='stime']", DateTime);
		webtest.type("xpath=//input[@name='etime']", DateTime.substring(0, 11) + "23:59:59");
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_go_away_business1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='外出出差']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=atype", 1);
		webtest.type("name=address", "where");

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('outtime')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('intime')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='outtime']", DateTime);
		webtest.type("xpath=//input[@name='intime']", DateTime.substring(0, 11) + "23:59:59");

		webtest.type("name=reason", "no why");

		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_go_away_business2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='外出出差']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=atype", 1);
		webtest.type("name=address", "where");

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('outtime')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('intime')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='outtime']", DateTime);
		webtest.type("xpath=//input[@name='intime']", DateTime.substring(0, 11) + "23:59:59");

		webtest.type("name=reason", "no why");
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_punch_card_error1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='打卡异常']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.selectByIndex("name=errtype", 1);
		((JavascriptExecutor) getDriver())
				.executeScript("var setDate=document.getElementsByName('dt')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('ytime')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.type("xpath=//input[@name='dt']", DateTime.substring(0, 11));
		webtest.type("xpath=//input[@name='ytime']", DateTime.substring(12));
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_attendance_machine1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='考勤机设备']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");
		webtest.type("name=num", "number");
		webtest.type("name=name", "what's name");
		webtest.type("name=company", "hbsd company");
		Thread.sleep(500);
		webtest.click("id=AltS");
		if (webtest.isDisplayed("xpath=//span[contains(text(),'已存在了')]")) {
			Assert.assertTrue(true);
		} else {
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		}
	}

	@Test
	public void test_solve_cost1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='费用报销']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('sdt0_0')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.typeAndClear("xpath=//input[@name='sdt0_0']", DateTime);
		webtest.selectByIndex("name=name0_0", 1);

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('money0_0')[0];setDate.removeAttribute('type');"); // 将driver强制转换为JavascriptExecutor类型
		webtest.type("xpath=//input[@name='money0_0']", "110");

		webtest.click("xpath=//textarea[@name='explain']");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_solve_cost2() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='费用报销']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('sdt0_0')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.typeAndClear("xpath=//input[@name='sdt0_0']", DateTime);
		webtest.selectByIndex("name=name0_0", 1);

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('money0_0')[0];setDate.removeAttribute('type');"); // 将driver强制转换为JavascriptExecutor类型
		webtest.type("xpath=//input[@name='money0_0']", "110");

		webtest.click("xpath=//textarea[@name='explain']");
		webtest.type("xpath=//textarea[@name='explain']", "explain what 23333");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	@Test
	public void test_go_away_business_reimbursement1() throws InterruptedException {
		webtest.click("id=menu_list_num42");
		webtest.click("xpath=//a[text()='出差报销']");
		webtest.enterFrame1("xpath=//iframe[@name='openinputiframe']");

		webtest.type("name=purpose", "purpose");
		webtest.type("name=purresult", "purresult");
		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('sdt0_0')[0];setDate.removeAttribute('readonly');"); // 将driver强制转换为JavascriptExecutor类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTime = sdf.format(new Date());
		webtest.typeAndClear("xpath=//input[@name='sdt0_0']", DateTime);
		webtest.selectByIndex("name=name0_0", 1);

		((JavascriptExecutor) getDriver()).executeScript(
				"var setDate=document.getElementsByName('money0_0')[0];setDate.removeAttribute('type');"); // 将driver强制转换为JavascriptExecutor类型
		webtest.type("xpath=//input[@name='money0_0']", "110");
		webtest.runJs("window.scroll(0,500)");

		webtest.click("xpath=//textarea[@name='explain']");
		Thread.sleep(500);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}
	
	
	
}

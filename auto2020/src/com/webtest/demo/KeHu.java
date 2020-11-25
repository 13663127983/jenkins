package com.webtest.demo;

import static org.testng.Assert.assertTrue;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
/*
 * @author 黄家承
 * 	testcase number:50
 * status:success
 */

public class KeHu extends BaseTest {

	// 在所有测试方法前执行，登录信呼，并切换到客户模板
	@BeforeMethod
	public void login() throws InterruptedException {
		webtest.open("http://127.0.0.1:81/?m=index");
		webtest.type("name=adminuser", "admin");
		webtest.type("xpath=//input[@type='password']", "123456");
		webtest.click("name=button");

	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，删除用户名称，点击保存，显示用户名不能为空
	@Test(dependsOnMethods = { "readedMail" })
	public void test01() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.clear("name=name");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 提醒消息设为已读，防止影响其他测试
	@Test
	public void readedMail() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'提醒信息')]");
		webtest.click("xpath=//input[@type='checkbox']");
		Thread.sleep(1000);
		webtest.click("xpath=//button[text()='标为已读']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，修改用户名称，点击保存，保存成功
	@Test
	public void test02() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.type("name=name", "A");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，删除来源，点击保存，显示来源不能为空
	@Test
	public void test03() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='-请选择-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，修改来源，点击保存，保存成功
	@Test
	public void test04() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='电话开拓']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，删除用户类型，点击保存，显示用户类型不能为空
	@Test
	public void test05() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='-请选择-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，修改客户类型，点击保存，保存成功
	@Test
	public void test06() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='软件']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，删除地址，点击保存，显示地址不能为空
	// 这个用例失败了，这是个bug
	@Test
	public void test07() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.clear("name=address");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertFalse(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，修改地址，点击保存，保存成功
	@Test
	public void test08() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.type("name=address", "A");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，删除状态，点击保存，显示状态不能为空
	@Test
	public void test09() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.runJs("window.scroll(0,500)");
		webtest.click("name=status");
		webtest.click("xpath=//option[text()='-请选择-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，修改状态，点击保存，保存成功
	@Test
	public void test10() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.runJs("window.scroll(0,500)");
		webtest.click("name=status");
		webtest.click("xpath=//option[text()='停用']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，删除是否标☆，点击保存，显示是否标☆不能为空
	@Test
	public void test11() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.runJs("window.scroll(0,500)");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='-请选择-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击编辑，修改是否标☆，点击保存，保存成功
	@Test
	public void test12() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.runJs("window.scroll(0,500)");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='是']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击删除，点击取消
	@Test
	public void test13() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='删除...']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//a[text()='操作V']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 新增
	@Test
	public void test14() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' 新增']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='网上开拓']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='互联网']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='新增保存成功']"));
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击关闭
	@Test
	public void test15() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		Thread.sleep(1000);
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='关闭']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情，点击操作PV，点击刷新
	@Test
	public void test16() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		Thread.sleep(1000);
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='刷新']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，删除用户名称，点击保存，显示用户名不能为空
	@Test
	public void test17() throws InterruptedException {

		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.clear("name=name");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，修改用户名称，点击保存，保存成功
	@Test
	public void test18() throws InterruptedException {

		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		Thread.sleep(3500);
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.type("name=name", "A");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(3500);
		webtest.closeWindow();

		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，删除来源，点击保存，显示来源不能为空
	@Test
	public void test19() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='-请选择-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，修改来源，点击保存，保存成功
	@Test
	public void test20() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='电话开拓']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，删除用户类型，点击保存，显示用户类型不能为空
	@Test
	public void test21() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='-请选择-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，修改客户类型，点击保存，保存成功
	@Test
	public void test22() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='软件']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，删除地址，点击保存，显示地址不能为空
	// 这个用例失败了，这是个bug
	@Test
	public void test23() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.clear("name=address");
		webtest.click("xpath=//input[@type='button']");
		Thread.sleep(3500);
		webtest.closeWindow();
		Assert.assertFalse(webtest.isDisplayed("xpath=//span[text()='地址不能为空']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，修改地址，点击保存，保存成功
	@Test
	public void test24() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.type("name=address", "A");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，删除状态，点击保存，显示状态不能为空
	@Test
	public void test25() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.exectueScript("name=status");
		webtest.click("name=status");
		webtest.click("xpath=//option[text()='-请选择-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，修改状态，点击保存，保存成功
	@Test
	public void test26() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.exectueScript("name=status");
		webtest.click("name=status");
		webtest.click("xpath=//option[text()='停用']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，删除是否标☆，点击保存，显示是否标☆不能为空
	@Test
	public void test27() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.exectueScript("name=isstat");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='-请选择-']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[@id='msgview']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击编辑，修改是否标☆，点击保存，保存成功
	@Test
	public void test28() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.exectueScript("name=isstat");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='是']");
		webtest.click("xpath=//input[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击删除，点击取消
	@Test
	public void test29() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='删除...']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		webtest.closeWindow();
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		Thread.sleep(3500);
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击删除，点击确定，删除成功
	@Test
	public void test30() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='删除...']");
		webtest.click("xpath=//button[@id='confirm_btn1']");
		Thread.sleep(3500);
		webtest.closeWindow();
		Thread.sleep(500);
		webtest.getWindow(0);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击关闭
	@Test
	public void test31() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='关闭']");
		webtest.closeWindow();
		webtest.getWindow(0);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击详情(新窗口)，点击操作PV，点击刷新
	@Test
	public void test32() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情(新窗口)']");
		webtest.switchToNewWindow();
		webtest.click("xpath=//a[text()='操作V']");
		webtest.click("xpath=//li[text()='刷新']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//a[text()='操作V']"));
		Thread.sleep(3500);
		webtest.closeWindow();
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击+添加跟进记录，点击确定，显示没有输入[+添加跟进记录]说明
	@Test
	public void test33() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='＋添加跟进记录']");
		webtest.click("xpath=//button[@type='button']");
		Thread.sleep(3500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//button[@type='button']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击+添加跟进记录，点击取消
	@Test
	public void test34() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='＋添加跟进记录']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击+添加跟进记录，在[+添加跟进记录]说明中输入内容，点击确定，显示处理成功
	@Test
	public void test35() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='＋添加跟进记录']");
		webtest.type("xpath=//textarea[@id='confirm_input']", "A");
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='处理成功']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击停用，点击确定，显示没有输入[停用]说明
	@Test
	public void test36() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='停用']");
		webtest.click("xpath=//button[@type='button']");
		Thread.sleep(3500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//button[@type='button']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击停用，点击取消
	@Test
	public void test37() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='停用']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击停用，在[停用]说明中输入内容，点击确定，显示处理成功
	@Test
	public void test38() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='停用']");
		webtest.type("xpath=//textarea[@id='confirm_input']", "A");
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='处理成功']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击标☆，点击确定，显示没有输入[标☆]说明
	// 这是个bug，必填项不用填就可以
	@Test
	public void test39() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' 新增']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='网上开拓']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='互联网']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='标☆']");
		webtest.click("xpath=//button[@type='button']");
		Thread.sleep(3500);
		Assert.assertFalse(webtest.isDisplayed("xpath=//button[@type='button']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击标☆，点击取消
	@Test
	public void test40() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' 新增']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='网上开拓']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='互联网']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='标☆']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击标☆，在[标☆]说明中输入内容，点击确定，显示处理成功
	@Test
	public void test41() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' 新增']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='网上开拓']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='互联网']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='标☆']");
		webtest.type("xpath=//textarea[@id='confirm_input']", "A");
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='处理成功']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击取消标☆，点击确定，显示没有输入[取消标☆]说明
	// 这是个bug，必填项不用填就可以
	@Test
	public void test42() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' 新增']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='网上开拓']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='互联网']");
		webtest.runJs("window.scroll(0,500)");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='是']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.runJs("window.scroll(0,500)");
		webtest.click("xpath=//li[text()='取消标☆']");
		webtest.click("xpath=//button[@type='button']");
		Thread.sleep(3500);
		Assert.assertFalse(webtest.isDisplayed("xpath=//button[@type='button']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击取消标☆，点击取消
	@Test
	public void test43() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' 新增']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='网上开拓']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='互联网']");
		webtest.runJs("window.scroll(0,500)");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='是']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.runJs("window.scroll(0,500)");
		webtest.click("xpath=//li[text()='取消标☆']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击取消标☆，在[取消标☆]说明中输入内容，点击确定，显示处理成功
	@Test
	public void test44() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()=' 新增']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", "A");
		webtest.click("name=laiyuan");
		webtest.click("xpath=//option[text()='网上开拓']");
		webtest.click("name=type");
		webtest.click("xpath=//option[text()='互联网']");
		webtest.runJs("window.scroll(0,500)");
		webtest.click("name=isstat");
		webtest.click("xpath=//option[text()='是']");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.runJs("window.scroll(0,500)");
		webtest.click("xpath=//li[text()='取消标☆']");
		webtest.type("xpath=//textarea[@id='confirm_input']", "A");
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='处理成功']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我停用客户，点击操作，点击启用，点击确定，显示没有输入[启用]说明
	// 这是个bug，必填项不用填就可以
	@Test
	public void test45() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()='我停用客户']");
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='启用']");
		webtest.click("xpath=//button[@type='button']");
		Thread.sleep(3500);
		Assert.assertFalse(webtest.isDisplayed("xpath=//button[@type='button']"));
		Thread.sleep(500);
	}

	// 选择一个我停用客户，点击操作，点击启用，点击取消
	@Test
	public void test46() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()='我停用客户']");
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='启用']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我停用客户，点击操作，点击启用，在[启用]说明中输入内容，点击确定，显示处理成功
	@Test
	public void test47() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//button[text()='我停用客户']");
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='启用']");
		webtest.type("xpath=//textarea[@id='confirm_input']", "A");
		webtest.click("xpath=//button[@type='button']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='处理成功']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击编辑
	@Test
	public void test48() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='编辑']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("xpath=//input[@type='button']");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));

		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击删除，点击取消
	@Test
	public void test49() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='删除']");
		webtest.click("xpath=//button[@id='confirm_btn']");
		Thread.sleep(500);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='管理员']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}

	// 选择一个我的客户，点击操作，点击删除，点击确定，删除成功
	@Test
	public void test50() throws InterruptedException {
		webtest.click("xpath=//span[text()='客户']");
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(0));
		webtest.click("xpath=//td[text()='管理员']");
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='删除']");
		webtest.type("xpath=//textarea[@id='confirm_input']", "A");
		webtest.click("xpath=//button[@id='confirm_btn1']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='处理成功']"));
		webtest.leaveFrame();
		Thread.sleep(500);
	}
	//// ****************************************************************************************************
	
}

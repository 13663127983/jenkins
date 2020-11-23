package com.webtest.demo;




import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;
/*
 * @author 刘畅
 * 	testcase number:50
 * status:success
 */

public class XinHu extends BaseTest {

	@BeforeMethod
	public void login() throws InterruptedException {
		webtest.open("http://127.0.0.1:81/?m=index");
		webtest.type("name=adminuser", "admin");
		webtest.type("xpath=//input[@type='password']", "123456");
		webtest.click("name=button");
	}

	// 个人资料，选择一条记录，点击编辑，将学历改为本科，点击保存，保存成功1
	@Test
	public void deleteWork() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(1));
		webtest.click("xpath=//td[text()='男']");
		webtest.click("xpath=//button[@click='edit']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.clear("xpath=//input[@name='xueli']");
		webtest.type("xpath=//input[@name='xueli']", "本科");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
	}

	// 个人资料，选择一条记录，点击编辑，上传一张图片，点击保存，保存成功2
	@Test
	public void addPic() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(1));
		webtest.click("xpath=//td[text()='男']");
		webtest.click("xpath=//button[@click='edit']");
		webtest.enterFrame1("name=openinputiframe");
		// webtest.runJs("document.getElementsByName('zhaopian')[0].removeAttribute('type')");
		webtest.type("id=filed_zhaopian_inp", "C:\\AD\\g.jpg");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='编辑保存成功']"));
	}

	// 个人资料，选择一条记录，点击详情，点击操作V，点击关闭3
	@Test
	public void closePage() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(1));
		webtest.click("xpath=//td[text()='男']");
		webtest.click("xpath=//button[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("id=showmenu");
		webtest.click("xpath=//li[contains(text(),'关闭')]");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'个人中心')]"));

	}

	// 个人资料，选择一条记录，点击详情，点击操作V，点击刷新4
	@Test
	public void refreshPage1() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(1));
		webtest.click("xpath=//td[text()='男']");
		webtest.click("xpath=//button[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		webtest.click("id=showmenu");
		webtest.click("xpath=//li[contains(text(),'刷新')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'人员档案')]"));
	}

	// 我的薪资，点击导出5
	@Test
	public void refreshPage() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(2));
		webtest.click("xpath=//button[text()='导出']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

	// 内部通讯录，给自己发消息，发送"你好呀，打工人"6
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

	// 个人通讯录，新增7(数据驱动excel)
	@Test(dataProvider = "xinhu1", dataProviderClass = NSDataProvider.class)
	public void addPerson(String s1, String s2, String s3) throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(4));
		webtest.click("xpath=//button[contains(text(),'新增')]");
		webtest.enterFrame1("name=openinputiframe");
		webtest.type("name=name", s1);
		webtest.selectByValue("name=sex", s2);
		webtest.type("name=mobile", s3);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'新增保存成功')]"));

	}

	// 删除个人通讯录的第一个联系人8
	@Test
	public void deleteRelation() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(4));
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'删除')]");
		webtest.click("id=confirm_btn1");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

	// 个人中心，我的薪资，点开详情9
	@Test
	public void lookMoneyDetails() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(2));
		webtest.click("xpath=//td[text()='1']");
		webtest.click("xpath=//button[text()='详情']");
		webtest.enterFrame1("name=openinputiframe");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'薪资')]"));

	}

	// 查看个人通讯录第一个联系人的详情10
	@Test
	public void lookDetails() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(4));
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'详情')]");
		webtest.enterFrame1("name=openinputiframe");
		// 判断查阅记录存不存在
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[contains(text(),'查阅记录')]"));

	}

//	// 查看个人通讯录第一个联系人的详情（新窗口打开）11
	@Test
	public void lookDetailsNewWindow() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(4));
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'详情(新窗口)')]");
		String window = webtest.getCurrentWindow();
		// 打开新窗口
		webtest.openWindow();
		// 判断查阅记录存不存在
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[contains(text(),'查阅记录')]"));
		webtest.runJs("window.close()");
		webtest.switchToWindow(window);

		Thread.sleep(2000);

	}

	

//	//对个人通讯录第一个人进行评论，内容为"你好"12
	@Test
	public void commentInfo() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(4));
		Thread.sleep(1000);
		webtest.click("xpath=//a[contains(text(),'操作')]");
		Thread.sleep(1000);
		webtest.click("xpath=//li[contains(text(),'评论')]");
		webtest.type("id=confirm_input", "你好");
		webtest.click("id=confirm_btn1");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

	// 提醒消息设为已读，防止影响其他测试13
	@Test
	public void readedMail1() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'提醒信息')]");
		webtest.click("xpath=//input[@type='checkbox']");
		Thread.sleep(1000);
		webtest.click("xpath=//button[text()='标为已读']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

	// 个人通讯录里的搜索框功能，搜索刘畅14
	@Test
	public void seachInfo() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(4));
		Thread.sleep(1000);
		webtest.type("xpath=//input[@placeholder='标题']", "刘畅");
		;
		webtest.click("xpath=//button[text()='搜索']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[text()='刘畅']"));

	}

	// 个人通讯录，新增组15
	@Test(dependsOnMethods = { "readedMail1" })
	public void addGroup() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(4));
		Thread.sleep(1000);
		webtest.click("class=icon-plus");
		webtest.type("name=name", "python");
		webtest.runJs("document.getElementsByClassName('btn btn-primary')[0].removeAttribute('disabled')");
		webtest.click("xpath=//button[contains(text(),'确定')]");
		Thread.sleep(1000);
		// 判断有无这个内容
		Assert.assertTrue(webtest.isTextPresent("python"));

	}
	
	

	// 个人通讯录，编辑组，把第一个组名加上测试16
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

	// 个人通讯录，删除第一个组17
	@Test
	public void deleteGroup() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(4));
		Thread.sleep(1000);
		// 点击第一个
		webtest.click(webtest.getLocator("xpath=//div[@style='padding-left:10px']").get(0));
		webtest.click("xpath=//a[@click='typedel']");
		Thread.sleep(1000);
		webtest.click("id=confirm_btn1");
		Thread.sleep(1000);

		// Assert.assertFalse(webtest.isTextPresent("测试"));

	}

	// 个人通讯录，组刷新功能18
	@Test
	public void refreshGroup() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(4));
		Thread.sleep(1000);
		webtest.click("xpath=//a[@click='reload']");
		Thread.sleep(1000);

	}

	// 个人中心/我上传过的文件，删除我上传过的第一个文件19
	@Test
	public void deleteFile() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(5));
		Thread.sleep(1000);
		webtest.click("xpath=//td[contains(text(),'jpg')]");
		webtest.click("xpath=//button[contains(text(),'删除')]");
		webtest.click("id=confirm_btn1");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[text()='删除成功']"));

	}

//	//个人中心/我上传过的文件，搜索出jpg图片，断言有png即失败20
	@Test
	public void searchFile() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(0));
		Thread.sleep(1000);
		webtest.click(webtest.getLocator("xpath=//div[@class='menutwo']").get(5));
		Thread.sleep(1000);
		webtest.type("xpath=//input[@placeholder='文件名/创建人/关联表']", "jpg");
		webtest.click("xpath=//button[@click='search']");
		Assert.assertFalse(webtest.isDisplayed("xpath=//td[contains(text(),'png')]"));

	}

	// 邮件，发邮件，然后在我的邮件里断言21
	@Test
	public void sendMail() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		Thread.sleep(1000);
		webtest.click("xpath=//button[contains(text(),'写信')]");
		webtest.enterFrame1("name=openinputiframe");
		webtest.clear("name=title");
		webtest.type("name=title", "魑魅魍魉");
		webtest.click("id=btnchange_recename");
		// 选中所有复选框
//			List<WebElement> list = webtest.getLocator("xpath=//input[@type='checkbox']");
//			for(WebElement we : list) {
//				webtest.click(we);
//			}
		// 选中第一个复选框
		webtest.click(webtest.getLocator("xpath=//input[@type='checkbox']").get(1));
		webtest.click("xpath=//input[@value='确定']");
		webtest.enterFrame1("class=ke-edit-iframe");
		webtest.click("class=ke-content");
		webtest.type("class=ke-content", "你好呀");
		webtest.switchToParent();
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'新增保存成功')]"));

	}

	// 删除我的第一条邮件22
	@Test(dependsOnMethods = { "readedMail" })
	public void deleteMail() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		Thread.sleep(1000);
		// 删除所有邮件
		// webtest.click("xpath=//input[@type='checkbox']");

		// 删除第一条
		webtest.click(webtest.getLocator("xpath=//input[@type='checkbox']").get(1));
		Thread.sleep(1000);
		webtest.click("xpath=//button[@click='delyj']");
		webtest.click("id=confirm_btn1");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'删除成功')]"));

	}

	// 所有邮件标识已读23
	@Test(dependsOnMethods = { "sendMail" })
	public void readedMail() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(1));
		Thread.sleep(1000);
		webtest.click("xpath=//input[@type='checkbox']");
		Thread.sleep(1000);
		webtest.click("xpath=//button[text()='标识已读']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功标识')]"));

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

	// 查看第一条通知公告详情26
	@Test
	public void lookNotice() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(2));
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'详情')]");
		webtest.enterFrame1("name=openinputiframe");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[text()='查阅记录']"));

	}

	// 查看第一条通知公告详情（新窗口）27
	@Test
	public void lookNoticeNewWindow() throws InterruptedException {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(2));
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'详情(新窗口)')]");
		String window = webtest.getCurrentWindow();
		webtest.openWindow();
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[text()='查阅记录']"));
		webtest.runJs("window.close()");
		webtest.switchToWindow(window);
		Thread.sleep(2000);

	}

	
	// 评论第一条通知公告28
	@Test
	public void commentNotice() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(2));
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'评论')]");
		webtest.type("id=confirm_input", "comment");
		webtest.click("id=confirm_btn1");
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

	// 删除第一条通知公告30
	@Test
	public void deleteNotice() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(2));
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'删除')]");
		webtest.click("id=confirm_btn1");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

	// 通知公告，导出全部31
	@Test
	public void exportAllNotice() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(2));
		webtest.click("xpath=//button[@click='daochu']");
		webtest.click("xpath=//li[contains(text(),'导出全部')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功，共有记录')]"));
	}

	// 通知公告，导出当前页32
	@Test
	public void exportThisPageNotice() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(2));
		webtest.click("xpath=//button[@click='daochu']");
		webtest.click("xpath=//li[contains(text(),'导出当前页')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功，共有记录')]"));
	}

	// 通知公告，订阅此列表33
	@Test
	public void subscribe() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(2));
		webtest.click("xpath=//button[@click='daochu']");
		webtest.click("xpath=//li[contains(text(),'订阅此列表')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//td[contains(text(),'订阅参数')]"));
	}

	// 日程，新增34
	@Test
	public void addSchedule() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(3));
		webtest.click("xpath=//button[contains(text(),'新增')]");
		webtest.enterFrame1("name=openinputiframe");
		webtest.clear("name=title");
		webtest.type("name=title", "新增日程");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'新增保存成功')]"));

	}

	// 日程，导出35
	@Test
	public void exportSchedule() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(3));
		webtest.click("xpath=//button[contains(text(),'导出')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功，共有记录')]"));

	}

//	//日程，日程管理，查看第一条日程的详情36
	@Test
	public void lookScheduleDetails() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(3));
		webtest.click("xpath=//button[contains(text(),'管理')]");
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'详情')]");
		webtest.enterFrame1("name=openinputiframe");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[text()='查阅记录']"));

	}

	// 日程，日程管理，查看第一条日程的详情(新窗口)37
	@Test
	public void lookScheduleDetailsNewWindow() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(3));
		webtest.click("xpath=//button[contains(text(),'管理')]");
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'详情(新窗口)')]");
		String window = webtest.getCurrentWindow();
		webtest.openWindow();
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[text()='查阅记录']"));
		webtest.runJs("window.close()");
		webtest.switchToWindow(window);

	}

//	
	// 日程，日程管理，评论第一条日程38
	@Test
	public void commentSchedule() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(3));
		webtest.click("xpath=//button[contains(text(),'管理')]");
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'评论')]");
		webtest.type("id=confirm_input", "comment");
		webtest.click("id=confirm_btn1");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

	// 日程，日程管理，编辑第一条日程39
	@Test
	public void editSchedule() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(3));
		webtest.click("xpath=//button[contains(text(),'管理')]");
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'编辑')]");
		webtest.enterFrame1("name=openinputiframe");
		webtest.clear("name=title");
		webtest.type("name=title", "编辑过的");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'编辑保存成功')]"));

	}

	// 日程，日程管理，删除第一条日程40
	@Test
	public void deleteSchedule() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(3));
		webtest.click("xpath=//button[contains(text(),'管理')]");
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'删除')]");
		webtest.click("id=confirm_btn1");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

	// 日程，日程管理，导出全部日程41
	@Test
	public void exportAllSchedule() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(3));
		webtest.click("xpath=//button[contains(text(),'管理')]");
		webtest.click("xpath=//button[@click='daochu']");
		webtest.click("xpath=//li[contains(text(),'导出全部')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功，共有记录')]"));

	}

	// 日程，日程管理，导出当前页日程42
	@Test
	public void exportThisPageSchedule() {
		webtest.click(webtest.getLocator("xpath=//div[@class='menuone']").get(3));
		webtest.click("xpath=//button[contains(text(),'管理')]");
		webtest.click("xpath=//button[@click='daochu']");
		webtest.click("xpath=//li[contains(text(),'导出当前页')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功，共有记录')]"));

	}

	// 工作日报，我的日报，新增工作日报（类型为年报）43
	@Test
	public void addReport() {
		webtest.click("xpath=//div[contains(text(),'工作日报')]");
		webtest.click("xpath=//div[contains(text(),'我的日报')]");
		webtest.click("xpath=//button[contains(text(),'新增')]");
		webtest.enterFrame1("name=openinputiframe");
		webtest.selectByValue("name=type", "3");
		webtest.type("name=content", "新增日报");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'新增保存成功')]"));

	}

	// 工作日报，我的日报，查看第一条工作日报详情44
	@Test
	public void lookReportDetails() {
		webtest.click("xpath=//div[contains(text(),'工作日报')]");
		webtest.click("xpath=//div[contains(text(),'我的日报')]");
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'详情')]");
		webtest.enterFrame1("name=openinputiframe");
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[text()='查阅记录']"));

	}

	// 工作日报，我的日报，查看第一条工作日报详情(新窗口)45
	@Test
	public void lookReportDetailsNewWindow() throws InterruptedException {
		webtest.click("xpath=//div[contains(text(),'工作日报')]");
		webtest.click("xpath=//div[contains(text(),'我的日报')]");
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'详情(新窗口)')]");
		String window = webtest.getCurrentWindow();
		webtest.openWindow();
		Assert.assertTrue(webtest.isDisplayed("xpath=//span[text()='查阅记录']"));
		webtest.runJs("window.close()");
		webtest.switchToWindow(window);
		Thread.sleep(2000);

	}

	// 工作日报，我的日报，点评第一条工作日报46
	@Test
	public void sayReport() {
		webtest.click("xpath=//div[contains(text(),'工作日报')]");
		webtest.click("xpath=//div[contains(text(),'我的日报')]");
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'点评')]");
		webtest.type("id=confirm_input", "点评一下");
		webtest.type("xpath=//input[starts-with(@id,'showfielsv_')]", "C:\\ad\\g.jpg");
		webtest.click("id=confirm_btn1");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));
	}

	// 工作日报，我的日报，评论第一条工作日报47
	@Test
	public void commentReport() {
		webtest.click("xpath=//div[contains(text(),'工作日报')]");
		webtest.click("xpath=//div[contains(text(),'我的日报')]");
		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'评论')]");
		webtest.type("id=confirm_input", "评论一下");
		webtest.click("id=confirm_btn1");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));
	}

	// 工作日报，我的日报，搜索内容带有“日报11”的工作日报48
	@Test
	public void searchReport() {
		webtest.click("xpath=//div[contains(text(),'工作日报')]");
		webtest.click("xpath=//div[contains(text(),'我的日报')]");
		webtest.type("xpath=//input[@placeholder='关键字']", "日报11");
		webtest.click("xpath=//button[@click=searchbtn]");
		Assert.assertFalse(webtest.isDisplayed("xpath=//td[contains(text(),'日报11')]"));
	}

	// 订阅报表，导出全部49
	@Test
	public void exportAllSub() {
		webtest.click("xpath=//div[contains(text(),'订阅报表')]");
		webtest.click("xpath=//button[contains(text(),'导出')]");
		webtest.click("xpath=//li[contains(text(),'导出全部')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

	// 订阅报表，导出当前页50
	@Test
	public void exportThisPageSub() {
		webtest.click("xpath=//div[contains(text(),'订阅报表')]");
		webtest.click("xpath=//button[contains(text(),'导出')]");
		webtest.click("xpath=//li[contains(text(),'导出当前页')]");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

}

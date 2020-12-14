package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

/*
 * @author 吴汶航
 * 	testcase number:50
 *  status:success
 *  行政模块
 */




public class XingZheng extends BaseTest {

	@BeforeMethod
	public void login() throws InterruptedException {
		webtest.open("http://127.0.0.1:81/?m=index");

	}

	// 1.成功登陆
		@Test(priority = 1)
		public void test_success_login() {
			webtest.open("?m=login");
			webtest.type("name=adminuser", "admin");
			webtest.type("xpath=//input[@type='password']", "123456");
			webtest.click("name=button");
			assertTrue(webtest.isTextPresent("  首页"));
		}

		// 2.新增物品
		@Test(priority = 2)
		public void test_addSuccess_items() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num28");
			webtest.click("id=menu_list_num30");
			webtest.click("xpath=//button[@click='clickwin,0']");

			webtest.enterFrame1("name=openinputiframe");

			webtest.type("name=name", "联想小新Air14");
			webtest.click("name=typeid");
			webtest.click("xpath=//option[text()='互联网']");
			webtest.click("name=unit");
			webtest.click("xpath=//option[@value='台']");

			webtest.click("id=AltS");
			webtest.leaveFrame();
			assertTrue(webtest.isTextPresent("新增保存成功"));

		}

		// 3.删除物品
		@Test(priority = 3)
		public void test_selectSuccess_items() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num28");
			webtest.click("id=menu_list_num30");
			webtest.click("xpath=//div[text()='×']");
			webtest.click("xpath=//tbody[starts-with(@id,'tbody')]/tr[1]/td[1]");
//			webtest.click("xpath=//tr[@oi='0')]");
			webtest.click("xpath=//button[starts-with(@id,'del')]");
			webtest.click("id=confirm_btn1");

			assertTrue(webtest.isTextPresent("删除成功"));
		}

		// 4.修改物品
		@Test(priority = 4)
		public void test_editor_items() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num28");
			webtest.click("id=menu_list_num30");
			webtest.click("xpath=//div[text()='×']");
			webtest.click("xpath=//tbody[starts-with(@id,'tbody')]/tr[1]/td[1]");
			webtest.click("xpath=//button[starts-with(@id,'edit')]");
			webtest.enterFrame1("name=openinputiframe");
			webtest.type("name=name", "联想小新Air");
			webtest.click("name=unit");
			webtest.click("xpath=//option[@value='台']");
			webtest.click("id=AltS");
			webtest.leaveFrame();

			assertTrue(webtest.isTextPresent("编辑保存成功"));
		}

		// 5.新增固定资产
		@Test(priority = 5)
		public void test_addSuccess_FixedAssets() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//button[@click='adds']");

			webtest.enterFrame1("name=openinputiframe");

			webtest.click("id=div_typeid");
			webtest.click("xpath=//option[@value='207']");
			webtest.type("name=title", "这是台式电脑");
			webtest.click("name=ckid");
			webtest.click("xpath=//option[text()='仓库1']");
			webtest.click("name=laiyuan");
			webtest.click("xpath=//option[@value='购入']");
			webtest.click("name=state");
			webtest.click("xpath=//option[@value='0']");
			webtest.click("id=AltS");
			webtest.leaveFrame();

			assertTrue(webtest.isTextPresent("新增保存成功"));
		}

		// 6.新增固定资产，未选择资产分类
		@Test(priority = 6)
		public void test_add_null_typeid_FixedAssets() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//button[@click='adds']");

			webtest.enterFrame1("name=openinputiframe");

			webtest.click("id=div_typeid");
			webtest.click("xpath=//option[@value='']");
			webtest.type("name=title", "这是台式电脑");
			webtest.click("name=ckid");
			webtest.click("xpath=//option[text()='仓库1']");
			webtest.click("name=laiyuan");
			webtest.click("xpath=//option[@value='购入']");
			webtest.click("name=state");
			webtest.click("xpath=//option[@value='0']");
			webtest.click("id=AltS");

			assertTrue(webtest.isTextPresent("资产分类不能为空"));
			webtest.leaveFrame();
		}

		// 7.新增固定资产，未输入名称
		@Test(priority = 7)
		public void test_add_null_title_FixedAssets() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//button[@click='adds']");

			webtest.enterFrame1("name=openinputiframe");

			webtest.click("id=div_typeid");
			webtest.click("xpath=//option[@value='207']");
			webtest.type("name=title", "");
			webtest.click("name=ckid");
			webtest.click("xpath=//option[text()='仓库1']");
			webtest.click("name=laiyuan");
			webtest.click("xpath=//option[@value='购入']");
			webtest.click("name=state");
			webtest.click("xpath=//option[@value='0']");
			webtest.click("id=AltS");

			assertTrue(webtest.isTextPresent("名称不能为空"));
			webtest.leaveFrame();
		}

		// 8.新增固定资产，未选择资产来源
		@Test(priority = 8)
		public void test_add_null_laiyuan_FixedAssets() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//button[@click='adds']");

			webtest.enterFrame1("name=openinputiframe");

			webtest.click("id=div_typeid");
			webtest.click("xpath=//option[@value='207']");
			webtest.type("name=title", "这是台式电脑");
			webtest.click("name=ckid");
			webtest.click("xpath=//option[text()='仓库1']");
			webtest.click("name=state");
			webtest.click("xpath=//option[@value='0']");
			webtest.click("id=AltS");
			assertTrue(webtest.isTextPresent("资产来源不能为空"));
			webtest.leaveFrame();
		}

		// 9.新增固定资产，未选择仓库
		@Test(priority = 9)
		public void test_add_null_ckid_FixedAssets() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//button[@click='adds']");

			webtest.enterFrame1("name=openinputiframe");

			webtest.click("id=div_typeid");
			webtest.click("xpath=//option[@value='207']");
			webtest.type("name=title", "这是台式电脑");
			webtest.click("name=laiyuan");
			webtest.click("xpath=//option[@value='购入']");
			webtest.click("name=state");
			webtest.click("xpath=//option[@value='0']");
			webtest.click("id=AltS");

			assertTrue(webtest.isTextPresent("存放仓库不能为空"));
			webtest.leaveFrame();
		}

		// 10.新增固定资产，未选择状态
		@Test(priority = 10)
		public void test_add_null_state_FixedAssets() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//button[@click='adds']");

			webtest.enterFrame1("name=openinputiframe");

			webtest.click("id=div_typeid");
			webtest.click("xpath=//option[@value='207']");
			webtest.type("name=title", "这是台式电脑");
			webtest.click("name=ckid");
			webtest.click("xpath=//option[text()='仓库1']");
			webtest.click("name=laiyuan");
			webtest.click("xpath=//option[@value='购入']");
			webtest.click("id=div_state");
			webtest.click("xpath=//select[@name='state']/option[1]");
			webtest.click("id=AltS");

			assertTrue(webtest.isTextPresent("状态不能为空"));
			webtest.leaveFrame();
		}

		// 11.新增固定资产，未输入任何信息
		@Test(priority = 11)
		public void test_add_null_all_FixedAssets() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//button[@click='adds']");

			webtest.enterFrame1("name=openinputiframe");
			webtest.click("id=AltS");
			assertTrue(webtest.isTextPresent("资产分类不能为空"));
			webtest.leaveFrame();
		}

		// 12.固定资产操作——资产详情
		@Test(priority = 12)
		public void test_details_FixedAssets() {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[text()='操作']");

			webtest.click("xpath=//li[text()='详情']");
			assertTrue(webtest.isTextPresent("详情"));
		}

		// 13.固定资产操作——资产详情（新窗口）
		@Test(priority = 13)
		public void test_details_newWindow_FixedAssets() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[text()='操作']");

			webtest.click("xpath=//li[text()='详情(新窗口)']");
			Thread.sleep(1000);
//			定位新窗口
			webtest.getWindow(1);
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("查阅记录"));
			webtest.getWindow(0);
		}

		// 14.固定资产操作——领用登记
		@Test(priority = 14)
		public void test_recipients_FixedAssets() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[text()='操作']");

			webtest.click("xpath=//li[text()='领用登记']");
			webtest.type("id=confirm_input", "领用登记说明");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");

			assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 15.固定资产操作——维修登记
		@Test(priority = 15)
		public void test_maintenance_FixedAssets() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[text()='操作']");

			webtest.click("xpath=//li[text()='维修登记']");
			webtest.type("id=confirm_input", "维修登记说明");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");

			assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 16.固定资产操作——评论
		@Test(priority = 16)
		public void test_comments_FixedAssets() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[text()='操作']");

			webtest.click("xpath=//li[text()='评论']");
			webtest.type("id=confirm_input", "我的评论说明");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");

			assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 17.固定资产操作——删除（有删除说明）
		@Test(priority = 17)
		public void test_delete_instructions_FixedAssets() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[text()='操作']");

			webtest.click("xpath=//li[text()='删除']");
			webtest.type("id=confirm_input", "我的删除说明");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");

			assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 18.固定资产操作——删除（无删除说明）
		@Test(priority = 18)
		public void test_delete_null_noInstructions_FixedAssets() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[text()='操作']");

			webtest.click("xpath=//li[text()='删除']");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");

			assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 19.固定资产操作——添加提醒（成功）
		@Test(priority = 19)
		public void test_add_reminder_success_FixedAssets() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[text()='操作']");
			String str = webtest.getText("xpath=//li[@temp='5']");
			webtest.click("xpath=//li[@temp='5']");

			webtest.enterFrame1("name=openinputiframe");
			webtest.click("name=rave_pinlvs2");
			webtest.click("xpath=//td[text()='28']");
			webtest.click("xpath=//a[text()='确定']");
			webtest.click("name=ratecont");
			Thread.sleep(1000);
			webtest.click("id=AltS");
			webtest.leaveFrame();
			if (str.equals("提醒设置编辑")) {
				assertTrue(webtest.isTextPresent("编辑保存成功"));
			} else {
				assertTrue(webtest.isTextPresent("新增保存成功"));
			}
		}

		// 20.固定资产操作——添加提醒（失败）
		@Test(priority = 20)
		public void test_add_reminder_false_FixedAssets() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[text()='操作']");

			String str = webtest.getText("xpath=//li[@temp='5']");
			webtest.click("xpath=//li[@temp='5']");
			webtest.enterFrame1("name=openinputiframe");
			if (str.equals("提醒设置编辑")) {
				webtest.click("name=rave_pinlvs2");
				webtest.click("xpath=//a[text()='清空']");
				webtest.click("name=ratecont");
			}
			Thread.sleep(1000);
			webtest.click("id=AltS");
			assertTrue(webtest.isTextPresent("提醒频率不能为空"));
			webtest.leaveFrame();
		}

		// 21.添加资产分类1
		@Test(priority = 21)
		public void test_add_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[@title='新增']");
			webtest.type("name=name", "联想Air15");
			webtest.click("name=sort");
			webtest.click("xpath=//button[starts-with(@id,'save')]");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 21.添加资产分类2
		@Test(priority = 21)
		public void test_add2_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[@title='新增']");
			webtest.type("name=name", "联想Air152");
			webtest.click("name=sort");
			webtest.click("xpath=//button[starts-with(@id,'save')]");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 22.添加资产分类（未输入名称）
		@Test(priority = 22)
		public void test_add_noName_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[@title='新增']");
			webtest.type("name=name", "");
			webtest.click("name=sort");
			Thread.sleep(1000);
			assertTrue(webtest.isElementPresent("xpath=//td[contains(@id,'title')]"));
		}

		// 23.添加资产分类（输入重复名称）
		@Test(priority = 23)
		public void test_add_doublename_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[@title='新增']");
			webtest.type("name=name", "联想Air15");
			webtest.click("name=sort");
			webtest.click("xpath=//button[starts-with(@id,'save')]");
			Thread.sleep(1000);
			Assert.assertFalse(webtest.isTextPresent("名称不能重复"));
		}

		// 24.修改资产分类名称
		@Test(priority = 24)
		public void test_modify_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//ul[@oi='0']");
			webtest.click("xpath=//a[@title='编辑']");
			webtest.type("name=name", "联想小新");
			webtest.click("name=sort");
			webtest.click("xpath=//button[starts-with(@id,'save')]");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 25.修改资产分类名称（输入重复名称）
		@Test(priority = 25)
		public void test_modify_doublename_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//ul[@oi='0']");
			webtest.click("xpath=//a[@title='编辑']");
			webtest.type("name=name", "电脑");
			webtest.click("name=sort");
			webtest.click("xpath=//button[starts-with(@id,'save')]");
			Thread.sleep(1000);
			Assert.assertFalse(webtest.isTextPresent("名称不能重复"));
		}

		// 26.修改资产分类名称（未选择分类）
		@Test(priority = 26)
		public void test_modify_noChoseName_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[@title='编辑']");
			Thread.sleep(1000);
			Assert.assertFalse(webtest.isTextPresent("请选择分类"));
		}

		// 27.删除资产分类名称
		@Test(priority = 27)
		public void test_delete_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//ul[@oi='7']");
			webtest.click("xpath=//a[@title='删除']");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("删除成功"));
		}

		// 28.删除资产分类（未选择分类）
		@Test(priority = 28)
		public void test_delete_noChoseName_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[@title='删除']");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			Assert.assertFalse(webtest.isTextPresent("请选择分类"));
		}

		// 29.删除资产分类名称（有下级分类）
		@Test(priority = 29)
		public void test_delete_haveSun_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//ul[@oi='6']");
			webtest.click("xpath=//a[@title='删除']");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("有下级分类不允许删除"));
		}

		// 30.移动资产分类
		@Test(priority = 30)
		public void test_mobile_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//ul[@oi='8']");
			webtest.click("xpath=//a[@title='移动']");
			webtest.click("xpath=//ul[@oi='7']");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("移动成功"));
		}

		// 31.移动资产分类（未选择需要移动分类）
		@Test(priority = 31)
		public void test_mobile_noChose_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[@title='移动']");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("没有选中行"));
		}

		// 32.移动资产分类（未选择移动到哪个分类之下）
		@Test(priority = 32)
		public void test_mobile_noChose5_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//ul[@oi='7']");
			webtest.click("xpath=//a[@title='移动']");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("请在5秒内选择其他分类确认移动"));
		}

		// 33.移动资产分类（移动到自己的下级）
		@Test(priority = 33)
		public void test_mobile_myDown_classification() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//ul[@oi='6']");
			webtest.click("xpath=//a[@title='移动']");
			webtest.click("xpath=//ul[@oi='2']");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("不能移动到自己的下级"));
		}

		// 34.移动资产分类到顶级
		@Test(priority = 34)
		public void test_mobile_classification_toUp() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//ul[@oi='8']");
			webtest.click("xpath=//a[@title='移动到顶级']");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			assertTrue(webtest.isTextPresent("移动成功"));
		}

		// 35.移动资产分类到顶级（未选择需要移动分类）
		@Test(priority = 35)
		public void test_mobile_noChose_classification_toUp() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//a[@title='移动到顶级']");
			Thread.sleep(1000);
			Assert.assertFalse(webtest.isTextPresent("没有选中行"));
		}

		// 36.移动资产分类到顶级（已经为顶级分类）
		@Test(priority = 36)
		public void test_mobile_choseUp_classification_toUp() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num137");
			webtest.click("xpath=//ul[@oi='0']");
			webtest.click("xpath=//a[@title='移动到顶级']");
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			Assert.assertFalse(webtest.isTextPresent("已经为顶级分类"));
		}

		// 37.新增车辆预定
		@Test(priority = 37)
		public void test_reservation_add_success() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			webtest.click("xpath=//button[starts-with(@id,'addbtn')]");

			webtest.enterFrame1("name=openinputiframe");

			webtest.click("id=btnchange_usename");
			webtest.type("xpath=//input[starts-with(@id,'changekey')]", "项目主管");
			Thread.sleep(1000);
			webtest.mouseToElementandClick("xpath=//input[contains(@name,'soukey')]");
			webtest.click("xpath=//input[starts-with(@id,'changeok')]");
			Thread.sleep(100);
			webtest.click("name=startdt");
			webtest.click("xpath=//td[text()='27']");
			webtest.click("xpath=//a[text()='确定']");
			webtest.click("name=enddt");
			webtest.click("xpath=//td[text()='28']");
			webtest.click("xpath=//a[text()='确定']");
			webtest.type("name=address", "目的地");
			webtest.type("name=xianlines", "线路");
			Thread.sleep(1000);
			webtest.click("xpath=//span[@id='div_carnum']/table/tbody/tr/td[2]/a");
			webtest.click("xpath=//input[@value='2']");
			webtest.click("xpath=//input[starts-with(@id,'changeok')]");
			webtest.click("id=btnchange_jianame");
			webtest.type("xpath=//input[starts-with(@id,'changekey')]", "高级程序员");
			Thread.sleep(1000);
			webtest.mouseToElementandClick("xpath=//input[contains(@name,'soukey')]");
			webtest.click("xpath=//input[starts-with(@id,'changeok')]");
			Thread.sleep(1000);
			webtest.click("id=AltS");

			webtest.leaveFrame();
			assertTrue(webtest.isTextPresent("新增保存成功"));

		}

		// 38.待处理状态——车辆预定查询操作——详情
		@Test(priority = 38)
		public void test_car_reservation_operation_details() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='0']");
				Thread.sleep(1000);
				assertTrue(webtest.isTextPresent("车辆预定"));
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

		// 39.待处理状态——车辆预定查询操作——详情（新窗口）
		@Test(priority = 39)
		public void test_car_reservation_operation_details_newWindow() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='1']");
				webtest.getWindow(1);
				Thread.sleep(1000);
				assertTrue(webtest.isTextPresent("查阅记录"));
				webtest.getWindow(0);
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

		// 40.待处理状态——车辆预定查询操作——追加说明
		@Test(priority = 40)
		public void test_car_reservation_operation_additional() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='2']");
				webtest.type("id=confirm_input", "添加的追加说明");
				webtest.click("id=confirm_btn1");
				Thread.sleep(1000);
				assertTrue(webtest.isTextPresent("处理成功"));
			} else {
				System.out.println("The operation was not found !");
				assertTrue(true);
			}
		}

		// 41.待处理状态——车辆预定查询操作——追加说明（未输入）
		@Test(priority = 41)
		public void test_car_reservation_operation_noAdditional() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='2']");
				webtest.type("id=confirm_input", "");
				webtest.click("id=confirm_btn1");
				Thread.sleep(1000);
				assertTrue(webtest.isTextPresent("没有输入[追加说明...]说明"));
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

		// 42.待处理状态——车辆预定查询操作——催办
		@Test(priority = 42)
		public void test_car_reservation_operation_cuiBan() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='4']");
				webtest.type("id=confirm_input", "催办说明");
				webtest.click("id=confirm_btn1");
				Thread.sleep(1000);
				assertTrue(webtest.isTextPresent("处理成功"));
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

		// 43.待处理状态——车辆预定查询操作——催办（未输入）
		@Test(priority = 43)
		public void test_car_reservation_operation_noCuiBan() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='4']");
				webtest.type("id=confirm_input", "");
				webtest.click("id=confirm_btn1");
				Thread.sleep(1000);
				assertTrue(webtest.isTextPresent("没有输入[催办...]说明"));
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

		// 44.待处理状态——车辆预定查询操作——评论
		@Test(priority = 44)
		public void test_car_reservation_operation_comments() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='5']");
				webtest.type("id=confirm_input", "我的评论");
				webtest.click("id=confirm_btn1");
				Thread.sleep(1000);
				assertTrue(webtest.isTextPresent("处理成功"));
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

		// 45.待处理状态——车辆预定查询操作——评论（未输入）
		@Test(priority = 45)
		public void test_car_reservation_operation_noComments() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='5']");
				webtest.type("id=confirm_input", "");
				webtest.click("id=confirm_btn1");
				Thread.sleep(1000);
				assertTrue(webtest.isTextPresent("没有输入[评论]说明"));
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

		// 46.待处理状态——车辆预定查询操作——添加提醒
		@Test(priority = 46)
		public void test_car_reservation_operation_addRemind() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				String str2 = webtest.getText("xpath=//li[@temp='6']");
				webtest.click("xpath=//li[@temp='6']");
				webtest.enterFrame1("name=openinputiframe");
				webtest.click("name=rave_pinlvs2");
				webtest.click("xpath=//td[text()='28']");
				webtest.click("xpath=//a[text()='确定']");
				webtest.click("name=ratecont");
				Thread.sleep(1000);
				webtest.click("id=AltS");
				webtest.leaveFrame();
				if (str2.equals("提醒设置编辑")) {
					assertTrue(webtest.isTextPresent("编辑保存成功"));
				} else {
					assertTrue(webtest.isTextPresent("新增保存成功"));
				}
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

		// 47.待处理状态——车辆预定查询操作——添加提醒
		@Test(priority = 47)
		public void test_car_reservation_operation_addRemind_noPinLv() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				String str2 = webtest.getText("xpath=//li[@temp='6']");
				webtest.click("xpath=//li[@temp='6']");
				webtest.enterFrame1("name=openinputiframe");
				if (str2.equals("提醒设置编辑")) {
					webtest.click("name=rave_pinlvs2");
					webtest.click("xpath=//a[text()='清空']");
					webtest.click("name=ratecont");
				}
				Thread.sleep(1000);
				webtest.click("id=AltS");
				assertTrue(webtest.isTextPresent("提醒频率不能为空"));
				webtest.leaveFrame();
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}

		}

		// 48.待处理状态——车辆预定查询操作——编辑
		@Test(priority = 48)
		public void test_car_reservation_operation_editor() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='7']");
				webtest.enterFrame1("name=openinputiframe");
				webtest.click("id=AltS");
				webtest.leaveFrame();
				assertTrue(webtest.isTextPresent("编辑保存成功"));
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

		// 49.待处理状态——车辆预定查询操作——作废申请（未输入）
		@Test(priority = 49)
		public void test_car_reservation_operation_noInvalid() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='3']");
				webtest.type("id=confirm_input", "");
				webtest.click("id=confirm_btn1");
				Thread.sleep(1000);
				assertTrue(webtest.isTextPresent("没有输入[作废申请...]说明"));
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

		// 50.待处理状态——车辆预定查询操作——作废申请
		@Test(priority = 50)
		public void test_car_reservation_operation_invalid() throws InterruptedException {
			webtest.click("xpath=//span[text()='行政']");
			webtest.click("id=menu_list_num138");
			webtest.click("id=menu_list_num144");
			String str = webtest.getText("xpath=//font[text()='待处理']");
			if (str.equals("待处理")) {
				webtest.click("xpath=//a[text()='操作']");
				webtest.click("xpath=//li[@temp='3']");
				webtest.type("id=confirm_input", "添加的作废申请");
				webtest.click("id=confirm_btn1");
				Thread.sleep(1000);
				assertTrue(webtest.isTextPresent("处理成功"));
			} else {
				System.out.println("The operation was not found !");
				assertTrue(false);
			}
		}

}

package com.webtest.demo;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

public class RenShi extends BaseTest {
	@BeforeMethod
	public void login() throws InterruptedException {
		webtest.open("http://127.0.0.1:81/?m=index");
	}
	@Test(dependsOnMethods = { "readedMail" })
	public void test01(){
		// 人员档案编辑测试
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_down_isons_num84");
		webtest.click("id=menu_list_num85");

		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='编辑']");
		// 进入编辑frame
		webtest.enterFrame("openinputiframe");
		// 添加图片
		webtest.type("id=filed_zhaopian_inp", "D:\\AD\\g.jpg");
		// 修改日期
		webtest.click("name=workdate");
		webtest.click("xpath=//td[@title='下一年']");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[text()='20']");
		webtest.click("xpath=//a[text()='确定']");
		// 向下滑动
		webtest.runJs("window.scroll(0,5000)");
		webtest.click("xpath=/html/body/div/div[2]/div[3]/form/div[2]/table/tbody/tr[2]/td[6]/a");
		// 保存
		webtest.click("id=AltS");
		// 退出frame
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
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

	@Test
	public void test2() {
		// 人员档案添加评论测试
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_down_isons_num84");
		webtest.click("id=menu_list_num85");

		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='评论']");
		webtest.type("xpath=//*[@id='confirm_input']", "真不错!");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test3() {
		// 导出文件
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_down_isons_num84");
		webtest.click("id=menu_list_num85");

		webtest.click("xpath=//button[@click='daochu']");
		webtest.click("xpath=//li[text()='导出全部']");
		webtest.click("xpath=//a[text()='[下载]']");
	}

	@Test
	public void test4() {
		// 人员档案查看详情
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_down_isons_num84");
		webtest.click("id=menu_list_num85");

		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='详情']");
		// 进入详情页frame
		webtest.enterFrame("openinputiframe");
		webtest.runJs("window.scroll(0,5000)");
		// 未找到关闭按钮直接跳出
		webtest.click("id=winiframe_spancancel");

	}

	@Test
	public void test5() {
		// 新增员工合同
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_down_isons_num84");
		webtest.click("id=menu_list_num95");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		// 进入详情页frame
		webtest.enterFrame("openinputiframe");
		webtest.click("xpath=//a[text()='选择']");
		webtest.click("xpath=//td[contains(text(),'开发部')]");
		webtest.click("xpath=//input[@value='6']");
		webtest.click("xpath=//input[@value='确定']");
		webtest.selectByIndex("name=companyid", 2);
		webtest.type("xpath=//input[@name='name']", "正式工合同");
		webtest.selectByValue("name=httype", "劳动合同");
		webtest.click("name=startdt");
		webtest.click("xpath=//a[text()='现在']");
		webtest.click("name=enddt");
		webtest.click("xpath=//td[@title='下一年']");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[text()='20']");
		webtest.click("xpath=//a[text()='确定']");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test6() {
		// 员工合同下载
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_down_isons_num84");
		webtest.click("id=menu_list_num95");

		webtest.click("xpath=//button[@click='daochu']");
		webtest.click("xpath=//li[text()='导出全部']");
		webtest.click("xpath=//a[text()='[下载]']");
	}

	@Test
	public void test7() {
		// 人员分析导出
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_down_isons_num84");
		webtest.click("menu_list_num149");

		webtest.click("xpath=//button[@click='daochu']");
		webtest.click("xpath=//a[text()='[下载]']");
	}

	@Test
	public void test8() throws InterruptedException {
		// 按照学历进行人员分析
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_down_isons_num84");
		webtest.click("id=menu_list_num149");

		Thread.sleep(1000);
		webtest.selectByValue("class=form-control", "xueli");
		// 还可以尝试下滑选择年龄进行分析
		webtest.click("xpath=//button[text()='分析']");
	}

	@Test
	public void test9() {
		// 转正新增提醒
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num96");

		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='评论']");
		webtest.type("xpath=//*[@id='confirm_input']", "真不错!");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test10() {
		// 新增离职申请
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num97");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		// 进入详情页frame
		webtest.enterFrame("openinputiframe");

		webtest.selectByValue("name=redundtype", "辞职");

		webtest.click("class=inputs datesss");
		webtest.click("xpath=//a[text()='现在']");
		webtest.type("name=redundreson", "家中有事");
		webtest.click("id=AltS");
		webtest.leaveFrame();

	}

//	@Test
//	public void tes11() {
//		// 将新增的离职申请删除
//		webtest.click("xpath=//span[text()='人事考勤']");
//		webtest.click("id=menu_list_num127");
//		webtest.click("id=menu_list_num97");
//
//		webtest.click("xpath=//a[text()='操作']");
//		webtest.click("xpath=//li[text()='删除']");
//		webtest.type("xpath=//*[@id='confirm_input']", "不辞职了!");
//		webtest.click("xpath=//*[@id='confirm_btn1']");
//
//	}

	@Test
	public void test12() {
		// 离职申请追加说明
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num97");

		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[contains(text(),'追加说明')]");
		webtest.type("xpath=//*[@id='confirm_input']", "不想干了要辞职!");
		webtest.click("xpath=//*[@id='confirm_btn1']");
	}

	@Test
	public void test13() {
		// 人事调动新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num128");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		// 进入详情页frame
		webtest.enterFrame("openinputiframe");
		webtest.click("id=btnchange_tranname");
		webtest.click("xpath=//td[contains(text(),'开发部')]");
		webtest.click("xpath=//input[@value='6']");
		webtest.click("xpath=//input[@value='确定']");
		webtest.selectByValue("name=trantype", "晋升");
		webtest.click("id=btnchange_newdeptname");
		webtest.click("xpath=//input[@value='5']");
		webtest.click("xpath=//input[@value='确定']");
		webtest.type("name=newranking", "项目主管");
		webtest.click("name=effectivedt");
		webtest.click("xpath=//a[text()='现在']");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));

	}

	@Test
	public void test14() {
		// 人事调动新增作废
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num128");
		
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[contains(text(),'作废申请')]");
		webtest.type("xpath=//*[@id='confirm_input']", "作废申请！");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}
	@Test
	public void test15() {
		// 调薪申请删除
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num129");
		
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[text()='删除']");
		webtest.type("xpath=//*[@id='confirm_input']", "需要删除重新上交");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}
	@Test
	public void test16() {
		// 调薪申请新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num129");
		
		webtest.click("xpath=//button[contains(text(),'新增')]");
		// 进入详情页frame
		webtest.enterFrame("openinputiframe");
		webtest.type("name=floats", "5");
		webtest.click("name=effectivedt");
		webtest.click("xpath=//a[text()='现在']");
		webtest.type("name=explain", "工资太少，难以维持生计");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test17() {
		// 调薪申请导出
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num129");

		webtest.click("xpath=//button[@click='daochu']");
		webtest.click("xpath=//li[text()='导出全部']");
		webtest.click("xpath=//a[text()='[下载]']");
	}
	@Test
	public void test18() {
		//奖惩新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num130");
		
		webtest.click("xpath=//button[contains(text(),'新增')]");
		// 进入详情页frame
		webtest.enterFrame("openinputiframe");
		webtest.click("xpath=//a[text()='选择']");
		webtest.click("xpath=//td[contains(text(),'开发部')]");
		webtest.click("xpath=//input[@value='6']");
		webtest.click("xpath=//input[@value='确定']");
		webtest.click("name=happendt");
		webtest.click("xpath=//a[text()='现在']");
		webtest.type("name=hapaddress", "公司");
		webtest.selectByValue("name=result", "奖励");
		webtest.type("name=money", "500");
		webtest.type("name=explain", "表现优秀加以奖励");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}
	@Test
	public void test19() {
		//对新增奖惩评论
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num130");
		
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[contains(text(),'评论')]");
		webtest.type("xpath=//*[@id='confirm_input']", "做的不错!");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}
	@Test
	public void test20() {
		//对新增奖惩催办
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num127");
		webtest.click("id=menu_list_num130");
		
		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[contains(text(),'催办')]");
		webtest.type("xpath=//*[@id='confirm_input']", "做的不错,希望立刻奖励!");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}
	
	@Test(dataProvider = "movie",dataProviderClass = NSDataProvider.class)
	public void test21(String content,String daily) {
		
		// 新增周报
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num192");
		webtest.click("id=menu_list_num193");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		// 进入详情页frame
		webtest.enterFrame("openinputiframe");
		webtest.selectByValue("name=type", "1");
		webtest.type("name=content", content);
		webtest.type("name=plan", daily);
		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
		
	}

	@Test
	public void test22() {
		// 周报添加评论
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num192");
		webtest.click("id=menu_list_num193");

		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[contains(text(),'评论')]");
		webtest.type("xpath=//*[@id='confirm_input']", "做的不错!");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test23() {
		// 周报点评
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num192");
		webtest.click("id=menu_list_num193");

		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[contains(text(),'点评')]");
		webtest.type("xpath=//*[@id='confirm_input']", "可以将测试计划加入周报中");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test24() {
		// 周报搜索
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num192");
		webtest.click("id=menu_list_num193");

		webtest.type("xpath=//input[@placeholder='关键字']", "张飞");
		webtest.click("xpath=//button[@click='searchbtn']");
	}

	@Test
	public void test25() {
		// 新增薪资核算
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num98");
		webtest.click("id=menu_list_num99");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		// 进入详情页frame
		webtest.enterFrame("openinputiframe");
		webtest.click("xpath=//a[text()='选择']");
		webtest.click("xpath=//td[contains(text(),'开发部')]");
		webtest.click("xpath=//input[@value='6']");
		webtest.click("xpath=//input[@value='确定']");
		webtest.click("xpath=//input[@inputtype='month']");
		webtest.click("xpath=//a[contains(text(),'8月')]");
		webtest.click("xpath=//a[text()='确定']");
		webtest.type("xpath=//input[@name='skilljt']", "500");
		webtest.type("xpath=//input[@name='travelbt']", "300");
		webtest.type("xpath=//input[@name='telbt']", "100");
		webtest.click("xpath=//input[@value='初始数据']");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test26() {
		// 薪资核算评论
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num98");
		webtest.click("id=menu_list_num99");

		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[contains(text(),'评论')]");
		webtest.type("xpath=//*[@id='confirm_input']", "该员工做的不错值得加薪!");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test27() {
		// 薪资核算追加点评
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num98");
		webtest.click("id=menu_list_num99");

		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[contains(text(),'追加说明')]");
		webtest.type("xpath=//*[@id='confirm_input']", "请及时核算");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test28() {
		// 薪资核算删除
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num98");
		webtest.click("id=menu_list_num99");

		webtest.click("xpath=//a[text()='操作']");
		webtest.click("xpath=//li[contains(text(),'删除')]");
		webtest.type("xpath=//*[@id='confirm_input']", "写错了");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
		
	}
	@Test
	public void test29() {
		// 薪资核算查看已发放、待发放
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num98");
		webtest.click("id=menu_list_num102");
		
		webtest.click("xpath=//button[text()='待发放']");
		webtest.click("xpath=//button[text()='已发放']");
		webtest.click("xpath=//button[text()='全部']");
		
	}
	@Test
	public void test30() throws InterruptedException {
		// 新增考勤时间规则
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num53");

		webtest.click("xpath=//button[contains(text(),'新增规则')]");
		webtest.type("xpath=//input[@name='name']", "a一级");
		webtest.type("xpath=//input[@name='sort']", "2");
		webtest.click("xpath=//button[contains(text(),'确定')]");
		webtest.click("xpath=//td[@fields='name']");
		webtest.click("xpath=//button[text()='新增下级']");
		webtest.type("xpath=//input[@name='name']", "二级");
		webtest.type("xpath=//input[@name='sort']", "2");
		webtest.click("xpath=//button[contains(text(),'确定')]");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test31() {
		// 删除考勤规则
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num53");

		webtest.click("xpath=//td[@fields='name']");
		webtest.click("xpath=//button[contains(text(),'删除')]");
		webtest.click("xpath=//*[@id='confirm_btn1']");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test32() {
		// 考勤时间分配新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num54");
		// 选择对应的人员
		webtest.click("xpath=//button[contains(text(),'新增')]");
		webtest.click("xpath=//button[@changeuser='recename']");
		webtest.click("xpath=//td[contains(text(),'开发部')]");
		webtest.click("xpath=//input[@xname='赵子龙']");
		webtest.click("xpath=//input[@value='确定']");
		// 选中开始日期
		webtest.click("xpath=//tr[@na='startdt']/td[2]/div/span/button");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[@xu='22']");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		// 选中截至日期
		webtest.click("xpath=//tr[@na='enddt']/td[2]/div/span/button");
		webtest.click("xpath=//td[@title='下一年']");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[@xu='22']");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		// 选中下拉框
		webtest.selectByValue("name=mid", "44");
		webtest.click("xpath=//button[contains(text(),'确定')]");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));

	}

	@Test
	public void test33() {
		// 考勤时间分配删除新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num54");

		// 选中第一行，删除并确定
		webtest.click("xpath=//td[text()='赵子龙']");
		webtest.click("xpath=//button[contains(text(),'删除')]");
		webtest.click("id=confirm_btn1");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test34() {
		// 考勤时间分配搜索
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num54");

		// 筛选并点击搜索
		webtest.selectByValue("xpath=//select[@class='form-control']", "1");
		webtest.type("xpath=//button[contains(text(),'搜索')]", "中秋节");

	}

	@Test
	public void test35() throws InterruptedException {
		// 休息时间规则新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num55");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		webtest.type("xpath=//input[@name='name']", "中秋节");
		webtest.doubleClick("xpath=//button[contains(text(),'确定')]");
		

	}

	@Test
	public void test36() {
		// 休息时间规则删除
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num55");

		webtest.click("xpath=//td[contains(text(),'中秋节')]");
		webtest.click("xpath=//button[contains(text(),'删除')]");
		webtest.click("id=confirm_btn1");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test37() throws InterruptedException {
		// 休息时间分配新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num56");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		// 选中对应人员
		webtest.click("xpath=//tr[@na='recename']/td[2]/div/span/button[2]");
		webtest.click("xpath=//td[contains(text(),'开发部')]");
		webtest.click("xpath=//input[@xname='赵子龙']");
		webtest.click("xpath=//input[@value='确定']");
		// 选中开始日期
		webtest.click("xpath=//tr[@na='startdt']/td[2]/div/span/button");
		webtest.click("xpath=//a[text()='现在']");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		// 选中截至日期
		webtest.click("xpath=//tr[@na='enddt']/td[2]/div/span/button");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[@xu='22']");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		// 对应规则
		webtest.doubleClick("xpath=//button[contains(text(),'确定')]");
		

	}

	@Test
	public void test38() {
		// 休息时间分配删除
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num56");

		webtest.click("xpath=//td[text()='赵子龙']");
		webtest.click("xpath=//button[contains(text(),'删除')]");
		webtest.click("id=confirm_btn1");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));

	}

	@Test
	public void test39() {
		// 定位打卡位置新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num152");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		webtest.type("xpath=//input[@name='name']", "办公楼");
		webtest.type("xpath=//input[@name='address']", "C306");
		webtest.type("xpath=//input[@name='precision']", "25");
		webtest.click("xpath=//button[contains(text(),'确定')]");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test40() {
		// 定位打卡位置删除
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num152");

		webtest.click("xpath=//td[contains(text(),'办公楼')]");
		webtest.click("xpath=//button[contains(text(),'删除')]");
		webtest.click("id=confirm_btn1");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));

	}

	@Test
	public void test41() {
		// 定位打卡位置分配新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num153");

		// 选择对应的人员
		webtest.click("xpath=//button[contains(text(),'新增')]");
		webtest.click("xpath=//tr[@na='recename']/td[2]/div/span/button[2]");
		webtest.click("xpath=//td[contains(text(),'开发部')]");
		webtest.click("xpath=//input[@xname='赵子龙']");
		webtest.click("xpath=//input[@value='确定']");
		//开始日期
		webtest.click("xpath=//tr[@na='startdt']/td[2]/div/span/button");
		webtest.click("xpath=//a[text()='现在']");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		// 选中截至日期
		webtest.click("xpath=//tr[@na='enddt']/td[2]/div/span/button");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[@xu='22']");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		//对应规则
		webtest.selectByValue("name=mid", "2");
		// 确定
		webtest.click("xpath=//button[contains(text(),'确定')]");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));

	}

	@Test
	public void test42() {
		// 定位打卡位置分配删除
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num32");
		webtest.click("id=menu_list_num153");

		webtest.click("xpath=//td[contains(text(),'软件园')]");
		webtest.click("xpath=//button[contains(text(),'删除')]");
		webtest.click("id=confirm_btn1");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test43() {
		// 打卡记录新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num57");
		webtest.click("id=menu_list_num33");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		// 选择人员
		webtest.click("xpath=//tr[@na='recename']/td[2]/div/span/button[2]");
		webtest.click("xpath=//td[contains(text(),'开发部')]");
		webtest.click("xpath=//input[@xname='张飞']");
		webtest.click("xpath=//input[@value='确定']");
		// 选择打卡时间
		webtest.click("xpath=//button[@changedate='datetime']");
		webtest.click("xpath=//a[text()='现在']");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		// 说明
		webtest.type("name=explain", "打卡测试");
		webtest.click("xpath=//button[contains(text(),'确定')]");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test44() {
		// 打卡记录删除
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num57");
		webtest.click("id=menu_list_num33");

		webtest.click("xpath=//td[text()='张飞']");
		webtest.click("xpath=//button[contains(text(),'删除')]");
		webtest.click("id=confirm_btn1");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}

	@Test
	public void test45() {
		// 新增打卡异常
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num57");
		webtest.click("id=menu_list_num169");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		
		webtest.enterFrame("openinputiframe");
		// 异常类型选择
		webtest.selectByValue("name=errtype", "打卡不成功");
		// 异常日期
		webtest.click("name=dt");
		webtest.click("xpath=//a[contains(text(),'现在')]");
		// 应打卡时间
		webtest.click("name=ytime");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[2]/span[2]");
		webtest.click("xpath=//font[contains(text(),'08')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[2]/span[3]");
		webtest.click("xpath=//font[contains(text(),'30')]");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		webtest.type("name=explain", "网络差");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));

	}

	@Test
	public void test46() {
		// 打卡异常删除
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num57");
		webtest.click("id=menu_list_num169");

		webtest.click("xpath=//a[contains(text(),'操作')]");
		webtest.click("xpath=//li[contains(text(),'删除')]");
		webtest.type("id=confirm_input", "写错了");
		webtest.click("id=confirm_btn1");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));

	}

	@Test
	public void test47() {
		// 新增考勤信息
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num57");
		webtest.click("id=menu_list_num36");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		webtest.enterFrame("openinputiframe");
		// 选择人员
		webtest.click("xpath=//a[contains(text(),'选择')]");
		webtest.click("xpath=//td[contains(text(),'开发部')]");
		webtest.click("xpath=//input[@xname='张飞']");
		webtest.click("xpath=//input[@value='确定']");
		//类型
		webtest.selectByValue("name=kind", "增加年假");
		webtest.clear("name=totals");
		webtest.type("name=totals", "8");
		// 开始时间
		webtest.click("name=stime");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[contains(text(),'20')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[2]");
		webtest.click("xpath=//font[contains(text(),'19')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[3]");
		webtest.click("xpath=//font[contains(text(),'30')]");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		//截止时间
		webtest.click("name=etime");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[contains(text(),'20')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[2]");
		webtest.click("xpath=//font[contains(text(),'21')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[3]");
		webtest.click("xpath=//font[contains(text(),'30')]");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		webtest.type("name=explain", "加班");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}
		

	@Test
	public void test48() {
		// 新增加班单核算
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num57");
		webtest.click("id=menu_list_num217");

		webtest.click("xpath=//button[contains(text(),'新增')]");
		webtest.enterFrame("openinputiframe");
		// 开始加班时间
		webtest.click("name=stime");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[contains(text(),'20')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[2]");
		webtest.click("xpath=//font[contains(text(),'19')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[3]");
		webtest.click("xpath=//font[contains(text(),'30')]");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		// 加班截止时间
		webtest.click("name=etime");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[contains(text(),'20')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[2]");
		webtest.click("xpath=//font[contains(text(),'21')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[3]");
		webtest.click("xpath=//font[contains(text(),'30')]");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		// 加班兑换
		webtest.selectByValue("name=jiatype", "1");
		webtest.clear("name=jiafee");
		webtest.type("name=jiafee", "400");
		webtest.type("name=explain", "加班很累需要钱作动力");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}
	
	@Test
	public void test49() throws InterruptedException {
		//考试培训列表新增
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num199");
		webtest.click("id=menu_list_num200");
		
		webtest.click("xpath=//button[contains(text(),'新增')]");
		// 进入编辑frame
		webtest.enterFrame("openinputiframe");
		webtest.type("name=title", "会计考试");
		//考试对象
		webtest.click("id=btnchange_recename");
		webtest.click("xpath=//td[contains(text(),'财务部')]");
		webtest.click("xpath=//input[@xname='小乔']");
		webtest.click("xpath=//input[@value='确定']");
		//培训题库
		webtest.click("xpath=//span[@id='div_tikuname']/table/tbody/tr/td[2]/a");
		webtest.click("xpath=//input[@xname='PHP知识']");
		webtest.click("xpath=//input[@value='确定']");
		//开始时间
		webtest.click("name=startdt");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[contains(text(),'20')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[2]");
		webtest.click("xpath=//font[contains(text(),'08')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[3]");
		webtest.click("xpath=//font[contains(text(),'00')]");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		//截止时间
		webtest.click("name=enddt");
		webtest.click("xpath=//td[@title='下个月']");
		webtest.click("xpath=//td[contains(text(),'20')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[2]");
		webtest.click("xpath=//font[contains(text(),'09')]");
		webtest.click("xpath=//div[@class='rockdatepicker']/div[3]/span[3]");
		webtest.click("xpath=//font[contains(text(),'30')]");
		webtest.click("xpath=//a[contains(text(),'确定')]");
		//单选题目数量
		webtest.type("name=dsshu","1");
		//多选题目数量
		webtest.type("name=dxshu","1");
		//考试时间
		webtest.selectByValue("name=kstime", "45");
		//向下滑动
		webtest.runJs("window.scroll(0,500)");
		//总分
		webtest.clear("name=zfenshu");
		webtest.type("name=zfenshu","100");
		//合格分数
		webtest.clear("name=hgfen");
		webtest.type("name=hgfen","60");
		webtest.click("id=AltS");
		webtest.leaveFrame();
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}
	@Test
	public void test50() {
		//考试培训人员重新标识可培训
		webtest.click("xpath=//span[text()='人事考勤']");
		webtest.click("id=menu_list_num199");
		webtest.click("id=menu_list_num201");
		
		webtest.click("xpath=//input[@oi='0']");
		webtest.click("xpath=//input[@oi='1']");
		webtest.click("xpath=//button[contains(text(),'重新标识可培训')]");
		webtest.click("id=confirm_btn1");
		assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'成功')]"));
	}
	
}

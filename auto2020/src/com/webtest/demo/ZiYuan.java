package com.webtest.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
/*
 * @author 翟晓龙
 * 	testcase number:50
 * status:success
 */

public class ZiYuan extends BaseTest {
	private static String block="xpath=//span[@pmenuid='19']";
	
	@BeforeMethod
	public void login() throws InterruptedException {
		webtest.open("http://127.0.0.1:81/?m=index");

	}
//	// 登陆退出成功
//	@Test
//	public void test01() throws InterruptedException {
//		webtest.click("id=indexuserl");
//		webtest.click("xpath=//li[@temp='5']");
//		webtest.click("id=confirm_btn1");
//		Thread.sleep(2000);
//		Assert.assertTrue(webtest.isTextPresent("登录"));
//	}

	// 登录退出取消
	@Test(dependsOnMethods = { "readedMail" })
	public void test02() throws InterruptedException {
		webtest.click("id=indexuserl");
		webtest.click("xpath=//li[@temp='5']");
		webtest.click("id=confirm_btn");
		Assert.assertTrue(webtest.isTextPresent("资源"));
	}
	
	//提醒消息设为已读，防止影响其他测试
	@Test
	public void readedMail() throws InterruptedException {
		webtest.click("xpath=//a[contains(text(),'提醒信息')]");
		webtest.click("xpath=//input[@type='checkbox']");
		Thread.sleep(1000);
		webtest.click("xpath=//button[text()='标为已读']");
		Assert.assertTrue(webtest.isDisplayed("xpath=//div[contains(text(),'处理成功')]"));

	}

	// 个人文档预览(预览一个txt文件)
		@Test
		public void test03() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num124");
			webtest.click("xpath=//input[@oi='0']");
			webtest.click("xpath=//a[@href='javascript:;']");
			webtest.enterFrame1("name=openinputiframe");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("查看帮助?"));
		}

		// 个人文档删除
		@Test
		public void test04() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num124");
			webtest.click("xpath=//input[@oi='0']");
			webtest.click("xpath=//button[@class='btn btn-danger']");
			Thread.sleep(2000);
			webtest.click("id=confirm_btn1");
			Assert.assertTrue(webtest.isTextPresent("删除成功"));
		}
		
//		 资源板块下一页功能
		@Test
		public void test05() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num124");
			webtest.click("xpath=//button[starts-with(@id,'next')]");
			Assert.assertTrue(webtest.isElementPresent("xpath=//button[starts-with(@id,'shang')]"));
		}

		// 个人文档共享
		@Test
		public void test06() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num124");
			webtest.click("xpath=//input[@oi='0']");
			webtest.click("xpath=//button[@click='sharefile']");
			Thread.sleep(2000);
			webtest.click("xpath=//input[starts-with(@id,'changereload')]");
			Thread.sleep(1000);
			webtest.type("xpath=//input[starts-with(@id,'changekey')]", "管理层");
			Thread.sleep(1000);
			webtest.click("xpath=//input[starts-with(@id,'changesoubtn')]");
			Thread.sleep(1000);
			webtest.click("xpath=//input[@xname='磐石']");
			Thread.sleep(1000);
			webtest.click("xpath=//input[starts-with(@id,'changeok')]");
			Thread.sleep(1000);
			Assert.assertTrue(webtest.isTextPresent("共享成功"));
		}

		//个人文档取消共享
		@Test
		public void test07() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num124");
			webtest.click("xpath=//input[@oi='0']");
			webtest.click("xpath=//button[@click='qxsharefile']");
			Assert.assertTrue(webtest.isTextPresent("取消成功"));
		}


//		 个人文档移动
		@Test
		public void test08() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num124");
			webtest.click("xpath=//input[@oi='6']");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='movefile']");
			Thread.sleep(1000);
			webtest.doubleClick("xpath=//i[@nodeclick='treenode_1']");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");
			Assert.assertTrue(webtest.isTextPresent("移动成功"));
		}

		// 左侧分类、所有文档按钮及刷新按钮
		@Test
		public void test09() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num124");
			webtest.doubleClick("xpath=//i[@nodeclick='treenode_0']");
			Thread.sleep(1000);
			webtest.doubleClick("xpath=//i[@nodeclick='treenode_1']");
			Thread.sleep(1000);
			webtest.doubleClick("xpath=//i[@nodeclick='treenode_1_0']");
			Thread.sleep(1000);
			webtest.doubleClick("xpath=//i[@nodeclick='treenode_1_1']");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='genmu']");
			Thread.sleep(1000);
			webtest.click("xpath=//button[starts-with(@id,'refresh')]");
			Assert.assertTrue(webtest.isElementPresent("xpath=//button[starts-with(@id,'refresh')]"));
		}

//		左侧分类移动
		@Test
		public void test10() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num124");
			webtest.click("xpath=//i[@nodeclick='treenode_1_0']");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@class='icon-move']");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@nodeclick='treenode_0']");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");
			Assert.assertTrue(webtest.isTextPresent("移动成功"));
		}

		//左侧删除按钮
		@Test
		public void test11() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num124");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@nodeclick='treenode_0_0']");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@class='icon-trash']");
			webtest.click("id=confirm_btn1");
			Assert.assertTrue(webtest.isTextPresent("删除成功"));
		}

		// 左侧共享按钮
		@Test
		public void test12() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num124");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@nodeclick=\"treenode_0_0\"]");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@title='共享/取消共享']");
			Thread.sleep(1000);
			webtest.click("xpath=//input[starts-with(@name,'changeuserinput')]");
			Thread.sleep(1000);
			webtest.click("xpath=//input[starts-with(@id,'changeok')]");
			Thread.sleep(1000);
			Assert.assertTrue(webtest.isTextPresent("成功"));
		}
//		// 2修改
		@Test
		public void test13() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num203");
			webtest.click("xpath=//i[@class='icon-file-alt']");
			webtest.click("xpath=//i[@class='icon-edit']");
			Thread.sleep(1000);
			webtest.typeAndClear("name=name","demo1");
			webtest.typeAndClear("name=sort","1");
			Thread.sleep(1000);
			webtest.click("xpath=//button[starts-with(@id,'save')]");
			Assert.assertTrue(webtest.isTextPresent("处理成功"));
		}

//		// 添加
		@Test
		public void test14() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num203");
			webtest.click("xpath=//i[@class='icon-plus']");
			Thread.sleep(1000);
			webtest.typeAndClear("name=name","demo");
			webtest.typeAndClear("name=sort","1");
			Thread.sleep(1000);
			webtest.click("xpath=//button[starts-with(@id,'save')]");
			Assert.assertTrue(webtest.isTextPresent("处理成功"));
		}
		//删除
		@Test
		public void test15() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num203");
			Thread.sleep(2000);
			webtest.click("xpath=//i[@class='icon-file-alt']");
			webtest.click("xpath=//i[@class='icon-trash']");
			webtest.click("id=confirm_btn1");
			Assert.assertTrue(webtest.isTextPresent("删除成功"));
		}
//		// 刷新
		@Test
		public void test16() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num203");
			webtest.click("xpath=//a[@title='刷新']");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isElementPresent("xpath=//a[@title='刷新']"));
		}

//		// 移动
		@Test
		public void test17() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num203");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@nodeclick='treenode_1_0']");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@class='icon-move']");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@nodeclick='treenode_0']");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");
			Assert.assertTrue(webtest.isTextPresent("移动成功"));
		}

//		// 共享
		@Test
		public void test18() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num203");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@nodeclick='treenode_0_0']");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@class='icon-share-alt']");
			Thread.sleep(1000);
			webtest.type("xpath=//input[starts-with(@id,'changekey')]", "管理层");
			Thread.sleep(1000);
			webtest.click("xpath=//input[starts-with(@id,'changesoubtn')]");
			Thread.sleep(1000);
			webtest.click("xpath=//input[@xname='磐石']");
			Thread.sleep(1000);
			webtest.click("xpath=//input[starts-with(@id,'changeok')]");
			Thread.sleep(1000);
			Assert.assertTrue(webtest.isTextPresent("成功"));
		}
//		// 置到顶级目录
		@Test
		public void test19() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num203");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@nodeclick='treenode_0_0']");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@class='icon-arrow-up']");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("移动成功"));
		}

//		// 预览txt文件
		@Test
		public void test20() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num203");
			webtest.click("xpath=//input[@oi='0']");
			webtest.click("xpath=//a[@href='javascript:;']");
			webtest.enterFrame1("name=openinputiframe");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("查看帮助?"));
		}

		// 删除
		@Test
		public void test21() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num203");
			Thread.sleep(1000);
			webtest.click("xpath=//input[@oi='0']");
			Thread.sleep(1000);
			webtest.click("xpath=//button[starts-with(@id,'del')]");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			Assert.assertTrue(webtest.isTextPresent("删除成功"));
		}

		// 3搜索框
		@Test
		public void test22() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num125");
			Thread.sleep(1000);
			webtest.type("xpath=//input[starts-with(@id,'key')]","系统");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='search']");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("搜索"));
		}

		// 导出
		@Test
		public void test23() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num125");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='daochu,1']");
			Thread.sleep(1000);
			Assert.assertTrue(webtest.isTextPresent("处理成功"));
		}
	//
//		//4左边菜单删除
		@Test
		public void test24() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num134");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@nodeclick='treenode_0']");
			webtest.click("xpath=//i[@class='icon-trash']");
			webtest.click("id=confirm_btn1");
			Assert.assertTrue(webtest.isTextPresent("有下级分类不允许删除"));
		}


//		查看
		@Test
		public void test25() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num134");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@onclick=\"openxiangs('知识','knowledge',1)\"]");
			Thread.sleep(1000);
			webtest.enterFrame1("name=openinputiframe");
			Assert.assertTrue(webtest.isTextPresent("查阅记录"));
		}

		// 新增
		@Test
		public void test26() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num134");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='adds']");
			webtest.enterFrame1("name=openinputiframe");
			Thread.sleep(2000);
			webtest.typeAndClear("name=title","title");
			Thread.sleep(1000);
			webtest.type("name=typeid","demo");
			webtest.typeAndClear("name=sort","1");
			webtest.click("id=AltS");
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isTextPresent("新增保存成功"));
		}
	//
//		// 删除没有权限删除的文件
		@Test
		public void test27() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num134");
			Thread.sleep(1000);
			webtest.click("xpath=//td[@row='0' and @cell='0']");
			Thread.sleep(1000);
			webtest.click("xpath=//button[starts-with(@id,'del')]");
			webtest.click("id=confirm_btn1");
			Assert.assertTrue(webtest.isTextPresent("无权删除"));
		}
	//
//		// 左边菜单新增
		@Test
		public void test28() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num134");
			webtest.click("xpath=//i[@class='icon-plus']");
			Thread.sleep(1000);
			webtest.type("name=name","demo");
			webtest.type("name=sort","1");
			Thread.sleep(1000);
			webtest.click("xpath=//button[starts-with(@id,'save')]");
			Assert.assertTrue(webtest.isTextPresent("处理成功"));
		}
	//
//		// 查看页面的操作（关闭操作）
		@Test
		public void test29() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num134");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@onclick=\"openxiangs('知识','knowledge',1)\"]");
			Thread.sleep(1000);
			webtest.enterFrame1("name=openinputiframe");
			webtest.click("id=showmenu");
			Thread.sleep(1000);
			webtest.click("xpath=//li[@lx='3']");
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isTextPresent("新增"));
		}
	//
//		// 查看页面的操作（编辑操作）
		@Test
		public void test30() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num134");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@onclick=\"openxiangs('知识','knowledge',1)\"]");
			Thread.sleep(1000);
			webtest.enterFrame1("name=openinputiframe");
			webtest.click("id=showmenu");
			Thread.sleep(1000);
			webtest.click("xpath=//li[@lx='1']");
			Assert.assertTrue(webtest.isTextPresent("保存"));
		}
//		// 置到顶级目录
		@Test
		public void test31() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num134");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@nodeclick='treenode_3_0']");
			Thread.sleep(1000);
			webtest.click("xpath=//i[@class='icon-arrow-up']");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");
			Assert.assertTrue(webtest.isTextPresent("移动成功"));
		}
		
	//
//		// 5新增题目
		@Test
		public void test32() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num135");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='adds']");
			webtest.enterFrame1("name=openinputiframe");
			Thread.sleep(1000);
			webtest.selectByValue("name=typeid","227");
			webtest.selectByValue("name=type","0");
			Thread.sleep(2000);
			webtest.type("name=title","题目");
			Thread.sleep(1000);
			webtest.type("name=ana","A");
			webtest.type("name=anb","B");
			webtest.type("name=anc","C");
			webtest.type("name=and","D");
			Thread.sleep(1000);
			webtest.type("name=answer","A");
			Thread.sleep(1000);
			webtest.selectByValue("name=status","0");
			Thread.sleep(2000);
			webtest.click("id=AltS");
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isTextPresent("新增保存成功"));
		}
//		// 操作->详情
		@Test
		public void test33() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num135");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@oi='0' and @oj='0']");
			Thread.sleep(1000);
			webtest.click("xpath=//li[@temp='0']");
			Thread.sleep(1000);
			webtest.enterFrame1("name=openinputiframe");
			Assert.assertTrue(webtest.isTextPresent("查阅记录"));
		}
	//	
		// 操作->详情(新窗口)
		@Test
		public void test34() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num135");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@oi='0' and @oj='0']");
			Thread.sleep(1000);
			webtest.click("xpath=//li[@temp='1']");
			Thread.sleep(1000);
			webtest.runJs("window.close()");
			Assert.assertTrue(webtest.isTextPresent("操作"));
			
		}

		// 操作->评论
		@Test
		public void test35() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num135");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@oi='0' and @oj='0']");
			Thread.sleep(1000);
			webtest.click("xpath=//li[@temp='2']");
			Thread.sleep(1000);
			webtest.type("id=confirm_input","good");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			Assert.assertTrue(webtest.isTextPresent("处理成功"));
		}
		
		// 操作->设置提醒频率（失败，无法填写提醒频率）
		@Test
		public void test36() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num135");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@oi='0' and @oj='0']");
			Thread.sleep(1000);
			webtest.click("xpath=//li[@temp='3']");
			Thread.sleep(1000);
			webtest.type("name=ratecont","once");
			Thread.sleep(1000);
			webtest.click("id=Alts");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("操作"));
		}

		// 操作->编辑
		@Test
		public void test37() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num135");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@oi='0' and @oj='0']");
			Thread.sleep(1000);
			webtest.click("xpath=//li[@temp='4']");
			Thread.sleep(2000);
			webtest.enterFrame1("name=openinputiframe");
			Thread.sleep(1000);
			webtest.selectByValue("name=typeid","227");
			webtest.selectByValue("name=type","0");
			Thread.sleep(2000);
			webtest.type("name=title","题目");
			Thread.sleep(1000);
			webtest.typeAndClear("name=ana","A");
			webtest.typeAndClear("name=anb","B");
			webtest.typeAndClear("name=anc","C");
			webtest.typeAndClear("name=and","D");
			webtest.typeAndClear("name=answer","A");
			webtest.selectByValue("name=status","0");
			webtest.click("id=AltS");
			webtest.leaveFrame();
			Assert.assertTrue(webtest.isTextPresent("编辑保存成功"));
		}
		// 操作->删除
		@Test
		public void test38() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num135");
			webtest.click("xpath=//a[@oi='1' and @oj='0']");
			webtest.click("xpath=//li[@temp='5']");
			Thread.sleep(1000);
			webtest.type("id=confirm_input", "测试");
			webtest.click("id=confirm_btn1");
			Assert.assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 导出
		@Test
		public void test39() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num135");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='daochu']");
			Thread.sleep(1000);
			Assert.assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 导入题库{"title", "官网知识","单选","A","B","C","D","A","test"}
		@Test
		public void test40() throws InterruptedException {
			String[] str = { "title", "官网知识", "单选", "A", "B", "C", "D", "A", "test" };
			webtest.click(block);
			webtest.click("id=menu_list_num135");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='daoru']");
			Thread.sleep(1000);
			for (int i = 0; i < 9; i++) {
				webtest.type("xpath=//textarea[starts-with(@id,'maincont')]", str[i]);
				webtest.click("xpath=//a[@click='insrtss']");
			}
			webtest.click("xpath=//button[@click='saveadd']");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("导入数据为"));
		}

		// 翻到下一页、最后一页、上一页、最前一页
//		@Test
//		public void test41() throws InterruptedException {
//			load(block);
//			webtest.click("id=menu_list_num135");
//			Thread.sleep(1000);
//			webtest.click("xpath=//button[starts-with(@id,'next')]");
//			Thread.sleep(1000);
//			webtest.click("xpath=//button[starts-with(@id,'lastye')]");
//			Thread.sleep(1000);
//			webtest.click("xpath=//button[starts-with(@id,'shang')]");
//			Thread.sleep(1000);
//			webtest.click("xpath=//button[starts-with(@id,'shouye')]");
//			Thread.sleep(1000);
//		}

		// 资源搜索框
		@Test
		public void test42() throws InterruptedException {
			webtest.click(block);
			Thread.sleep(1000);
			webtest.click("id=indesearchmenu");
			Thread.sleep(1000);
			webtest.type("id=confirm_input","个人文档");
			Thread.sleep(1000);
			webtest.click("id=confirm_btn1");
			Thread.sleep(1000);
			Assert.assertTrue(webtest.isTextPresent("个人文档"));
		}

		// 资源菜单栏
		@Test
		public void test43() throws InterruptedException {
			webtest.click(block);
			Thread.sleep(1000);
			webtest.click("id=reordershla");
			Thread.sleep(1000);
			Assert.assertFalse(webtest.isElementPresent("id='indesearchmenu'"));
		}

		// 6搜索
		@Test
		public void test44() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num158");
			Thread.sleep(1000);
			webtest.type("xpath=//input[starts-with(@id,'key')]","工作效率");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='search']");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("工作效率"));
		}

		// 查看
		@Test
		public void test45() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num158");
			Thread.sleep(1000);
			webtest.click("xpath=//a[@href='javascript:;']");
			Thread.sleep(2000);
			webtest.enterFrame1("name=openinputiframe");
			Assert.assertTrue(webtest.isTextPresent("查阅记录"));
		}

		// 导出
		@Test
		public void test46() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num158");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='daochu']");
			Thread.sleep(1000);
			Assert.assertTrue(webtest.isTextPresent("处理成功"));
		}

		// 刷新
		@Test
		public void test47() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num158");
			//刷新
			webtest.click("xpath=//a[@click='reload']");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isElementPresent("xpath=//a[@click='reload']"));
		}

		// 7双击查看官网知识
		@Test
		public void test48() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num136");
			Thread.sleep(1000);
			webtest.doubleClick("xpath=//i[@nodeclick=\"treenode_0\"]");
			Thread.sleep(2000);
			webtest.click("xpath=//button[@click=\"genmu\"]");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isTextPresent("官网知识"));
		}

		// 左侧刷新按钮
		@Test
		public void test49() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num136");
			webtest.click("xpath=//a[@click=\"reload\"]");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isElementPresent("xpath=//a[@click='reload']"));
		}

		// 右侧刷新按钮
		@Test
		public void test50() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num136");
			webtest.click("xpath=//button[starts-with(@id,'refresh')]");
			Thread.sleep(2000);
			Assert.assertTrue(webtest.isElementPresent("xpath=//button[starts-with(@id,'refresh')]"));
		}

//		 导出并下载
		@Test
		public void test51() throws InterruptedException {
			webtest.click(block);
			webtest.click("id=menu_list_num136");
			Thread.sleep(1000);
			webtest.click("xpath=//button[@click='daochu']");
			Thread.sleep(1000);
			Assert.assertTrue(webtest.isTextPresent("处理成功"));
		}
}

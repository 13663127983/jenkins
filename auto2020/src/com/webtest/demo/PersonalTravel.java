package com.webtest.demo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class PersonalTravel extends BaseTest{
	@Test
	public void personalTravel()  {
		webtest.open("http://www.roqisoft.com/zhsx/");
		webtest.click("link=登录");
		webtest.type("id=user", "lc");
		webtest.type("id=pw", "123456");
		webtest.click("xpath=//input[@type='submit");
		webtest.click("partLink=我的空间");
		webtest.click("partLink=点我写游记");
		webtest.type("id=title", "aaaaaa");
		webtest.enterFrame1("class=ke-edit-iframe");
		webtest.click("tag=body");
		webtest.type("tag=body", "so high so high");
		webtest.leaveFrame();
		webtest.click("xpath=input[@type='submit'");
	}

}

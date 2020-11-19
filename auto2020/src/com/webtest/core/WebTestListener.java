package com.webtest.core;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.jetty9.io.ssl.SslClientConnectionFactory;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class WebTestListener extends TestListenerAdapter {
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
//		打印出总的测试用例数目
//		成功的/失败的测试用例名称和数目
		ITestNGMethod[] it = testContext.getAllTestMethods();
		System.out.println("总的测试用例数目为："+it.length);
		List<ITestResult> passList = this.getPassedTests();
		List<ITestResult> failedList=this.getFailedTests();
		System.out.println("成功的测试用例数目为："+passList.size());
		System.out.println("失败的测试用例数目为："+failedList.size());
		for(int i=0;i<passList.size();i++) {
			ITestResult tr = passList.get(i);
			System.out.println(tr.getInstanceName()+tr.getName()+"成功");
		}
		for(int i=0;i<failedList.size();i++) {
			ITestResult tr = failedList.get(i);
			System.out.println(tr.getInstanceName()+tr.getName()+"失败");
		}
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailure(tr);
//		失败的测试用例截屏
		BaseTest bt = (BaseTest) tr.getInstance();
		WebDriver driver = bt.getDriver();
		SeleniumScreenShot sss = new SeleniumScreenShot(driver);
		try {
			sss.screenShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}

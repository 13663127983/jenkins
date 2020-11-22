package com.webtest.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;
/**
 * author:lichang
 
 */
public class WebDriverEngine {

	WebDriver driver = null;
	ElementFinder finder = null;
	Actions action  =null;

	public WebDriverEngine(WebDriver driver) {
		
		this.driver = driver;
		driver.manage().window().maximize();
		finder = new ElementFinder(driver);
		action = new Actions(driver);
	}
	public String[] getAllWindowTitles() {
		// TODO Auto-generated method stub
	    String current = driver.getWindowHandle();

	    List<String> attributes = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	      driver.switchTo().window(handle);
	      attributes.add(driver.getTitle());
	    }

	    driver.switchTo().window(current);

	    return attributes.toArray(new String[attributes.size()]);
	}

	//自己添加
	public void clear(String locator) {
		finder.findElementByPrefix(locator).clear();
		
	}
	
	//自己添加
	public List<WebElement> getLocator(String locator) {
		return finder.findElementsByPrefix(locator);
		
	}
	
	//自己添加
	public WebElement getLocatorSingle(String locator) {
		return finder.findElementByPrefix(locator);
	}
	
	//自己添加
	public WebElement getTd(String content) {
		List<WebElement> list = finder.findElementsByPrefix("class=tr");
		
		return null;
		
	}
	//自己添加
	public String getCurrentWindow() {
		return driver.getWindowHandle();
		
	}
	
	//自己添加
	public void openWindow() {
		String windowHandle = driver.getWindowHandle();
		switchWindow(driver, windowHandle);
	}
	
	//自己添加
	public void switchToWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
		
	}
	
	//自己添加
	public void switchWindow(WebDriver driver, String windowHandle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {

			if (!windowHandle.equals(string)) {
				driver.switchTo().window(string);
				break;
			}
		}
	} 


	public void enterFrame(String frameID) {
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}
	public void enterFrame(int frameID) {
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}
	
	public void enterFrame1(String locator) {
		WebElement element = finder.findElement(locator);
		this.pause(3000);
		driver.switchTo().frame(element);
		Log.info("Entered iframe " + element);
	}


	public void leaveFrame() {
		driver.switchTo().defaultContent();
		Log.info("Left the iframe");
	}
	
	//自己添加,回到上一级iframe
	public void switchToParent() {
		driver.switchTo().parentFrame();
		
	}

	public void open(String url) {

		try {
			driver.get(url);
			pause(5000);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Log.info("Opened url " + url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	private void pause(int time) {
		if (time <= 0) {
			return;
		}
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isTextPresent(String pattern) {

		String text = driver.getPageSource();
		text = text.trim();
		if (text.contains(pattern)) {
			return true;
		}
		return false;
	}
	public void enter() {
		action.sendKeys(Keys.ENTER);
	}

	public void typeAndClear(String locator, String value) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.clear();
			element.sendKeys(value);

		}
	}

	public void type(String locator, String value) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.sendKeys(value);
		}
	}

	public boolean isChecked(String locator) {
		WebElement element = finder.findElement(locator);
		return element.isSelected();
	}

	public void click(String locator) {

		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.click();
			this.pause(3000);
		}
	}
	
	//自己添加
	public void click(WebElement element) {
		element.click();
		
	}

	public void clickLonger(String locator) {

		WebElement element = finder.findElement(locator);
		if (element != null) {
			runJs("window.scrollTo(0," + element.getLocation().x + ")");
			element.click();
			this.pause(3000);
		}
	}

	public void doubleClick(String locator) throws InterruptedException {
		WebElement element = finder.findElement(locator);
	
		action.doubleClick(element).build().perform();
	}

	public boolean isDisplayed(String locator) {

		WebElement element = finder.findElement(locator);
		if (element != null) {
			return element.isDisplayed();
		}
		return false;
	}

	public String getText(String locator) {

		return finder.findElement(locator).getText().trim();
	}

	public boolean isElementPresent(String locator) {

		WebElement element = null;
		try {
			element = finder.findElement(locator);
		} catch (Exception e) {

			Log.info(e.getMessage());
		}
		if (element != null) {
			return true;
		}
		{
			return false;
		}
	}

	public String getValue(String locator) {

		return finder.findElement(locator).getAttribute("value");
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void goForward() {

		driver.navigate().forward();
	}

	public Alert getAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	public String getAlertTest() {

		return getAlert().getText();
	}

	public void alertAccept() {

		getAlert().accept();
		}

	public Select getSelect(String locator) {
		Select inputSelect = new Select(finder.findElement(locator));
		return inputSelect;
	}

	public void selectByValue(String locator, String value) {
		getSelect(locator).selectByValue(value);
		this.pause(5000);
	}

	public void selectByVisibleText(String locator, String value) {
		getSelect(locator).selectByVisibleText(value);
	}

	public void selectByIndex(String locator, int index) {
		getSelect(locator).selectByIndex(index);
	}

	

	public String getHtmlSource() {

		return driver.getPageSource();
	}

	public void runJs(String js) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(js);
	}
	
	public void clickAndHold(String locator) throws InterruptedException {
		action.clickAndHold(finder.findElement(locator)).perform();
		this.pause(1000);
		action.release().perform();
	}
	
	public void mouseToElement(String locator) throws InterruptedException {
		action.moveToElement(finder.findElement(locator)).moveByOffset(10, 3).perform();
	}

	public void mouseToElementandClick(String locator) throws InterruptedException {
		action.moveToElement(finder.findElement(locator)).click().perform();
	}
	public void switchWidow(int i){
	    List<String> windows = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	    
	    	windows.add(handle);
	    }
	    driver.switchTo().window(windows.get(i));
	}
	//�Ҽ�
	public void rightClickMouse(String locator) throws InterruptedException {
		action.contextClick(finder.findElement(locator)).perform();
		}
	//Tab
	public void tapClick(){
	
		action.sendKeys(Keys.TAB).perform();
	}
	
	
	//自己添加
	public void escClick() {
		action.sendKeys(Keys.ESCAPE).perform();
	}
	
	//自己添加
	public void enterClick() {
		action.sendKeys(Keys.ENTER).perform();
	}
	public void tapType(String content){
		
			action.sendKeys(content).perform();
		}
	
	public void getWindow(int i){
		List<String> windows = new ArrayList<String>();
		for (String handle : driver.getWindowHandles())
		{
			//System.out.println(handle);  
			windows.add(handle);
		}
		driver.switchTo().window(windows.get(i));
	}
	//自己添加的（黄）
		public void switchToNewWindow(){
			//得到当前句柄
			String currentWindow = driver.getWindowHandle();
		    //得到所有窗口的句柄
		    Set<String> handles = driver.getWindowHandles(); 
		    //排除当前窗口的句柄，则剩下是新窗口
		    Iterator<String> it = handles.iterator();
		    while(it.hasNext()){
		        if(currentWindow == it.next())  continue;
		        driver.switchTo().window(it.next());      
		    }
		}
		//自己添加的（黄）
		public void closeWindow() {
	        try {
	            String winHandleBefore = driver.getWindowHandle();//关闭当前窗口前，获取当前窗口句柄
	            Set<String> winHandles = driver.getWindowHandles();//使用set集合获取所有窗口句柄
	            driver.close();//关闭窗口
	            Iterator<String> it = winHandles.iterator();//创建迭代器，迭代winHandles里的句柄
	            while (it.hasNext()) {//用it.hasNext()判断时候有下一个窗口,如果有就切换到下一个窗口
	                String win = it.next();//获取集合中的元素
	                if (!win.equals(winHandleBefore)) { //如果此窗口不是关闭前的窗口
	                    driver.switchTo().window(win);//切换到新窗口
	                    break;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		//自己添加的（黄）
		public void exectueScript(String locator) {
			String js3 = "arguments[0].scrollIntoView();";
			WebElement element = finder.findElement(locator);
			((JavascriptExecutor) driver).executeScript(js3, element);

		}



	
	
	
}

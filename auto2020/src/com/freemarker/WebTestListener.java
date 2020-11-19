package com.freemarker;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.webtest.utils.ReadProperties;

//监听器
public class WebTestListener extends TestListenerAdapter {
	FreemarkerTemplateEngine ft = new FreemarkerTemplateEngine();

	public WebTestListener() {
		super();
	}

	public String writeResultToMailTemplate() {
		ITestNGMethod method[] = this.getAllTestMethods();
		List<ITestResult> failedList = this.getFailedTests();
		List<ITestResult> passedList = this.getPassedTests();
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("date", new Date());
		context.put("failedList", failedList);
		context.put("passedList", passedList);
		context.put("casesize", passedList.size() + failedList.size());
		context.put("failcasesize", failedList.size());
		context.put("passedcasesize", passedList.size());
		try {
			String content = ft.run(context);
			return content;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);

		String emailContent = this.writeResultToMailTemplate();
		String emailTitle;
		try {
			emailTitle = ReadProperties.getPropertyValue("mail_title") + "----" + this.getTime();
			String toMail = ReadProperties.getPropertyValue("tomail");
			MailUtil.sendEmail(toMail, emailTitle, emailContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getTime() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		return f.format(c.getTime());
	}
}
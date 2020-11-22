package com.webtest.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NSDataProvider {

	
//	@DataProvider(name="zl_shop")
//	public  Object[][] getTxtData() throws IOException{
//		return new  TxtDataProvider().getTxtUser("data/user.txt");
//	}
//	@DataProvider(name="movie")
//	public  Object[][] getMovieData() throws IOException{
//		return new  ExcelDataProvider().getTestDataByExcel("data/movie.xlxs","Sheet1");
//	}
//	@Test(dataProvider="txt")
//	public void getData(String a,String b) {
//		System.out.println(a+" "+b);
//		
//	}
//
//	@DataProvider(name="excel")
//	public Object[][] getExcelDada() throws IOException{
//		return new ExcelDataProvider().getTestDataByExcel("data/user.xlsx","Sheet1");
//	}
//	
//	@DataProvider(name="mysql")
//	public Object[][] getMysqlDada() throws IOException{
//		return new MysqlDataProvider().getTestDataByMysql("SELECT filmname, petname\r\n" + 
//				"FROM `mm_movie` ");
//	}
//	
//	@Test(dataProvider="mysql")
//	public void testDB(String a,String b) {
//		System.out.println(a+" "+b);
//	}
//	
	
//	@DataProvider(name="travel")
//	public Object[][] getTxtData1() throws IOException{
//		return new TxtDataProvider().getTxtUser("D:\\java\\workspace\\auto2020\\file.txt");
//		
//	}
	
	@DataProvider(name="xinhu1")
	public Object[][] getExcelkData1() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data/xinhu.xlsx", "Sheet1");
		
	}
	
	@DataProvider(name="xinhu2")
	public Object[][] getExcelkData2() throws IOException{
		return new ExcelDataProvider().getTestDataByExcel("data/xinhu.xlsx", "Sheet2");
		
	}
	
	
	
	
}
